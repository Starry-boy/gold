package com.jiaxc.gold.report.api;

import com.jiaxc.gold.common.domain.vo.R;
import com.jiaxc.gold.report.domain.command.ExportCommand;
import com.jiaxc.gold.report.domain.query.ExportQuery;
import com.jiaxc.gold.report.domain.vo.ExportMapModelVO;
import com.jiaxc.gold.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/1 15:27
 */
@RestController
@RequestMapping("report")
public class ReportAPI {

    @Autowired
    private ReportService reportService;

    @GetMapping("list")
    @ResponseBody
    public R list(ExportQuery query){
        return R.ok(reportService.page(query));
    }

    @GetMapping("export")
    @ResponseBody
    public R export(ExportCommand exportCommand){
        return R.ok(null);
    }

    @GetMapping("showModel")
    public R<ExportMapModelVO> showModel(@RequestParam("modelName") String modelName){
        return R.ok(reportService.getMode(modelName));
    }
}
