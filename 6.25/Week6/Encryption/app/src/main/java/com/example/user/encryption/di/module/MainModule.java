package com.example.user.encryption.di.module;

import com.example.user.encryption.manager.CipherManager;
import com.example.user.encryption.manager.KeystoreManager;
import com.example.user.encryption.view.main.MainPresenter;

import javax.crypto.Cipher;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter(KeystoreManager keystoreManager, CipherManager cipherManager) {
        return new MainPresenter(keystoreManager, cipherManager);
    }

}
