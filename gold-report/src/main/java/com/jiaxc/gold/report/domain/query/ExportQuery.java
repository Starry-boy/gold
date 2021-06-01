package com.jiaxc.gold.report.domain.query;

import com.jiaxc.gold.common.domain.vo.BaseQuery;
import lombok.Data;

import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 15:41
 */
@Data
public class ExportQuery extends BaseQuery {
    private List<QueryCondition> list;
    private int pageNo;
    private int pageSize;
    private String sqlTemplateName;

    @Data
    public class QueryCondition{
        private String field;
        private String option;
        private String value;
        private String type;
    }

}
