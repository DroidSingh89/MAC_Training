package com.example.user.firebase_uu;

/**
 * Created by singh on 11/30/17.
 */

public class Movie {

    String name;
    String director;
    String year;

    public Movie() {
    }

    public Movie(String name, String director, String year) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
