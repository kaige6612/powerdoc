package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDocHvBushingsMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.service.PowerDocHvBushingsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.entity.PowerDocHvBushings;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDocHvBushingsServiceImpl
 */
@Service("powerDocHvBushingsService")
public class PowerDocHvBushingsServiceImpl extends BaseServiceImpl<PowerDocHvBushings> implements PowerDocHvBushingsService {
    @Autowired
    private PowerDocHvBushingsMapper powerDocHvBushingsMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDocHvBushingsMapper;
    }

}
