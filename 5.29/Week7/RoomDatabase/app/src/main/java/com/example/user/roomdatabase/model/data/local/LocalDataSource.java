package com.example.user.roomdatabase.model.data.local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.user.roomdatabase.model.Person;
import com.example.user.roomdatabase.model.data.local.room.PersonDao;
import com.example.user.roomdatabase.model.data.local.room.PersonDatabase;

import java.util.List;

import static android.arch.persistence.room.Room.databaseBuilder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource {


    private static final String TAG =
            LocalDataSource.class.getSimpleName() + "_TAG";

    Context context;
    PersonDatabase personDatabase;
    PersonDao personDao;


    public LocalDataSource(Context context) {
        this.context = context;

        personDatabase =
                databaseBuilder(context,
                        PersonDatabase.class,
                        "person_database").build();

        personDao = personDatabase.personDao();

    }


    public void savePerson(final Person person) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                personDao.savePerson(person);
                Log.d(TAG, "run: Saving person:" + person.toString());

            }
        }).start();


    }

    public void getAllPersons() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Person> personList = personDao.getAllPersons();
                Log.d(TAG, "run: persons" + personList.toString());
            }
        }).start();

    }

    @SuppressLint("CheckResult")
    public void getPersonsRx(final DatabaseInteractor databaseInteractor) {


        personDao.getAllPersonsRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<List<Person>, List<Person>>() {
                    @Override
                    public List<Person> apply(List<Person> personList){
                        for (Person person : personList) {
                            person.setAge(person.getAge() + "0");

                        }
                        return personList;

                    }
                })
                .subscribe(new Consumer<List<Person>>() {
                    @Override
                    public void accept(List<Person> people) {

                        //Toast.makeText(context, people.toString(), Toast.LENGTH_SHORT).show();
                        databaseInteractor.onPersonList(people);

                    }
                });


    }


    public interface DatabaseInteractor{

        void onPersonList(List<Person> personList);
    }


}
