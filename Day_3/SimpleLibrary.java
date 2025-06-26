package corejava;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;      // book name
    boolean issued;    // true = borrowed, false = on shelf

    Book(String title) {
        this.title  = title;
        this.issued = false;     // starts as available
    }
}

class Library {
    // Dynamic list so we don’t worry about size limits
    ArrayList<Book> shelf = new ArrayList<>();

    /* add a new book (if the title is not already present) */
    void addBook(String title) {
        if (findBook(title) != null) {
            System.out.println(" Book already exists.");
            return;
        }
        shelf.add(new Book(title));
        System.out.println("Book added.");
    }

    /* remove a book (only if it exists AND is not issued) */
    void removeBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        if (b.issued) {
            System.out.println(" Can’t remove – book is issued.");
            return;
        }
        shelf.remove(b);
        System.out.println("Book removed.");
    }

    /* issue a book (only if it exists AND is available) */
    void issueBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println(" Book not found.");
            return;
        }
        if (b.issued) {
            System.out.println("Already issued.");
            return;
        }
        b.issued = true;
        System.out.println(" Book issued.");
    }

    /* helper – locate a book object by title (case‑insensitive) */
    private Book findBook(String title) {
        for (Book b : shelf) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }
}

/* ---------------- Main program ---------------- */
public class SimpleLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        System.out.println("Simple Library – commands: add | remove | issue | exit");

        while (true) {
            System.out.print("\n> ");          // prompt
            String command = sc.next();        // first word
            sc.nextLine();                     // clear the rest of the line

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Good‑bye!");
                break;
            }

            switch (command.toLowerCase()) {
                case "add" -> {
                    System.out.print("Title to add   : ");
                    String title = sc.nextLine();
                    lib.addBook(title);
                }
                case "remove" -> {
                    System.out.print("Title to remove: ");
                    String title = sc.nextLine();
                    lib.removeBook(title);
                }
                case "issue" -> {
                    System.out.print("Title to issue : ");
                    String title = sc.nextLine();
                    lib.issueBook(title);
                }
                default -> System.out.println("Unknown command.");
            }
        }
    }
}
