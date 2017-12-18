package com.example.user.makingrestcalls;

import android.util.Log;

import com.example.user.makingrestcalls.model.mocky.MockyResponse;
import com.example.user.makingrestcalls.model.mocky.Popup;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by singh on 12/18/17.
 */

public class MyParser {


    private static final String TAG = "MyParser";

    public static void parseUsingJSON(String unparsed) throws JSONException {

        JSONObject mockyObject = new JSONObject(unparsed);
        JSONObject menuObject = mockyObject.getJSONObject("menu");
        JSONObject popupObject = menuObject.getJSONObject("popup");
        JSONArray menuItemArray = popupObject.getJSONArray("menuitem");

        for (int i = 0; i < 3; i++) {

            JSONObject jsonObject = (JSONObject) menuItemArray.get(i);
            Log.d(TAG, "parseUsingJSON: " + jsonObject.getString("value"));
        }


    }

    public static MockyResponse parseUsingGson(String response){

        Gson gson = new Gson();
        MockyResponse mockyResponse = gson.fromJson(response, MockyResponse.class);
        return mockyResponse;

    }
}
