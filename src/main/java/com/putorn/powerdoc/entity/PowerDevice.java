package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDevice的实体类")
public class PowerDevice extends BaseEntity{

    // 设备表主键自增
    @ApiModelProperty(value = "设备表主键自增",example = "")
    private java.lang.Long deviceId;
    // 设备名称
    @ApiModelProperty(value = "设备名称",example = "")
    private java.lang.String deviceName;
    // 设备类型（变压器，避雷器等）
    @ApiModelProperty(value = "设备类型（变压器，避雷器等）",example = "")
    private java.lang.String deviceType;
    // 气温（℃）
    @ApiModelProperty(value = "气温（℃）",example = "")
    private java.lang.String airTemperature;
    // 湿度
    @ApiModelProperty(value = "湿度",example = "")
    private java.lang.String humidity;
    // 运行电压
    @ApiModelProperty(value = "运行电压",example = "")
    private java.lang.String runHumidity;
    // 油温
    @ApiModelProperty(value = "油温",example = "")
    private java.lang.String oilTemperature;
    // 连接组别
    @ApiModelProperty(value = "连接组别",example = "")
    private java.lang.String connectGroup;
    // 型号
    @ApiModelProperty(value = "型号",example = "")
    private java.lang.String modelNo;
    // 制造厂家
    @ApiModelProperty(value = "制造厂家",example = "")
    private java.lang.String producer;
    // 容量
    @ApiModelProperty(value = "容量",example = "")
    private java.lang.String capacity;
    // 运行编号
    @ApiModelProperty(value = "运行编号",example = "")
    private java.lang.String runNo;
    // 投运日期
    @ApiModelProperty(value = "投运日期",example = "")
    private java.lang.String runDate;
    // 出厂日期
    @ApiModelProperty(value = "出厂日期",example = "")
    private java.lang.String productionDate;
    // 出厂编号
    @ApiModelProperty(value = "出厂编号",example = "")
    private java.lang.String productionNo;
    // 状态 0：失效 1：正常 2：已删除
    @ApiModelProperty(value = "状态 0：失效 1：正常 2：已删除",example = "")
    private java.lang.String status;
    // 添加人id
    @ApiModelProperty(value = "添加人id",example = "")
    private java.lang.Integer addUserid;
    // 添加人姓名
    @ApiModelProperty(value = "添加人姓名",example = "")
    private java.lang.String addUsername;
    // 添加时间
    @ApiModelProperty(value = "添加时间",example = "")
    private java.sql.Timestamp addtime;
    // 修改人id
    @ApiModelProperty(value = "修改人id",example = "")
    private java.lang.Integer editUserid;
    // 修改人姓名
    @ApiModelProperty(value = "修改人姓名",example = "")
    private java.lang.String editUsername;
    // 修改时间
    @ApiModelProperty(value = "修改时间",example = "")
    private java.sql.Timestamp edittime;



    public void setDeviceId(java.lang.Long deviceId) {
        this.deviceId = deviceId;
    }
    public java.lang.Long getDeviceId() {
        return this.deviceId;
    }
    public void setDeviceName(java.lang.String deviceName) {
        this.deviceName = deviceName;
    }
    public java.lang.String getDeviceName() {
        return this.deviceName;
    }
    public void setDeviceType(java.lang.String deviceType) {
        this.deviceType = deviceType;
    }
    public java.lang.String getDeviceType() {
        return this.deviceType;
    }
    public void setAirTemperature(java.lang.String airTemperature) {
        this.airTemperature = airTemperature;
    }
    public java.lang.String getAirTemperature() {
        return this.airTemperature;
    }
    public void setHumidity(java.lang.String humidity) {
        this.humidity = humidity;
    }
    public java.lang.String getHumidity() {
        return this.humidity;
    }
    public void setRunHumidity(java.lang.String runHumidity) {
        this.runHumidity = runHumidity;
    }
    public java.lang.String getRunHumidity() {
        return this.runHumidity;
    }
    public void setOilTemperature(java.lang.String oilTemperature) {
        this.oilTemperature = oilTemperature;
    }
    public java.lang.String getOilTemperature() {
        return this.oilTemperature;
    }
    public void setConnectGroup(java.lang.String connectGroup) {
        this.connectGroup = connectGroup;
    }
    public java.lang.String getConnectGroup() {
        return this.connectGroup;
    }
    public void setModelNo(java.lang.String modelNo) {
        this.modelNo = modelNo;
    }
    public java.lang.String getModelNo() {
        return this.modelNo;
    }
    public void setProducer(java.lang.String producer) {
        this.producer = producer;
    }
    public java.lang.String getProducer() {
        return this.producer;
    }
    public void setCapacity(java.lang.String capacity) {
        this.capacity = capacity;
    }
    public java.lang.String getCapacity() {
        return this.capacity;
    }
    public void setRunNo(java.lang.String runNo) {
        this.runNo = runNo;
    }
    public java.lang.String getRunNo() {
        return this.runNo;
    }
    public void setRunDate(java.lang.String runDate) {
        this.runDate = runDate;
    }
    public java.lang.String getRunDate() {
        return this.runDate;
    }
    public void setProductionDate(java.lang.String productionDate) {
        this.productionDate = productionDate;
    }
    public java.lang.String getProductionDate() {
        return this.productionDate;
    }
    public void setProductionNo(java.lang.String productionNo) {
        this.productionNo = productionNo;
    }
    public java.lang.String getProductionNo() {
        return this.productionNo;
    }
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    public java.lang.String getStatus() {
        return this.status;
    }
    public void setAddUserid(java.lang.Integer addUserid) {
        this.addUserid = addUserid;
    }
    public java.lang.Integer getAddUserid() {
        return this.addUserid;
    }
    public void setAddUsername(java.lang.String addUsername) {
        this.addUsername = addUsername;
    }
    public java.lang.String getAddUsername() {
        return this.addUsername;
    }
    public void setAddtime(java.sql.Timestamp addtime) {
        this.addtime = addtime;
    }
    public java.sql.Timestamp getAddtime() {
        return this.addtime;
    }
    public void setEditUserid(java.lang.Integer editUserid) {
        this.editUserid = editUserid;
    }
    public java.lang.Integer getEditUserid() {
        return this.editUserid;
    }
    public void setEditUsername(java.lang.String editUsername) {
        this.editUsername = editUsername;
    }
    public java.lang.String getEditUsername() {
        return this.editUsername;
    }
    public void setEdittime(java.sql.Timestamp edittime) {
        this.edittime = edittime;
    }
    public java.sql.Timestamp getEdittime() {
        return this.edittime;
    }
}

