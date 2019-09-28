package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerReport的实体类")
public class PowerReport extends BaseEntity{

    // 变电站id
    @ApiModelProperty(value = "变电站id",example = "")
    private Long substationId;
    // 变电站名称
    @ApiModelProperty(value = "变电站名称",example = "")
    private String substationName;
    // 设备ids
    @ApiModelProperty(value = "设备ids",example = "")
    private String deviceIds;
    // 设备名称
    @ApiModelProperty(value = "设备名称",example = "")
    private String deviceNames;
    // 运行编号
    @ApiModelProperty(value = "运行编号",example = "")
    private String runNo;
    // 试验性质
    @ApiModelProperty(value = "试验性质",example = "")
    private String testProperties;
    // 试验人员id（，号分割）
    @ApiModelProperty(value = "试验人员id（，号分割）",example = "")
    private String testPeopleId;
    // 试验人员
    @ApiModelProperty(value = "试验人员",example = "")
    private String testPeople;
    // 试验负责人id
    @ApiModelProperty(value = "试验负责人id",example = "")
    private String testDutyPersonId;
    // 试验负责人
    @ApiModelProperty(value = "试验负责人",example = "")
    private String testDutyPerson;
    // 试验日期
    @ApiModelProperty(value = "试验日期",example = "")
    private String testDate;
    // 校对人id
    @ApiModelProperty(value = "校对人id",example = "")
    private String reviewPersonId;
    // 校对人
    @ApiModelProperty(value = "校对人",example = "")
    private String reviewPerson;
    // 审核人id
    @ApiModelProperty(value = "审核人id",example = "")
    private String checkPersonId;
    // 审核人
    @ApiModelProperty(value = "审核人",example = "")
    private String checkPerson;
    // 批准人id
    @ApiModelProperty(value = "批准人id",example = "")
    private String approvePersonId;
    // 批准人
    @ApiModelProperty(value = "批准人",example = "")
    private String approvePerson;
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
    // 报告状态 0：失效:1：正常  2：已删除
    @ApiModelProperty(value = "报告状态 0：失效:1：正常  2：已删除",example = "")
    private String reportStatus;
    // 报告类型 （预留字段）
    @ApiModelProperty(value = "报告类型 （预留字段）",example = "")
    private String reportType;



    public void setSubstationId(Long substationId) {
        this.substationId = substationId;
    }
    public Long getSubstationId() {
        return this.substationId;
    }
    public void setSubstationName(String substationName) {
        this.substationName = substationName;
    }
    public String getSubstationName() {
        return this.substationName;
    }
    public void setDeviceIds(String deviceIds) {
        this.deviceIds = deviceIds;
    }
    public String getDeviceIds() {
        return this.deviceIds;
    }
    public void setDeviceNames(String deviceNames) {
        this.deviceNames = deviceNames;
    }
    public String getDeviceNames() {
        return this.deviceNames;
    }
    public void setRunNo(String runNo) {
        this.runNo = runNo;
    }
    public String getRunNo() {
        return this.runNo;
    }
    public void setTestProperties(String testProperties) {
        this.testProperties = testProperties;
    }
    public String getTestProperties() {
        return this.testProperties;
    }
    public void setTestPeopleId(String testPeopleId) {
        this.testPeopleId = testPeopleId;
    }
    public String getTestPeopleId() {
        return this.testPeopleId;
    }
    public void setTestPeople(String testPeople) {
        this.testPeople = testPeople;
    }
    public String getTestPeople() {
        return this.testPeople;
    }
    public void setTestDutyPersonId(String testDutyPersonId) {
        this.testDutyPersonId = testDutyPersonId;
    }
    public String getTestDutyPersonId() {
        return this.testDutyPersonId;
    }
    public void setTestDutyPerson(String testDutyPerson) {
        this.testDutyPerson = testDutyPerson;
    }
    public String getTestDutyPerson() {
        return this.testDutyPerson;
    }
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }
    public String getTestDate() {
        return this.testDate;
    }
    public void setReviewPersonId(String reviewPersonId) {
        this.reviewPersonId = reviewPersonId;
    }
    public String getReviewPersonId() {
        return this.reviewPersonId;
    }
    public void setReviewPerson(String reviewPerson) {
        this.reviewPerson = reviewPerson;
    }
    public String getReviewPerson() {
        return this.reviewPerson;
    }
    public void setCheckPersonId(String checkPersonId) {
        this.checkPersonId = checkPersonId;
    }
    public String getCheckPersonId() {
        return this.checkPersonId;
    }
    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }
    public String getCheckPerson() {
        return this.checkPerson;
    }
    public void setApprovePersonId(String approvePersonId) {
        this.approvePersonId = approvePersonId;
    }
    public String getApprovePersonId() {
        return this.approvePersonId;
    }
    public void setApprovePerson(String approvePerson) {
        this.approvePerson = approvePerson;
    }
    public String getApprovePerson() {
        return this.approvePerson;
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
    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
    public String getReportStatus() {
        return this.reportStatus;
    }
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    public String getReportType() {
        return this.reportType;
    }
}

