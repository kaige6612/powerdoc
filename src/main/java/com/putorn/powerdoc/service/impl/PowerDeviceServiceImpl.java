package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDeviceMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.service.PowerDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerDeviceServiceImpl
 */
@Service("powerDeviceService")
public class PowerDeviceServiceImpl extends BaseServiceImpl<PowerDevice> implements PowerDeviceService {
    @Autowired
    private PowerDeviceMapper powerDeviceMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDeviceMapper;
    }

}
