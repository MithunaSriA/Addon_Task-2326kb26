package corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdbs";
        String user = "root";
        String pass = "mithuna7";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected Successfully!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
