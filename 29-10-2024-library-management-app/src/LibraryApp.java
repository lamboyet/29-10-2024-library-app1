public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        librarian.displayMenu();
    }
}
