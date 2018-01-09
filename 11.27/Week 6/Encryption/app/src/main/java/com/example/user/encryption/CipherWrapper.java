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
 * Created by singh on 1/9/18.
 */

public class CipherWrapper {

    String transformation;
    Cipher cipher;

    public CipherWrapper(String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.transformation = transformation;
        cipher = Cipher.getInstance(transformation);
    }

    public String encrypt(String plainText, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
    }

    public String decrypt(String encryptedData, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedBytes = Base64.decode(encryptedData, Base64.DEFAULT);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}
