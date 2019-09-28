package com.putorn.powerdoc.web;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.service.PowerDeviceService;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.base.PageParamHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("save")
    public ResponseEntity<Map<String,Object>> savePowerDevice(@RequestBody PowerDevice powerDevice){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            result.put("state","success");
            int changeCount = this.powerDeviceService.save(powerDevice);
            if(changeCount!=1) {
                result.put("state","error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("update")
    public ResponseEntity<Map<String,Object>> updatePowerDevice(@RequestBody PowerDevice powerDevice){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            int changeCount = this.powerDeviceService.update(powerDevice);
            result.put("state","success");
            if(changeCount!=1) {
                result.put("state","error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("delete")
    public ResponseEntity<Map<String,Object>> deletePowerDevice(@RequestBody PowerDevice powerDevice){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            int changeCount = this.powerDeviceService.delete(powerDevice.getId());
            result.put("state","success");
            if(changeCount!=1) {
                result.put("state","error");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }



    @PostMapping("query")
    public ResponseEntity<PageBean> queryPowerDevice(HttpServletRequest request){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            PageBean pageInfo =this.powerDeviceService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}