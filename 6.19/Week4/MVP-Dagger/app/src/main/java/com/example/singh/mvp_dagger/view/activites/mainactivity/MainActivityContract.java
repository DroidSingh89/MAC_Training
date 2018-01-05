package com.example.singh.mvp_dagger.view.activites.mainactivity;

import com.example.singh.mvp_dagger.BasePresenter;
import com.example.singh.mvp_dagger.BaseView;
import com.example.singh.mvp_dagger.model.Person;

import java.util.List;

/**
 * Created by singh on 7/12/17.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void setFullName(String fullName);

        void sendPersonList(List<Person> personList);


    }

    interface Presenter extends BasePresenter<View>{

        void getFullName(String firstName, String lastName);
        void addPerson(Person person);
        void sendToSecondActivity();

    }


}
