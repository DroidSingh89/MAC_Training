package com.example.user.encryption;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
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

/**
 * Created by singh on 1/9/18.
 */

public class KeystoreWrapper {

    private static final String PROVIDER_KEYSTORE = "AndroidKeyStore";
    Context context;
    KeyStore keyStore;

    public KeystoreWrapper(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.context = context;
        init();
    }

    public void init() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        keyStore = KeyStore.getInstance(PROVIDER_KEYSTORE);
        keyStore.load(null);

    }

    public KeyPair createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyPairGenerator keyPairGenerator =
                KeyPairGenerator.getInstance("RSA", PROVIDER_KEYSTORE);

        Calendar startDate = Calendar.getInstance();
        Calendar endData = Calendar.getInstance();

        endData.add(Calendar.YEAR, 1);

        KeyPairGeneratorSpec keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setSubject(new X500Principal("CN = ${alias} CA Certificate"))
                .setStartDate(startDate.getTime())
                .setEndDate(endData.getTime())
                .build();

        keyPairGenerator.initialize(keyPairGeneratorSpec);

        return keyPairGenerator.generateKeyPair();

    }

    public KeyPair getAsymKey(String alias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
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
