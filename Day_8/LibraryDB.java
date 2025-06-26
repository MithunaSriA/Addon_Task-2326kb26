package corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LibraryDB {
    public static void main(String[] args) {
        try {
            // Connect to SQLite database (creates file if not exists)
            Connection conn = DriverManager.getConnection("jdbc:sqlite:library.db");
            Statement stmt = conn.createStatement();

            // Create Books table
            stmt.execute("CREATE TABLE IF NOT EXISTS Books (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "title TEXT NOT NULL," +
                         "author TEXT NOT NULL);");

            // Create Members table
            stmt.execute("CREATE TABLE IF NOT EXISTS Members (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT NOT NULL," +
                         "email TEXT UNIQUE NOT NULL);");

            // Create Borrow table
            stmt.execute("CREATE TABLE IF NOT EXISTS Borrow (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "member_id INTEGER," +
                         "book_id INTEGER," +
                         "borrow_date TEXT," +
                         "FOREIGN KEY(member_id) REFERENCES Members(id)," +
                         "FOREIGN KEY(book_id) REFERENCES Books(id));");

            // Insert 3 books
            stmt.execute("INSERT INTO Books (title, author) VALUES ('Java Basics', 'James Gosling');");
            stmt.execute("INSERT INTO Books (title, author) VALUES ('Python 101', 'Guido van Rossum');");
            stmt.execute("INSERT INTO Books (title, author) VALUES ('C++ Guide', 'Bjarne Stroustrup');");

            // Insert 3 members
            stmt.execute("INSERT INTO Members (name, email) VALUES ('Alice', 'alice@gmail.com');");
            stmt.execute("INSERT INTO Members (name, email) VALUES ('Bob', 'bob@gmail.com');");
            stmt.execute("INSERT INTO Members (name, email) VALUES ('Charlie', 'charlie@gmail.com');");

            // Insert 3 borrow records
            stmt.execute("INSERT INTO Borrow (member_id, book_id, borrow_date) VALUES (1, 2, '2025-06-21');");
            stmt.execute("INSERT INTO Borrow (member_id, book_id, borrow_date) VALUES (2, 1, '2025-06-20');");
            stmt.execute("INSERT INTO Borrow (member_id, book_id, borrow_date) VALUES (3, 3, '2025-06-19');");

            System.out.println("Library database created and populated successfully!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}