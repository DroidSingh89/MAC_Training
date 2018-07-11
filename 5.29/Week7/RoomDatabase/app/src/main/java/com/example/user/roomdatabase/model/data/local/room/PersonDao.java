package com.example.user.roomdatabase.model.data.local.room;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.roomdatabase.model.Person;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface PersonDao {

    @Insert
    void savePerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();

    @Query("SELECT * FROM Person")
    Flowable<List<Person>> getAllPersonsRx();

}
