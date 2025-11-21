import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single student with an ID/Name and a list of grades.
 */
class Student {
    private String name;
    private List<String> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
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

    @Override
    public String toString() {
        return name + ": " + grades.toString();
    }
}