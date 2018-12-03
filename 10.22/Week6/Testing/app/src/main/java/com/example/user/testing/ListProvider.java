package com.example.user.testing;

import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class ListProvider {



    public  List<String> getRawList() {

        List<String> rawList = new ArrayList<>();
        rawList.add("A");
        rawList.add("B");
        rawList.add("C");
        rawList.add("D");
        return rawList;

    }



}
