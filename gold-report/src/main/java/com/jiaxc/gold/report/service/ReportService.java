package com.jiaxc.gold.report.service;

import com.jiaxc.gold.report.domain.query.ExportQuery;
import com.jiaxc.gold.report.domain.vo.ExportMapModelVO;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:18
 */
public interface ReportService {

    /**
     * 获取显示
     * @param modelName
     * @return
     */
    ExportMapModelVO getMode(String modelName);

    Object page(ExportQuery query);
}
