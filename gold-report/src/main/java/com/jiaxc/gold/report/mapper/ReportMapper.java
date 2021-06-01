package com.jiaxc.gold.report.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:47
 */
public interface ReportMapper {

    @Select("${sql}")
    List<Map<String,Object>> list(@Param("sql") String sql);

    @Select("${sql}")
    int count(@Param("sql") String sql);
}
