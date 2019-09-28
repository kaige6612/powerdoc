package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDeviceModel的实体类")
public class PowerDeviceModel extends BaseEntity{

    // 模板id
    @ApiModelProperty(value = "模板id",example = "")
    private java.lang.Long modelId;
    // 模板名称
    @ApiModelProperty(value = "模板名称",example = "")
    private java.lang.String modelName;
    // 设备id
    @ApiModelProperty(value = "设备id",example = "")
    private java.lang.Long deviceId;
    // 设备名称
    @ApiModelProperty(value = "设备名称",example = "")
    private java.lang.String devieName;
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



    public void setModelId(java.lang.Long modelId) {
        this.modelId = modelId;
    }
    public java.lang.Long getModelId() {
        return this.modelId;
    }
    public void setModelName(java.lang.String modelName) {
        this.modelName = modelName;
    }
    public java.lang.String getModelName() {
        return this.modelName;
    }
    public void setDeviceId(java.lang.Long deviceId) {
        this.deviceId = deviceId;
    }
    public java.lang.Long getDeviceId() {
        return this.deviceId;
    }
    public void setDevieName(java.lang.String devieName) {
        this.devieName = devieName;
    }
    public java.lang.String getDevieName() {
        return this.devieName;
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

