package corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddFeeColumn {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
            Statement stmt = conn.createStatement();

            // Add fee column if it doesn't exist
            stmt.execute("ALTER TABLE Course ADD COLUMN fee REAL;");

            System.out.println("Fee column added to Course table.");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            if (e.getMessage().contains("duplicate column")) {
                System.out.println("Fee column already exists.");
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}