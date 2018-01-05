
package com.example.user.makingrestcalls.model.mocky;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Menuitem implements Serializable
{

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("onclick")
    @Expose
    private String onclick;
    private final static long serialVersionUID = -2986569911467448632L;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }


}
