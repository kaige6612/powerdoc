package com.putorn.powerdoc.dao;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerDeviceModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  PowerDeviceModelMapper
 */
@Component
public interface PowerDeviceModelMapper extends BaseDao<PowerDeviceModel>{

    List<PowerDeviceModel> effectiveList(PowerDeviceModel powerDeviceModel);

    /**
     * 按设备查找模型
     * @param deviceId
     * @return
     */
    List<PowerDeviceModel> queryListByDeviceId(int deviceId);
}
