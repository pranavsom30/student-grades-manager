import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Student> studentRecords = new HashMap<>();
    private static final String FILENAME = "student_grades.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        loadRecords();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Grade Tracker Menu ---");
            System.out.println("1. Add Grade for Student");
            System.out.println("2. View All Student Records");
            System.out.println("3. Exit and Save");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addGrade(scanner);
                    break;
                case 2:
                    viewRecords();
                    break;
                case 3:
                    saveRecords();
                    running = false;
                    System.out.println("Exiting. Records saved.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // --- Helper Methods ---

    static void addGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        Student student = studentRecords.get(name);
        if (student == null) {
            student = new Student(name);
            studentRecords.put(name, student);
            System.out.println("New student record created for " + name);
        }

        System.out.print("Enter grade to add: ");
        String grade = scanner.nextLine();
        student.addGrade(grade);
        System.out.println("Grade added successfully for " + name + ".");
    }

    static void viewRecords() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n*** All Student Records ***");

        for (Student student : studentRecords.values()) {
            System.out.println(student);
        }
        System.out.println("***************************");
    }

    // --- File I/O Methods ---

    static void saveRecords() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILENAME))) {
            for (Student student : studentRecords.values()) {
                String gradesLine = String.join(",", student.getGrades());
                pw.println(student.getName() + ":" + gradesLine);
            }
        } catch (IOException e) {
            System.err.println("Error saving records: " + e.getMessage());
            throw e;
        }
    }

    static void loadRecords() throws IOException {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("Grade file not found. Starting with empty records.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length != 2)
                    continue;

                String name = parts[0].trim();
                String gradesData = parts[1];

                Student student = new Student(name);

                if (!gradesData.isEmpty()) {
                    String[] gradesArray = gradesData.split(",");
                    for (String grade : gradesArray) {
                        student.addGrade(grade.trim());
                    }
                }

                studentRecords.put(name, student);
            }
        } catch (IOException e) {
            System.err.println("Error loading records: " + e.getMessage());
            throw e;
        }
        System.out.println(studentRecords.size() + " records loaded successfully.");
    }
}