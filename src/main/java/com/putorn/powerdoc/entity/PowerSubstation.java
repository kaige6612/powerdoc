package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerSubstation的实体类")
public class PowerSubstation extends BaseEntity{

        // 变电站id
        @ApiModelProperty(value = "变电站id",example = "")
		private Long substationId;
        // 变电站名称
        @ApiModelProperty(value = "变电站名称",example = "")
		private String substationName;
        // 变电站等级（备用）
        @ApiModelProperty(value = "变电站等级（备用）",example = "")
		private String substationLevel;
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
	public void setSubstationLevel(String substationLevel) {
		this.substationLevel = substationLevel;
	}
	public String getSubstationLevel() {
		return this.substationLevel;
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

