package com.putorn.powerdoc.entity;
import com.alibaba.fastjson.annotation.JSONField;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocHvBushings的实体类")
public class PowerDocHvBushings extends BaseEntity{

        // 高压套管试验报告主键
        @ApiModelProperty(value = "高压套管试验报告主键",example = "")
		private Long hvBushingsId;
        // 所属报告id
        @ApiModelProperty(value = "所属报告id",example = "")
		private Long subreportId;
        // A_一次末屏
        @ApiModelProperty(value = "A_一次末屏",example = "")
		private String aonce;
        // A_末屏地
        @ApiModelProperty(value = "A_末屏地",example = "")
		private String aland;
        // B_一次末屏
        @ApiModelProperty(value = "B_一次末屏",example = "")
		private String bonce;
        // B_末屏地
        @ApiModelProperty(value = "B_末屏地",example = "")
		private String bland;
        // C_一次末屏
        @ApiModelProperty(value = "C_一次末屏",example = "")
		private String conce;
        // C_末屏地
        @ApiModelProperty(value = "C_末屏地",example = "")
		private String cland;
        // D_一次末屏
        @ApiModelProperty(value = "D_一次末屏",example = "")
		private String donce;
        // D_末屏地
        @ApiModelProperty(value = "D_末屏地",example = "")
		private String dland;
        // 试验部位
        @ApiModelProperty(value = "试验部位",example = "")
		private String testPosition;
        // 试验电压
        @ApiModelProperty(value = "试验电压",example = "")
		private String testVoltage;
        // A_Cx(pF)
        @ApiModelProperty(value = "A_Cx(pF)",example = "")
		private String acx;
        // A_tgδ%
        @ApiModelProperty(value = "A_tgδ%",example = "")
		private String atg;
        // A_原始电容
        @ApiModelProperty(value = "A_原始电容",example = "")
		private String apf;
        // A_△C %
        @ApiModelProperty(value = "A_△C %",example = "")
		private String ac;
        // B_Cx(pF)
        @ApiModelProperty(value = "B_Cx(pF)",example = "")
		private String bcx;
        // B_tgδ%
        @ApiModelProperty(value = "B_tgδ%",example = "")
		private String btg;
        // B_原始电容
        @ApiModelProperty(value = "B_原始电容",example = "")
		private String bpf;
        // B_△C %
        @ApiModelProperty(value = "B_△C %",example = "")
		private String bc;
        // C_Cx(pF)
        @ApiModelProperty(value = "C_Cx(pF)",example = "")
		private String ccx;
        // C_tgδ%
        @ApiModelProperty(value = "C_tgδ%",example = "")
		private String ctg;
        // C_原始电容
        @ApiModelProperty(value = "C_原始电容",example = "")
		private String cpf;
        // C_△C %
        @ApiModelProperty(value = "C_△C %",example = "")
		private String cc;
        // D_Cx(pF)
        @ApiModelProperty(value = "D_Cx(pF)",example = "")
		private String dcx;
        // D_tgδ%
        @ApiModelProperty(value = "D_tgδ%",example = "")
		private String dtg;
        // D_原始电容
        @ApiModelProperty(value = "D_原始电容",example = "")
		private String dpf;
        // D_△C %
        @ApiModelProperty(value = "D_△C %",example = "")
		private String dc;
        // 添加人id
        @ApiModelProperty(value = "添加人id",example = "")
		private Integer addUserid;
        // 添加人姓名
        @ApiModelProperty(value = "添加人姓名",example = "")
		private String addUsername;
        // 添加时间
		@JSONField(format="yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "添加时间",example = "")
		private java.sql.Timestamp addtime;
        // 修改人id
        @ApiModelProperty(value = "修改人id",example = "")
		private Integer editUserid;
        // 修改人姓名
        @ApiModelProperty(value = "修改人姓名",example = "")
		private String editUsername;
        // 修改时间
		@JSONField(format="yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "修改时间",example = "")
		private java.sql.Timestamp edittime;



	public void setHvBushingsId(Long hvBushingsId) {
		this.hvBushingsId = hvBushingsId;
	}
	public Long getHvBushingsId() {
		return this.hvBushingsId;
	}
	public void setSubreportId(Long subreportId) {
		this.subreportId = subreportId;
	}
	public Long getSubreportId() {
		return this.subreportId;
	}
	public void setAonce(String aonce) {
		this.aonce = aonce;
	}
	public String getAonce() {
		return this.aonce;
	}
	public void setAland(String aland) {
		this.aland = aland;
	}
	public String getAland() {
		return this.aland;
	}
	public void setBonce(String bonce) {
		this.bonce = bonce;
	}
	public String getBonce() {
		return this.bonce;
	}
	public void setBland(String bland) {
		this.bland = bland;
	}
	public String getBland() {
		return this.bland;
	}
	public void setConce(String conce) {
		this.conce = conce;
	}
	public String getConce() {
		return this.conce;
	}
	public void setCland(String cland) {
		this.cland = cland;
	}
	public String getCland() {
		return this.cland;
	}
	public void setDonce(String donce) {
		this.donce = donce;
	}
	public String getDonce() {
		return this.donce;
	}
	public void setDland(String dland) {
		this.dland = dland;
	}
	public String getDland() {
		return this.dland;
	}
	public void setTestPosition(String testPosition) {
		this.testPosition = testPosition;
	}
	public String getTestPosition() {
		return this.testPosition;
	}
	public void setTestVoltage(String testVoltage) {
		this.testVoltage = testVoltage;
	}
	public String getTestVoltage() {
		return this.testVoltage;
	}
	public void setAcx(String acx) {
		this.acx = acx;
	}
	public String getAcx() {
		return this.acx;
	}
	public void setAtg(String atg) {
		this.atg = atg;
	}
	public String getAtg() {
		return this.atg;
	}
	public void setApf(String apf) {
		this.apf = apf;
	}
	public String getApf() {
		return this.apf;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getAc() {
		return this.ac;
	}
	public void setBcx(String bcx) {
		this.bcx = bcx;
	}
	public String getBcx() {
		return this.bcx;
	}
	public void setBtg(String btg) {
		this.btg = btg;
	}
	public String getBtg() {
		return this.btg;
	}
	public void setBpf(String bpf) {
		this.bpf = bpf;
	}
	public String getBpf() {
		return this.bpf;
	}
	public void setBc(String bc) {
		this.bc = bc;
	}
	public String getBc() {
		return this.bc;
	}
	public void setCcx(String ccx) {
		this.ccx = ccx;
	}
	public String getCcx() {
		return this.ccx;
	}
	public void setCtg(String ctg) {
		this.ctg = ctg;
	}
	public String getCtg() {
		return this.ctg;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getCc() {
		return this.cc;
	}
	public void setDcx(String dcx) {
		this.dcx = dcx;
	}
	public String getDcx() {
		return this.dcx;
	}
	public void setDtg(String dtg) {
		this.dtg = dtg;
	}
	public String getDtg() {
		return this.dtg;
	}
	public void setDpf(String dpf) {
		this.dpf = dpf;
	}
	public String getDpf() {
		return this.dpf;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getDc() {
		return this.dc;
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

