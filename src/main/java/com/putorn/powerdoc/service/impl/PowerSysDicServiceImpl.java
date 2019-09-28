package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerSysDicMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerSysDic;
import com.putorn.powerdoc.service.PowerSysDicService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerSysDicServiceImpl
 */
@Service("powerSysDicService")
public class PowerSysDicServiceImpl extends BaseServiceImpl<PowerSysDic> implements PowerSysDicService {
    @Autowired
    private PowerSysDicMapper powerSysDicMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerSysDicMapper;
    }

}
