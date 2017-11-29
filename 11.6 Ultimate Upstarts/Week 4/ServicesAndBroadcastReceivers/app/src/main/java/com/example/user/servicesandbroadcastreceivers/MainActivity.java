package com.example.user.servicesandbroadcastreceivers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.servicesandbroadcastreceivers.receivers.MyDynamicReceiver;
import com.example.user.servicesandbroadcastreceivers.services.MyBoundService;
import com.example.user.servicesandbroadcastreceivers.services.MyIntentService;
import com.example.user.servicesandbroadcastreceivers.services.MyStartedService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    @BindView(R.id.btnStartStartedService)
    Button btnStartStartedService;
    @BindView(R.id.btnStopStartedService)
    Button btnStopStartedService;
    @BindView(R.id.btnIntentService)
    Button btnIntentService;
    @BindView(R.id.btnBindService)
    Button btnBindService;
    @BindView(R.id.tvBindServiceData)
    TextView tvBindServiceData;
    @BindView(R.id.btnUnbindService)
    Button btnUnbindService;
    @BindView(R.id.etSendData)
    EditText etSendData;
    @BindView(R.id.btnSendBroadcast)
    Button btnSendBroadcast;
    @BindView(R.id.tvBRData)
    TextView tvBRData;
    @BindView(R.id.btnGetBoundData)
    Button btnGetBoundData;
    private MyDynamicReceiver myDynamicReceiver;
    private IntentFilter filter;
    private MyBoundService myBoundService;
    private boolean isBound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.btnStartStartedService, R.id.btnStopStartedService, R.id.btnIntentService, R.id.btnBindService, R.id.btnUnbindService, R.id.btnSendBroadcast})
    public void onViewClicked(View view) {

        //started service
        Intent startedIntent = new Intent(this, MyStartedService.class);
        //intent service
        Intent intIntent = new Intent(this, MyIntentService.class);
        //bound service
        Intent boundIntent = new Intent(this, MyBoundService.class);


        switch (view.getId()) {
            case R.id.btnStartStartedService:

                startService(startedIntent);

                break;
            case R.id.btnStopStartedService:
                stopService(startedIntent);

                break;
            case R.id.btnIntentService:
                startService(intIntent);

                break;
            case R.id.btnBindService:
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);

                break;
            case R.id.btnUnbindService:

                if (isBound) {
                    unbindService(serviceConnection);
                    onServiceUnbind();
                }

                break;
            case R.id.btnSendBroadcast:

                Intent brIntent = new Intent("sendToOtherApp");
                brIntent.putExtra("data", etSendData.getText().toString());
                LocalBroadcastManager.getInstance(this).sendBroadcast(brIntent);

                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        myDynamicReceiver = new MyDynamicReceiver(tvBRData);
        filter = new IntentFilter();
        filter.addAction("intentData");
        registerReceiver(myDynamicReceiver, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myDynamicReceiver);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: ");
            isBound = true;
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundService = myBinder.getService();
            myBoundService.initData();
            Toast.makeText(myBoundService, "Bounded", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


        }
    };

    private void onServiceUnbind() {
        isBound = false;
        Toast.makeText(MainActivity.this
                , "UnBounded", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btnGetBoundData)
    public void onViewClicked() {

        if (isBound) {
            tvBindServiceData.setText(myBoundService.getData());
        } else {
            tvBindServiceData.setText("default data");
        }

    }
}
