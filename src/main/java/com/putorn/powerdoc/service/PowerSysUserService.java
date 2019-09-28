package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerSysUser;

import java.util.Map;

/**
 *  PowerSysUserService
 */
public interface PowerSysUserService extends BaseService<PowerSysUser>{

    Map<String,Object> saveUser(PowerSysUser upUser);
}
