package com.putorn.powerdoc.web;
import com.alibaba.fastjson.JSON;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.entity.PowerSysUser;
import com.putorn.powerdoc.entity.vo.PowerReportVo;
import com.putorn.powerdoc.enumconst.SystemAdminEnum;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerReportService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  PowerReportController
 */
@RestController
@RequestMapping("report")
public class PowerReportController{
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private PowerReportService powerReportService;


    @PostMapping("saveReportBatch")
//    @ApiImplicitParam(name = "reportList",value = "批量报告信息",dataType = "List<PowerReportVo>",required = true)
    @ApiOperation(value = "保存批量报告信息",notes = "保存批量报告信息",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> saveReportBatch(@RequestBody List<PowerReportVo> reportList){
        Map<String,Object> result = new HashMap<>();
        result.put("result","");
        String message;
        int code = 400;
        try {
            logger.info("保存批量报告信息参数为："+JSON.toJSONString(reportList));
            if(reportList != null && reportList.size() > 0) {
                List<String> errorList = powerReportService.saveReportBatch(reportList);
                if(errorList == null || errorList.size() == 0) {
                    code = 200;
                    message = "报告全部保存成功";
                }else if(errorList.size() == reportList.size()) {
                    message = "报告全部保存失败";
                }else {
                    message = "报告部分保存失败，失败的报告id为："+JSON.toJSONString(errorList)+"失败数量：" + errorList.size();
                }
            }else {
                message = "请求参数为空，请检查！";
            }

        }catch (Exception e){
            code = 500;
            message = "服务异常";
            result.put("message","服务异常");
            logger.error(e);

        }
        result.put("code",code);
        result.put("message",message);
        logger.info("保存报告返回结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);

    }

    @PostMapping("queryReportList")
    @ApiImplicitParam(name = "report",value = "报告查询条件，可为空",paramType = "PowerReport")
    @ApiOperation(value = "分页按条件查询报告" ,notes="分页查询所有报告")
    public ResponseEntity<PageBean> queryReportList(HttpServletRequest request, @RequestBody PageParam pageParam){
        try {
//            PageParam pageParam = PageParamHelper.getPageParam(request);
            Map<String, Object> params = pageParam.getParams();
            params.put("reportStatus", SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            params.put("sortColumns", "addtime");

            HttpSession session = request.getSession();

            Object obj = session.getAttribute("user");
            if(obj != null || !"".equals(obj)) {
                PowerSysUser user = (PowerSysUser)obj;
                Integer isSysadmin = user.getIsSysadmin();
                //如果是管理员，则可查看全部，否则只能查看个人参与的报告
                if(isSysadmin != SystemAdminEnum.YES.getKey()) {
                    params.put("userId",user.getId());
                }
                params.put("sortColumns","test_date");
                pageParam.setParams(params);
                PageBean pageInfo =this.powerReportService.listPage(pageParam);
                return ResponseEntity.ok(pageInfo);
            }else {
                logger.error("未登录，禁止获取试验报告");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}