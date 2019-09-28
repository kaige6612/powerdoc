package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocInsulationMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerDocInsulation;
import com.putorn.powerdoc.service.PowerDocInsulationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocInsulationServiceImpl
 */
@Service("powerDocInsulationService")
public class PowerDocInsulationServiceImpl extends BaseServiceImpl<PowerDocInsulation> implements PowerDocInsulationService {
    @Autowired
    private PowerDocInsulationMapper powerDocInsulationMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocInsulationMapper;
    }

}
