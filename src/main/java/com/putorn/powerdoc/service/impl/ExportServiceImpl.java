package com.putorn.powerdoc.service.impl;

import com.putorn.powerdoc.dao.*;
import com.putorn.powerdoc.entity.PowerReport;
import com.putorn.powerdoc.entity.PowerSubReport;
import com.putorn.powerdoc.service.ExportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service("exportService")
public class ExportServiceImpl implements ExportService {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private PowerReportMapper powerReportMapper;

    @Autowired
    private PowerSubstationMapper substationMapper;

    @Autowired
    private PowerDeviceMapper deviceMapper;

    @Autowired
    private PowerSysUserMapper userMapper;

    @Autowired
    private PowerInstrumentMapper instrumentMapper;

    @Autowired
    private PowerSubReportMapper subReportMapper;

    @Autowired
    private PowerDeviceModelMapper deviceModelMapper;

    @Autowired
    private PowerModelMapper modelMapper;

    @Autowired
    private PowerDocInsulationMapper insulationMapper;

    @Autowired
    private PowerDocDcResistanceMapper dcResistanceMapper;

    @Autowired
    private PowerDocHvBushingsMapper hvBushingsMapper;

    @Autowired
    private PowerDocVoltageTransformerMapper voltageTransformerMapper;

    @Autowired
    private PowerDocCurrentTransformerMapper currentTransformerMapper;

    @Autowired
    private PowerDocResistanceDetailMapper resistanceDetailMapper;
    @Override
    public Map<String, Object> exportDocByReportId(String reportId, HttpServletResponse response) {
        Long reportIdLong = Long.parseLong(reportId);
        //查询报告主页信息
        PowerReport powerReport = powerReportMapper.selectByPrimaryKey(reportIdLong);

        //查询每个报告的表头信息
        PowerSubReport subReport = new PowerSubReport();
        subReport.setReportId(reportIdLong);
        List<PowerSubReport> powerSubReports = subReportMapper.listByObj(subReport);

        //查询报告中的具体数据

        return null;
    }
}
