package com.example.user.encryption;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.etPlainText)
    EditText etPlainText;
    @BindView(R.id.btnConvertToCipher)
    Button btnConvertToCipher;
    @BindView(R.id.tvCipherText)
    TextView tvCipherText;
    @BindView(R.id.btnConvertToPlain)
    Button btnConvertToPlain;
    @BindView(R.id.tvPlainText)
    TextView tvPlainText;
    private KeystoreManager keystoreManager;
    private CipherManager cipherManager;
    private KeyPair keyPair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        try {
            initManagers();
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException | NoSuchPaddingException | InvalidAlgorithmParameterException | NoSuchProviderException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    private void initManagers() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException, UnrecoverableKeyException {
        keystoreManager = new KeystoreManager(this);
        keyPair = keystoreManager.getKeyPair("something");
        cipherManager = new CipherManager();
    }

    //@OnClick({R.id.btnConvertToCipher, R.id.btnConvertToPlain})
    public void onViewClicked(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        switch (view.getId()) {
            case R.id.btnConvertToCipher:

                String encryptedData = cipherManager.encrypt(etPlainText.getText().toString(), keyPair.getPublic());
                tvCipherText.setText(encryptedData);

                break;
            case R.id.btnConvertToPlain:

                String plainText = cipherManager.decrypt(tvCipherText.getText().toString(), keyPair.getPrivate());
                tvPlainText.setText(plainText);

                break;
        }
    }
}
