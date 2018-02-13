package com.example.user.firebase.model;

/**
 * Created by singh on 2/13/18.
 */

public class Movie {

    String name;
    String director;
    String year;
    String genre;
    String rating;

    public Movie(String name, String director, String year, String genre, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie() {
    }


    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", rating='" + rating + '\'' +
                '}';
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

