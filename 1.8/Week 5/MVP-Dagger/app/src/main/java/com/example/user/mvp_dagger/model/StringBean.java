package com.example.user.mvp_dagger.model;

/**
 * Created by singh on 2/8/18.
 */

public class StringBean {

    String data;

    public StringBean(String data) {
        this.data = data;
    }

    public String getData() {
        return data + "something else";
    }

    public void setData(String data) {
        this.data = data;
    }
}
