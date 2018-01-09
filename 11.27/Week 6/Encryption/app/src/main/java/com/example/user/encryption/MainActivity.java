package com.example.user.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText etPlainText;
    private TextView tvEncryptedText;
    private KeystoreWrapper keystoreWrapper;
    private CipherWrapper cipherWrapper;
    private KeyPair masterKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlainText = findViewById(R.id.etPlainText);
        tvEncryptedText = findViewById(R.id.tvEncryptedText);

        try {
            keystoreWrapper = new KeystoreWrapper(getApplicationContext());
            cipherWrapper = new CipherWrapper(TRANSFORMATION);

            keystoreWrapper.createKeyPair("master");
            masterKey = keystoreWrapper.getAsymKey("master");



        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | NoSuchPaddingException | IOException | InvalidAlgorithmParameterException | UnrecoverableKeyException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public void onDataEncrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        String plainText = etPlainText.getText().toString();
        Log.d(TAG, "onCreate: PlainText: " + plainText);

        String encryptedData = cipherWrapper.encrypt(plainText, masterKey.getPublic());
        Log.d(TAG, "onCreate: EncryptedData: " + encryptedData);

        String decryptedData = cipherWrapper.decrypt(encryptedData, masterKey.getPrivate());
        Log.d(TAG, "onCreate: DecryptedData:" + decryptedData);

        tvEncryptedText.setText(decryptedData);
    }
}
