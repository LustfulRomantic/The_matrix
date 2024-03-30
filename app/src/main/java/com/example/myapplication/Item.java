package com.example.myapplication;

import java.util.ArrayList;
import java.util.Date;

public class Item {

    private String who, name, desc, pic  = "tbd";
    private Date date;

    private ArrayList<MazeMatrix> graph = new ArrayList<>();
    private String config = "tbd";
    private String status = "a1"; //a1 = app1 , a2 = app2 ....

    Item() {}

    Item(String who, String name, String desc, Date date, String status) {
        this.who = who;
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.status = status;
    }

    public void setStatus(String status){this.status = status;}
    public void setWho(String who) {this.who = who;}
    public void setDate(Date date) {
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

    public Date getDate() {
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
    public ArrayList<MazeMatrix> getGraph() {return graph;}

    @Override
    public String toString() {
        return "Item{" +
                "who='" + who + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                ", date=" + date +
                ", graph=" + graph +
                ", config='" + config + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
