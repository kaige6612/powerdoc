package com.putorn.powerdoc.entity.vo;

import com.alibaba.fastjson.JSONObject;
import com.putorn.powerdoc.entity.PowerSubReport;


public class PowerSubReportVo extends PowerSubReport  {
    private JSONObject reportDetail;

    public JSONObject getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(JSONObject reportDetail) {
        this.reportDetail = reportDetail;
    }
}
