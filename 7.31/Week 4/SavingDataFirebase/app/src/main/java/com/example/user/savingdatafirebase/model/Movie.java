package com.example.user.savingdatafirebase.model;

/**
 * Created by singh on 8/23/17.
 */

public class Movie {



    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}' + "\n";
    }

    String name;
    String director;
    int year;

    public Movie() {
    }

    public Movie(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
