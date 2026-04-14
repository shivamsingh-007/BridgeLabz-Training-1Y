package com.gla.generics;

public class BookCategory implements ProductCategory {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public String getCategoryName() {
        return "Book - " + genre;
    }
}
