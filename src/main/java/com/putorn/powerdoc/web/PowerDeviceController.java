package com.putorn.powerdoc.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerDeviceService;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.base.PageParamHelper;
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
 *  PowerDeviceController
 */
@RestController
@RequestMapping("powerDevice")
public class PowerDeviceController{

    @Autowired
    private PowerDeviceService powerDeviceService;

    private final Log logger = LogFactory.getLog(this.getClass());
    @PostMapping("saveDevice")
    @ApiImplicitParam(name = "device",value = "添加设备",dataType = "PowerDevice",required = true)
    @ApiOperation(value = "添加设备",notes = "添加设备对象,主键自增",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> savePowerDevice(@RequestBody PowerDevice device){
        Map<String,Object> result = new HashMap<>();
        try {
            result = powerDeviceService.saveDevice(device);
        }catch (Exception e){
            result.put("state","error");
            result.put("msg","服务异常");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        logger.info("添加设备结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }


    @PostMapping("updateDevice")
    @ApiImplicitParam(name = "device",value = "单个设备",dataType = "PowerDevice",required = true)
    @ApiOperation("更新设备")
    public ResponseEntity<Map<String,Object>> updatePowerDevice(@RequestBody PowerDevice device){
        Map<String,Object> result = new HashMap<>();
        try {
            Long id = device.getId();
            //校验设备id不能为空
            if(id == null) {
                result.put("state","error");
                result.put("msg","设备id不能为空!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
            }
            int changeCount = powerDeviceService.update(device);
            if(changeCount == 0) {
                result.put("state","error");
                result.put("msg","没有找到设备!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
            result.put("state","success");
            result.put("msg","修改设备成功!");
        }catch (Exception e){
            logger.error(e);
            result.put("state","error");
            result.put("msg","系统错误!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "deleteDeviceById")
    @ApiImplicitParam(name = "id",value = "id,仅逻辑删除设备",paramType = "query" ,required = true)
    @ApiOperation(value = "单个删除设备",notes = "id 必填,状态 0开启 1禁用 2删除 ")
    public ResponseEntity<Map<String,Object>> deletePowerDevice(Long id){
        Map<String,Object> result = new HashMap<>();
        try{
            PowerDevice device = powerDeviceService.getById(id);
            if(device != null) {
                device.setStatus(SystemStatusEnum.SYSTEM_STATUS_DELETED.getKey());
                powerDeviceService.update(device);
                result.put("state","success");
                result.put("msg","删除成功!");
            }else {
                result.put("state","error");
                result.put("msg","没有查询到此设备!");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("msg","服务异常!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("queryDeviceList")
    @ApiImplicitParam(name = "device",value = "设备查询条件，可为空",paramType = "PowerDevice" ,required = false)
    @ApiOperation(value = "分页按条件查询设备" ,notes="分页查询所有设备")
    public ResponseEntity<PageBean> queryPowerDevice(HttpServletRequest request, PowerDevice device){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            Map<String, Object> params = JSONObject.parseObject(JSON.toJSONString(device), new TypeReference<Map<String, Object>>(){});
            params.put("device_status", SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            pageParam.setParams(params);
            PageBean pageInfo =this.powerDeviceService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}