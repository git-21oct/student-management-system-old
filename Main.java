import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();   // loads students.txt
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    int id = readInt("Enter ID: ");
                    String name = readText("Enter Name: ");
                    int age = readInt("Enter Age: ");
                    String course = readText("Enter Course: ");
                    manager.addStudent(new Student(id, name, age, course));
                    break;
                case 2:
                    manager.viewAll();
                    break;
                case 3:
                    int uid = readInt("Enter ID of student to update: ");
                    String newName = readText("Enter new Name: ");
                    int newAge = readInt("Enter new Age: ");
                    String newCourse = readText("Enter new Course: ");
                    manager.updateStudent(uid, newName, newAge, newCourse);
                    break;
                case 4:
                    manager.deleteStudent(readInt("Enter ID of student to delete: "));
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // Keeps asking until the user types a valid whole number
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Keeps asking until the text is not empty; commas are replaced
    // because the data file uses commas as separators
    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = sc.nextLine().trim().replace(",", " ");
            if (!text.isEmpty()) return text;
            System.out.println("This field cannot be empty.");
        }
    }
}
