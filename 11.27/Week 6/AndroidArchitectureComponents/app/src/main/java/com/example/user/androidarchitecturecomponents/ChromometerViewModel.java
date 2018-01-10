package com.example.user.androidarchitecturecomponents;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

/**
 * Created by singh on 1/10/18.
 */

public class ChromometerViewModel extends ViewModel{


    @Nullable
    Long startTime;

    @Nullable
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
}
