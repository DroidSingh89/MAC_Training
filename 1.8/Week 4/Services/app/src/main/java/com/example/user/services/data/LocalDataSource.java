package com.example.user.services.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 1/30/18.
 */

public class LocalDataSource {


    public static List<String> getSimpleData(int count) {

        String[] FIRSTNAME_DICTIIONARY = new String[]{"Jennifer",
                "John", "Joseph", "James", "Tri", "Michael", "David"};

        String[] LASTNAME_DICTIIONARY = new String[]{"Vo",
                "Johnson", "Davidson", "Singh", "Alemu", "Smith", "Lee"};
        List<String> stringList = new ArrayList<>();

        String fullname;
        for (int i = 0; i < count; i++) {

            fullname = FIRSTNAME_DICTIIONARY
                    [new Random().nextInt(FIRSTNAME_DICTIIONARY.length)]
                    + " "
                    + LASTNAME_DICTIIONARY
                    [new Random().nextInt(LASTNAME_DICTIIONARY.length)];

            stringList.add(fullname);
        }
        return stringList;
    }

}