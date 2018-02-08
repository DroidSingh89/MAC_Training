
package com.example.user.makingrestcalls.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popup {

    @SerializedName("menuitem")
    @Expose
    private List<Menuitem> menuitem = null;

    public List<Menuitem> getMenuitem() {
        return menuitem;
    }

    public void setMenuitem(List<Menuitem> menuitem) {
        this.menuitem = menuitem;
    }


}
