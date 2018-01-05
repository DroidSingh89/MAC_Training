package com.example.user.lifecycleandconfigchanges;

import java.io.Serializable;

/**
 * Created by singh on 11/9/17.
 */

public class DataSerializable implements Serializable{

    String textField;
    String date;
    String time;

    @Override
    public String toString() {
        return "DataSerializable{" +
                "textField='" + textField + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public DataSerializable(String textField, String date, String time) {
        this.textField = textField;
        this.date = date;
        this.time = time;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
