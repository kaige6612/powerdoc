package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocDcResistance的实体类")
public class PowerDocDcResistance extends BaseEntity{

    // 变压器直流电阻报告主键
    @ApiModelProperty(value = "变压器直流电阻报告主键",example = "")
    private java.lang.Long dcResistanceId;
    // 所属报告id
    @ApiModelProperty(value = "所属报告id",example = "")
    private java.lang.Long subreportId;
    // 直阻测试值-ab
    @ApiModelProperty(value = "直阻测试值-ab",example = "")
    private java.lang.String dcAb;
    // 直阻测试值-bc
    @ApiModelProperty(value = "直阻测试值-bc",example = "")
    private java.lang.String dcBc;
    // 直阻测试值-ca
    @ApiModelProperty(value = "直阻测试值-ca",example = "")
    private java.lang.String dcCa;
    // 直阻测试值-斜杠
    @ApiModelProperty(value = "直阻测试值-斜杠",example = "")
    private java.lang.String dcLast;
    // 换算至相电阻-ax
    @ApiModelProperty(value = "换算至相电阻-ax",example = "")
    private java.lang.String convertAx;
    // 换算至相电阻-by
    @ApiModelProperty(value = "换算至相电阻-by",example = "")
    private java.lang.String convertBy;
    // 换算至相电阻-cz
    @ApiModelProperty(value = "换算至相电阻-cz",example = "")
    private java.lang.String convertCz;
    // 相间最大误差(%)
    @ApiModelProperty(value = "相间最大误差(%)",example = "")
    private java.lang.String convertError;
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



    public void setDcResistanceId(java.lang.Long dcResistanceId) {
        this.dcResistanceId = dcResistanceId;
    }
    public java.lang.Long getDcResistanceId() {
        return this.dcResistanceId;
    }
    public void setSubreportId(java.lang.Long subreportId) {
        this.subreportId = subreportId;
    }
    public java.lang.Long getSubreportId() {
        return this.subreportId;
    }
    public void setDcAb(java.lang.String dcAb) {
        this.dcAb = dcAb;
    }
    public java.lang.String getDcAb() {
        return this.dcAb;
    }
    public void setDcBc(java.lang.String dcBc) {
        this.dcBc = dcBc;
    }
    public java.lang.String getDcBc() {
        return this.dcBc;
    }
    public void setDcCa(java.lang.String dcCa) {
        this.dcCa = dcCa;
    }
    public java.lang.String getDcCa() {
        return this.dcCa;
    }
    public void setDcLast(java.lang.String dcLast) {
        this.dcLast = dcLast;
    }
    public java.lang.String getDcLast() {
        return this.dcLast;
    }
    public void setConvertAx(java.lang.String convertAx) {
        this.convertAx = convertAx;
    }
    public java.lang.String getConvertAx() {
        return this.convertAx;
    }
    public void setConvertBy(java.lang.String convertBy) {
        this.convertBy = convertBy;
    }
    public java.lang.String getConvertBy() {
        return this.convertBy;
    }
    public void setConvertCz(java.lang.String convertCz) {
        this.convertCz = convertCz;
    }
    public java.lang.String getConvertCz() {
        return this.convertCz;
    }
    public void setConvertError(java.lang.String convertError) {
        this.convertError = convertError;
    }
    public java.lang.String getConvertError() {
        return this.convertError;
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

