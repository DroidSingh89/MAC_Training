package com.example.user.analytics;

import org.json.JSONException;
import org.json.JSONObject;

public class MixPanelUtils {

    public static String getToken() {
        return "4fca82899f641fe406d91e2e839ee173";
    }

    public static PropsBuilder propCreator() {
        return new PropsBuilder();
    }


    //    builder pattern
    public static class PropsBuilder {

        JSONObject propJson;

        PropsBuilder() {
            propJson = new JSONObject();

        }

        public PropsBuilder addProperty(String propName, String propValue) throws JSONException {
            propJson.put(propName, propValue);

            return this;
        }


        public JSONObject build() {
            return this.propJson;
        }

    }

    public static class Events{

        public static final String RUNNING = "onRunning";
        public static final String JUMPING = "onJumping";
        public static final String SWIMMING = "onSwimming";
        public static final String SKYDIVING = "onSkyDiving";
        public static final String TIME = "onTimeEvent";

    }


}
