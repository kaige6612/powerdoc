package com.putorn.powerdoc.entity;
import com.putorn.powerdoc.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "PowerSysUser的实体类")
public class PowerSysUser extends BaseEntity{

        // 用户名
        @ApiModelProperty(value = "用户名",example = "")
		private String username;
        // 密码
        @ApiModelProperty(value = "密码",example = "")
		private String password;
        // 昵称
        @ApiModelProperty(value = "昵称",example = "")
		private String nickname;
        // 用户图标
        @ApiModelProperty(value = "用户图标",example = "")
		private String icon;
        // 性别 默认0 男 1，女 2
        @ApiModelProperty(value = "性别 默认0 男 1，女 2",example = "")
		private Integer sex;
        // 手机
        @ApiModelProperty(value = "手机",example = "")
		private String phone;
        // 邮箱
        @ApiModelProperty(value = "邮箱",example = "")
		private String email;
        // 最后登录IP
        @ApiModelProperty(value = "最后登录IP",example = "")
		private String lastip;
        // 最后登录时间
        @ApiModelProperty(value = "最后登录时间",example = "")
		private java.sql.Timestamp lasttime;
        // 注册IP
        @ApiModelProperty(value = "注册IP",example = "")
		private String regip;
        // 注册时间
        @ApiModelProperty(value = "注册时间",example = "")
		private java.sql.Timestamp regtime;
        // 登录错误次数
        @ApiModelProperty(value = "登录错误次数",example = "")
		private Integer loginErrorNum;
        // 是否系统管理员 0否 1是
        @ApiModelProperty(value = "是否系统管理员 0否 1是",example = "")
		private Integer isSysadmin;
        // 是否是试验负责人 0：否 1：是
        @ApiModelProperty(value = "是否是试验负责人 0：否 1：是",example = "")
		private Integer isDutyPerson;
        // 状态  1启用  2禁用 3已删除
        @ApiModelProperty(value = "状态  1启用  2禁用 3已删除",example = "")
		private Integer status;
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



	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIcon() {
		return this.icon;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSex() {
		return this.sex;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public String getLastip() {
		return this.lastip;
	}
	public void setLasttime(java.sql.Timestamp lasttime) {
		this.lasttime = lasttime;
	}
	public java.sql.Timestamp getLasttime() {
		return this.lasttime;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRegip() {
		return this.regip;
	}
	public void setRegtime(java.sql.Timestamp regtime) {
		this.regtime = regtime;
	}
	public java.sql.Timestamp getRegtime() {
		return this.regtime;
	}
	public void setLoginErrorNum(Integer loginErrorNum) {
		this.loginErrorNum = loginErrorNum;
	}
	public Integer getLoginErrorNum() {
		return this.loginErrorNum;
	}
	public void setIsSysadmin(Integer isSysadmin) {
		this.isSysadmin = isSysadmin;
	}
	public Integer getIsSysadmin() {
		return this.isSysadmin;
	}
	public void setIsDutyPerson(Integer isDutyPerson) {
		this.isDutyPerson = isDutyPerson;
	}
	public Integer getIsDutyPerson() {
		return this.isDutyPerson;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatus() {
		return this.status;
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

