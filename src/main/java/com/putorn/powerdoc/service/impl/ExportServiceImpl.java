package com.putorn.powerdoc.service.impl;

import com.alibaba.fastjson.JSON;
import com.putorn.powerdoc.dao.*;
import com.putorn.powerdoc.entity.*;
import com.putorn.powerdoc.service.ExportService;
import com.putorn.powerdoc.util.DataConvertUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
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
        PowerSubReport subReportQuery = new PowerSubReport();
        subReportQuery.setReportId(reportIdLong);
        List<PowerSubReport> powerSubReports = subReportMapper.listByObj(subReportQuery);

        for (PowerSubReport subReport: powerSubReports) {



        }
        //查询报告中的具体数据

        return null;
    }

    /**
     * 根据选用的模板的不同，确定查询表，获取数据
     * @param subReport
     * @return
     */
    private String getSubRepost(PowerSubReport subReport) throws Exception{
        String errMsg = null;
        Long subReportId = subReport.getId();
        Long deviceModelId = subReport.getDeviceModelId();

        Map<String, Object> subReportMap = DataConvertUtil.javaBeanToMap(subReport);
        Map<String, Object> detailMap = new HashMap<>();
        PowerModel powerModel = modelMapper.selectByPrimaryKey(deviceModelMapper.selectByPrimaryKey(deviceModelId).getModelId());

        if(powerModel == null) {
            errMsg = "没有查询到报告对应的模板信息，请检查！";
        }
        switch (powerModel.getModelTableName()) {
            case "power_doc_insulation":
                PowerDocInsulation insulation = new PowerDocInsulation();
                insulation.setSubreportId(subReportId);
                List<PowerDocInsulation> powerDocInsulations = insulationMapper.listByObj(insulation);
                logger.info("查询结果："+ JSON.toJSONString(powerDocInsulations));
                //每个子报告只可能对应一个子报告内容，否则就是异常数据不予处理
                if(powerDocInsulations != null && powerDocInsulations.size() == 1) {
                    insulation = powerDocInsulations.get(0);
                    detailMap = DataConvertUtil.javaBeanToMap(insulation);
                }
                break;
            case "power_doc_dc_resistance":
                PowerDocDcResistance dcResistance = new PowerDocDcResistance();
                dcResistance.setSubreportId(subReportId);
                List<PowerDocDcResistance> dcResistances = dcResistanceMapper.listByObj(dcResistance);
                logger.info("查询结果："+ JSON.toJSONString(dcResistances));
                //每个子报告只可能对应一个子报告内容，否则就是异常数据不予处理
                if(dcResistances != null && dcResistances.size() == 1) {
                    dcResistance = dcResistances.get(0);
                    detailMap = DataConvertUtil.javaBeanToMap(dcResistance);
                    
                    //查询列表分列信息
                    PowerDocResistanceDetail detailQuery = new PowerDocResistanceDetail();
                    detailQuery.setSubreportId(subReportId);
                    List<PowerDocResistanceDetail> powerDocResistanceDetails = resistanceDetailMapper.listByObj(detailQuery);
                    for (PowerDocResistanceDetail detail:powerDocResistanceDetails) {
                        detailMap.put(detail.getRowNum()+"HighAO",detail.getHighAo());
                        detailMap.put(detail.getRowNum()+"HighBO",detail.getHighBo());
                        detailMap.put(detail.getRowNum()+"HighCO",detail.getHighCo());
                        detailMap.put(detail.getRowNum()+"HighError",detail.getHighError());
                        detailMap.put(detail.getRowNum()+"MiddleAmOm",detail.getMiddleAmOm());
                        detailMap.put(detail.getRowNum()+"MiddleBmOm",detail.getMiddleBmOm());
                        detailMap.put(detail.getRowNum()+"MiddleCmOm",detail.getMiddleCmOm());
                        detailMap.put(detail.getRowNum()+"MiddleError",detail.getMiddleError());
                    }
                    if(powerDocResistanceDetails.size() < 17) {//不足17 行，则其他行默认为空
                        for (int i = powerDocResistanceDetails.size(); i < 18; i++) {
                            detailMap.put(i+"HighAO","");
                            detailMap.put(i+"HighBO","");
                            detailMap.put(i+"HighCO","");
                            detailMap.put(i+"HighError","");
                            detailMap.put(i+"MiddleAmOm","");
                            detailMap.put(i+"MiddleBmOm","");
                            detailMap.put(i+"MiddleCmOm","");
                            detailMap.put(i+"MiddleError","");
                        }
                    }

                    
                }
                break;
            case "power_doc_hv_bushings":
                
                PowerDocHvBushings hvBushings = new PowerDocHvBushings();
                hvBushings.setSubreportId(subReportId);
                List<PowerDocHvBushings> hvBushingss = hvBushingsMapper.listByObj(hvBushings);
                logger.info("查询结果："+ JSON.toJSONString(hvBushingss));
                //每个子报告只可能对应一个子报告内容，否则就是异常数据不予处理
                if(hvBushingss != null && hvBushingss.size() == 1) {
                    hvBushings = hvBushingss.get(0);
                    detailMap = DataConvertUtil.javaBeanToMap(hvBushings);
                }
                break;
            case "power_doc_voltage_transformer":
                PowerDocVoltageTransformer voltageTransformer = new PowerDocVoltageTransformer();
                voltageTransformer.setSubreportId(subReportId);
                List<PowerDocVoltageTransformer> voltageTransformers = voltageTransformerMapper.listByObj(voltageTransformer);
                logger.info("查询结果："+ JSON.toJSONString(voltageTransformers));
                //每个子报告只可能对应一个子报告内容，否则就是异常数据不予处理
                if(voltageTransformers != null && voltageTransformers.size() == 1) {
                    voltageTransformer = voltageTransformers.get(0);
                    detailMap = DataConvertUtil.javaBeanToMap(voltageTransformer);
                }
                break;

            case "power_doc_current_transformer":
                
                PowerDocCurrentTransformer currentTransformer = new PowerDocCurrentTransformer();
                currentTransformer.setSubreportId(subReportId);
                List<PowerDocCurrentTransformer> currentTransformers = currentTransformerMapper.listByObj(currentTransformer);
                logger.info("查询结果："+ JSON.toJSONString(currentTransformers));
                //每个子报告只可能对应一个子报告内容，否则就是异常数据不予处理
                if(currentTransformers != null && currentTransformers.size() == 1) {
                    currentTransformer = currentTransformers.get(0);
                    detailMap = DataConvertUtil.javaBeanToMap(currentTransformer);
                }
                break;
                        
        }
        //合并属性，生产完整的子报告
        subReportMap.putAll(detailMap);

        return errMsg;
    }
}
