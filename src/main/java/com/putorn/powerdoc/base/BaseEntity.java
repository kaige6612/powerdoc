package com.putorn.powerdoc.base;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 基类
 */
@ApiModel
public class BaseEntity implements Serializable{

	@ApiModelProperty(value = "主键,自增",example = "")
	private Long id;// 主键ID.
	@ApiModelProperty(value = "添加人id",example = "",hidden = true)
	private Integer addUserid;//添加人id
	@ApiModelProperty(value = "添加人姓名",example = "张三",hidden = true)
	private String addUsername;//添加人姓名
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "添加时间",example = "2019-03-14 15:28:34",hidden = true)
	private Timestamp addtime;//添加时间
	@ApiModelProperty(value = "修改人id",example = "123",hidden = true)
	private Integer editUserid;//修改人id
	@ApiModelProperty(value = "添加人姓名",example = "张三",hidden = true)
	private String editUsername;//添加人姓名
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "修改时间",example = "2019-03-14 15:28:34",hidden = true)
	private Timestamp edittime;//修改时间

//	private Integer version ;// 版本号默认为0


	public Integer getAddUserid() {
		return addUserid;
	}

	public void setAddUserid(Integer addUserid) {
		this.addUserid = addUserid;
	}

	public String getAddUsername() {
		return addUsername;
	}

	public void setAddUsername(String addUsername) {
		this.addUsername = addUsername;
	}

	public Integer getEditUserid() {
		return editUserid;
	}

	public void setEditUserid(Integer editUserid) {
		this.editUserid = editUserid;
	}

	public String getEditUsername() {
		return editUsername;
	}

	public void setEditUsername(String editUsername) {
		this.editUsername = editUsername;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getEdittime() {
		return edittime;
	}

	public void setEdittime(Timestamp edittime) {
		this.edittime = edittime;
	}
}
