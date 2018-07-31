package com.example.user.encryption;

import android.app.Application;
import android.content.Context;


import com.example.user.encryption.di.component.DaggerAppComponent;
import com.example.user.encryption.di.component.MainComponent;
import com.example.user.encryption.di.module.EncryptionModule;
import com.example.user.encryption.di.module.MainModule;

public class MainApplication extends Application{

    MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public MainComponent getMainComponent() {

        mainComponent = DaggerAppComponent.builder()
                .encryptionModule(new EncryptionModule(this))
                .build().addMain(new MainModule());

        return mainComponent;
    }

    public void clearMainComponent() {
        mainComponent = null;
    }
}
