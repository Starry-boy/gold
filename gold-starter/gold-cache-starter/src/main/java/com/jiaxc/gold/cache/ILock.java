package com.jiaxc.gold.cache;

public interface ILock {

    /**
     *
     * @param key
     * @param spinCount 自旋次数
     * @param expireTime 过期时间 单位秒
     * @return true - 加锁成功 false - 加锁失败
     */
    boolean lock(String key,int spinCount,long expireTime);

    boolean lock(String key,long expireTime);

    /**
     * 释放锁
     * @param key
     * @param requestId
     */
    void unLock(String key,String requestId);

    /**
     * 释放锁
     * @param key
     */
    void unLock(String key);
}
