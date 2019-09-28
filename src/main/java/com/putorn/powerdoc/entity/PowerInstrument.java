package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerInstrument的实体类")
public class PowerInstrument extends BaseEntity{

    // 仪器表主键
    @ApiModelProperty(value = "仪器表主键",example = "")
    private java.lang.Long instrumentId;
    // 仪器名称
    @ApiModelProperty(value = "仪器名称",example = "")
    private java.lang.String instrumentName;
    // 仪器类型（备用）
    @ApiModelProperty(value = "仪器类型（备用）",example = "")
    private java.lang.String instrumentType;
    // 仪器状态 0：失效 1：正常 2：已删除
    @ApiModelProperty(value = "仪器状态 0：失效 1：正常 2：已删除",example = "")
    private java.lang.String instrumentStatus;
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



    public void setInstrumentId(java.lang.Long instrumentId) {
        this.instrumentId = instrumentId;
    }
    public java.lang.Long getInstrumentId() {
        return this.instrumentId;
    }
    public void setInstrumentName(java.lang.String instrumentName) {
        this.instrumentName = instrumentName;
    }
    public java.lang.String getInstrumentName() {
        return this.instrumentName;
    }
    public void setInstrumentType(java.lang.String instrumentType) {
        this.instrumentType = instrumentType;
    }
    public java.lang.String getInstrumentType() {
        return this.instrumentType;
    }
    public void setInstrumentStatus(java.lang.String instrumentStatus) {
        this.instrumentStatus = instrumentStatus;
    }
    public java.lang.String getInstrumentStatus() {
        return this.instrumentStatus;
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

