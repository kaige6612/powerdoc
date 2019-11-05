package com.putorn.powerdoc.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.putorn.powerdoc.entity.PowerSysUser;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerSysUserService;
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
import java.util.List;
import java.util.Map;

/**
 *  PowerSysUserController
 */
@RestController
@RequestMapping("powerSysUser")
public class PowerSysUserController{
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private PowerSysUserService powerSysUserService;

    @PostMapping("saveUser")
    @ApiImplicitParam(name = "sysUser",value = "添加用户",dataType = "PowerSysUser",required = true)
    @ApiOperation(value = "添加用户",notes = "添加用户对象,主键自增",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> savePowerSysUser(@RequestBody PowerSysUser sysUser,HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        try {
            String errorMsg = ValidateEntityParam.validateUser(sysUser);
            if(errorMsg  != null) {
                result.put("state","error");
                result.put("msg",errorMsg);
            }else {
                String ipAdrress = IpUtil.getIpAdrress(request);
                sysUser.setRegip(ipAdrress);
                result = powerSysUserService.saveUser(sysUser);
            }
        }catch (Exception e){

            result.put("state","error");
            result.put("msg","服务异常");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        logger.info("添加用户结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }


    @PostMapping("updateUser")
    @ApiImplicitParam(name = "sysUser",value = "单个用户",dataType = "PowerSysUser",required = true)
    @ApiOperation("更新用户")
    public ResponseEntity<Map<String,Object>> updatePowerSysUser(@RequestBody PowerSysUser sysUser){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            Long id = sysUser.getId();
            //校验用户id不能为空
            if(id == null) {
                result.put("state","error");
                result.put("msg","用户id不能为空!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
            }
            int changeCount = powerSysUserService.update(sysUser);
            if(changeCount == 0) {
                result.put("state","error");
                result.put("msg","没有找到用户!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
            }
            result.put("state","success");
            result.put("msg","修改用户成功!");
        }catch (Exception e){
            logger.error(e);
            result.put("state","error");
            result.put("msg","系统错误!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "deleteUserById")
    @ApiImplicitParam(name = "id",value = "id,仅逻辑删除用户",paramType = "query" ,required = true)
    @ApiOperation(value = "单个删除用户",notes = "id 必填,状态 0开启 1禁用 2删除 ")
    public ResponseEntity<Map<String,Object>> deletePowerSysUser(Long id){
        Map<String,Object> result = new HashMap<>();
        try{
            PowerSysUser sysUser = powerSysUserService.getById(id);
            if(sysUser != null) {
                sysUser.setStatus(Integer.parseInt(SystemStatusEnum.SYSTEM_STATUS_DELETED.getKey()));
                powerSysUserService.update(sysUser);
                result.put("state","success");
                result.put("msg","删除成功!");
            }else {
                result.put("state","error");
                result.put("msg","没有查询到此用户!");
            }

        }catch (Exception e){
            e.printStackTrace();
            result.put("state","error");
            result.put("msg","服务异常!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("queryUserList")
    @ApiImplicitParam(name = "sysUser",value = "sysUser可为空的json",paramType = "PowerSysUser" ,required = false)
    @ApiOperation(value = "分页按条件查询用户" ,notes="分页查询所有用户")
    public ResponseEntity<PageBean> queryPowerSysUser(@RequestBody PageParam pageParam){
        try {
//            PageParam pageParam = PageParamHelper.getPageParam(request);
//            Map<String, Object> params = JSONObject.parseObject(JSON.toJSONString(sysUser), new TypeReference<Map<String, Object>>(){});
            pageParam.getParams().put("status",SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
//            pageParam.setParams(params);
            PageBean pageInfo =this.powerSysUserService.listPage(pageParam);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}