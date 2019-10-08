package com.putorn.powerdoc.entity.vo;

import com.putorn.powerdoc.entity.PowerDocDcResistance;
import com.putorn.powerdoc.entity.PowerDocResistanceDetail;

import java.util.List;

public class PowerDocDcResistanceVo extends PowerDocDcResistance {

    private List<PowerDocResistanceDetail> details;

    public List<PowerDocResistanceDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PowerDocResistanceDetail> details) {
        this.details = details;
    }
}
