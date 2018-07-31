package com.example.user.encryption.di.module;

import android.content.Context;

import com.example.user.encryption.manager.CipherManager;
import com.example.user.encryption.manager.KeystoreManager;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.NoSuchPaddingException;

import dagger.Module;
import dagger.Provides;

@Module
public class EncryptionModule {

    Context context;

    public EncryptionModule(Context context) {
        this.context = context;
    }

    @Provides
    KeystoreManager providesKeyStoreManager(Context context) {
        try {
            return new KeystoreManager(context);
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Provides
    CipherManager provideCipherManager() {
        try {
            return new CipherManager();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Provides
    Context provideContext() {
        return context;
    }


}
