package com.example.user.encryption;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;

import javax.security.auth.x500.X500Principal;

public class KeyStoreWrapper {

    private Context context;
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String CURRENT_ALGORITHM = "RSA";
    private KeyStore keyStore;


    public KeyStoreWrapper(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.context = context;
        init();
    }

    private void init() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
    }

    private void createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(CURRENT_ALGORITHM, KEYSTORE_PROVIDER);

//        create a date for the certificate
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

//        create the certificate using generator spec with above date
        KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setStartDate(startDate.getTime())
                .setSubject(new X500Principal("CN={alias} CA certificate"))
                .setEndDate(endDate.getTime())
                .build();

        keyPairGenerator.initialize(spec);
        keyPairGenerator.generateKeyPair();

    }

    public KeyPair getKeyPair(String alias) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableKeyException, KeyStoreException {
        createKeyPair(alias);

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if (privateKey != null && publicKey != null) {
            return new KeyPair(publicKey, privateKey);
        } else return null;

    }

    public void removeKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);

    }



}
