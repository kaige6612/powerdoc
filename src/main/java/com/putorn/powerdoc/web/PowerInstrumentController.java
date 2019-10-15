package com.putorn.powerdoc.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.putorn.powerdoc.entity.PowerInstrument;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerInstrumentService;
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
import java.util.List;
import java.util.Map;

/**
 *  PowerInstrumentController
 */
@RestController
@RequestMapping("powerInstrument")
public class PowerInstrumentController{

    @Autowired
    private PowerInstrumentService powerInstrumentService;

    private final Log logger = LogFactory.getLog(this.getClass());
    @RequestMapping("saveInstrument")
    @ApiImplicitParam(name = "instrument",value = "添加仪器",dataType = "PowerInstrument",required = true)
    @ApiOperation(value = "添加仪器",notes = "添加仪器对象,主键自增"/*,produces = "application/json"*/)
    @ApiResponse(code = 200,message = "success")
//    public ResponseEntity<Map<String,Object>> savePowerInstrument(@RequestBody PowerInstrument instrument){
    public ResponseEntity<Map<String,Object>> savePowerInstrument(HttpServletRequest request,String instrumentId,String instrumentName){
        Map<String,Object> result = new HashMap<>();
        try {
            int i = 1/0;
//            request.getpara
            PowerInstrument instrument = new PowerInstrument();
            instrument.setInstrumentName(instrumentName);
            result = powerInstrumentService.saveInstrument(instrument);
        }catch (Exception e){
            result.put("state","error");
            result.put("msg","服务异常");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        logger.info("添加仪器结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }


    @PostMapping("updateInstrument")
    @ApiImplicitParam(name = "instrument",value = "单个仪器",dataType = "PowerInstrument",required = true)
    @ApiOperation("更新仪器")
    public ResponseEntity<Map<String,Object>> updatePowerInstrument(@RequestBody PowerInstrument instrument){
        Map<String,Object> result = new HashMap<>();
        try {
            Long id = instrument.getInstrumentId();
            //校验仪器id不能为空
            if(id == null) {
                result.put("state","error");
                result.put("msg","仪器id不能为空!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
            }
            int changeCount = powerInstrumentService.update(instrument);
            if(changeCount == 0) {
                result.put("state","error");
                result.put("msg","没有找到仪器!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
            result.put("state","success");
            result.put("msg","修改仪器成功!");
        }catch (Exception e){
            logger.error(e);
            result.put("state","error");
            result.put("msg","系统错误!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "deleteInstrumentById")
    @ApiImplicitParam(name = "id",value = "id,仅逻辑删除仪器",paramType = "query" ,required = true)
    @ApiOperation(value = "单个删除仪器",notes = "id 必填,状态 0开启 1禁用 2删除 ")
    public ResponseEntity<Map<String,Object>> deletePowerInstrument(Long id){
        Map<String,Object> result = new HashMap<>();
        try{
            PowerInstrument instrument = powerInstrumentService.getById(id);
            if(instrument != null) {
                instrument.setInstrumentStatus(SystemStatusEnum.SYSTEM_STATUS_DELETED.getKey());
                powerInstrumentService.update(instrument);
                result.put("state","success");
                result.put("msg","删除成功!");
            }else {
                result.put("state","error");
                result.put("msg","没有查询到此仪器!");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("msg","服务异常!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }



    @PostMapping("queryInstrumentList")
    @ApiImplicitParam(name = "instrument",value = "设备查询条件，可为空",paramType = "PowerInstrument" ,required = false)
    @ApiOperation(value = "分页按条件查询仪器" ,notes="分页查询所有仪器")
    public ResponseEntity<List<PowerInstrument>> queryPowerInstrument(HttpServletRequest request, PowerInstrument instrument){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            Map<String, Object> params = JSONObject.parseObject(JSON.toJSONString(instrument), new TypeReference<Map<String, Object>>(){});
            params.put("instrumentStatus", SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            pageParam.setParams(params);
            PageBean pageInfo =this.powerInstrumentService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo.getRecordList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}