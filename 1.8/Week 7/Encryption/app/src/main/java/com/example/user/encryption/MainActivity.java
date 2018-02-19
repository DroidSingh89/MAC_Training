package com.example.user.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private static final String ALIAS = "wicked";
    private EditText etPlainText;
    private TextView tvCipherText;
    private TextView tvPlainText;
    private CipherWrapper cipherWrapper;
    private KeystoreWrapper keystoreWrapper;
    private KeyPair keyPair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlainText = findViewById(R.id.etPlainText);
        tvCipherText = findViewById(R.id.tvCipherText);
        tvPlainText = findViewById(R.id.tvPlainText);

        try {
            init(ALIAS);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | CertificateException | IOException | KeyStoreException | InvalidAlgorithmParameterException | NoSuchProviderException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    public void init(String wicked) throws NoSuchAlgorithmException, NoSuchPaddingException, CertificateException, KeyStoreException, IOException, NoSuchProviderException, InvalidAlgorithmParameterException, UnrecoverableKeyException {

        cipherWrapper = new CipherWrapper();
        keystoreWrapper = new KeystoreWrapper(this);
        keystoreWrapper.createKeyPair(wicked);
        keyPair = keystoreWrapper.getKeyPair(wicked);

    }

    public void onEncrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String cipherText = cipherWrapper.encrypt(etPlainText.getText().toString(), keyPair.getPublic());
        tvCipherText.setText(cipherText);
    }

    public void onDecrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String plainText = cipherWrapper.decrypt(tvCipherText.getText().toString(), keyPair.getPrivate());
        tvPlainText.setText(plainText);

    }
}
