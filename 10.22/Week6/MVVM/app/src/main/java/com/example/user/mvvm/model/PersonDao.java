package com.example.user.mvvm.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


import io.reactivex.Flowable;

@Dao
public interface PersonDao {

    @Insert
    void savePerson(Person person);

    @Query("Select * from Person")
    Flowable<List<Person>> getPeople();
}
