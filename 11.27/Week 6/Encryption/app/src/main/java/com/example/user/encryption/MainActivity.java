package com.example.user.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            KeystoreWrapper keystoreWrapper = new KeystoreWrapper(getApplicationContext());
            CipherWrapper cipherWrapper = new CipherWrapper(TRANSFORMATION);

            keystoreWrapper.createKeyPair("master");
            KeyPair masterKey = keystoreWrapper.getAsymKey("master");

            String plainText = "Hello world";
            Log.d(TAG, "onCreate: PlainText: " + plainText);

            String encryptedData = cipherWrapper.encrypt(plainText, masterKey.getPublic());
            Log.d(TAG, "onCreate: EncryptedData: " + encryptedData);

            String decryptedData = cipherWrapper.decrypt(encryptedData, masterKey.getPrivate());
            Log.d(TAG, "onCreate: DecryptedData:" + decryptedData);


        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | NoSuchPaddingException | IOException | InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | UnrecoverableKeyException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
