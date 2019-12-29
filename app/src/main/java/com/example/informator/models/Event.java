package com.example.informator.models;

import java.util.Date;

public class Event {
    private int id;
    private String imgUrl;
    private String title;
    private String desc;
    private Date date;

    public Event(int id, String imgUrl, String title, String desc, Date date) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}
