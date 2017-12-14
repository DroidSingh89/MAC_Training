package com.example.user.encryption;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by singh on 12/14/17.
 */

public class CipherWrapper {


    String transformation;
    private Cipher cipher;

    public CipherWrapper(String transformation) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.transformation = transformation;
        initwrapper();
    }

    private void initwrapper() throws NoSuchPaddingException, NoSuchAlgorithmException {
        cipher = Cipher.getInstance(transformation);

    }

    public String encrypt(String data, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(data.getBytes());
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }


    public String decrypt(String encryptedData, Key key) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedBytes = Base64.decode(encryptedData, Base64.DEFAULT);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);

    }


}
