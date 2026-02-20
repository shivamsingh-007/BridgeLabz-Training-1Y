package library.transactions;

import library.books.Book;
import library.members.Member;

public class Transaction {

    private int transactionId;
    private Book book;
    private Member member;
    private String status;

    public Transaction(int transactionId, Book book, Member member) {
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.status = "Pending";
    }

    public void issueBook() {
        if (book.isAvailable()) {
            book.setAvailable(false);
            status = "Issued";
            System.out.println("--- Transaction Details ---");
            System.out.println("Transaction ID : " + transactionId);
            System.out.println("Book Issued    : " + book.getTitle());
            System.out.println("Issued To      : " + member.getName());
            System.out.println("Status         : " + status);
        } else {
            System.out.println("Book is not available for issue.");
        }
    }

    public void returnBook() {
        book.setAvailable(true);
        status = "Returned";
        System.out.println("Book '" + book.getTitle() + "' returned by " + member.getName());
    }
}
