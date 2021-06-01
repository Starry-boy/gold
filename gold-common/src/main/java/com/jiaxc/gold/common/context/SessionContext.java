package com.jiaxc.gold.common.context;

import com.jiaxc.gold.common.domain.bo.UserBO;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 18:11
 */
public class SessionContext {
    private static ThreadLocal<UserBO> userInfoThreadLocal = new ThreadLocal<>();

    public static UserBO getCurrentUser(){
        return userInfoThreadLocal.get();
    }

    public static void setUser(UserBO userBO){
        userInfoThreadLocal.set(userBO);
    }
}
