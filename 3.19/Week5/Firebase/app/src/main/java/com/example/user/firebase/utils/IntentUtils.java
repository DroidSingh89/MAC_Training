package com.example.user.firebase.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IntentUtils {

    public static Builder create(Context context){
        return new Builder(context);
    }

    public static class Builder {

        Intent intent;
        Context context;

        public Builder(Context context) {
            this.intent = new Intent();
            this.context = context;

        }

        public Builder addComponent(Class component) {

            this.intent.setComponent(new ComponentName(context, component));
            return this;
        }

        //add more putExtra constructors for other data types of use object class
        public Builder putExtra(String key, String data) {

            this.intent.putExtra(key, data);
            return this;

        }

        public Intent build() {
            return this.intent;
        }

        public void startActivity(){
            this.context.startActivity(this.intent);

        }

        public void startService(){
            this.context.startService(this.intent);

        }



    }
}
