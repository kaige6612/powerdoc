package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerDeviceModelMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerDevice;
import com.putorn.powerdoc.entity.PowerDeviceModel;
import com.putorn.powerdoc.entity.PowerModel;
import com.putorn.powerdoc.service.PowerDeviceModelService;
import com.putorn.powerdoc.service.PowerDeviceService;
import com.putorn.powerdoc.service.PowerModelService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;

import java.util.List;

/**
 *  PowerDeviceModelServiceImpl
 */
@Service("powerDeviceModelService")
public class PowerDeviceModelServiceImpl extends BaseServiceImpl<PowerDeviceModel> implements PowerDeviceModelService {
    @Autowired
    private PowerDeviceModelMapper powerDeviceModelMapper;

    @Autowired
    private PowerDeviceService deviceService;

    @Autowired
    private PowerModelService modelService;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerDeviceModelMapper;
    }

    @Override
    public String saveByDeviceIdAndModelId(String deviceId, String modelId) {
        String error = null;
        Long deviceIdLong = Long.parseLong(deviceId);
        Long modelIdLong = Long.parseLong(modelId);
        PowerDevice device = deviceService.getById(deviceIdLong);
        PowerModel model = modelService.getById(modelIdLong);
        if(device == null || model == null) {
            error = "没有查询到设备信息或模板信息";
        }else {
            PowerDeviceModel deviceModel = new PowerDeviceModel();
            deviceModel.setModelId(modelIdLong);
            deviceModel.setDeviceId(deviceIdLong);
            deviceModel.setDevieName(device.getDeviceName());
            deviceModel.setModelName(model.getModelName());
            int insert = powerDeviceModelMapper.insert(deviceModel);
            if(insert != 1) {
                error = "新增失败";
            }
        }
        return error;
    }

    @Override
    public List<PowerDeviceModel> effectiveList(PowerDeviceModel powerDeviceModel) {
        return powerDeviceModelMapper.effectiveList(powerDeviceModel);
    }
}
