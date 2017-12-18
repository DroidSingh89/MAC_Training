
package com.example.user.makingrestcalls.model.mocky;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Popup implements Serializable
{

    @SerializedName("menuitem")
    @Expose
    private List<Menuitem> menuitem = null;
    private final static long serialVersionUID = -5958169647650419962L;

    public List<Menuitem> getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(List<Menuitem> menuitem) {
        this.menuitem = menuitem;
    }



}
