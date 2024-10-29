import java.util.Scanner;

public class Librarian {
    private Library library;

    public Librarian(Library library)
    {
        this.library = library;
    }

    public void displayMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Check Book Availability");
            System.out.println("4. View All Books");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Exit");
            System.out.println("Choose an option");
            choice = scanner.nextInt();
            performAction(choice,scanner);

        }while(choice!=6);

        System.out.println("exiting Library management system");
        scanner.close();
    }

    private void performAction(int choice, Scanner scanner)
    {
        switch (choice)
        {
            case 1:
                System.out.println("Enter book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter book author");
                String author = scanner.nextLine();
                System.out.println("Enter book ISBN: ");
                String isbn = scanner.nextLine();

                Book newBook = new Book(title,author,isbn);
                library.addBook(newBook);
                break;

            case 2:
                System.out.println("Enter ISBN of book to remove");
                String isbnToRemove = scanner.nextLine();
                library.removeBook(isbnToRemove);
                break;

            case 3:
                System.out.println("Enter ISBM of the book to check availability");
                String isbnToCheck = scanner.nextLine();
                boolean available = library.isBookAvailable(isbnToCheck);
                System.out.println("book availability" + (available? "Available": "Not available" ));
                break;

            case 4:
                library.getAllBooks();
                break;

            case 5:
                library.getBorrowedBooks();
                break;

            case 6:
                System.out.println("Exiting");
            default:
                System.out.println("invalid choice");
                break;

        }
    }
}