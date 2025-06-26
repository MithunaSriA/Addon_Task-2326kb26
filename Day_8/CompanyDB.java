package corejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CompanyDB {
    public static void main(String[] args) {
        try {
            // Step 1: Connect to the SQLite database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:company.db");
            Statement stmt = conn.createStatement();

            // Step 2: Create Department table
            String createDepartment = "CREATE TABLE IF NOT EXISTS Department (" +
                                      "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                      "name TEXT NOT NULL);";
            stmt.execute(createDepartment);

            // Step 3: Create Employee table
            String createEmployee = "CREATE TABLE IF NOT EXISTS Employee (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    "name TEXT NOT NULL," +
                                    "salary REAL," +
                                    "department_id INTEGER," +
                                    "FOREIGN KEY(department_id) REFERENCES Department(id));";
            stmt.execute(createEmployee);

            // Step 4: Insert 3 departments
            stmt.execute("INSERT INTO Department (name) VALUES ('HR');");
            stmt.execute("INSERT INTO Department (name) VALUES ('IT');");
            stmt.execute("INSERT INTO Department (name) VALUES ('Finance');");

            // Step 5: Insert 5 employees
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('Alice', 40000, 1);");
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('Bob', 50000, 2);");
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('Charlie', 45000, 1);");
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('David', 60000, 2);");
            stmt.execute("INSERT INTO Employee (name, salary, department_id) VALUES ('Eva', 55000, 3);");

            System.out.println("Tables created and records inserted successfully!");

            // Step 6: Close connection
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
