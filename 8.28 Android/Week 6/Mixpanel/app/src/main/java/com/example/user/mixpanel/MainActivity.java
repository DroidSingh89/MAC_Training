package com.example.user.mixpanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String YOUR_PROJECT_TOKEN = "574b01183c919a6e7d28b2f82f2690a3";
    private MixpanelAPI mixpanel;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String projectToken = YOUR_PROJECT_TOKEN; // e.g.: "1ef7e30d2a58d27f4b90c42e31d6d7ad"
        mixpanel = MixpanelAPI.getInstance(this, projectToken);

        mixpanel.eventElapsedTime("Time on main");
    }


    public void logActivity(View view) {
        String activity = "";

        switch (view.getId()) {

            case R.id.btnJump:

                activity = "Jump";
                trackMixpanel(activity);
                break;

            case R.id.btnFly:

                activity = "Fly";
                trackMixpanel(activity);

                break;

            case R.id.btnRun:

                activity = "Run";
                trackMixpanel(activity);
                break;

            case R.id.btnSleep:

                activity = "Sleep";
                trackMixpanel(activity);

                trackMixpanelTime();
                break;

        }

    }

    private void trackMixpanel(String activity) {
        try {
            JSONObject props = new JSONObject();
            props.put("Activity", activity);
            props.put("Logged in", false);
            mixpanel.track("MainActivity - on" + activity + " called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }


    private void trackMixpanelTime() {

            mixpanel.track("Time on main");

    }
}
