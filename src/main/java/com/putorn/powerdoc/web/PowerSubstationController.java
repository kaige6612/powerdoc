package com.putorn.powerdoc.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.putorn.powerdoc.entity.PowerSubstation;
import com.putorn.powerdoc.entity.PowerSubstation;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerSubstationService;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.base.PageParamHelper;
import com.putorn.powerdoc.util.IpUtil;
import com.putorn.powerdoc.util.ValidateEntityParam;
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
import java.util.HashMap;
import java.util.Map;

/**
 *  PowerSubstationController
 */
@RestController
@RequestMapping("powerSubstation")
public class PowerSubstationController{
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private PowerSubstationService powerSubstationService;

    @PostMapping("saveSubstation")
    @ApiImplicitParam(name = "substation",value = "添加变电站",dataType = "PowerSubstation",required = true)
    @ApiOperation(value = "添加变电站",notes = "添加变电站对象,主键自增",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> savePowerSubstation(@RequestBody PowerSubstation substation, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {
            result = powerSubstationService.saveSubstation(substation);
        }catch (Exception e){
            result.put("state","error");
            result.put("msg","服务异常");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        logger.info("添加变电站结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }


    @PostMapping("updateSubstation")
    @ApiImplicitParam(name = "substation",value = "单个变电站",dataType = "PowerSubstation",required = true)
    @ApiOperation("更新变电站")
    public ResponseEntity<Map<String,Object>> updatePowerSubstation(@RequestBody PowerSubstation substation){
        Map<String,Object> result = new HashMap<>();
        try {
            Long id = substation.getId();
            //校验变电站id不能为空
            if(id == null) {
                result.put("state","error");
                result.put("msg","变电站id不能为空!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
            }
            int changeCount = powerSubstationService.update(substation);
            if(changeCount == 0) {
                result.put("state","error");
                result.put("msg","没有找到变电站!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
            result.put("state","success");
            result.put("msg","修改变电站成功!");
        }catch (Exception e){
            logger.error(e);
            result.put("state","error");
            result.put("msg","系统错误!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "deleteSubstationById")
    @ApiImplicitParam(name = "id",value = "id,仅逻辑删除变电站",paramType = "query" ,required = true)
    @ApiOperation(value = "单个删除变电站",notes = "id 必填,状态 0开启 1禁用 2删除 ")
    public ResponseEntity<Map<String,Object>> deletePowerSubstation(Long id){
        Map<String,Object> result = new HashMap<>();
        try{
            int delete = powerSubstationService.delete(id);
            if(delete == 1) {
                result.put("state","success");
                result.put("msg","删除成功!");
            }else if(delete == 0){
                result.put("state","error");
                result.put("msg","没有查询到此变电站!");
            }

        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("msg","服务异常!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("querySubstationList")
    @ApiImplicitParam(name = "substation",value = "substation可为空的json",paramType = "PowerSubstation" ,required = false)
    @ApiOperation(value = "分页按条件查询变电站" ,notes="分页查询所有变电站")
    public ResponseEntity<PageBean> queryPowerSubstation(HttpServletRequest request, PowerSubstation substation){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            Map<String, Object> params = JSONObject.parseObject(JSON.toJSONString(substation), new TypeReference<Map<String, Object>>(){});
            pageParam.setParams(params);
            PageBean pageInfo =this.powerSubstationService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}