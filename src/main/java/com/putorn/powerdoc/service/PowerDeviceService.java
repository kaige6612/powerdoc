package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerDevice;

import java.util.Map;

/**
 *  PowerDeviceService
 */
public interface PowerDeviceService extends BaseService<PowerDevice>{

    Map<String, Object> saveDevice(PowerDevice device);
}
