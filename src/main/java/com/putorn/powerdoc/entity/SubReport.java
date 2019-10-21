package com.putorn.powerdoc.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;
import java.util.Date;

public class SubReport {
    // 添加人id
    private Integer addUserid;
    // 添加人姓名
    private String addUsername;
    // 添加时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp addtime;
    // 修改人id
    private Integer editUserid;
    // 修改人姓名
    private String editUsername;
    // 修改时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date edittime;

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

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
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

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }
}
