package corejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecords {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database (file will be created if not exist)
            Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
            Statement stmt = conn.createStatement();

            // Step 2: Insert 5 Students
            stmt.execute("INSERT INTO Student (name, email) VALUES ('Alice', 'alice@gmail.com');");
            stmt.execute("INSERT INTO Student (name, email) VALUES ('Bob', 'bob@gmail.com');");
            stmt.execute("INSERT INTO Student (name, email) VALUES ('Charlie', 'charlie@gmail.com');");
            stmt.execute("INSERT INTO Student (name, email) VALUES ('David', 'david@gmail.com');");
            stmt.execute("INSERT INTO Student (name, email) VALUES ('Eva', 'eva@gmail.com');");

            // Step 3: Insert 5 Courses (each linked to a student by ID 1-5)
            stmt.execute("INSERT INTO Course (name, student_id) VALUES ('Math', 1);");
            stmt.execute("INSERT INTO Course (name, student_id) VALUES ('Science', 2);");
            stmt.execute("INSERT INTO Course (name, student_id) VALUES ('History', 3);");
            stmt.execute("INSERT INTO Course (name, student_id) VALUES ('English', 4);");
            stmt.execute("INSERT INTO Course (name, student_id) VALUES ('Computer', 5);");

            // Step 4: Done!
            System.out.println("5 Students and 5 Courses inserted successfully!");

            // Step 5: Close connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


