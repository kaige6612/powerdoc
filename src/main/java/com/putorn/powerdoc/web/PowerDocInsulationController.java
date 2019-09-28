package com.putorn.powerdoc.web;
import com.putorn.powerdoc.entity.PowerDocInsulation;
import com.putorn.powerdoc.service.PowerDocInsulationService;
import com.putorn.powerdoc.base.PageBean;
import com.putorn.powerdoc.base.PageParam;
import com.putorn.powerdoc.base.PageParamHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
 *  PowerDocInsulationController
 */
@RestController
@RequestMapping("powerDocInsulation")
public class PowerDocInsulationController{

    @Autowired
    private PowerDocInsulationService powerDocInsulationService;

    @PostMapping("save")
    @ApiImplicitParam(name = "powerDocInsulation",value = "添加用户",dataType = "PowerDocInsulation",required = true)
    @ApiOperation(value = "添加报告",notes = "添加报告",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> savePowerDocInsulation(@RequestBody PowerDocInsulation powerDocInsulation){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            result.put("state","success");
            int changeCount = this.powerDocInsulationService.save(powerDocInsulation);
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
    public ResponseEntity<Map<String,Object>> updatePowerDocInsulation(@RequestBody PowerDocInsulation powerDocInsulation){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            int changeCount = this.powerDocInsulationService.update(powerDocInsulation);
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
    public ResponseEntity<Map<String,Object>> deletePowerDocInsulation(@RequestBody PowerDocInsulation powerDocInsulation){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            int changeCount = this.powerDocInsulationService.delete(powerDocInsulation.getId());
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
    public ResponseEntity<PageBean> queryPowerDocInsulation(HttpServletRequest request){
        try {
            PageParam pageParam = PageParamHelper.getPageParam(request);
            PageBean pageInfo =this.powerDocInsulationService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}