package com.example.user.analytics;

import org.json.JSONException;
import org.json.JSONObject;

public class Event {


    String name;
    JSONObject props;

    public Event(String name, JSONObject props) {
        this.name = name;
        this.props = props;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Activity: " + name;
    }

    public JSONObject getProps() {
        return props;
    }

    public void setProps(JSONObject props) {
        this.props = props;
    }

    public static class PropBuilder {


        JSONObject jsonObject;

        public PropBuilder() {

            jsonObject = new JSONObject();

        }

        public PropBuilder addProp(String propName, String propValue) throws JSONException {
            jsonObject.put(propName, propValue);
            return this;

        }

        public JSONObject build() {
            return jsonObject;
        }


    }


}
