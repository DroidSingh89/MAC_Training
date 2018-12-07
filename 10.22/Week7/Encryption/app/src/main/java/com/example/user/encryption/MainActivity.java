package com.example.user.encryption;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.encryption.manager.CipherManager;
import com.example.user.encryption.manager.KeyStoreManager;

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
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName()+ "_TAG";
    private EditText etPlainText;
    private TextView tvCipherText;
    private TextView tvPlainText;
    private EditText etAlias;
    private TextView tvKeyPair;
    private CipherManager cipherManager;
    private KeyStoreManager keyStoreManager;
    String currentAlias;
    private KeyPair keyPair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        try {
            Log.d(TAG, "onCreate: ");
            cipherManager = new CipherManager();
            keyStoreManager = new KeyStoreManager(this);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | CertificateException | KeyStoreException | IOException e) {
            e.printStackTrace();
        }

    }

    private void bindViews() {
        etAlias = findViewById(R.id.etAlias);
        tvKeyPair = findViewById(R.id.tvKeyPair);
        etPlainText = findViewById(R.id.etPlainText);
        tvCipherText = findViewById(R.id.tvCipherText);
        tvPlainText = findViewById(R.id.tvPlainText);
    }

    public void onEncryption(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        String cipherText = cipherManager.encrypt(etPlainText.getText().toString(), keyPair.getPrivate());
        tvCipherText.setText(cipherText);

    }

    public void onDecryption(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        String plainText = cipherManager.decrypt(tvCipherText.getText().toString(), keyPair.getPublic());
        tvPlainText.setText(plainText);

    }

    public void onGenerateKeyPair(View view) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableKeyException, KeyStoreException {
        currentAlias = etAlias.getText().toString();
        keyStoreManager.generateKey(currentAlias);
        keyPair = keyStoreManager.getKeyPair(currentAlias);
        String keyPairString = "PrivateKey: "+ keyPair.getPrivate().toString() +
                "PublicKey: "+ keyPair.getPublic().toString();
        tvKeyPair.setText(keyPairString);

    }
}
