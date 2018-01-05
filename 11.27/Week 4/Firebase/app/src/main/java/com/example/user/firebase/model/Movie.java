package com.example.user.firebase.model;

/**
 * Created by singh on 12/21/17.
 */

public class Movie {


    String name;
    String year;
    String genre;
    String director;

    public Movie() {

    }

    public Movie(String name, String year, String genre, String director) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
