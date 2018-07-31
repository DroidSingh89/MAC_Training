package com.example.user.encryption.di.component;

import com.example.user.encryption.di.module.EncryptionModule;
import com.example.user.encryption.di.module.MainModule;

import dagger.Component;

@Component(modules = EncryptionModule.class)
public interface AppComponent {

    MainComponent addMain(MainModule mainModule);


}
