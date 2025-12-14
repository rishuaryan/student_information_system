// src/StudentInformationSystem.java
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = readLine("Enter your choice: ");
            switch (choice) {
                case "1": addStudent(); break;
                case "2": viewAllStudents(); break;
                case "3": searchStudent(); break;
                case "4": updateStudent(); break;
                case "5": deleteStudent(); break;
                case "6": running = false; System.out.println("Thank you for using Student Information System!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
        System.out.println("1. Add New Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    // ------- Input helpers -------
    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static String readNonBlank(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (ValidationUtils.notBlank(s)) return s.trim();
            System.out.println("Input cannot be empty.");
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            String s = readLine(prompt);
            Integer val = ValidationUtils.parsePositiveInt(s);
            if (val != null) return val;
            System.out.println("Please enter a positive integer.");
        }
    }

    private static double readGrade(String prompt) {
        while (true) {
            String s = readLine(prompt);
            Double val = ValidationUtils.parseGrade(s);
            if (val != null) return val;
            System.out.println("Please enter a grade between 0 and 100.");
        }
    }

    // ------- Menu actions -------
    private static void addStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");
        String studentId = readNonBlank("Enter Student ID: ");
        String name = readNonBlank("Enter Name: ");
        int age = readPositiveInt("Enter Age: ");
        double grade = readGrade("Enter Grade: ");
        String contact = readNonBlank("Enter Contact: ");

        try {
            Student student = new Student(name, age, grade, studentId, contact);
            boolean ok = manager.addStudent(student);
            if (ok) System.out.println("✅ Student added successfully!");
            else System.out.println("❗ A student with this ID already exists.");
        } catch (IllegalArgumentException e) {
            System.out.println("❗ " + e.getMessage());
        }
    }

    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        List<Student> list = manager.getAll();
        if (list.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        // Table header
        System.out.printf("%-15s %-20s %-8s %-8s %-25s%n", "Student ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-".repeat(80));
        // Rows
        for (Student s : list) {
            System.out.printf("%-15s %-20s %-8d %-8.2f %-25s%n",
                    s.getStudentId(), s.getName(), s.getAge(), s.getGrade(), s.getContact());
        }
    }

    private static void searchStudent() {
        System.out.println("\n=== SEARCH STUDENT ===");
        String query = readNonBlank("Enter Student ID or Name: ");
        Student byId = manager.findById(query);
        if (byId != null) {
            System.out.println("\nFound by ID:");
            System.out.println(byId.toPrettyString());
            return;
        }
        List<Student> byName = manager.findByName(query);
        if (byName.isEmpty()) {
            System.out.println("No matching student found.");
        } else {
            System.out.println("\nMatches by name:");
            for (Student s : byName) {
                System.out.println(s.toPrettyString());
            }
        }
    }

    private static void updateStudent() {
        System.out.println("\n=== UPDATE STUDENT ===");
        String id = readNonBlank("Enter Student ID to update: ");
        Student s = manager.findById(id);
        if (s == null) {
            System.out.println("No student found with that ID.");
            return;
        }

        System.out.println("Leave a field blank to keep current value.");
        String newName = readLine("New Name (" + s.getName() + "): ");
        String ageStr = readLine("New Age (" + s.getAge() + "): ");
        String gradeStr = readLine("New Grade (" + String.format("%.2f", s.getGrade()) + "): ");
        String newContact = readLine("New Contact (" + s.getContact() + "): ");

        Integer newAge = ValidationUtils.notBlank(ageStr) ? ValidationUtils.parsePositiveInt(ageStr) : null;
        Double newGrade = ValidationUtils.notBlank(gradeStr) ? ValidationUtils.parseGrade(gradeStr) : null;

        if (ValidationUtils.notBlank(ageStr) && newAge == null) {
            System.out.println("Invalid age entered. Update cancelled.");
            return;
        }
        if (ValidationUtils.notBlank(gradeStr) && newGrade == null) {
            System.out.println("Invalid grade entered. Update cancelled.");
            return;
        }
        boolean ok = manager.updateStudent(
                id,
                ValidationUtils.notBlank(newName) ? newName : null,
                newAge,
                newGrade,
                ValidationUtils.notBlank(newContact) ? newContact : null
        );
        System.out.println(ok ? "✅ Student updated successfully!" : "❗ Update failed due to invalid data.");
    }

    private static void deleteStudent() {
        System.out.println("\n=== DELETE STUDENT ===");
        String id = readNonBlank("Enter Student ID to delete: ");
        boolean ok = manager.deleteStudent(id);
        System.out.println(ok ? "🗑️ Student deleted." : "❗ No student found with that ID.");
    }
}
