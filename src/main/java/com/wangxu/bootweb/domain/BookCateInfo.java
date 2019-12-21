package com.wangxu.bootweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "cate_list")
public class BookCateInfo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private long cateid;
    @Column(nullable = false,name = "cateName")
    private String cateName;
    @Column(nullable = false,name = "cateurl")
    private String cateUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCateid() {
        return cateid;
    }

    public void setCateid(long cateid) {
        this.cateid = cateid;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateUrl() {
        return cateUrl;
    }

    public void setCateUrl(String cateUrl) {
        this.cateUrl = cateUrl;
    }
}
