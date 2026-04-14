package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Book> library = new HashMap<>();
        
        library.put("978-0-13-468599-1", new Book("978-0-13-468599-1", "The Pragmatic Programmer", "David Thomas", 2019));
        library.put("978-0-59-651798-1", new Book("978-0-59-651798-1", "JavaScript: The Good Parts", "Douglas Crockford", 2008));
        library.put("978-0-13-235088-4", new Book("978-0-13-235088-4", "Clean Code", "Robert Martin", 2008));
        library.put("978-0-59-600920-5", new Book("978-0-59-600920-5", "Head First Design Patterns", "Eric Freeman", 2004));
        
        System.out.println("Library Books:");
        for (Map.Entry<String, Book> entry : library.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + " -> " + entry.getValue());
        }
        
        String searchISBN = "978-0-13-235088-4";
        if (library.containsKey(searchISBN)) {
            System.out.println("\nFound Book: " + library.get(searchISBN));
        }
        
        System.out.println("\nBooks published after 2010:");
        library.forEach((isbn, book) -> {
            if (book.getYear() > 2010) {
                System.out.println(book);
            }
        });
        
        library.put("978-0-13-449416-6", new Book("978-0-13-449416-6", "The Elements of Computing Systems", "Noam Nisan", 2005));
        System.out.println("\nTotal Books: " + library.size());
        
        library.remove("978-0-59-600920-5");
        System.out.println("After removing Head First Design Patterns: " + library.size() + " books");
    }
}

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    
    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}
