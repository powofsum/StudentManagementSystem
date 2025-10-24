
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= Student Management System =========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("5.Search");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    String age = sc.nextLine();
                    System.out.print("Enter Gender (Male/Female): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();
                    System.out.print("Enter GPA: ");
                    String gpa = sc.nextLine();

                    admin.addStudent(id, name, age, gender, department, gpa);
                    break;

                case 2:
                    System.out.println("\n--- Student List ---");
                    admin.ViewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID of the student to delete: ");
                    long deleteId = sc.nextLong();
                    admin.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully (if found).");
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                case 5:
                    admin.searchStudent("MOhamed");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}