package com.jiaxc.gold.base.log.api;

import com.jiaxc.gold.base.log.model.po.ApiLog;
import com.jiaxc.gold.common.constist.enums.OperationEnum;
import com.jiaxc.gold.common.domain.vo.R;
import com.jiaxc.gold.log.anno.TraceLog;
import org.springframework.web.bind.annotation.*;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 15:09
 */
@RestController
@RequestMapping("api/v1")
public class Health {

    @GetMapping("check")
    @TraceLog(option = OperationEnum.QUERY,desc = "健康检查")
    public R check() {
        return R.ok("OK!");
    }

    @PostMapping("modify")
    @TraceLog(option = OperationEnum.MODIFY,desc = "测试修改", businessKey = "#apiLog.id")
    public R modify(@RequestBody ApiLog apiLog) {
        return R.ok("OK!");
    }
}
