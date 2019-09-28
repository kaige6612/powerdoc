package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocVoltageTransformer的实体类")
public class PowerDocVoltageTransformer extends BaseEntity{

        // 电压互感器试验报告主键
        @ApiModelProperty(value = "电压互感器试验报告主键",example = "")
		private Long voltageTransformerId;
        // 所属报告id
        @ApiModelProperty(value = "所属报告id",example = "")
		private Long subreportId;
        // 绝缘电阻测量_A_一次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_A_一次/其它及地",example = "")
		private String afirst;
        // 绝缘电阻测量_A_二次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_A_二次/其它及地",example = "")
		private String asecond;
        // 绝缘电阻测量_A_辅助/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_A_辅助/其它及地",example = "")
		private String asupport;
        // 绝缘电阻测量_B_一次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_B_一次/其它及地",example = "")
		private String bfirst;
        // 绝缘电阻测量_B_二次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_B_二次/其它及地",example = "")
		private String bsecond;
        // 绝缘电阻测量_B_辅助/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_B_辅助/其它及地",example = "")
		private String bsupport;
        // 绝缘电阻测量_C_一次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_C_一次/其它及地",example = "")
		private String cfirst;
        // 绝缘电阻测量_C_二次/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_C_二次/其它及地",example = "")
		private String csecond;
        // 绝缘电阻测量_C_辅助/其它及地
        @ApiModelProperty(value = "绝缘电阻测量_C_辅助/其它及地",example = "")
		private String csupport;
        // 交流耐压_试验部位
        @ApiModelProperty(value = "交流耐压_试验部位",example = "")
		private String testPosition;
        // 交流耐压_A_试验电压(kv)
        @ApiModelProperty(value = "交流耐压_A_试验电压(kv)",example = "")
		private String avoltage;
        // 交流耐压_B_试验电压(kv)
        @ApiModelProperty(value = "交流耐压_B_试验电压(kv)",example = "")
		private String bvoltage;
        // 交流耐压_C_试验电压(kv)
        @ApiModelProperty(value = "交流耐压_C_试验电压(kv)",example = "")
		private String cvoltage;
        // 交流耐压_A_试讲（分）
        @ApiModelProperty(value = "交流耐压_A_试讲（分）",example = "")
		private String atime;
        // 交流耐压_B_试讲（分）
        @ApiModelProperty(value = "交流耐压_B_试讲（分）",example = "")
		private String btime;
        // 交流耐压_C_试讲（分）
        @ApiModelProperty(value = "交流耐压_C_试讲（分）",example = "")
		private String ctime;
        // 交流耐压_A_结果
        @ApiModelProperty(value = "交流耐压_A_结果",example = "")
		private String aresult;
        // 交流耐压_B_结果
        @ApiModelProperty(value = "交流耐压_B_结果",example = "")
		private String bresult;
        // 交流耐压_C_结果
        @ApiModelProperty(value = "交流耐压_C_结果",example = "")
		private String cresult;
        // 交流耐压_A_耐压后绝缘（ＭΩ）
        @ApiModelProperty(value = "交流耐压_A_耐压后绝缘（ＭΩ）",example = "")
		private String aafter;
        // 交流耐压_B_耐压后绝缘（ＭΩ）
        @ApiModelProperty(value = "交流耐压_B_耐压后绝缘（ＭΩ）",example = "")
		private String bafter;
        // 交流耐压_C_耐压后绝缘（ＭΩ）
        @ApiModelProperty(value = "交流耐压_C_耐压后绝缘（ＭΩ）",example = "")
		private String cafter;
        // 直流电阻测试_A_直流电阻值（Ω）
        @ApiModelProperty(value = "直流电阻测试_A_直流电阻值（Ω）",example = "")
		private String adirect;
        // 直流电阻测试_B_直流电阻值（Ω）
        @ApiModelProperty(value = "直流电阻测试_B_直流电阻值（Ω）",example = "")
		private String bdirect;
        // 直流电阻测试_C_直流电阻值（Ω）
        @ApiModelProperty(value = "直流电阻测试_C_直流电阻值（Ω）",example = "")
		private String cdirect;
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



	public void setVoltageTransformerId(Long voltageTransformerId) {
		this.voltageTransformerId = voltageTransformerId;
	}
	public Long getVoltageTransformerId() {
		return this.voltageTransformerId;
	}
	public void setSubreportId(Long subreportId) {
		this.subreportId = subreportId;
	}
	public Long getSubreportId() {
		return this.subreportId;
	}
	public void setAfirst(String afirst) {
		this.afirst = afirst;
	}
	public String getAfirst() {
		return this.afirst;
	}
	public void setAsecond(String asecond) {
		this.asecond = asecond;
	}
	public String getAsecond() {
		return this.asecond;
	}
	public void setAsupport(String asupport) {
		this.asupport = asupport;
	}
	public String getAsupport() {
		return this.asupport;
	}
	public void setBfirst(String bfirst) {
		this.bfirst = bfirst;
	}
	public String getBfirst() {
		return this.bfirst;
	}
	public void setBsecond(String bsecond) {
		this.bsecond = bsecond;
	}
	public String getBsecond() {
		return this.bsecond;
	}
	public void setBsupport(String bsupport) {
		this.bsupport = bsupport;
	}
	public String getBsupport() {
		return this.bsupport;
	}
	public void setCfirst(String cfirst) {
		this.cfirst = cfirst;
	}
	public String getCfirst() {
		return this.cfirst;
	}
	public void setCsecond(String csecond) {
		this.csecond = csecond;
	}
	public String getCsecond() {
		return this.csecond;
	}
	public void setCsupport(String csupport) {
		this.csupport = csupport;
	}
	public String getCsupport() {
		return this.csupport;
	}
	public void setTestPosition(String testPosition) {
		this.testPosition = testPosition;
	}
	public String getTestPosition() {
		return this.testPosition;
	}
	public void setAvoltage(String avoltage) {
		this.avoltage = avoltage;
	}
	public String getAvoltage() {
		return this.avoltage;
	}
	public void setBvoltage(String bvoltage) {
		this.bvoltage = bvoltage;
	}
	public String getBvoltage() {
		return this.bvoltage;
	}
	public void setCvoltage(String cvoltage) {
		this.cvoltage = cvoltage;
	}
	public String getCvoltage() {
		return this.cvoltage;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getAtime() {
		return this.atime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getBtime() {
		return this.btime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCtime() {
		return this.ctime;
	}
	public void setAresult(String aresult) {
		this.aresult = aresult;
	}
	public String getAresult() {
		return this.aresult;
	}
	public void setBresult(String bresult) {
		this.bresult = bresult;
	}
	public String getBresult() {
		return this.bresult;
	}
	public void setCresult(String cresult) {
		this.cresult = cresult;
	}
	public String getCresult() {
		return this.cresult;
	}
	public void setAafter(String aafter) {
		this.aafter = aafter;
	}
	public String getAafter() {
		return this.aafter;
	}
	public void setBafter(String bafter) {
		this.bafter = bafter;
	}
	public String getBafter() {
		return this.bafter;
	}
	public void setCafter(String cafter) {
		this.cafter = cafter;
	}
	public String getCafter() {
		return this.cafter;
	}
	public void setAdirect(String adirect) {
		this.adirect = adirect;
	}
	public String getAdirect() {
		return this.adirect;
	}
	public void setBdirect(String bdirect) {
		this.bdirect = bdirect;
	}
	public String getBdirect() {
		return this.bdirect;
	}
	public void setCdirect(String cdirect) {
		this.cdirect = cdirect;
	}
	public String getCdirect() {
		return this.cdirect;
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

