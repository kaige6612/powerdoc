package com.putorn.powerdoc.web;
import com.putorn.powerdoc.entity.PowerSysConfig;
import com.putorn.powerdoc.service.PowerSysConfigService;
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
 *  PowerSysConfigController
 */
@RestController
@RequestMapping("powerSysConfig")
public class PowerSysConfigController{

    @Autowired
    private PowerSysConfigService powerSysConfigService;

    @PostMapping("save")
    public ResponseEntity<Map<String,Object>> savePowerSysConfig(@RequestBody PowerSysConfig powerSysConfig){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            result.put("state","success");
            int changeCount = this.powerSysConfigService.save(powerSysConfig);
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
    public ResponseEntity<Map<String,Object>> updatePowerSysConfig(@RequestBody PowerSysConfig powerSysConfig){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            int changeCount = this.powerSysConfigService.update(powerSysConfig);
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
    public ResponseEntity<Map<String,Object>> deletePowerSysConfig(@RequestBody PowerSysConfig powerSysConfig){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            int changeCount = this.powerSysConfigService.delete(powerSysConfig.getId());
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
    public ResponseEntity<PageBean> queryPowerSysConfig(HttpServletRequest request){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            PageBean pageInfo =this.powerSysConfigService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}