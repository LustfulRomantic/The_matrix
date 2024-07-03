package com.example.myapplication;

import java.util.ArrayList;
import java.util.Date;

public class Item {

    private String who, name, desc, status, pic, date;
    Item() {}

    Item(String who, String name, String desc, String date, String status, String pic) {
        this.who = who;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.pic = pic;
        this.status = status;
    }

    public void setStatus(String status){this.status = status;}
    public void setWho(String who) {this.who = who;}
    public void setDate(String date) {
        this.date = date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDate() {
        return date;
    }
    public String getWho(){return who;}
    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
    public String getPic() {
        return pic;
    }
    public String getStatus() {return status;}

    @Override
    public String toString() {
        return "Item{" +
                "who='" + who + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                ", date=" + date +'\''+
                ", status='" + status + '\'' +
                '}';
    }
}
