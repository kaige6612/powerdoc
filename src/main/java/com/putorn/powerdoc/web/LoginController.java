package com.putorn.powerdoc.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.putorn.powerdoc.common.UserSessionContext;
import com.putorn.powerdoc.entity.*;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.*;
import com.putorn.powerdoc.service.impl.PowerSysUserServiceImpl;
import com.putorn.powerdoc.util.IpUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private PowerSysUserServiceImpl userService;

    @Autowired
    private PowerSubstationService powerSubstationService;

    @Autowired
    private PowerInstrumentService powerInstrumentService;

    @Autowired
    private PowerDeviceModelService powerDeviceModelService;

    @Autowired
    private PowerDeviceService powerDeviceService;

    @Autowired
    private PowerModelService powerModelService;

    @PostMapping("userLogin")
    @ApiOperation(value = "用户登录",notes = "根据用户名和密码进行登录",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> saveUpUser(@RequestBody PowerSysUser paramUser, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();

        try {
            String userName = paramUser.getUsername();
            String password = paramUser.getPassword();
            logger.info("用户登录参数为:"+JSON.toJSONString(paramUser));
            if(StringUtils.isEmpty(userName)) {
                result.put("code","404");
                result.put("message","请输入用户名！");
            }else {
                PowerSysUser user = new PowerSysUser();
                user.setUsername(userName);
                List<PowerSysUser> userList = userService.listByObj(user);
                if(userList == null || userList.size() == 0) {
                    result.put("code","404");
                    result.put("message","没有此用户，请检查输入后重试");
                }else if(userList.size() > 1) {
                    result.put("code","400");
                    result.put("message","发现多个用户，请注意是否认为篡改数据库");
                }else {
                    boolean flag = false;
                    for (PowerSysUser queryUse:userList) {
                        if(queryUse.getPassword().equals(password)) {
                            //查询到的用户名密码与输入的相同，则登录成功
                            result.put("code","200");
                            result.put("message","登录成功");

                            flag = true;
                            //更新最新登录ip
                            String ipAdrress = IpUtil.getIpAdrress(request);
                            queryUse.setLastip(ipAdrress);
                            userService.update(queryUse);
                            //保存到缓存中，方便使用
                            UserSessionContext.setSession(queryUse);

                            //安全起见 不返回用户密码
                            queryUse.setPassword("");
                            result.put("result",queryUse);
                            HttpSession session = request.getSession();
                            session.setAttribute("user",queryUse);

                        }
                    }
                    if (!flag){
                        result.put("code","400");
                        result.put("message","密码错误！");
                    }
                }
            }

        }catch (Exception e){

            result.put("code","500");
            result.put("message","服务异常");
            result.put("result","");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        if(!result.containsKey("result")) {
            result.put("result","");
        }
        logger.info("用户登录返回结果："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }


    @PostMapping("getBasicData")
    @ApiOperation(value = "获取基础信息资料",notes = "获取基础信息资料",produces = "application/json")
    @ApiResponse(code = 200,message = "success")
    public ResponseEntity<Map<String,Object>> getBasicData(){
        Map<String,Object> result = new HashMap<>();

        JSONObject resultJson = new JSONObject();
        try {
            //查询所有有效用户
            PowerSysUser queryUser = new PowerSysUser();
            queryUser.setStatus(Integer.parseInt(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey()));
            List<PowerSysUser> powerSysUsers = userService.listByObj(queryUser);
            resultJson.put("userList",powerSysUsers);

            //查询所有变电站信息
            PowerSubstation powerSubstation = new PowerSubstation();
            List<PowerSubstation> powerSubstations = powerSubstationService.listByObj(powerSubstation);
            resultJson.put("substationsList",powerSubstations);

            //所有有效仪器信息
            PowerInstrument instrument = new PowerInstrument();
            instrument.setInstrumentStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            List<PowerInstrument> powerInstruments = powerInstrumentService.listByObj(instrument);
            resultJson.put("instrumentList",powerInstruments);

            //获取所有有效设备信息
            PowerDevice powerDevice = new PowerDevice();
            powerDevice.setStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            List<PowerDevice> powerDevices = powerDeviceService.listByObj(powerDevice);
            resultJson.put("deviceList",powerDevices);

            //获取所有有效模板信息
            PowerModel powerModel = new PowerModel();
            powerModel.setModelStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            List<PowerModel> powerModels = powerModelService.listByObj(powerModel);
            resultJson.put("modelList",powerModels);

            //获取所有配置的模板设备关系
            PowerDeviceModel powerDeviceModel = new PowerDeviceModel();

            List<PowerDeviceModel> powerDeviceModels = powerDeviceModelService.effectiveList(powerDeviceModel);
            resultJson.put("deviceModelList",powerDeviceModels);

            result.put("code","200");
            result.put("message","查询成功");
        }catch (Exception e){
            result.clear();
            result.put("code","500");
            result.put("message","服务异常");
            result.put("result","");
            logger.error("服务异常!!! result="+ JSON.toJSONString(result),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
        result.put("result",resultJson.toJSONString());
        logger.info("获取基础数据 ："+JSON.toJSONString(result));
        return ResponseEntity.ok(result);
    }
}
