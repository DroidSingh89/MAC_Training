package com.example.user.lifecycleandconfigchanges;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by singh on 11/9/17.
 */

public class DataParcelable implements Parcelable{

    String textField;
    String date;
    String time;

    @Override
    public String toString() {
        return "DataParcelable{" +
                "textField='" + textField + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public DataParcelable(String textField, String date, String time) {
        this.textField = textField;
        this.date = date;
        this.time = time;
    }

    protected DataParcelable(Parcel in) {
        textField = in.readString();
        date = in.readString();
        time = in.readString();
    }

    public static final Creator<DataParcelable> CREATOR = new Creator<DataParcelable>() {
        @Override
        public DataParcelable createFromParcel(Parcel in) {
            return new DataParcelable(in);
        }

        @Override
        public DataParcelable[] newArray(int size) {
            return new DataParcelable[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textField);
        dest.writeString(date);
        dest.writeString(time);
    }
}
