package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerSysConfigMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerSysConfig;
import com.putorn.powerdoc.service.PowerSysConfigService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerSysConfigServiceImpl
 */
@Service("powerSysConfigService")
public class PowerSysConfigServiceImpl extends BaseServiceImpl<PowerSysConfig> implements PowerSysConfigService {
    @Autowired
    private PowerSysConfigMapper powerSysConfigMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerSysConfigMapper;
    }

}
