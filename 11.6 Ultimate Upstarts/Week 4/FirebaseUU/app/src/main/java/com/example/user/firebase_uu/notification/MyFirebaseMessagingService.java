package com.example.user.firebase_uu.notification;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;


/**
 * Created by singh on 12/6/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    Handler handler = new Handler(Looper.getMainLooper());

    public static final String TAG = "MyFBMsgServiceTag";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                Log.d(TAG, "onMessageReceived: inside if");
                scheduleJob(remoteMessage.getData());
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            updateUI(remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void updateUI(final String body) {
        Log.d(TAG, "updateUI: " + Thread.currentThread());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), body, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void handleNow() {

    }

    private void scheduleJob(final Map<String, String> data) {
        Log.d(TAG, "scheduleJob: " + Thread.currentThread());

        Intent intent = new Intent("openDialog");
        intent.putExtra("customdata", data.get("Custom1"));
        getApplicationContext().sendBroadcast(intent);

    }
}
