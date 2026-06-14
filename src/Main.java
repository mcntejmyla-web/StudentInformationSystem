import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String studentId;
    String name;
    int age;
    double grade;
    String contact;

    Student(String studentId, String name, int age, double grade, String contact) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.contact = contact;
    }

    void displayInfo() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Grade      : " + grade);
        System.out.println("Contact    : " + contact);
        System.out.println("-----------------------------");
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        while (age <= 0) {
            System.out.print("Age must be positive. Enter again: ");
            age = sc.nextInt();
        }

        System.out.print("Enter Grade (0-100): ");
        double grade = sc.nextDouble();

        while (grade < 0 || grade > 100) {
            System.out.print("Grade must be between 0 and 100. Enter again: ");
            grade = sc.nextDouble();
        }

        sc.nextLine();

        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();

        Student s = new Student(id, name, age, grade, contact);
        students.add(s);

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            s.displayInfo();
        }
    }

    static void searchStudent() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.studentId.equals(id)) {
                s.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }
}
