package com.putorn.powerdoc.web;
import com.putorn.powerdoc.entity.PowerModel;
import com.putorn.powerdoc.service.PowerModelService;
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
 *  PowerModelController
 */
@RestController
@RequestMapping("powerModel")
public class PowerModelController{

    @Autowired
    private PowerModelService powerModelService;

    @PostMapping("save")
    public ResponseEntity<Map<String,Object>> savePowerModel(@RequestBody PowerModel powerModel){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            result.put("state","success");
            int changeCount = this.powerModelService.save(powerModel);
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
    public ResponseEntity<Map<String,Object>> updatePowerModel(@RequestBody PowerModel powerModel){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            int changeCount = this.powerModelService.update(powerModel);
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
    public ResponseEntity<Map<String,Object>> deletePowerModel(@RequestBody PowerModel powerModel){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            int changeCount = this.powerModelService.delete(powerModel.getId());
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
    public ResponseEntity<PageBean> queryPowerModel(HttpServletRequest request){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            PageBean pageInfo =this.powerModelService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}