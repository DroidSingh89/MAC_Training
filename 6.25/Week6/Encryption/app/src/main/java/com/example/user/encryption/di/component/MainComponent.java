package com.example.user.encryption.di.component;

import com.example.user.encryption.di.module.EncryptionModule;
import com.example.user.encryption.di.module.MainModule;
import com.example.user.encryption.view.main.MainActivity;


import dagger.Subcomponent;

@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
