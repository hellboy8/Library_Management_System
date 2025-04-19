import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        User user = new User("John Doe");

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = sc.nextLine();
                    Book borrowBook = library.findBook(borrowTitle);
                    if (borrowBook != null && borrowBook.isAvailable()) {
                        user.borrowBook(borrowBook);
                        borrowBook.setAvailable(false);
                        System.out.println("You have borrowed: " + borrowBook.getTitle());
                    } else if (borrowBook != null) {
                        System.out.println("Sorry, the book is already borrowed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = sc.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if (returnBook != null && !returnBook.isAvailable()) {
                        user.returnBook(returnBook);
                        returnBook.setAvailable(true);
                        System.out.println("You have returned: " + returnBook.getTitle());
                    } else if (returnBook != null) {
                        System.out.println("You haven't borrowed this book.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Your Borrowed Books:");
                    for (Book borrowedBook : user.getBorrowedBooks()) {
                        System.out.println(borrowedBook.getTitle());
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
