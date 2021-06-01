package com.jiaxc.gold.log.service;

import com.jiaxc.gold.log.model.dto.APILogDTO;

/**
 * @author ratel
 * @version 1.0
 * @description: web API日志服务
 * @date 2021/4/18 14:23
 */
public interface APILogService {

    /**
     * 保存接口日志
     * @param apiLogDTO
     */
    void saveLog(APILogDTO apiLogDTO);
}
