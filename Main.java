import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Student> studentRecords = new HashMap<>();
    private static final String FILENAME = "student_grades.txt";
    private static int nextStudentId = 1;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        loadRecords();
        nextStudentId = studentRecords.keySet().stream().max(Integer::compare).orElse(0) + 1;

        boolean running = true;
        while (running) {
            System.out.println("\n--- Grade Tracker Menu ---");
            System.out.println("1. Add Grade for Student");
            System.out.println("2. View All Student Records");
            System.out.println("3. Calculate Student Average Grade"); // New Case
            System.out.println("4. Exit and Save"); // Moved to 4
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
                    calculateAverage(scanner);
                    break;
                case 4:
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
        System.out.print("Enter student ID (or enter 0 to create a new student): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number for the ID.");
            scanner.nextLine();
            return;
        }
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Student student;
        if (studentId == 0) {
            System.out.print("Enter new student name: ");
            String name = scanner.nextLine().trim();

            studentId = nextStudentId++;
            student = new Student(studentId, name);
            studentRecords.put(studentId, student);
            System.out.println("New student record created with ID " + studentId + " for " + name);
        } else {
            student = studentRecords.get(studentId);
            if (student == null) {
                System.out.println("Student with ID " + studentId + " not found.");
                return;
            }
        }

        System.out.print("Enter grade to add (use numbers for accurate average calculation): ");
        String grade = scanner.nextLine();
        student.addGrade(grade);
        System.out.println("Grade added successfully for ID " + studentId + " (" + student.getName() + ").");
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

    static void calculateAverage(Scanner scanner) {
        System.out.print("Enter the ID of the student to calculate the average for: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number for the ID.");
            scanner.nextLine();
            return;
        }
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = studentRecords.get(studentId);

        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        double average = student.getAverageGrade();
        String formattedAverage = String.format("%.2f", average);

        if (average == 0.0 && !student.getGrades().isEmpty()) {
            System.out.println("\n--- Average Grade for " + student.getName() + " (ID: " + studentId + ") ---");
            System.out.println("Student has grades, but none were numeric for calculation.");
            System.out.println("Grades on record: " + student.getGrades());
        } else if (student.getGrades().isEmpty()) {
            System.out.println("\n--- Average Grade for " + student.getName() + " (ID: " + studentId + ") ---");
            System.out.println("No grades found for this student.");
        } else {
            System.out.println("\n--- Average Grade for " + student.getName() + " (ID: " + studentId + ") ---");
            System.out.println("Total Grades Count: " + student.getGrades().size());
            System.out.println("Numeric Average: " + formattedAverage);
        }
    }

    // --- File I/O Methods ---

    static void saveRecords() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILENAME))) {
            for (Student student : studentRecords.values()) {
                String gradesLine = String.join(",", student.getGrades());
                pw.println(student.getId() + ";" + student.getName() + ":" + gradesLine);
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

                String[] idNameParts = parts[0].split(";", 2);
                if (idNameParts.length != 2)
                    continue;

                try {
                    int studentId = Integer.parseInt(idNameParts[0].trim());
                    String name = idNameParts[1].trim();
                    String gradesData = parts[1];

                    Student student = new Student(studentId, name);

                    if (!gradesData.isEmpty()) {
                        String[] gradesArray = gradesData.split(",");
                        for (String grade : gradesArray) {
                            student.addGrade(grade.trim());
                        }
                    }

                    studentRecords.put(studentId, student);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping line due to invalid ID format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading records: " + e.getMessage());
            throw e;
        }
        System.out.println(studentRecords.size() + " records loaded successfully.");
    }
}