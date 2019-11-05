package com.putorn.powerdoc.web;
import com.putorn.powerdoc.entity.PowerDeviceModel;
import com.putorn.powerdoc.service.PowerDeviceModelService;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.base.PageParamHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  PowerDeviceModelController
 */
@RestController
@RequestMapping("powerDeviceModel")
public class PowerDeviceModelController{

    @Autowired
    private PowerDeviceModelService powerDeviceModelService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId",value = "设备id",required = true),
            @ApiImplicitParam(name = "modelId",value = "模板id, 当有多个时，以英文半角逗号分割, eg: 1,2,3",required = true)
    })
    @ApiOperation(value = "配置设备与模板关系",notes = "配置设备与模板关系",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    @PostMapping("save")
    public ResponseEntity<Map<String,Object>> savePowerDeviceModel(@RequestParam String deviceId, @RequestParam String modelId){
        Map<String,Object> result = new HashMap<String,Object>();
        String message =  null;
        boolean success = false;
        try {
            if(StringUtils.isEmpty(deviceId) || StringUtils.isEmpty(modelId)) {
                message = "模型id或设备id不能为空";
            }else {
                // todo 需要把此处代码放到service中去执行，需控制事物的回滚
                String[] modelIds = modelId.split(",");
                for (int i = 0; i < modelIds.length; i++ ) {
                    String ret = powerDeviceModelService.saveByDeviceIdAndModelId(deviceId,modelIds[i]);
                    message = (message == null ? ret : message);
                }
//                message = powerDeviceModelService.saveByDeviceIdAndModelId(deviceId,modelId);
                if(message == null) {
                    success = true;
                    message = "新增成功";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("message","服务异常");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        result.put("message",message);
        if(!success) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("update")
    public ResponseEntity<Map<String,Object>> updatePowerDeviceModel(@RequestBody PowerDeviceModel powerDeviceModel){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            int changeCount = this.powerDeviceModelService.update(powerDeviceModel);
            result.put("message","success");
            if(changeCount!=1) {
                result.put("message","error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("message","error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("delete")
    public ResponseEntity<Map<String,Object>> deletePowerDeviceModel(@RequestBody PowerDeviceModel powerDeviceModel){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            int changeCount = this.powerDeviceModelService.delete(powerDeviceModel.getId());
            result.put("message","success");
            if(changeCount!=1) {
                result.put("message","error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("message","error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("queryModelByDeviceId")
    public ResponseEntity<List<PowerDeviceModel>> queryPowerDeviceModelByDeviceId(@RequestParam int deviceId) {
        List<PowerDeviceModel> powerDeviceModels = powerDeviceModelService.queryListByDeviceId(deviceId);
        return ResponseEntity.ok(powerDeviceModels);
    }


    @PostMapping("query")
    public ResponseEntity<PageBean> queryPowerDeviceModel(HttpServletRequest request){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            PageBean pageInfo =this.powerDeviceModelService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}