package com.putorn.powerdoc.service;
import com.putorn.powerdoc.base.BaseService;
import com.putorn.powerdoc.entity.PowerReport;
import com.putorn.powerdoc.entity.vo.PowerReportVo;

import java.util.List;

/**
 *  PowerReportService
 */
public interface PowerReportService extends BaseService<PowerReport>{

    List<String> saveReportBatch(List<PowerReportVo> reportList);
}
