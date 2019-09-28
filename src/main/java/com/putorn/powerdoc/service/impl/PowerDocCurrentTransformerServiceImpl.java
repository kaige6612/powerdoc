package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocCurrentTransformerMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.service.PowerDocCurrentTransformerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.entity.PowerDocCurrentTransformer;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocCurrentTransformerServiceImpl
 */
@Service("powerDocCurrentTransformerService")
public class PowerDocCurrentTransformerServiceImpl extends BaseServiceImpl<PowerDocCurrentTransformer> implements PowerDocCurrentTransformerService {
    @Autowired
    private PowerDocCurrentTransformerMapper powerDocCurrentTransformerMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocCurrentTransformerMapper;
    }

}
