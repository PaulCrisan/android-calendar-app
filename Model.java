package com.wallpapernote.plutopix.wallpaperorganizer;

import java.io.Serializable;


public class Model implements Serializable {

    private int id;
    private int year;
    private int month;
    private int day;
    private int hour;
    private String note;

    private static final long serialVersionUID = 50L;

    private int star;
    private String birthday;
    private String customr;




    public Model(){

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Model(int year, int month, int day, int hour, String note) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;

        this.note = note;
    }

    public Model(int year, int month, int day, int star) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.star = star;

    }
    public Model(int month, int day,String birthday) {
        this.month = month;
        this.day = day;
        this.birthday = birthday;

    }
    public Model(String customr, int year, int month, int day) {
        this.customr = customr;
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public String getCustomr() {
        return customr;
    }

    public void setCustomr(String customr) {
        this.customr = customr;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


}
