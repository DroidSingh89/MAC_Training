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
 * Created by singh on 2/19/18.
 */

public class KeystoreWrapper {


    private static final java.lang.String KEYSTORE_PROVIDER = "AndroidKeyStore";
    Context context;
    KeyStore keyStore;
    KeyPairGenerator keyPairGenerator;
    public static final String  My_ALGORITHM = "RSA";


    public KeystoreWrapper(Context context) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        this.context = context;
        keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);

    }

    public KeyPair createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        keyPairGenerator = KeyPairGenerator.getInstance(My_ALGORITHM, KEYSTORE_PROVIDER);

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setStartDate(startDate.getTime())
                .setSubject(new X500Principal("CN={alias} CA Certificate"))
                .setEndDate(endDate.getTime())
                .build();

        keyPairGenerator.initialize(spec);

        return keyPairGenerator.generateKeyPair();
    }

    public KeyPair getKeyPair(String alias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if(privateKey!=null && publicKey!=null)
            return new KeyPair(publicKey, privateKey);
        else return null;
    }

    public void removeKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);

    }






}
