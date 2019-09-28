package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocDcResistanceMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.service.PowerDocDcResistanceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.entity.PowerDocDcResistance;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocDcResistanceServiceImpl
 */
@Service("powerDocDcResistanceService")
public class PowerDocDcResistanceServiceImpl extends BaseServiceImpl<PowerDocDcResistance> implements PowerDocDcResistanceService {
    @Autowired
    private PowerDocDcResistanceMapper powerDocDcResistanceMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocDcResistanceMapper;
    }

}
