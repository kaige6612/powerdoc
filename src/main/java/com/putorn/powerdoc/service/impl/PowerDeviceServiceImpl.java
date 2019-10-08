package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDeviceMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerDeviceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> saveDevice(PowerDevice device) {
        Map<String, Object> result = new HashMap<>();
        if(device == null || StringUtils.isEmpty(device.getDeviceName())) {
            result.put("state","error");
            result.put("msg","未获取到设备名称，请检查！");
        }else {
            PowerDevice query = new PowerDevice();
            query.setDeviceName(device.getDeviceName());
            List<PowerDevice> PowerDevices = this.listByObj(query);
            //如果存在相同名称的设备名称
            if(PowerDevices != null && PowerDevices.size() > 0) {
                result.put("state","error");
                result.put("msg","当前设备名称存在，无法添加重名的设备！");
            }else {
                device.setStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
                this.save(device);
                result.put("state","success");
                result.put("msg","添加设备成功！");
            }
        }
        return result;
    }
}
