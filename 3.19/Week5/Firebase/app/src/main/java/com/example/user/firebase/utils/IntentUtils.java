package com.example.user.firebase.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IntentUtils {


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

        public Builder putExtra(String key, String data) {

            this.intent.putExtra(key, data);
            return this;

        }

        public Intent build() {
            return this.intent;
        }


    }
}
