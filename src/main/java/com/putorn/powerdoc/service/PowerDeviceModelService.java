package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerDeviceModel;

import java.util.List;

/**
 *  PowerDeviceModelService
 */
public interface PowerDeviceModelService extends BaseService<PowerDeviceModel>{

    String saveByDeviceIdAndModelId(String deviceId, String modelId);

    List<PowerDeviceModel> effectiveList(PowerDeviceModel powerDeviceModel);

    /**
     * 按设备查找模型
     * @param deviceId
     * @return
     */
    List<PowerDeviceModel> queryListByDeviceId(int deviceId);
}
