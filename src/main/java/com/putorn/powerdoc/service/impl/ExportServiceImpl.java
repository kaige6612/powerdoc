package com.putorn.powerdoc.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.DocxRenderData;
import com.putorn.powerdoc.dao.*;
import com.putorn.powerdoc.entity.*;
import com.putorn.powerdoc.entity.vo.PowerReportExportEntity;
import com.putorn.powerdoc.service.ExportService;
import com.putorn.powerdoc.util.DataConvertUtil;
import com.putorn.powerdoc.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

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
        OutputStream out = null;
        try {
            //查询报告主页信息
            PowerReport powerReport = powerReportMapper.selectByPrimaryKey(reportIdLong);

            PowerReportExportEntity exportEntity = new PowerReportExportEntity();
            exportEntity.setReport(powerReport);
            //查询每个报告的表头信息
            PowerSubReport subReportQuery = new PowerSubReport();
            subReportQuery.setReportId(reportIdLong);
            List<PowerSubReport> powerSubReports = subReportMapper.listByObj(subReportQuery);
            Map<String,List<PowerSubReport>> groups = this.groupSubReports(powerSubReports);

            //遍历都包含哪些模板子报告
            Set<String> keySet = groups.keySet();
            List<PowerModel> powerModels = modelMapper.listByObj(new PowerModel());
            for (PowerModel model : powerModels) {
                String tableName = model.getModelTableName();
                if(!keySet.contains(tableName)) {
                    // 不包含，则直接生成空文档
                    exportEntity = this.setDocRenderNull(exportEntity,tableName);
                }else {
                    //包含则拼接文档
                    // 1、获取模板对应的子报告
                    List<PowerSubReport> subReports = groups.get(tableName);

                    // 2、根据库名，获取子报告详情
                    List<Map<String, Object>> subReportDetail = getSubReportDetail(tableName, subReports,powerReport);

                    // 3、设置要生成的文档
                    exportEntity = setDocs(exportEntity, tableName, subReportDetail);

                }
            }

            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/0_first.docx");

//        生成报告
            XWPFTemplate template = XWPFTemplate.compile(inputStream).render(exportEntity);

            String docName = "实验报告"+ DateUtil.getDateTime2()+".docx";
//            docName = URLEncoder.encode(docName,"UTF-8");
            //设置响应流
            response.addHeader("Content-Type", "application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=" +docName);
            out = response.getOutputStream();
            template.write(out);
            out.flush();
            out.close();
            template.close();
        //查询报告中的具体数据
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 不存在的直接写入null
     * @param exportEntity
     * @param tableName
     * @return
     */
    private PowerReportExportEntity setDocRenderNull(PowerReportExportEntity exportEntity, String tableName) {
        if(tableName.equalsIgnoreCase("power_doc_insulation")) {
            exportEntity.setInsulation(null);
        }
        if(tableName.equalsIgnoreCase("power_doc_dc_resistance")) {
            exportEntity.setDcResistance(null);
        }
        if(tableName.equalsIgnoreCase("power_doc_hv_bushings")) {
            exportEntity.setHvBushings(null);
        }
        if(tableName.equalsIgnoreCase("power_doc_voltage_transformer")) {
            exportEntity.setVoltageTransformer(null);
        }
        if(tableName.equalsIgnoreCase("power_doc_current_transformer")) {
            exportEntity.setCurrentTransformer(null);
        }
        return exportEntity;
    }

    /**
     * 分组，将同一模板设备id的报告分为一组
     * @param powerSubReports
     * @return
     */
    private Map<String, List<PowerSubReport>> groupSubReports(List<PowerSubReport> powerSubReports) {
        Map<String, List<PowerSubReport>> result = new HashMap<>();
        for (PowerSubReport subReport:powerSubReports){
            String deviceModelId = subReport.getDeviceModelId().toString();
            PowerModel powerModel = modelMapper.selectByPrimaryKey(deviceModelMapper.selectByPrimaryKey(Long.parseLong(deviceModelId)).getModelId());

            String tableName = powerModel.getModelTableName();
            List<PowerSubReport> list = result.containsKey(tableName)? result.get(tableName) : new ArrayList<>();

            list.add(subReport);
            result.put(tableName,list);
        }
        return result;
    }

    /**
     * 根据选用的模板的不同，确定查询表，获取数据
     * @param tableName
     * @param subReports
     * @return
     */
    private List<Map<String,Object>> getSubReportDetail(String tableName,List<PowerSubReport> subReports,PowerReport report) throws Exception{
//
        List<Map<String,Object>> list = new ArrayList<>();
        for (PowerSubReport subReport : subReports) {
            Map<String, Object> subReportMap = DataConvertUtil.javaBeanToMap(subReport);
            Map<String, Object> detailMap = new HashMap<>();
            Long subReportId = subReport.getId();

            //将报告封面中的公共信息加入map中
            subReportMap.put("substationName",report.getSubstationName());
            subReportMap.put("runNo",report.getRunNo());
            subReportMap.put("testDate",report.getTestDate());
            switch (tableName) {
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
                            detailMap.put(detail.getRowNum()+"AO",detail.getHighAo());
                            detailMap.put(detail.getRowNum()+"BO",detail.getHighBo());
                            detailMap.put(detail.getRowNum()+"CO",detail.getHighCo());
                            detailMap.put(detail.getRowNum()+"Er",detail.getHighError());
                            detailMap.put(detail.getRowNum()+"Am",detail.getMiddleAmOm());
                            detailMap.put(detail.getRowNum()+"Bm",detail.getMiddleBmOm());
                            detailMap.put(detail.getRowNum()+"Cm",detail.getMiddleCmOm());
                            detailMap.put(detail.getRowNum()+"MEr",detail.getMiddleError());
                        }
                        if(powerDocResistanceDetails.size() < 17) {//不足17 行，则其他行默认为空
                            for (int i = powerDocResistanceDetails.size(); i < 18; i++) {
                                detailMap.put(i+"AO","");
                                detailMap.put(i+"BO","");
                                detailMap.put(i+"CO","");
                                detailMap.put(i+"Er","");
                                detailMap.put(i+"Am","");
                                detailMap.put(i+"Bm","");
                                detailMap.put(i+"Cm","");
                                detailMap.put(i+"MEr","");
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

            subReportMap.putAll(detailMap);
            list.add(subReportMap);
        }
        return list;
    }

    private PowerReportExportEntity setDocs(PowerReportExportEntity exportEntity,String tableName,List<Map<String, Object>> subReportDetail) {
        //判定写入哪个模板数据
        if(tableName.equalsIgnoreCase("power_doc_insulation")) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/1_insulation.docx");

            DocxRenderData insulation = new DocxRenderData(inputStream, subReportDetail );
            exportEntity.setInsulation(insulation);
        }
        if(tableName.equalsIgnoreCase("power_doc_dc_resistance")) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/2_dc_resistance.docx");

            DocxRenderData dcResistance = new DocxRenderData(inputStream, subReportDetail );
            exportEntity.setDcResistance(dcResistance);
        }
        if(tableName.equalsIgnoreCase("power_doc_hv_bushings")) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/3_hv_bushings.docx");

            DocxRenderData hvBushings = new DocxRenderData(inputStream, subReportDetail );
            exportEntity.setHvBushings(hvBushings);
        }
        if(tableName.equalsIgnoreCase("power_doc_voltage_transformer")) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/15_voltage_transformer.docx");

            DocxRenderData voltageTransformer = new DocxRenderData(inputStream, subReportDetail );
            exportEntity.setVoltageTransformer(voltageTransformer);
        }
        if(tableName.equalsIgnoreCase("power_doc_current_transformer")) {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("template/16_current_transformer.docx");

            DocxRenderData currentTransformer = new DocxRenderData(inputStream, subReportDetail );
            exportEntity.setCurrentTransformer(currentTransformer);
        }
        return exportEntity;
    }
}
