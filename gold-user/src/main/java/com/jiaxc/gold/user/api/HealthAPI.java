package com.jiaxc.gold.user.api;

import com.jiaxc.gold.common.constist.enums.OperationDescEnum;
import com.jiaxc.gold.common.constist.enums.OperationEnum;
import com.jiaxc.gold.common.domain.vo.R;
import com.jiaxc.gold.log.anno.TraceLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 11:48
 */
@RestController
@RequestMapping("api/v1")
public class HealthAPI {

    @GetMapping("health.do")
    @TraceLog(option = OperationEnum.QUERY, desc = OperationDescEnum.S0004)
    public R check(){
        return R.ok("OK!");
    }
}
