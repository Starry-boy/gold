package com.jiaxc.gold.report.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiaxc.gold.cache.CacheService;
import com.jiaxc.gold.cache.constist.enums.CacheServiceEnum;
import com.jiaxc.gold.cache.factory.CacheFactory;
import com.jiaxc.gold.report.constist.enums.CacheKeyEnum;
import com.jiaxc.gold.report.domain.query.ExportQuery;
import com.jiaxc.gold.report.domain.vo.ExportMapModelVO;
import com.jiaxc.gold.report.mapper.ReportMapper;
import com.jiaxc.gold.report.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:18
 */

@Slf4j
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CacheFactory cacheFactory;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public ExportMapModelVO getMode(String modelName) {
        CacheService cacheService = cacheFactory.getCacheService(CacheServiceEnum.EHCACHE);
        return cacheService.get(CacheKeyEnum.MODEL_PREFIX.toCacheKey(modelName), ExportMapModelVO.class);
    }

    @Override
    public Page<Map<String, Object>> page(ExportQuery query) {
        CacheService cacheService = cacheFactory.getCacheService(CacheServiceEnum.EHCACHE);
        String sqlTemplate = cacheService.get(CacheKeyEnum.SQL_TEMPLATE_PREFIX.toCacheKey(query.getSqlTemplateName()));
        final String FINAL_QUERY_SQL = parseSQL(sqlTemplate, query,true);
        final String FINAL_COUNT_SQL = parseSQL(sqlTemplate, query,false);
        List<Map<String, Object>> result = reportMapper.list(FINAL_QUERY_SQL);
        int count = reportMapper.count(FINAL_COUNT_SQL);
        Page<Map<String, Object>> page = new Page<>();
        page.setRecords(result);
        page.setSize(count);
        return page;
    }

    private String parseSQL(String sqlTemplate, ExportQuery exportQuery,boolean limit) {
        List<ExportQuery.QueryCondition> list = exportQuery.getList();
        Map<String[], List<ExportQuery.QueryCondition>> group = list.stream().collect(Collectors.groupingBy(o -> new String[]{o.getField(), o.getOption()}));
        StringJoiner sj = new StringJoiner("");
        group.entrySet().forEach(
                entry -> {
                    String operator = convertOperator(entry.getKey()[1]);
                    String field = entry.getKey()[0];
                    sj.add(" and ").add(field).add(operator).add(" ( ").add(String.join(",", entry.getValue().stream().map(v -> v.getValue()).collect(Collectors.toList()).toArray(new String[]{}))).add(")");
                }
        );

        EvaluationContext context = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();
        if (limit){
            //将参数名与参数值对应起来
            int start = (exportQuery.getPageNo() <= 0 ? 1 : exportQuery.getPageNo()) * exportQuery.getPageSize();
            String limitCommand = String.format("limit %s,%s",start,exportQuery.getPageSize());
            context.setVariable("#LIMIT", limitCommand);
        } else {
            context.setVariable("#SHOW_FIELDS"," count(1) ");

        }
        Expression expression = parser.parseExpression(sqlTemplate);
        return expression.getValue(parser).toString();
    }


    private String convertOperator(String operator){
        switch (operator){
            case "=":
                return " in ";
            case "<>":
            case "!=":
                return " not in ";
        }
        throw new RuntimeException("未定义的操作符");
    }
}
