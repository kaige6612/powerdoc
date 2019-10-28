package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.common.UserSessionContext;
import com.putorn.powerdoc.dao.PowerSysUserMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerSysUser;
import com.putorn.powerdoc.enumconst.SystemAdminEnum;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerSysUserService;
import com.putorn.powerdoc.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  PowerSysUserServiceImpl
 */
@Service("powerSysUserService")
public class PowerSysUserServiceImpl extends BaseServiceImpl<PowerSysUser> implements PowerSysUserService {
    @Autowired
    private PowerSysUserMapper powerSysUserMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerSysUserMapper;
    }

    @Override
    public Map<String, Object> saveUser(PowerSysUser upUser) {
        Map<String, Object> result = new HashMap<>();
        PowerSysUser queryUser = new PowerSysUser();
        queryUser.setUsername(upUser.getUsername());
        List<PowerSysUser> upUsers = this.listByObj(queryUser);
        //该用户名已存在
        if (upUsers != null && upUsers.size() > 0) {
            result.put("state", "error");
            result.put("msg", "用户名已被占用，请重新输入");
        } else {

            String nowTime = DateUtil.getDateTime();
            upUser.setRegtime(Timestamp.valueOf(nowTime));
            upUser.setStatus(Integer.parseInt(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey()));

            //如果没有此参数,默认非系统管理员
            Integer isSysadmin = upUser.getIsSysadmin() == null ? SystemAdminEnum.NO.getKey() : upUser.getIsSysadmin();
            upUser.setIsSysadmin(isSysadmin);

            result.put("state", "success");
            result.put("msg", "添加用户成功");
            this.save(upUser);
        }
        return result;
    }
}
