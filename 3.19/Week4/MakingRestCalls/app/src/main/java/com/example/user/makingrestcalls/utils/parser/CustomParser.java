package com.example.user.makingrestcalls.utils.parser;

import android.util.Log;

import com.example.user.makingrestcalls.model.GithubProfile;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class CustomParser {

    public static void parse(String className, String response) throws JSONException {

        switch (className) {
            case "GITHUBPROFILE":

                GithubProfile githubProfile = new GithubProfile();
                JSONObject jsonObject = new JSONObject(response);
                String name = jsonObject.getString("name");
                githubProfile.setName(name);
                Log.d(TAG, "parse: " + githubProfile.toString());

                break;

        }
    }
}
