package com.example.user.encryption.view.main;

import android.util.JsonReader;
import android.util.Log;

import com.example.user.encryption.manager.CipherManager;
import com.example.user.encryption.manager.KeystoreManager;
import com.example.user.encryption.model.Person;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter{

    KeystoreManager keystoreManager;
    CipherManager cipherManager;
    KeyPair keyPair;
    MainContract.View view;

    private static final String TAG = MainPresenter.class.getSimpleName();
    @Inject
    public MainPresenter(KeystoreManager keystoreManager, CipherManager cipherManager) {
        this.keystoreManager = keystoreManager;
        this.cipherManager = cipherManager;
        try {
            this.keyPair = keystoreManager.getKeyPair("something");
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void encryptData(Person person) {

        try {

            String encryptedData = cipherManager.encrpyt(person.toString(), keyPair.getPublic());
            this.view.onEncrytion(encryptedData);

        } catch ( BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void decryptData(String encryptedData) {


        String decryptedData = null;
        try {
            decryptedData = cipherManager.decrypt(encryptedData, keyPair.getPrivate());
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "decryptData: "+ decryptedData);
        this.view.onDecryption(parsePerson(decryptedData));


    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

    }

    @Override
    public void detachView() {

        this.view = null;
    }

    public Person parsePerson(String rawJson) {


        Log.d(TAG, "parsePerson: "+ rawJson);
        try {
            JSONObject jsonObject = new JSONObject(rawJson);
            JSONObject personJson = jsonObject.getJSONObject("Person");
            String name = personJson.getString("name");
            Person person = new Person(name);
            Log.d(TAG, "parsePerson: "+ person.toString());
            return person;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}
