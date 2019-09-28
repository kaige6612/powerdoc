package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocInsulation的实体类")
public class PowerDocInsulation extends BaseEntity{

        // 绝缘报告主键
        @ApiModelProperty(value = "绝缘报告主键",example = "")
		private Long insulationId;
        // 所属报告id
        @ApiModelProperty(value = "所属报告id",example = "")
		private Long subreportId;
        // 铁芯/地绝缘( MΩ)
        @ApiModelProperty(value = "铁芯/地绝缘( MΩ)",example = "")
		private String ironCore;
        // 夹件/地绝缘( MΩ)
        @ApiModelProperty(value = "夹件/地绝缘( MΩ)",example = "")
		private String clip;
        // 高压/中压、低压及地-R15s
        @ApiModelProperty(value = "高压/中压、低压及地-R15s",example = "")
		private String highMidR15;
        // 中压/高压、低压及地-R15s
        @ApiModelProperty(value = "中压/高压、低压及地-R15s",example = "")
		private String midHighR15;
        // 低压/高压、中压及地-R15s
        @ApiModelProperty(value = "低压/高压、中压及地-R15s",example = "")
		private String lowHighR15;
        // 高压/中压、低压及地-R60
        @ApiModelProperty(value = "高压/中压、低压及地-R60",example = "")
		private String highMidR60;
        // 中压/高压、低压及地-R60
        @ApiModelProperty(value = "中压/高压、低压及地-R60",example = "")
		private String midHighR60;
        // 低压/高压、中压及地-R60
        @ApiModelProperty(value = "低压/高压、中压及地-R60",example = "")
		private String lowHighR60;
        // 高压/中压、低压及地-R10
        @ApiModelProperty(value = "高压/中压、低压及地-R10",example = "")
		private String highMidR10;
        // 中压/高压、低压及地-R10
        @ApiModelProperty(value = "中压/高压、低压及地-R10",example = "")
		private String midHighR10;
        // 低压/高压、中压及地-R10
        @ApiModelProperty(value = "低压/高压、中压及地-R10",example = "")
		private String lowHighR10;
        // 高压/中压、低压及地-吸收比
        @ApiModelProperty(value = "高压/中压、低压及地-吸收比",example = "")
		private String highMidRatio;
        // 中压/高压、低压及地-吸收比
        @ApiModelProperty(value = "中压/高压、低压及地-吸收比",example = "")
		private String midHighRatio;
        // 低压/高压、中压及地-吸收比
        @ApiModelProperty(value = "低压/高压、中压及地-吸收比",example = "")
		private String lowHighRatio;
        // 高压/中压、低压及地-极化指数
        @ApiModelProperty(value = "高压/中压、低压及地-极化指数",example = "")
		private String highMidIndex;
        // 中压/高压、低压及地-极化指数
        @ApiModelProperty(value = "中压/高压、低压及地-极化指数",example = "")
		private String midHighIndex;
        // 低压/高压、中压及地-极化指数
        @ApiModelProperty(value = "低压/高压、中压及地-极化指数",example = "")
		private String lowHighIndex;
        // 高压/中压、低压及地-电压
        @ApiModelProperty(value = "高压/中压、低压及地-电压",example = "")
		private String highMidKv;
        // 中压/高压、低压及地-电压
        @ApiModelProperty(value = "中压/高压、低压及地-电压",example = "")
		private String midHighKv;
        // 低压/高压、中压及地-电压
        @ApiModelProperty(value = "低压/高压、中压及地-电压",example = "")
		private String lowHighKv;
        // 高压/中压、低压及地-电容
        @ApiModelProperty(value = "高压/中压、低压及地-电容",example = "")
		private String highMidNf;
        // 中压/高压、低压及地-电容
        @ApiModelProperty(value = "中压/高压、低压及地-电容",example = "")
		private String midHighNf;
        // 低压/高压、中压及地-电容
        @ApiModelProperty(value = "低压/高压、中压及地-电容",example = "")
		private String lowHighNf;
        // 高压/中压、低压及地-介损
        @ApiModelProperty(value = "高压/中压、低压及地-介损",example = "")
		private String highMidTg;
        // 中压/高压、低压及地-介损
        @ApiModelProperty(value = "中压/高压、低压及地-介损",example = "")
		private String midHighTg;
        // 低压/高压、中压及地-介损
        @ApiModelProperty(value = "低压/高压、中压及地-介损",example = "")
		private String lowHighTg;
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



	public void setInsulationId(Long insulationId) {
		this.insulationId = insulationId;
	}
	public Long getInsulationId() {
		return this.insulationId;
	}
	public void setSubreportId(Long subreportId) {
		this.subreportId = subreportId;
	}
	public Long getSubreportId() {
		return this.subreportId;
	}
	public void setIronCore(String ironCore) {
		this.ironCore = ironCore;
	}
	public String getIronCore() {
		return this.ironCore;
	}
	public void setClip(String clip) {
		this.clip = clip;
	}
	public String getClip() {
		return this.clip;
	}
	public void setHighMidR15(String highMidR15) {
		this.highMidR15 = highMidR15;
	}
	public String getHighMidR15() {
		return this.highMidR15;
	}
	public void setMidHighR15(String midHighR15) {
		this.midHighR15 = midHighR15;
	}
	public String getMidHighR15() {
		return this.midHighR15;
	}
	public void setLowHighR15(String lowHighR15) {
		this.lowHighR15 = lowHighR15;
	}
	public String getLowHighR15() {
		return this.lowHighR15;
	}
	public void setHighMidR60(String highMidR60) {
		this.highMidR60 = highMidR60;
	}
	public String getHighMidR60() {
		return this.highMidR60;
	}
	public void setMidHighR60(String midHighR60) {
		this.midHighR60 = midHighR60;
	}
	public String getMidHighR60() {
		return this.midHighR60;
	}
	public void setLowHighR60(String lowHighR60) {
		this.lowHighR60 = lowHighR60;
	}
	public String getLowHighR60() {
		return this.lowHighR60;
	}
	public void setHighMidR10(String highMidR10) {
		this.highMidR10 = highMidR10;
	}
	public String getHighMidR10() {
		return this.highMidR10;
	}
	public void setMidHighR10(String midHighR10) {
		this.midHighR10 = midHighR10;
	}
	public String getMidHighR10() {
		return this.midHighR10;
	}
	public void setLowHighR10(String lowHighR10) {
		this.lowHighR10 = lowHighR10;
	}
	public String getLowHighR10() {
		return this.lowHighR10;
	}
	public void setHighMidRatio(String highMidRatio) {
		this.highMidRatio = highMidRatio;
	}
	public String getHighMidRatio() {
		return this.highMidRatio;
	}
	public void setMidHighRatio(String midHighRatio) {
		this.midHighRatio = midHighRatio;
	}
	public String getMidHighRatio() {
		return this.midHighRatio;
	}
	public void setLowHighRatio(String lowHighRatio) {
		this.lowHighRatio = lowHighRatio;
	}
	public String getLowHighRatio() {
		return this.lowHighRatio;
	}
	public void setHighMidIndex(String highMidIndex) {
		this.highMidIndex = highMidIndex;
	}
	public String getHighMidIndex() {
		return this.highMidIndex;
	}
	public void setMidHighIndex(String midHighIndex) {
		this.midHighIndex = midHighIndex;
	}
	public String getMidHighIndex() {
		return this.midHighIndex;
	}
	public void setLowHighIndex(String lowHighIndex) {
		this.lowHighIndex = lowHighIndex;
	}
	public String getLowHighIndex() {
		return this.lowHighIndex;
	}
	public void setHighMidKv(String highMidKv) {
		this.highMidKv = highMidKv;
	}
	public String getHighMidKv() {
		return this.highMidKv;
	}
	public void setMidHighKv(String midHighKv) {
		this.midHighKv = midHighKv;
	}
	public String getMidHighKv() {
		return this.midHighKv;
	}
	public void setLowHighKv(String lowHighKv) {
		this.lowHighKv = lowHighKv;
	}
	public String getLowHighKv() {
		return this.lowHighKv;
	}
	public void setHighMidNf(String highMidNf) {
		this.highMidNf = highMidNf;
	}
	public String getHighMidNf() {
		return this.highMidNf;
	}
	public void setMidHighNf(String midHighNf) {
		this.midHighNf = midHighNf;
	}
	public String getMidHighNf() {
		return this.midHighNf;
	}
	public void setLowHighNf(String lowHighNf) {
		this.lowHighNf = lowHighNf;
	}
	public String getLowHighNf() {
		return this.lowHighNf;
	}
	public void setHighMidTg(String highMidTg) {
		this.highMidTg = highMidTg;
	}
	public String getHighMidTg() {
		return this.highMidTg;
	}
	public void setMidHighTg(String midHighTg) {
		this.midHighTg = midHighTg;
	}
	public String getMidHighTg() {
		return this.midHighTg;
	}
	public void setLowHighTg(String lowHighTg) {
		this.lowHighTg = lowHighTg;
	}
	public String getLowHighTg() {
		return this.lowHighTg;
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

