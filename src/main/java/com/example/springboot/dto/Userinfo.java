package com.example.springboot.dto;

import java.io.Serializable;

/**
 * 记录用户信息(Userinfo)实体类
 *
 * @author makejava
 * @since 2021-11-14 21:31:11
 */
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 565038218864511108L;

    private Integer id;

    private String name;

    private String money;

    private String address;

    private String state;

    private String date;

    private String thumb;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }


}

