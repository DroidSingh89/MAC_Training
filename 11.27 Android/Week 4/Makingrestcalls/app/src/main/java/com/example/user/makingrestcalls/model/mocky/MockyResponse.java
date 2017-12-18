
package com.example.user.makingrestcalls.model.mocky;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MockyResponse implements Serializable
{

    @SerializedName("menu")
    @Expose
    private Menu menu;
    private final static long serialVersionUID = 546526841114745140L;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }



}
