import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎓 Welcome to Student Grades Manager!");
        Scanner scanner = new Scanner(System.in);

        // Placeholder menu
        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Student Grade");
            System.out.println("2. View Grades");
            System.out.println("3. Calculate Average");
            System.out.println("4. Exit");
            System.out.print("👉 ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("📌 Feature not yet implemented (Add Grade).");
                    break;
                case 2:
                    System.out.println("📌 Feature not yet implemented (View Grades).");
                    break;
                case 3:
                    System.out.println("📌 Feature not yet implemented (Calculate Average).");
                    break;
                case 4:
                    running = false;
                    System.out.println("👋 Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}