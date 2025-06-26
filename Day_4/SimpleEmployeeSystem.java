package corejava;
import java.io.*;
import java.util.*;

public class SimpleEmployeeSystem {

    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Record System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> updateEmployee(sc);
                case 4 -> deleteEmployee(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // 1. Add new employee
    public static void addEmployee(Scanner sc) throws IOException {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        String salary = sc.nextLine();

        FileWriter fw = new FileWriter(FILE_NAME, true); 
        fw.write(id + "," + name + "," + salary + "\n");
        fw.close();

        System.out.println("Employee added successfully!");
    }

    // 2. View all employees
    public static void viewEmployees() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No employee records found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        System.out.println("\nID\tName\tSalary");
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println(parts[0] + "\t" + parts[1] + "\t" + parts[2]);
        }
        br.close();
    }

    // 3. Update an employee
    public static void updateEmployee(Scanner sc) throws IOException {
        System.out.print("Enter Employee ID to update: ");
        String idToUpdate = sc.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(idToUpdate)) {
                found = true;
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();
                System.out.print("Enter New Salary: ");
                String newSalary = sc.nextLine();
                writer.write(idToUpdate + "," + newName + "," + newSalary + "\n");
            } else {
                writer.write(line + "\n");
            }
        }

        writer.close();
        reader.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    // 4. Delete an employee
    public static void deleteEmployee(Scanner sc) throws IOException {
        System.out.print("Enter Employee ID to delete: ");
        String idToDelete = sc.nextLine();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean deleted = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(idToDelete)) {
                deleted = true; // skip writing this line
                continue;
            }
            writer.write(line + "\n");
        }

        writer.close();
        reader.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (deleted) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee ID not found.");
        }
    }
}
