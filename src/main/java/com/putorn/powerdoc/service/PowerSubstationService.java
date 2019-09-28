package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerSubstation;

import java.util.Map;

/**
 *  PowerSubstationService
 */
public interface PowerSubstationService extends BaseService<PowerSubstation>{

    Map<String,Object> saveSubstation(PowerSubstation substation);
}
