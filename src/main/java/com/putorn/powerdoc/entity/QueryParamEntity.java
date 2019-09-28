package com.putorn.powerdoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description: 封装下拉框查询 支持随时扩展
 * @author：Guoqingkai
 * @date:2019/4/19
 */
@ApiModel(description = "下拉框参数")
public class QueryParamEntity {
	@ApiModelProperty(value = "查询部门下拉框(all标识所有的机构下的)",example = "")
	private String departmentList;
	@ApiModelProperty(value = "查询角色下拉框(all标识所有的机构下的)",example = "")
	private String roleList;

	public String getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(String departmentList) {
		this.departmentList = departmentList;
	}

	public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}
}
