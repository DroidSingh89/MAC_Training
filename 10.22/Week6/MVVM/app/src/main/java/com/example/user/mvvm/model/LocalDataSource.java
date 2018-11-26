package com.example.user.mvvm.model;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource {

    PersonDao personDao;
    PersonDatabase personDatabase;

    public LocalDataSource(Context context) {

        personDatabase = Room.databaseBuilder(context, PersonDatabase.class, "Person-Database").build();
        personDao = personDatabase.personDao();

    }


    public void savePerson(final Person person) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                personDao.savePerson(person);
            }
        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();

    }


    public void getPeople(final Callback callback) {


        personDao.getPeople()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Person>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Person> people) {
                        callback.onPeopleData(people);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    public interface Callback {
        void onPeopleData(List<Person> personList);
    }
}
