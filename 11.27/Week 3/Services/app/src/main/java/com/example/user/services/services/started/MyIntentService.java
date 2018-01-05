package com.example.user.services.services.started;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;


public class MyIntentService extends IntentService {

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.user.services.services.started.action.FOO";
    private static final String ACTION_BAZ = "com.example.user.services.services.started.action.BAZ";


    private static final String EXTRA_PARAM1 = "com.example.user.services.services.started.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.user.services.services.started.extra.PARAM2";
    private static final String TAG = "MyIntentTag";

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
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                Log.d(TAG, "onHandleIntent: ActionFoo Thread: " + Thread.currentThread().getName());
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                Log.d(TAG, "onHandleIntent: ActionBaz");
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }

            Log.d(TAG, "onHandleIntent: No action");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    private void handleActionFoo(String param1, String param2) {
        Log.d(TAG, "handleActionFoo: " + param1 + ":" + param2);


        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "handleActionFoo: Task Progress" + i);
        }


    }

    private void handleActionBaz(String param1, String param2) {
        Log.d(TAG, "handleActionBaz: " + param1 + ":" + param2);
    }
}
