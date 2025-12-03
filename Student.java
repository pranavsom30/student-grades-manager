import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single student with an ID/Name and a list of grades.
 */
class Student {
    private int studentId;
    private String name;
    private List<String> grades;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String grade) {
        this.grades.add(grade);
    }

    public List<String> getGrades() {
        return grades;
    }

    /**
     * Calculates the average of the student's grades.
     * Only numeric grades are included in the calculation.
     * 
     * @return The average grade as a double, or 0.0 if no numeric grades exist.
     */
    public double getAverageGrade() {
        double sum = 0.0;
        int count = 0;

        for (String grade : grades) {
            try {
                double numericGrade = Double.parseDouble(grade.trim());
                sum += numericGrade;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Warning: Non-numeric grade '" + grade + "' ignored in average calculation.");
            }
        }

        if (count == 0) {
            return 0.0;
        } else {
            return sum / count;
        }
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Grades: " + grades.toString();
    }
}