package com.example.user.receiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class MyReceiver extends BroadcastReceiver {

    TextView tvMain;

    public MyReceiver(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String dataFromApp = intent.getStringExtra("KEY");
        tvMain.setText(dataFromApp);

    }
}
