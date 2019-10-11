package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerSubReport的实体类")
public class PowerSubReport extends BaseEntity{

    // 设备模板表
    @ApiModelProperty(value = "设备模板表",example = "")
    private Long deviceModelId;
    // 父id
    @ApiModelProperty(value = "父id",example = "")
    private Long reportId;
    // 设备id
    @ApiModelProperty(value = "设备id",example = "")
    private Long deviceId;
    // 设备名称
    @ApiModelProperty(value = "设备名称",example = "")
    private String deviceName;
    // 设备类型（统计后维护）
    @ApiModelProperty(value = "设备类型（统计后维护）",example = "")
    private String deviceType;
    // 气温（℃）
    @ApiModelProperty(value = "气温（℃）",example = "")
    private String airTemperature;
    // 湿度
    @ApiModelProperty(value = "湿度",example = "")
    private String humidity;
    // 运行电压
    @ApiModelProperty(value = "运行电压",example = "")
    private String runHumidity;
    // 油温
    @ApiModelProperty(value = "油温",example = "")
    private String oilTemperature;
    // 连接组别
    @ApiModelProperty(value = "连接组别",example = "")
    private String connectGroup;
    // 型号
    @ApiModelProperty(value = "型号",example = "")
    private String modelNo;
    // 制造厂家
    @ApiModelProperty(value = "制造厂家",example = "")
    private String producer;
    // 容量
    @ApiModelProperty(value = "容量",example = "")
    private String capacity;
    // 运行编号
    @ApiModelProperty(value = "运行编号",example = "")
    private String runNo;
    // 投运日期
    @ApiModelProperty(value = "投运日期",example = "")
    private String runDate;
    // 出厂日期
    @ApiModelProperty(value = "出厂日期",example = "")
    private String productionDate;
    // 出厂编号
    @ApiModelProperty(value = "出厂编号",example = "")
    private String productionNo;
    // 使用仪器ids（，号分割）
    @ApiModelProperty(value = "使用仪器ids（，号分割）",example = "")
    private String instrumentIds;
    // 使用仪器（，号分割）
    @ApiModelProperty(value = "使用仪器（，号分割）",example = "")
    private String instrumentNames;
    // 试验日期
    @ApiModelProperty(value = "试验日期",example = "")
    private String testDate;
    // 状态 0：失效 1：正常 2：已删除
    @ApiModelProperty(value = "状态 0：失效 1：正常 2：已删除",example = "")
    private String status;
    // 结论
    @ApiModelProperty(value = "结论",example = "")
    private String conclusion;
    // 备注
    @ApiModelProperty(value = "备注",example = "")
    private String remark;
    // 添加人id
    @ApiModelProperty(value = "添加人id",example = "")
    private Integer addUserid;
    // 添加人姓名
    @ApiModelProperty(value = "添加人姓名",example = "")
    private String addUsername;
    // 添加时间
    @ApiModelProperty(value = "添加时间",example = "")
    private java.sql.Timestamp addtime;
    // 修改人id
    @ApiModelProperty(value = "修改人id",example = "")
    private Integer editUserid;
    // 修改人姓名
    @ApiModelProperty(value = "修改人姓名",example = "")
    private String editUsername;
    // 修改时间
    @ApiModelProperty(value = "修改时间",example = "")
    private java.sql.Timestamp edittime;



    public void setDeviceModelId(Long deviceModelId) {
        this.deviceModelId = deviceModelId;
    }
    public Long getDeviceModelId() {
        return this.deviceModelId;
    }
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }
    public Long getReportId() {
        return this.reportId;
    }
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    public Long getDeviceId() {
        return this.deviceId;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getDeviceName() {
        return this.deviceName;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getDeviceType() {
        return this.deviceType;
    }
    public void setAirTemperature(String airTemperature) {
        this.airTemperature = airTemperature;
    }
    public String getAirTemperature() {
        return this.airTemperature;
    }
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getHumidity() {
        return this.humidity;
    }
    public void setRunHumidity(String runHumidity) {
        this.runHumidity = runHumidity;
    }
    public String getRunHumidity() {
        return this.runHumidity;
    }
    public void setOilTemperature(String oilTemperature) {
        this.oilTemperature = oilTemperature;
    }
    public String getOilTemperature() {
        return this.oilTemperature;
    }
    public void setConnectGroup(String connectGroup) {
        this.connectGroup = connectGroup;
    }
    public String getConnectGroup() {
        return this.connectGroup;
    }
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
    public String getModelNo() {
        return this.modelNo;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getProducer() {
        return this.producer;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public String getCapacity() {
        return this.capacity;
    }
    public void setRunNo(String runNo) {
        this.runNo = runNo;
    }
    public String getRunNo() {
        return this.runNo;
    }
    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }
    public String getRunDate() {
        return this.runDate;
    }
    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
    public String getProductionDate() {
        return this.productionDate;
    }
    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo;
    }
    public String getProductionNo() {
        return this.productionNo;
    }
    public void setInstrumentIds(String instrumentIds) {
        this.instrumentIds = instrumentIds;
    }
    public String getInstrumentIds() {
        return this.instrumentIds;
    }
    public void setInstrumentNames(String instrumentNames) {
        this.instrumentNames = instrumentNames;
    }
    public String getInstrumentNames() {
        return this.instrumentNames;
    }
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }
    public String getTestDate() {
        return this.testDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getConclusion() {
        return this.conclusion;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setAddUserid(Integer addUserid) {
        this.addUserid = addUserid;
    }
    public Integer getAddUserid() {
        return this.addUserid;
    }
    public void setAddUsername(String addUsername) {
        this.addUsername = addUsername;
    }
    public String getAddUsername() {
        return this.addUsername;
    }
    public void setAddtime(java.sql.Timestamp addtime) {
        this.addtime = addtime;
    }
    public java.sql.Timestamp getAddtime() {
        return this.addtime;
    }
    public void setEditUserid(Integer editUserid) {
        this.editUserid = editUserid;
    }
    public Integer getEditUserid() {
        return this.editUserid;
    }
    public void setEditUsername(String editUsername) {
        this.editUsername = editUsername;
    }
    public String getEditUsername() {
        return this.editUsername;
    }
    public void setEdittime(java.sql.Timestamp edittime) {
        this.edittime = edittime;
    }
    public java.sql.Timestamp getEdittime() {
        return this.edittime;
    }
}

