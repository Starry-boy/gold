package com.jiaxc.gold.log.service;

import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 10:13
 */
public interface BuriedPointAble {
    /**
     * 访问量自增
     * @param endpoint
     * @param date
     * @return
     */
    int incrVisit(String endpoint, Date date);


    /**
     * 访客数自增
     * @param endpoint
     * @param visitor 工号 或 IP
     * @param date
     * @return
     */
    int incrVisitor(String endpoint, String visitor, Date date);


    /**
     * 增加页面浏览数
     * @param endpoint
     * @return
     */
    int addPageViews(String endpoint, String visitor, Date date);

    /**
     * 打开页面
     * @param endpoint
     * @param visitor
     * @param date
     */
    void recordOpenPage(String endpoint, String visitor, Date date);

    /**
     * 关闭页面
     * @param endpoint
     * @param visitor
     * @param date
     */
    void recordClosePage(String endpoint, String visitor, Date date);
}
