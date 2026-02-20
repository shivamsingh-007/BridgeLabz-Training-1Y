import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryMain {

    public static void main(String[] args) {

        System.out.println("========== Library Management System ==========");
        System.out.println();

        System.out.println("1. Adding a New Book:");
        Book b1 = new Book(1001, "Java Programming", "James Gosling");
        b1.displayBook();
        System.out.println();

        System.out.println("2. Registering a New Member:");
        Member m1 = new Member(501, "Priya Singh", "priya@email.com");
        m1.displayMember();
        System.out.println();

        System.out.println("3. Issuing Book to Member:");
        Transaction t1 = new Transaction(701, b1, m1);
        t1.issueBook();
        System.out.println();

        System.out.println("4. Returning the Book:");
        t1.returnBook();
    }
}
