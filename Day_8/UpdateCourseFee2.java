package corejava;

import java.sql.*;
import java.util.Scanner;

public class UpdateCourseFee2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");

            System.out.print("Enter Course ID to update: ");
            int courseId = scanner.nextInt();

            System.out.print("Enter new Course Fee: ");
            double newFee = scanner.nextDouble();

            String sql = "UPDATE Course SET fee = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, newFee);
            pstmt.setInt(2, courseId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Course fee updated successfully.");
            } else {
                System.out.println("Course ID not found.");
            }

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
