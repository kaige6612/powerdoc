package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerInstrumentMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerInstrument;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerInstrumentService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  PowerInstrumentServiceImpl
 */
@Service("powerInstrumentService")
public class PowerInstrumentServiceImpl extends BaseServiceImpl<PowerInstrument> implements PowerInstrumentService {
    @Autowired
    private PowerInstrumentMapper powerInstrumentMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerInstrumentMapper;
    }

    @Override
    public Map<String, Object> saveInstrument(PowerInstrument instrument) {
        Map<String, Object> result = new HashMap<>();
        if(instrument == null || StringUtils.isEmpty(instrument.getInstrumentName())) {
            result.put("state","error");
            result.put("msg","未获取到仪器名称，请检查！");
        }else {
            PowerInstrument query = new PowerInstrument();
            query.setInstrumentName(instrument.getInstrumentName());
            List<PowerInstrument> PowerInstruments = this.listByObj(query);
            //如果存在相同名称的仪器名称
            if(PowerInstruments != null && PowerInstruments.size() > 0) {
                result.put("state","error");
                result.put("msg","当前仪器名称存在，无法添加重名的仪器！");
            }else {
                instrument.setInstrumentStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
                this.save(instrument);
                result.put("state","success");
                result.put("msg","添加仪器成功！");
            }
        }
        return result;
    }
}
