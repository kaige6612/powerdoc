package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocResistanceDetailMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.service.PowerDocResistanceDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.entity.PowerDocResistanceDetail;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocResistanceDetailServiceImpl
 */
@Service("powerDocResistanceDetailService")
public class PowerDocResistanceDetailServiceImpl extends BaseServiceImpl<PowerDocResistanceDetail> implements PowerDocResistanceDetailService {
    @Autowired
    private PowerDocResistanceDetailMapper powerDocResistanceDetailMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocResistanceDetailMapper;
    }

}
