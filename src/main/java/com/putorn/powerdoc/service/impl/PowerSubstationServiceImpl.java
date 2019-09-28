package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerSubstationMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerSubstation;
import com.putorn.powerdoc.service.PowerSubstationService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  PowerSubstationServiceImpl
 */
@Service("powerSubstationService")
public class PowerSubstationServiceImpl extends BaseServiceImpl<PowerSubstation> implements PowerSubstationService {
    @Autowired
    private PowerSubstationMapper powerSubstationMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerSubstationMapper;
    }

    @Override
    public Map<String, Object> saveSubstation(PowerSubstation substation) {
        Map<String, Object> result = new HashMap<>();
        if(substation == null || StringUtils.isEmpty(substation.getSubstationName())) {
            result.put("state","error");
            result.put("msg","未获取到变电站名称，请检查！");
        }else {
            PowerSubstation query = new PowerSubstation();
            query.setSubstationName(substation.getSubstationName());
            List<PowerSubstation> powerSubstations = powerSubstationMapper.listByObj(query);
            //如果存在相同名称的变电站名称
            if(powerSubstations != null && powerSubstations.size() > 0) {
                result.put("state","error");
                result.put("msg","当前变电站名称存在，无法添加重名的变电站！");
            }else {
                this.save(substation);
                result.put("state","success");
                result.put("msg","添加变电站成功！");
            }
        }

        return result;
    }
}
