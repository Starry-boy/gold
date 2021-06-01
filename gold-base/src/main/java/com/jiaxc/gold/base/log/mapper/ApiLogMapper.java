package com.jiaxc.gold.base.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaxc.gold.base.log.model.po.ApiLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiLogMapper extends BaseMapper<ApiLog> {
    int updateBatch(List<ApiLog> list);

    int updateBatchSelective(List<ApiLog> list);

    int batchInsert(@Param("list") List<ApiLog> list);
}