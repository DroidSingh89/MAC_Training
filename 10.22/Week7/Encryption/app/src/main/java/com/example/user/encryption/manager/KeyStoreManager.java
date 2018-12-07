package com.example.user.encryption.manager;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Log;

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

public class KeyStoreManager {

    private static final String TAG = KeyStoreManager.class.getSimpleName()+ "_TAG";
    private static final String PROVIDER = "AndroidKeyStore";
    private static final String ALGORITHM = "RSA";
    private Context context;
    private KeyStore keyStore;

    public KeyStoreManager(Context context) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        this.context = context;
        keyStore = KeyStore.getInstance(PROVIDER);
        Log.d(TAG, "KeyStoreManager: ");
//        can pass a password to the keystore while loading the instance
        keyStore.load(null);

    }

    public KeyPair generateKey(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {

//        generator required to create a keypair with the specification
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, PROVIDER);

//        need start and end date for the certificate
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        KeyPairGeneratorSpec keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)//alias used for saving the certificate
                .setSerialNumber(BigInteger.ONE)
                .setStartDate(startDate.getTime())
                .setEndDate(endDate.getTime())
//                certificate subject used to create a certificate using the alias name provided
                .setSubject(new X500Principal("CN = {alias} CA Certificate"))
                .build();

        keyPairGenerator.initialize(keyPairGeneratorSpec);
        return keyPairGenerator.generateKeyPair();

    }


    public KeyPair getKeyPair(String alias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if (privateKey != null && publicKey != null)
            return new KeyPair(publicKey, privateKey);
        else return null;

    }

    public void removeKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);

    }
}
