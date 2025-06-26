package corejava;
import java.util.Scanner;
import java.io.*;

// Person class
class Person {
    String name;
    int age;

    void getPersonDetails(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        sc.nextLine(); // consume leftover newline
    }

    void showPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age : " + age);
    }
}

// Employee class extends Person
class Employee extends Person {
    double basicSalary;

    void getEmployeeDetails(Scanner sc) {
        getPersonDetails(sc); // ask for name and age first
        System.out.print("Enter basic salary: ");
        basicSalary = sc.nextDouble();
    }

    double calculateSalary() {
        double hra = basicSalary * 0.15; // 15% HRA
        double da = basicSalary * 0.05;  // 5% DA
        return basicSalary + hra + da;
    }

    void showEmployeeDetails() {
        showPersonDetails();
        System.out.println("Basic Salary : ₹" + basicSalary);
        System.out.println("Total Salary : ₹" + calculateSalary());
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee emp = new Employee(); // create object
        emp.getEmployeeDetails(sc);    // get user input

        System.out.println("\n--- Employee Details ---");
        emp.showEmployeeDetails();
        
        sc.close(); // close Scanner
    }
}