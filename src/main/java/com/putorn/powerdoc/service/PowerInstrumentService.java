package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerInstrument;

import java.util.Map;

/**
 *  PowerInstrumentService
 */
public interface PowerInstrumentService extends BaseService<PowerInstrument>{

    Map<String,Object> saveInstrument(PowerInstrument instrument);
}
