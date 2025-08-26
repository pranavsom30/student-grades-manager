import java.io.*;
import java.util.*;

public class Main {
    static List<String> grades = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        loadGrades(); // Load from file at start

        boolean running = true;
        while (running) {
            System.out.println("1. Add Grade  2. View Grades  3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    grades.add(grade);
                    saveGrades(); // Save to file
                    break;
                case 2:
                    System.out.println("Grades: " + grades);
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
        scanner.close();
    }

    static void saveGrades() throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter("grades.txt"))) {
            for (String g : grades) pw.println(g);
        }
    }

    static void loadGrades() throws IOException {
        File file = new File("grades.txt");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) grades.add(line);
        }
    }
}
