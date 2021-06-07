package com.jiaxc.gold.cache.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReentrantLockDTO implements Serializable,Comparable<ReentrantLockDTO> {
    private String key;
    private String requestId;
    private Long expireTime;
    private int count;

    @Override
    public int compareTo(ReentrantLockDTO o) {
        return o == null ? 1 : (this.expireTime - o.getExpireTime() > 0 ? 1 : -1);
    }
}
