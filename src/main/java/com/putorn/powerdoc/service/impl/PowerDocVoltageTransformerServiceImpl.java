package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocVoltageTransformerMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.service.PowerDocVoltageTransformerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.entity.PowerDocVoltageTransformer;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocVoltageTransformerServiceImpl
 */
@Service("powerDocVoltageTransformerService")
public class PowerDocVoltageTransformerServiceImpl extends BaseServiceImpl<PowerDocVoltageTransformer> implements PowerDocVoltageTransformerService {
    @Autowired
    private PowerDocVoltageTransformerMapper powerDocVoltageTransformerMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocVoltageTransformerMapper;
    }

}
