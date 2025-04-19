import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Book> borrowedBooks;

    public User(String username) {
        this.username = username;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
