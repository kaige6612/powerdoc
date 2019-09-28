package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerModel的实体类")
public class PowerModel extends BaseEntity{

        // 模板表主键
        @ApiModelProperty(value = "模板表主键",example = "")
		private Long modelId;
        // 模板明细对应表名
        @ApiModelProperty(value = "模板明细对应表名",example = "")
		private String modelTableName;
        // 模板名称
        @ApiModelProperty(value = "模板名称",example = "")
		private String modelName;
        // 模板类型（备用）
        @ApiModelProperty(value = "模板类型（备用）",example = "")
		private String modelType;
        // 文档模板名称
        @ApiModelProperty(value = "文档模板名称",example = "")
		private String modelTemplateName;
        // 模板路径
        @ApiModelProperty(value = "模板路径",example = "")
		private String modelUrl;
        // 模板状态 0：失效 1：正常 2：已删除
        @ApiModelProperty(value = "模板状态 0：失效 1：正常 2：已删除",example = "")
		private String modelStatus;
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



	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}
	public Long getModelId() {
		return this.modelId;
	}
	public void setModelTableName(String modelTableName) {
		this.modelTableName = modelTableName;
	}
	public String getModelTableName() {
		return this.modelTableName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelName() {
		return this.modelName;
	}
	public void setModelType(String modelType) {
		this.modelType = modelType;
	}
	public String getModelType() {
		return this.modelType;
	}
	public void setModelTemplateName(String modelTemplateName) {
		this.modelTemplateName = modelTemplateName;
	}
	public String getModelTemplateName() {
		return this.modelTemplateName;
	}
	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}
	public String getModelUrl() {
		return this.modelUrl;
	}
	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	}
	public String getModelStatus() {
		return this.modelStatus;
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

