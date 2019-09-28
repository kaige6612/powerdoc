package com.putorn.powerdoc.entity.vo;

import com.putorn.powerdoc.entity.PowerReport;
import com.putorn.powerdoc.entity.PowerSubReport;

import java.util.List;

public class PowerReportVo extends PowerReport {

    private List<PowerSubReportVo> subReportList;

    public List<PowerSubReportVo> getSubReportList() {
        return subReportList;
    }

    public void setSubReportList(List<PowerSubReportVo> subReportList) {
        this.subReportList = subReportList;
    }
}
