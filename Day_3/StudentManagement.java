package corejava;

import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[5];  // For 5 subjects

    // Method to input student details
    void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        name = sc.nextLine();
    }

    // Method to assign marks
    void assignMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to calculate average
    double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / 5.0;
    }

    // Method to calculate grade
    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    }

    // Method to display student result
    void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.print("Marks   : ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nAverage : " + getAverage());
        System.out.println("Grade   : " + getGrade());
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Student s = new Student();
        s.inputDetails();   // Step 1: Create student
        s.assignMarks();    // Step 2: Assign marks
        s.displayResult();  // Step 3: Display result
    }
}