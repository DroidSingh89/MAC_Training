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
 * Created by singh on 12/14/17.
 */

public class KeyStoreWrapper {


    private KeyStore keyStore;
    private Context context;

    public KeyStoreWrapper(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.context = context;
        initWrapper();
    }

    private void initWrapper() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {

        keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);

    }

    public KeyPair createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {

//create the keypair instance with algorithm and provider to generate the key
        KeyPairGenerator keyPairGenerator
                = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");

//setup start and end date for the certificate to be added to the keypair
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        endDate.add(Calendar.YEAR, 10);
//use the specification to init the keypair generator
        KeyPairGeneratorSpec keyPairGeneratorSpec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setSubject(new X500Principal("CN =${alias} CA Certificate"))
                .setStartDate(startDate.getTime())
                .setEndDate(endDate.getTime())
                .build();

        keyPairGenerator.initialize(keyPairGeneratorSpec);

        return keyPairGenerator.generateKeyPair();

    }


    public KeyPair getAsymKey(String alias) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if (privateKey != null && publicKey != null)
            return new KeyPair(publicKey, privateKey);
        else
            return null;
    }

    public void removeKey(String alias) throws KeyStoreException {

        keyStore.deleteEntry(alias);

    }

}
