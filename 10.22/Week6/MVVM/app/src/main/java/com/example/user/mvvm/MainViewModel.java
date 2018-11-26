package com.example.user.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.example.user.mvvm.model.LocalDataSource;
import com.example.user.mvvm.model.Person;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName() + "_TAG";


    MutableLiveData<Person> personData = new MutableLiveData<>();

    LocalDataSource localDataSource;

    public MainViewModel(@NonNull Application application) {
        super(application);
       localDataSource = new LocalDataSource(application.getApplicationContext());

    }


    public LiveData<Person> getPersonData() {
        return personData;
    }

//    emulate the network call for 2 seconds and update the live data object
//    Also check if the data is observed when the activity is not on foreground
    public void updatePerson(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            personData.setValue(new Person("New Name", "New Age"));

                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void savePerson(View view, Person person) {

        localDataSource.savePerson(person);
    }

    public void getPeople(View view) {
        localDataSource.getPeople(new LocalDataSource.Callback() {
            @Override
            public void onPeopleData(List<Person> personList) {
                Log.d(TAG, "onPeopleData: "+ personList.size());
            }
        });
    }

    public void onButtonClicked(View view, Person person) {
        Log.d(TAG, "onButtonClicked: " + person.toString());
    }
}
