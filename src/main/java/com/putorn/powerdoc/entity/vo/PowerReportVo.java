package com.putorn.powerdoc.entity.vo;

import com.alibaba.fastjson.JSONObject;
import com.putorn.powerdoc.entity.PowerReport;
import com.putorn.powerdoc.entity.PowerSubReport;

import java.util.List;

public class PowerReportVo extends PowerReport {

    private List<JSONObject> subReportList;

    public List<JSONObject> getSubReportList() {
        return subReportList;
    }

    public void setSubReportList(List<JSONObject> subReportList) {
        this.subReportList = subReportList;
    }
}
