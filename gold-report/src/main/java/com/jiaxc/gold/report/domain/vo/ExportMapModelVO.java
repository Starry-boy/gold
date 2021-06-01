package com.jiaxc.gold.report.domain.vo;

import com.jiaxc.gold.common.domain.vo.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 16:04
 */
@Data
public class ExportMapModelVO extends BaseVO {
    private List<ExportFieldMapVO> list;

    @Data
    public class ExportFieldMapVO{
        String name;
        String Type;
        String desc;
    }
}
