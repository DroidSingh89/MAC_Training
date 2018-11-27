package com.example.user.amazonbooksexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Book {

	@SerializedName("imageURL")
	private String imageURL;

	@SerializedName("title")
	private String title;

	public void setImageURL(String imageURL){
		this.imageURL = imageURL;
	}

	public String getImageURL(){
		return imageURL;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"Book{" +
			"imageURL = '" + imageURL + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(imageURL, book.imageURL) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imageURL, title);
    }
}