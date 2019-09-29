package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocResistanceDetail的实体类")
public class PowerDocResistanceDetail extends BaseEntity{

        // 变压器直流电阻报告主键
        @ApiModelProperty(value = "变压器直流电阻报告主键",example = "")
		private Long detailId;
        // 所属报告id
        @ApiModelProperty(value = "所属报告id",example = "")
		private Long subreportId;
        // 行号
        @ApiModelProperty(value = "行号",example = "")
		private String rowNum;
        // 高压侧直阻（m）_AO
        @ApiModelProperty(value = "高压侧直阻（m）_AO",example = "")
		private String highAo;
        // 高压侧直阻（m）_BO
        @ApiModelProperty(value = "高压侧直阻（m）_BO",example = "")
		private String highBo;
        // 高压侧直阻（m）_CO
        @ApiModelProperty(value = "高压侧直阻（m）_CO",example = "")
		private String highCo;
        // 高压侧直阻（m）_相间最大误差(%)
        @ApiModelProperty(value = "高压侧直阻（m）_相间最大误差(%)",example = "")
		private String highError;
        // 中压侧直阻（m）_AmOm
        @ApiModelProperty(value = "中压侧直阻（m）_AmOm",example = "")
		private String middleAmOm;
        // 中压侧直阻（m）_BmOm
        @ApiModelProperty(value = "中压侧直阻（m）_BmOm",example = "")
		private String middleBmOm;
        // 中压侧直阻（m）_CmOm
        @ApiModelProperty(value = "中压侧直阻（m）_CmOm",example = "")
		private String middleCmOm;
        // 中压侧直阻（m）_error
        @ApiModelProperty(value = "中压侧直阻（m）_error",example = "")
		private String middleError;
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



	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public Long getDetailId() {
		return this.detailId;
	}
	public void setSubreportId(Long subreportId) {
		this.subreportId = subreportId;
	}
	public Long getSubreportId() {
		return this.subreportId;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getRowNum() {
		return this.rowNum;
	}
	public void setHighAo(String highAo) {
		this.highAo = highAo;
	}
	public String getHighAo() {
		return this.highAo;
	}
	public void setHighBo(String highBo) {
		this.highBo = highBo;
	}
	public String getHighBo() {
		return this.highBo;
	}
	public void setHighCo(String highCo) {
		this.highCo = highCo;
	}
	public String getHighCo() {
		return this.highCo;
	}
	public void setHighError(String highError) {
		this.highError = highError;
	}
	public String getHighError() {
		return this.highError;
	}
	public void setMiddleAmOm(String middleAmOm) {
		this.middleAmOm = middleAmOm;
	}
	public String getMiddleAmOm() {
		return this.middleAmOm;
	}
	public void setMiddleBmOm(String middleBmOm) {
		this.middleBmOm = middleBmOm;
	}
	public String getMiddleBmOm() {
		return this.middleBmOm;
	}
	public void setMiddleCmOm(String middleCmOm) {
		this.middleCmOm = middleCmOm;
	}
	public String getMiddleCmOm() {
		return this.middleCmOm;
	}
	public void setMiddleError(String middleError) {
		this.middleError = middleError;
	}
	public String getMiddleError() {
		return this.middleError;
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

