package com.jiaxc.gold.cache.factory.adpater.impl;

import cn.hutool.core.net.NetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiaxc.gold.cache.ILock;
import com.jiaxc.gold.cache.dto.ReentrantLockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class RedisLock implements ILock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ObjectMapper json = new ObjectMapper();

    private String threadUniIdPrefix;

    /**
     * 有序队列，按时间排序
     */
    private final PriorityQueue<ReentrantLockDTO> queue = new PriorityQueue<>();
    private final Map<String, ReentrantLockDTO> map = new HashMap<>();


    public RedisLock() {
        String localMacAddress = NetUtil.getLocalMacAddress();
        InetAddress localhost = NetUtil.getLocalhost();
        this.threadUniIdPrefix = localMacAddress + ":" + localhost;

        new Thread(() -> {
            while (true) {
                ReentrantLockDTO lockDTO = queue.poll();
                //续费
                redisTemplate.expire(lockDTO.getKey(), lockDTO.getExpireTime(), TimeUnit.MILLISECONDS);

            }
        });
    }

    private String generateThreadUniId(){
        return threadUniIdPrefix + ":" + Thread.currentThread().getName();
    }

    @Override
    public boolean lock(String key, int spinCount, long expireTime) {
        Boolean isLock = false;
        int count = 0;
        expireTime = expireTime == 0 ? 0 : expireTime / 3;
        ReentrantLockDTO lockDTO = new ReentrantLockDTO();
        String requestId = generateThreadUniId();
        lockDTO.setRequestId(requestId);
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        try {
            //自旋锁实现
            while (count >= spinCount && !isLock) {
                isLock = operations.setIfAbsent(key, json.writeValueAsString(lockDTO), expireTime, TimeUnit.MILLISECONDS);
                if (!isLock) {
                    String objectStr = operations.get(key);
                    if (StringUtils.isEmpty(objectStr)) {
                        break;
                    }

                    try {
                        ReentrantLockDTO reentrantLockDTO = json.readValue(objectStr, ReentrantLockDTO.class);
                        //可重入锁实现
                        if (Objects.equals(reentrantLockDTO.getRequestId(), requestId)) {
                            reentrantLockDTO.setCount(reentrantLockDTO.getCount() + 1);
                            operations.set(key, json.writeValueAsString(reentrantLockDTO), spinCount, TimeUnit.MILLISECONDS);
                            isLock = true;
                        }
                    } catch (IOException e) {
                        return false;
                    }

                }

            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (isLock) {
            //看门狗
            synchronized (map) {
                ReentrantLockDTO dto = map.get(key);
                if (dto == null) {
                    map.put(key, dto);
                }
                queue.add(lockDTO);
            }
        }

        return isLock;
    }

    @Override
    public boolean lock(String key, long expireTime) {
        return lock(key, (int)expireTime / 1000, expireTime);
    }

    @Override
    public void unLock(String key, String requestId) {

    }

    @Override
    public void unLock(String key) {

    }
}
