package com.jiaxc.gold.log.service.adpater.impl;

import com.jiaxc.gold.log.service.adpater.BuriedPointAdapter;

import java.util.Date;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 10:36
 */
public class DefaultBuriedPoint implements BuriedPointAdapter {

    @Override
    public int incrVisit(String endpoint, Date date) {
        return 0;
    }

    @Override
    public int incrVisitor(String endpoint, String visitor, Date date) {
        return 0;
    }

    @Override
    public int addPageViews(String endpoint, String visitor, Date date) {
        return 0;
    }

    @Override
    public void recordOpenPage(String endpoint, String visitor, Date date) {

    }

    @Override
    public void recordClosePage(String endpoint, String visitor, Date date) {

    }
}
