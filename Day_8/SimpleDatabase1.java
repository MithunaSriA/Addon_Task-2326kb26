package corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SimpleDatabase1 {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to database (it will create the file if it doesn't exist)
            Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");

            // Step 2: Create a Statement to run SQL
            Statement stmt = conn.createStatement();

            // Step 3: Create Student table
            String createStudentTable = "CREATE TABLE IF NOT EXISTS Student (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "name TEXT NOT NULL," +
                                        "email TEXT NOT NULL UNIQUE);";
            stmt.execute(createStudentTable);

            // Step 4: Create Course table
            String createCourseTable = "CREATE TABLE IF NOT EXISTS Course (" +
                                       "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                       "name TEXT NOT NULL," +
                                       "student_id INTEGER," +
                                       "FOREIGN KEY(student_id) REFERENCES Student(id));";
            stmt.execute(createCourseTable);

            // Step 5: Done!
            System.out.println("Tables created successfully!");

            // Step 6: Close the connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}