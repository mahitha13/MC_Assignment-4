package com.mahitha.todoapp;

import java.util.UUID;

public class TodoTask {

    String mTitle;
    String mDetail;
    int mId;

    public TodoTask(String title, String detail, int mId){
        this.mTitle=title;
        this.mDetail=detail;
        this.mId=mId;
    }

    public int getmId() {
        return mId;
    }

    public String getDetail() {
        return mDetail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

}
