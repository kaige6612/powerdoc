package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerModelMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerModel;
import com.putorn.powerdoc.service.PowerModelService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerModelServiceImpl
 */
@Service("powerModelService")
public class PowerModelServiceImpl extends BaseServiceImpl<PowerModel> implements PowerModelService {
    @Autowired
    private PowerModelMapper powerModelMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerModelMapper;
    }

}
