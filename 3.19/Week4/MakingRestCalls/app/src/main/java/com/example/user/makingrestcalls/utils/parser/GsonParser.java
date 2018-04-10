package com.example.user.makingrestcalls.utils.parser;

import com.google.gson.Gson;

public class GsonParser {

    public static Object parse(String response, Class c) {
        Gson gson = new Gson();
        return gson.fromJson(response, c);

    }
}
