package com.example.user.encryption;

import android.security.keystore.KeyNotYetValidException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private CipherWrapper cipherWrapper;
    private KeyStoreWrapper keyStoreWrapper;
    private String alias = "Master_Key";
    private KeyPair masterKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            initWrappers();

            keyStoreWrapper.createKeyPair(alias);

            masterKey = keyStoreWrapper.getAsymKey(alias);

            String plainText = "Hello world, encrypt me!";
            Log.d(TAG, "onCreate: PlainText: " + plainText);

            String encryptedData = cipherWrapper.encrypt(plainText, masterKey.getPublic());
            Log.d(TAG, "onCreate: EncryptedData: " + encryptedData);

            String decryptedData = cipherWrapper.decrypt(encryptedData, masterKey.getPrivate());
            Log.d(TAG, "onCreate: DecryptedData: " + decryptedData);


        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | UnrecoverableKeyException | NoSuchProviderException | BadPaddingException | KeyStoreException | InvalidKeyException | IllegalBlockSizeException | CertificateException | IOException e) {
            e.printStackTrace();
        }


    }

    private void initWrappers() throws NoSuchAlgorithmException, NoSuchPaddingException, CertificateException, KeyStoreException, IOException {
        cipherWrapper = new CipherWrapper("RSA/ECB/PKCS1Padding");
        keyStoreWrapper = new KeyStoreWrapper(getApplicationContext());
    }


}
