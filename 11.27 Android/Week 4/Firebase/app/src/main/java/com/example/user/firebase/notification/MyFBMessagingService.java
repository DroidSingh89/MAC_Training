package com.example.user.firebase.notification;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by singh on 1/2/18.
 */

public class MyFBMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFBMessagingTag";

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
                scheduleJob(remoteMessage);
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }


        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void handleNow() {
        Log.d(TAG, "handleNow: ");

    }


    private void scheduleJob(RemoteMessage remoteMessage) {
        Log.d(TAG, "scheduleJob: " +
                "Name:" + remoteMessage.getData().get("name") +
                "Id: " + remoteMessage.getData().get("id"));
        String articleName = remoteMessage.getData().get("name");
        String id = remoteMessage.getData().get("task");



    }

}
