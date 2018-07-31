package com.example.user.encryption.view.main;

import com.example.user.encryption.model.Person;
import com.example.user.encryption.view.base.BasePresenter;
import com.example.user.encryption.view.base.BaseView;

import java.security.NoSuchAlgorithmException;

public interface MainContract {

    interface View extends BaseView {

        void onEncrytion(String encryptedData);

        void onDecryption(Person person);

    }


    interface Presenter extends BasePresenter<View> {

        void encryptData(Person person) throws NoSuchAlgorithmException;

        void decryptData(String encryptedData);
    }
}

