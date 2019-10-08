package com.putorn.powerdoc.service.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.putorn.powerdoc.base.BaseEntity;
import com.putorn.powerdoc.dao.*;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.*;
import com.putorn.powerdoc.entity.vo.PowerDocDcResistanceVo;
import com.putorn.powerdoc.entity.vo.PowerReportVo;
import com.putorn.powerdoc.entity.vo.PowerSubReportVo;
import com.putorn.powerdoc.entity.vo.SubReportDetailInterface;
import com.putorn.powerdoc.enumconst.SystemStatusEnum;
import com.putorn.powerdoc.service.PowerReportService;
import io.swagger.models.auth.In;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  PowerReportServiceImpl
 */
@Service("powerReportService")
@Transactional
public class PowerReportServiceImpl extends BaseServiceImpl<PowerReport> implements PowerReportService {
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
    protected BaseDao getBaseDao() {
        return this.powerReportMapper;
    }

    @Override
    public List<String> saveReportBatch(List<PowerReportVo> reportList) {
        List<String> errorList = new ArrayList<>();
        for (PowerReportVo powerReportVo :reportList) {
            //保存报告封面信息
            String error = this.insertReportFromVo(powerReportVo);
            //保存发生错误，则记录此错误报告的id,并跳过此条数据
            if(error != null) {
                errorList.add(String.valueOf(powerReportVo.getId()));
                continue;
            }else {
                //保存正常，则继续保存各个设备详细报告
                List<PowerSubReportVo> subReportList = powerReportVo.getSubReportList();
                for (PowerSubReportVo subReportVo:subReportList) {

                    //保存设备报告公共信息
                    Map<String, Object> subReportResultMap = this.saveSubReportFromVo(subReportVo, powerReportVo);
                    if(subReportResultMap.containsKey("errorMsg") && !StringUtils.isEmpty(subReportResultMap.get("errorMsg"))) {
                        errorList.add(error);
                        continue;
                    }else {
                        //获取插入的子报告id
                        String subReportId = subReportResultMap.get("subReportId").toString();

                        //根据选择的模板和设备对应关系，确定使用的模板，以确定需要插入数据的表格
                        String modelDeviceId = subReportVo.getModelDeviceId();

                        //必须存在此字段，否则无法判别需要转换的类及需要使用的模板
                        if(!StringUtils.isEmpty(modelDeviceId)) {
                            PowerDeviceModel powerDeviceModel = deviceModelMapper.selectByPrimaryKey(Long.parseLong(modelDeviceId));
                            PowerModel powerModel = modelMapper.selectByPrimaryKey(powerDeviceModel.getModelId());

                            //保存具体的报告信息
                            saveSubDetail(powerModel,subReportVo,subReportId);
                        }

                    }

                }
                
            }
        }
        return errorList;
    }

    /**
     * 保存报告详细数据信息
     * @param powerModel
     * @param subReportVo
     * @param subReportId
     */
    private void saveSubDetail(PowerModel powerModel,PowerSubReportVo subReportVo,String subReportId){
        String modelTableName = powerModel.getModelTableName();

        //获取具体报告内容
        JSONObject subReportDerail = subReportVo.getReportDetail();

        //判断报告内容，并保存相应的报告信息
        switch (modelTableName) {
            //变压器绝缘试验报告
            case "power_doc_insulation":
                PowerDocInsulation insulation = JSON.toJavaObject(subReportDerail,PowerDocInsulation.class);
                insulation.setSubreportId(Long.parseLong(subReportId));

                insulationMapper.insert(insulation);
                //保存报告具体信息
                break;

            //变压器直流电阻试验报告
            case "power_doc_dc_resistance":
                PowerDocDcResistanceVo resistanceVo = JSON.toJavaObject(subReportDerail, PowerDocDcResistanceVo.class);

                subReportDerail.remove("details");
                PowerDocDcResistance resistance = JSON.toJavaObject(subReportDerail,PowerDocDcResistance.class);
                resistance.setSubreportId(Long.parseLong(subReportId));
                dcResistanceMapper.insert(resistance);

                List<PowerDocResistanceDetail> details = resistanceVo.getDetails();
                //遍历并保存每行数据的信息
                for (PowerDocResistanceDetail detail: details) {
                    detail.setSubreportId(Long.parseLong(subReportId));
                    resistanceDetailMapper.insert(detail);
                }

                break;

            //高压套管试验报告
            case "power_doc_hv_bushings":
                PowerDocHvBushings hvBushings = JSON.toJavaObject(subReportDerail,PowerDocHvBushings.class);
                hvBushings.setSubreportId(Long.parseLong(subReportId));
                hvBushingsMapper.insert(hvBushings);
                break;

            //电压互感器试验报告
            case "power_doc_voltage_transformer":
                PowerDocVoltageTransformer voltageTransformer = JSON.toJavaObject(subReportDerail, PowerDocVoltageTransformer.class);
                voltageTransformer.setSubreportId(Long.parseLong(subReportId));
                voltageTransformerMapper.insert(voltageTransformer);
                break;

            //电流互感器试验报告
            case "power_doc_current_transformer":
                PowerDocCurrentTransformer currentTransformer = JSON.toJavaObject(subReportDerail, PowerDocCurrentTransformer.class);
                currentTransformer.setSubreportId(Long.parseLong(subReportId));
                currentTransformerMapper.insert(currentTransformer);
                break;
            default:
                break;
        }
    }

    /**
     * 从vo中提取信息并保存封面信息
     * @param powerReportVo
     * @return
     */
    private String insertReportFromVo(PowerReportVo powerReportVo) {
        String errorMsg = null;
        try {
            PowerReport report = new PowerReport();
            report.setId(powerReportVo.getId());
            report.setSubstationId(powerReportVo.getSubstationId());

            //保存变电站名称
            PowerSubstation powerSubstation = substationMapper.selectByPrimaryKey(powerReportVo.getSubstationId());
            if(powerSubstation != null) {
                report.setSubstationName(powerSubstation.getSubstationName());
            }

            String deviceIds = powerReportVo.getDeviceIds();
            report.setDeviceIds(deviceIds);

            //保存设备名称
            StringBuilder deviceNames = new StringBuilder();
            String[] deviceArray = deviceIds.split(",");
            for (int i = 0; i < deviceArray.length; i++) {
                PowerDevice powerDevice = deviceMapper.selectByPrimaryKey(Long.parseLong(deviceArray[i]));
                if(powerDevice != null) {
                    if(i == deviceArray.length-1) {
                        deviceNames.append(powerDevice.getDeviceName());
                    }else {
                        deviceNames.append(powerDevice.getDeviceName()).append(" ");
                    }
                }
            }
            report.setDeviceNames(deviceNames.toString());

            report.setRunNo(powerReportVo.getRunNo());
            report.setTestProperties(powerReportVo.getTestProperties());

            String testPeopleIds = powerReportVo.getTestPeopleId();
            report.setTestPeopleId(testPeopleIds);

            //查询并保存测试人员姓名
            StringBuilder usersSb = new StringBuilder();
            String[] testPeopleIdArray = testPeopleIds.split(",");
            for (int i = 0; i < testPeopleIdArray.length; i++) {
                PowerSysUser powerSysUser = userMapper.selectByPrimaryKey(Long.parseLong(testPeopleIdArray[i]));
                if(powerSysUser != null) {
                    if(testPeopleIdArray.length-1 == i) {
                        usersSb.append(powerSysUser.getUsername());
                    }else {
                        usersSb.append(powerSysUser.getUsername()).append(" ");
                    }
                }
            }
            report.setTestPeople(usersSb.toString());

            report.setTestDutyPersonId(powerReportVo.getTestDutyPersonId());
            report.setTestDutyPerson(userMapper.selectByPrimaryKey(Long.parseLong(powerReportVo.getTestDutyPersonId())).getUsername());

            report.setTestDate(powerReportVo.getTestDate());

            //保存校对人信息
            String reviewPersonId = powerReportVo.getReviewPersonId();
            if(reviewPersonId == null || StringUtils.isEmpty(reviewPersonId)) {
                report.setReviewPersonId("");
                report.setReviewPerson("");
            }else {
                report.setReviewPersonId(reviewPersonId);
                report.setReviewPerson(userMapper.selectByPrimaryKey(Long.parseLong(powerReportVo.getReviewPersonId())).getUsername());
            }

            //保存审核人信息
            String checkPersonId = powerReportVo.getCheckPersonId();
            if(checkPersonId == null || StringUtils.isEmpty(checkPersonId)) {
                report.setCheckPersonId("");
                report.setCheckPerson("");
            }else {
                report.setCheckPersonId(checkPersonId);
                report.setCheckPerson(userMapper.selectByPrimaryKey(Long.parseLong(powerReportVo.getCheckPersonId())).getUsername());
            }

            //保存审核人信息
            String approvePersonId = powerReportVo.getApprovePersonId();
            if(approvePersonId == null || StringUtils.isEmpty(approvePersonId)) {
                report.setApprovePersonId("");
                report.setApprovePerson("");
            }else {
                report.setApprovePersonId(approvePersonId);
                report.setApprovePerson(userMapper.selectByPrimaryKey(Long.parseLong(powerReportVo.getApprovePersonId())).getUsername());
            }

            //默认报告状态为有效
            report.setReportStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String addtime = sdf.format(new Date());
            report.setAddtime(Timestamp.valueOf(addtime));
            powerReportMapper.insert(report);
        }catch (Exception e) {
            logger.error("保存报告封面信息异常：",e);
            errorMsg = "服务异常";
        }
        return errorMsg;
    }


    /**
     * 插入子报告信息，并返回错误信息和主键
     * @param subReportVo
     * @param powerReportVo
     * @return
     */
    private Map<String,Object> saveSubReportFromVo(PowerSubReportVo subReportVo, PowerReportVo powerReportVo) {
        Map<String,Object> returnMap = new HashMap<>();
        String errorMsg = null;
        Long id = null;
        if(subReportVo != null && powerReportVo != null) {
            try {
                PowerSubReport subReport = new PowerSubReport();
                //默认有效
                subReport.setStatus(SystemStatusEnum.SYSTEM_STATUS_EFFECTIVE.getKey());
                //所属报告
                subReport.setReportId(powerReportVo.getId());
                subReport.setTestDate(powerReportVo.getTestDate());

                Long deviceId = subReportVo.getDeviceId();
                subReport.setDeviceId(deviceId);
                if(deviceId != null) {
                    PowerDevice powerDevice = deviceMapper.selectByPrimaryKey(deviceId);
                    if(powerDevice != null) {
                        subReport.setDeviceName(powerDevice.getDeviceName());
                        subReport.setDeviceType(powerDevice.getDeviceType());
                        subReport.setAirTemperature(powerDevice.getAirTemperature());
                        subReport.setHumidity(powerDevice.getHumidity());
                        subReport.setRunHumidity(powerDevice.getRunHumidity());
                        subReport.setConnectGroup(powerDevice.getConnectGroup());
                        subReport.setModelNo(powerDevice.getModelNo());
                        subReport.setProducer(powerDevice.getProducer());
                        subReport.setCapacity(powerDevice.getCapacity());
                        subReport.setRunNo(powerDevice.getRunNo());
                        subReport.setRunDate(powerDevice.getRunDate());
                        subReport.setProductionDate(powerDevice.getProductionDate());
                        subReport.setProductionNo(powerDevice.getProductionNo());
                    }
                }
                StringBuilder instrumentNamesSb = new StringBuilder("");
                String instrumentIds = subReportVo.getInstrumentIds();
                subReport.setInstrumentIds(instrumentIds);
                // 仪器设备非空
                if(!StringUtils.isEmpty(instrumentIds)) {
                    String[] instrumentIdArray = instrumentIds.split(",");
                    for (int i = 0; i < instrumentIdArray.length; i++) {
                        PowerInstrument instrument = instrumentMapper.selectByPrimaryKey(Long.parseLong(instrumentIdArray[i]));
                        if(instrument != null) {
                            if(i == instrumentIdArray.length-1) {
                                instrumentNamesSb.append(instrument.getInstrumentName());
                            }else {
                                //用空格分隔
                                instrumentNamesSb.append(instrument.getInstrumentName()).append(" ");
                            }
                        }else {
                            logger.info("仪器信息不存在，仪器id为："+instrumentIdArray[i]);
                        }
                    }
                }
                subReport.setInstrumentNames(instrumentNamesSb.toString());
                subReport.setConclusion(subReportVo.getConclusion());
                subReport.setRemark(subReportVo.getRemark());
                subReportMapper.insert(subReport);
                id = subReport.getId();
            }catch (Exception e) {
                logger.error("保存子报告信息失败，",e);
                errorMsg = "保存子报告信息失败";
            }
        }else {
            errorMsg = "报告信息或者子报告信息为null，请检查";
        }
        returnMap.put("errorMsg",errorMsg);
        returnMap.put("subReportId",id);
        return returnMap;
    }
}
