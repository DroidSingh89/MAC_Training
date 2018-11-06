package com.example.user.broadcastreceivers;

import android.content.Context;
import android.content.Intent;

public class StringManipulator extends Thread {

    public static final String ACTION_STRING_MANIPULATOR = "action.STRING_MANIPULATOR";
    String stringToManipulate;
    Context context;

    public StringManipulator(String stringToManipulate, Context context) {
        this.stringToManipulate = stringToManipulate;
        this.context = context;
    }

    @Override
    public void run() {
        super.run();

        stringToManipulate = stringToManipulate.concat(" + Manipulated stuff");

//        send broadcast
        Intent intent = new Intent(ACTION_STRING_MANIPULATOR);
        intent.putExtra("KEY_STRING", stringToManipulate);
        context.sendBroadcast(intent);


    }

}
