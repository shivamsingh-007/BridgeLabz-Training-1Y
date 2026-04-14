package com.gla.collectionframework;

import java.util.*;

public class LibraryManagement {
    private List<Book> allBooks;
    private Set<String> availableBookIds;
    private Queue<Book> borrowQueue;
    private Stack<Book> returnStack;

    public LibraryManagement() {
        this.allBooks = new ArrayList<>();
        this.availableBookIds = new HashSet<>();
        this.borrowQueue = new LinkedList<>();
        this.returnStack = new Stack<>();
    }

    public void addBook(Book book) {
        allBooks.add(book);
        availableBookIds.add(book.getBookId());
    }

    public void borrowBook(Book book) {
        if (availableBookIds.contains(book.getBookId())) {
            availableBookIds.remove(book.getBookId());
            borrowQueue.offer(book);
        }
    }

    public void returnBook() {
        Book book = borrowQueue.poll();
        if (book != null) {
            book.returnBook();
            availableBookIds.add(book.getBookId());
            returnStack.push(book);
        }
    }

    public void undoReturn() {
        if (!returnStack.isEmpty()) {
            Book book = returnStack.pop();
            availableBookIds.remove(book.getBookId());
            System.out.println("Undo return: " + book.getTitle());
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book b : allBooks) {
            if (b.getAuthor().equals(author)) {
                authorBooks.add(b);
            }
        }
        return authorBooks;
    }

    public Set<String> getAvailableBookIds() {
        return availableBookIds;
    }

    public int getBorrowedCount() {
        return borrowQueue.size();
    }

    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        library.addBook(new Book("BK001", "Java Basics", "John Smith"));
        library.addBook(new Book("BK002", "Python Guide", "Jane Doe"));
        library.addBook(new Book("BK003", "Data Structures", "John Smith"));
        library.borrowBook(library.allBooks.get(0));
        library.borrowBook(library.allBooks.get(1));
        System.out.println("Available: " + library.getAvailableBookIds());
        System.out.println("Borrowed: " + library.getBorrowedCount());
        library.returnBook();
        System.out.println("After return - Available: " + library.getAvailableBookIds());
        System.out.println("John Smith books: " + library.getBooksByAuthor("John Smith"));
    }
}

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void returnBook() {
        System.out.println("Book returned: " + title);
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
