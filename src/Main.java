import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("--------------------------------");
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
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid Input! Enter a number.");
                sc.next();
            }

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
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You For Using Student Information System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addStudent() {

        System.out.println("\n=== ADD STUDENT ===");

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.studentId.equals(id)) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

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

        Student student = new Student(id, name, age, grade, contact);

        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        System.out.println("\n=== STUDENT LIST ===");

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.printf("%-10s %-15s %-5s %-10s %-15s%n",
                "ID", "NAME", "AGE", "GRADE", "CONTACT");

        System.out.println("----------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-15s %-5d %-10.2f %-15s%n",
                    s.studentId,
                    s.name,
                    s.age,
                    s.grade,
                    s.contact);
        }
    }

    static void searchStudent() {

        System.out.println("\n=== SEARCH STUDENT ===");

        System.out.print("Enter Student ID or Name: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Student s : students) {

            if (s.studentId.equalsIgnoreCase(search)
                    || s.name.equalsIgnoreCase(search)) {

                s.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    static void updateStudent() {

        System.out.println("\n=== UPDATE STUDENT ===");

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        for (Student s : students) {

            if (s.studentId.equalsIgnoreCase(id)) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();

                while (s.age <= 0) {
                    System.out.print("Age must be positive. Enter again: ");
                    s.age = sc.nextInt();
                }

                System.out.print("Enter New Grade: ");
                s.grade = sc.nextDouble();

                while (s.grade < 0 || s.grade > 100) {
                    System.out.print("Grade must be between 0 and 100. Enter again: ");
                    s.grade = sc.nextDouble();
                }

                sc.nextLine();

                System.out.print("Enter New Contact: ");
                s.contact = sc.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {

        System.out.println("\n=== DELETE STUDENT ===");

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).studentId.equalsIgnoreCase(id)) {

                students.remove(i);

                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

}
