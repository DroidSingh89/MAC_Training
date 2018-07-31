package com.example.user.encryption.manager;

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

import javax.inject.Inject;
import javax.security.auth.x500.X500Principal;

public class KeystoreManager {


    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    public static final String ALGORITHM = "RSA";

    Context context;
    KeyStore keyStore;
    KeyPairGenerator keyPairGenerator;



    public KeystoreManager(Context context) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        this.context = context;
        this.keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        this.keyStore.load(null);

    }

    //    create a keypair
    public KeyPair createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        keyPairGenerator= KeyPairGenerator.getInstance(ALGORITHM, KEYSTORE_PROVIDER);

//        create dates for certificate
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

//        create keypair specification for certificate
        KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setSubject(new X500Principal("CN={alias} CA Certificate"))
                .setStartDate(startDate.getTime())
                .setEndDate(endDate.getTime())
                .build();


        keyPairGenerator.initialize(spec);

       return keyPairGenerator.generateKeyPair();

    }

    public KeyPair getKeyPair(String alias) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableKeyException, KeyStoreException {


        createKeyPair(alias);

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();

        if (publicKey != null & privateKey != null) {
            return new KeyPair(publicKey, privateKey);
        } else return null;


    }

    public void removeKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);

    }

}
