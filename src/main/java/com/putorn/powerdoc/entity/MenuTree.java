/*
 * www.com.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

package com.putorn.powerdoc.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author guoqingkai
 * @date
 * 部门 树形菜单
 */
public class MenuTree implements Serializable{

    /**
     * 本节点名称
     */
    @ApiModelProperty(value = "本节点名称",example = "技术部")
    private String label;

    //private String href;

    //private String[] tags;
    /**
     * 本节点id
     */
    @ApiModelProperty(value = "本节点id",example = "6")
    private String id;
    /**
     *父节点ID
     */
    @ApiModelProperty(value = "父节点ID",example = "6")
    private String parentId;
    /**
     *父节点名称
     */
    @ApiModelProperty(value = "父节点名称",example = "技术部")
    private String parentName;
    /**
     *子节点集合
     */
    @ApiModelProperty(value = "本节点名称",example = "{}")
    List<MenuTree> children;
    /**
     * 对应节点的类型  菜单、目录、操作
     */
    @ApiModelProperty(value = "节点类型",example = "0")
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
