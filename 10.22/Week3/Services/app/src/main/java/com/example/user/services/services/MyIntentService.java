package com.example.user.services.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName() + "_TAG";

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.user.services.services.action.FOO";
    private static final String ACTION_BAZ = "com.example.user.services.services.action.BAZ";


    private static final String EXTRA_PARAM1 = "com.example.user.services.services.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.user.services.services.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }


    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: " + Thread.currentThread().getName());
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private void handleActionFoo(String param1, String param2) {

        Log.d(TAG, "handleActionFoo: " + param1 + param2);
        startTask(param1, param2);

    }


    private void handleActionBaz(String param1, String param2) {

        Log.d(TAG, "handleActionBaz: " + param1 + param2);
        startTask(param1, param2);
    }


    public void startTask(String param1, String param2) {

//        processing one
        try {
            Thread.sleep(500);
            Log.d(TAG, "startTask: Processing: " + param1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        processing two
        try {
            Thread.sleep(500);
            Log.d(TAG, "startTask: Processing: " + param2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        send a broadcast back to the activity

    }
}
