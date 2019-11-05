package com.putorn.powerdoc.web;

import com.putorn.powerdoc.service.impl.ExportServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/export")
public class ExportDocController {

    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private ExportServiceImpl exportService;

    @GetMapping("exportDocByReportId/{reportId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reportId",value = "报告主键",required = true)
    })
//    @ApiImplicitParam(name = "paramUser",value = "单个用户",dataType = "PowerSysUser",required = true)
    @ApiOperation(value = "根据报告id导出报告内容",notes = "根据报告id导出报告内容",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> exportDocByReportId(@PathVariable("reportId") String reportId, HttpServletResponse response) {
        Map<String,Object> result = new HashMap<>();
        if(StringUtils.isEmpty(reportId)) {
            result.put("code","400");
            result.put("message","报告id不能为空");
            logger.info("报告id不能为空");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        result = exportService.exportDocByReportId(reportId,response);
        return ResponseEntity.ok(result);
    }

    /**
     * 预览在线的word文档
     * @param reportId
     * @param response
     */
    @GetMapping("viewDocByReportId/{reportId}")
    public void viewDocByReportId(@PathVariable("reportId") String reportId, HttpServletRequest request,  HttpServletResponse response){
        String path = request.getServletContext().getRealPath("/gen");
        String fileName = exportService.genDocToHtmlFilName(reportId, path);
        try {
            response.sendRedirect("/gen/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
