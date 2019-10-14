package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerDocCurrentTransformer的实体类")
public class PowerDocCurrentTransformer extends BaseEntity{

    // 电流互感器试验报告主键
    @ApiModelProperty(value = "电流互感器试验报告主键",example = "")
    private Long currentTransformerId;
    // 所属报告id
    @ApiModelProperty(value = "所属报告id",example = "")
    private Long subreportId;
    // 绝缘电阻测量_A_一次/末屏、二次及地
    @ApiModelProperty(value = "绝缘电阻测量_A_一次/末屏、二次及地",example = "")
    private String afirst;
    // 绝缘电阻测量_B_一次/末屏、二次及地
    @ApiModelProperty(value = "绝缘电阻测量_B_一次/末屏、二次及地",example = "")
    private String bfirst;
    // 绝缘电阻测量_C_一次/末屏、二次及地
    @ApiModelProperty(value = "绝缘电阻测量_C_一次/末屏、二次及地",example = "")
    private String cfirst;
    // 绝缘电阻测量_A_末屏/二次及地
    @ApiModelProperty(value = "绝缘电阻测量_A_末屏/二次及地",example = "")
    private String alast;
    // 绝缘电阻测量_B_末屏/二次及地
    @ApiModelProperty(value = "绝缘电阻测量_B_末屏/二次及地",example = "")
    private String blast;
    // 绝缘电阻测量_C_末屏/二次及地
    @ApiModelProperty(value = "绝缘电阻测量_C_末屏/二次及地",example = "")
    private String clast;
    // 绝缘电阻测量_A_二次/末屏及地
    @ApiModelProperty(value = "绝缘电阻测量_A_二次/末屏及地",example = "")
    private String asecond;
    // 绝缘电阻测量_B_二次/末屏及地
    @ApiModelProperty(value = "绝缘电阻测量_B_二次/末屏及地",example = "")
    private String bsecond;
    // 绝缘电阻测量_C_二次/末屏及地
    @ApiModelProperty(value = "绝缘电阻测量_C_二次/末屏及地",example = "")
    private String csecond;
    // 试验电压_正接法
    @ApiModelProperty(value = "试验电压_正接法",example = "")
    private String voltagePositive;
    // 试验部位_正接法
    @ApiModelProperty(value = "试验部位_正接法",example = "")
    private String testPositionPositive;
    // 电容值测量_正接法_A_Cx(pf)
    @ApiModelProperty(value = "电容值测量_正接法_A_Cx(pf)",example = "")
    private String acxPositive;
    // 电容值测量_正接法_B_Cx(pf)
    @ApiModelProperty(value = "电容值测量_正接法_B_Cx(pf)",example = "")
    private String bcxPositive;
    // 电容值测量_正接法_C_Cx(pf)
    @ApiModelProperty(value = "电容值测量_正接法_C_Cx(pf)",example = "")
    private String ccxPositive;
    // 电容值测量_正接法_A_tgδ%
    @ApiModelProperty(value = "电容值测量_正接法_A_tgδ%",example = "")
    private String atgPositive;
    // 电容值测量_正接法_B_tgδ%
    @ApiModelProperty(value = "电容值测量_正接法_B_tgδ%",example = "")
    private String btgPositive;
    // 电容值测量_正接法_C_tgδ%
    @ApiModelProperty(value = "电容值测量_正接法_C_tgδ%",example = "")
    private String ctgPositive;
    // 电容值测量_正接法_A_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_正接法_A_原始电容(pf)",example = "")
    private String apfPositive;
    // 电容值测量_正接法_B_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_正接法_B_原始电容(pf)",example = "")
    private String bpfPositive;
    // 电容值测量_正接法_C_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_正接法_C_原始电容(pf)",example = "")
    private String cpfPositive;
    // 电容值测量_正接法_A_△C %
    @ApiModelProperty(value = "电容值测量_正接法_A_△C %",example = "")
    private String acpositive;
    // 电容值测量_正接法_B_△C %
    @ApiModelProperty(value = "电容值测量_正接法_B_△C %",example = "")
    private String bcpositive;
    // 电容值测量_正接法_C_△C %
    @ApiModelProperty(value = "电容值测量_正接法_C_△C %",example = "")
    private String ccpositive;
    // 试验电压_反接法
    @ApiModelProperty(value = "试验电压_反接法",example = "")
    private String voltageReverse;
    // 试验部位_反接法
    @ApiModelProperty(value = "试验部位_反接法",example = "")
    private String testPositionReverse;
    // 电容值测量_反接法_A_Cx(pf)
    @ApiModelProperty(value = "电容值测量_反接法_A_Cx(pf)",example = "")
    private String acxReverse;
    // 电容值测量_反接法_B_Cx(pf)
    @ApiModelProperty(value = "电容值测量_反接法_B_Cx(pf)",example = "")
    private String bcxReverse;
    // 电容值测量_反接法_C_Cx(pf)
    @ApiModelProperty(value = "电容值测量_反接法_C_Cx(pf)",example = "")
    private String ccxReverse;
    // 电容值测量_反接法_A_tgδ%
    @ApiModelProperty(value = "电容值测量_反接法_A_tgδ%",example = "")
    private String atgReverse;
    // 电容值测量_反接法_B_tgδ%
    @ApiModelProperty(value = "电容值测量_反接法_B_tgδ%",example = "")
    private String btgReverse;
    // 电容值测量_反接法_C_tgδ%
    @ApiModelProperty(value = "电容值测量_反接法_C_tgδ%",example = "")
    private String ctgReverse;
    // 电容值测量_反接法_A_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_反接法_A_原始电容(pf)",example = "")
    private String apfReverse;
    // 电容值测量_反接法_B_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_反接法_B_原始电容(pf)",example = "")
    private String bpfReverse;
    // 电容值测量_反接法_C_原始电容(pf)
    @ApiModelProperty(value = "电容值测量_反接法_C_原始电容(pf)",example = "")
    private String cpfReverse;
    // 电容值测量_反接法_A_△C %
    @ApiModelProperty(value = "电容值测量_反接法_A_△C %",example = "")
    private String acreverse;
    // 电容值测量_反接法_B_△C %
    @ApiModelProperty(value = "电容值测量_反接法_B_△C %",example = "")
    private String bcreverse;
    // 电容值测量_反接法_C_△C %
    @ApiModelProperty(value = "电容值测量_反接法_C_△C %",example = "")
    private String ccreverse;
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



    public void setCurrentTransformerId(Long currentTransformerId) {
        this.currentTransformerId = currentTransformerId;
    }
    public Long getCurrentTransformerId() {
        return this.currentTransformerId;
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
    public void setBfirst(String bfirst) {
        this.bfirst = bfirst;
    }
    public String getBfirst() {
        return this.bfirst;
    }
    public void setCfirst(String cfirst) {
        this.cfirst = cfirst;
    }
    public String getCfirst() {
        return this.cfirst;
    }
    public void setAlast(String alast) {
        this.alast = alast;
    }
    public String getAlast() {
        return this.alast;
    }
    public void setBlast(String blast) {
        this.blast = blast;
    }
    public String getBlast() {
        return this.blast;
    }
    public void setClast(String clast) {
        this.clast = clast;
    }
    public String getClast() {
        return this.clast;
    }
    public void setAsecond(String asecond) {
        this.asecond = asecond;
    }
    public String getAsecond() {
        return this.asecond;
    }
    public void setBsecond(String bsecond) {
        this.bsecond = bsecond;
    }
    public String getBsecond() {
        return this.bsecond;
    }
    public void setCsecond(String csecond) {
        this.csecond = csecond;
    }
    public String getCsecond() {
        return this.csecond;
    }
    public void setVoltagePositive(String voltagePositive) {
        this.voltagePositive = voltagePositive;
    }
    public String getVoltagePositive() {
        return this.voltagePositive;
    }
    public void setTestPositionPositive(String testPositionPositive) {
        this.testPositionPositive = testPositionPositive;
    }
    public String getTestPositionPositive() {
        return this.testPositionPositive;
    }
    public void setAcxPositive(String acxPositive) {
        this.acxPositive = acxPositive;
    }
    public String getAcxPositive() {
        return this.acxPositive;
    }
    public void setBcxPositive(String bcxPositive) {
        this.bcxPositive = bcxPositive;
    }
    public String getBcxPositive() {
        return this.bcxPositive;
    }
    public void setCcxPositive(String ccxPositive) {
        this.ccxPositive = ccxPositive;
    }
    public String getCcxPositive() {
        return this.ccxPositive;
    }
    public void setAtgPositive(String atgPositive) {
        this.atgPositive = atgPositive;
    }
    public String getAtgPositive() {
        return this.atgPositive;
    }
    public void setBtgPositive(String btgPositive) {
        this.btgPositive = btgPositive;
    }
    public String getBtgPositive() {
        return this.btgPositive;
    }
    public void setCtgPositive(String ctgPositive) {
        this.ctgPositive = ctgPositive;
    }
    public String getCtgPositive() {
        return this.ctgPositive;
    }
    public void setApfPositive(String apfPositive) {
        this.apfPositive = apfPositive;
    }
    public String getApfPositive() {
        return this.apfPositive;
    }
    public void setBpfPositive(String bpfPositive) {
        this.bpfPositive = bpfPositive;
    }
    public String getBpfPositive() {
        return this.bpfPositive;
    }
    public void setCpfPositive(String cpfPositive) {
        this.cpfPositive = cpfPositive;
    }
    public String getCpfPositive() {
        return this.cpfPositive;
    }
    public void setAcpositive(String acpositive) {
        this.acpositive = acpositive;
    }
    public String getAcpositive() {
        return this.acpositive;
    }
    public void setBcpositive(String bcpositive) {
        this.bcpositive = bcpositive;
    }
    public String getBcpositive() {
        return this.bcpositive;
    }
    public void setCcpositive(String ccpositive) {
        this.ccpositive = ccpositive;
    }
    public String getCcpositive() {
        return this.ccpositive;
    }
    public void setVoltageReverse(String voltageReverse) {
        this.voltageReverse = voltageReverse;
    }
    public String getVoltageReverse() {
        return this.voltageReverse;
    }
    public void setTestPositionReverse(String testPositionReverse) {
        this.testPositionReverse = testPositionReverse;
    }
    public String getTestPositionReverse() {
        return this.testPositionReverse;
    }
    public void setAcxReverse(String acxReverse) {
        this.acxReverse = acxReverse;
    }
    public String getAcxReverse() {
        return this.acxReverse;
    }
    public void setBcxReverse(String bcxReverse) {
        this.bcxReverse = bcxReverse;
    }
    public String getBcxReverse() {
        return this.bcxReverse;
    }
    public void setCcxReverse(String ccxReverse) {
        this.ccxReverse = ccxReverse;
    }
    public String getCcxReverse() {
        return this.ccxReverse;
    }
    public void setAtgReverse(String atgReverse) {
        this.atgReverse = atgReverse;
    }
    public String getAtgReverse() {
        return this.atgReverse;
    }
    public void setBtgReverse(String btgReverse) {
        this.btgReverse = btgReverse;
    }
    public String getBtgReverse() {
        return this.btgReverse;
    }
    public void setCtgReverse(String ctgReverse) {
        this.ctgReverse = ctgReverse;
    }
    public String getCtgReverse() {
        return this.ctgReverse;
    }
    public void setApfReverse(String apfReverse) {
        this.apfReverse = apfReverse;
    }
    public String getApfReverse() {
        return this.apfReverse;
    }
    public void setBpfReverse(String bpfReverse) {
        this.bpfReverse = bpfReverse;
    }
    public String getBpfReverse() {
        return this.bpfReverse;
    }
    public void setCpfReverse(String cpfReverse) {
        this.cpfReverse = cpfReverse;
    }
    public String getCpfReverse() {
        return this.cpfReverse;
    }
    public void setAcreverse(String acreverse) {
        this.acreverse = acreverse;
    }
    public String getAcreverse() {
        return this.acreverse;
    }
    public void setBcreverse(String bcreverse) {
        this.bcreverse = bcreverse;
    }
    public String getBcreverse() {
        return this.bcreverse;
    }
    public void setCcreverse(String ccreverse) {
        this.ccreverse = ccreverse;
    }
    public String getCcreverse() {
        return this.ccreverse;
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

