package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerSysDic的实体类")
public class PowerSysDic extends BaseEntity{

        // 字典类型
        @ApiModelProperty(value = "字典类型",example = "")
		private String type;
        // 码值
        @ApiModelProperty(value = "码值",example = "")
		private String code;
        // 字典值
        @ApiModelProperty(value = "字典值",example = "")
		private String value;
        // 备注
        @ApiModelProperty(value = "备注",example = "")
		private String remark;
        // 添加者id
        @ApiModelProperty(value = "添加者id",example = "")
		private Integer addUserid;
        // 添加者姓名
        @ApiModelProperty(value = "添加者姓名",example = "")
		private String addUsername;
        // 添加时间
        @ApiModelProperty(value = "添加时间",example = "")
		private java.sql.Timestamp addtime;
        // 修改者id
        @ApiModelProperty(value = "修改者id",example = "")
		private Integer editUserid;
        // 修改者姓名
        @ApiModelProperty(value = "修改者姓名",example = "")
		private String editUsername;
        // 编辑时间
        @ApiModelProperty(value = "编辑时间",example = "")
		private java.sql.Timestamp edittime;



	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
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

