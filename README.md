# 🎓 Student Grades Manager (Java)

A robust console application built in Java for managing and persisting individual student grades. It leverages modern Java features for efficient and structured data handling.

## ✨ Key Features Implemented

- **Object-Oriented Design (OOP):** Utilizes a dedicated **`Student` class** to encapsulate student data (name and grades), promoting modularity and maintainability.
- **Efficient Data Storage:** Employs a **`HashMap<String, Student>`** for the core data structure, allowing for fast, **O(1)** (constant time) lookups of student records by their name.
- **Persistent Storage:** Implements reliable file input/output (`java.io.*`) to load and save records to a **`student_grades.txt`** file, ensuring data persists across program runs.
- **Console Interface:** Provides a simple menu-driven command-line interface for adding grades and viewing all student records.

---

## 🛠️ Technical Skills Demonstrated

| Area                  | Concept                                                                                         |
| :-------------------- | :---------------------------------------------------------------------------------------------- |
| **Java Fundamentals** | OOP principles (Class design, encapsulation, `toString()` override).                            |
| **Collections**       | Strategic use of `HashMap` (key-value storage) and `ArrayList` (dynamic grade lists).           |
| **File I/O**          | Implementation of `BufferedReader`, `PrintWriter`, and `FileWriter` for structured persistence. |
| **CLI & Input**       | Handling user interaction and parsing input using the `Scanner` class.                          |

---

## ⚙️ Setup & Execution

To run this project locally, follow these steps:

1.  **Clone the Repository**

    ```bash
    git clone [https://github.com/YOUR_USERNAME/student-grades-manager.git](https://github.com/YOUR_USERNAME/student-grades-manager.git)
    cd student-grades-manager
    ```

2.  **Compile the Code**
    _Ensure both `Main.java` and the `Student` class are accessible._

    ```bash
    javac Main.java
    ```

3.  **Run the Application**
    ```bash
    java Main
    ```
    The application will automatically attempt to load data from `student_grades.txt` or start fresh if the file doesn't exist.

---

## 🚀 Future Enhancements

The next steps for this project could include:

- **Grade Analysis:** Adding functionality to **calculate GPA**, course averages, and min/max grades per student.
- **Student Management:** Implementing commands to **remove** or **modify** existing student records.
- **UI/UX Improvement:** Migrating from a console interface to a graphical user interface (GUI) using technologies like **JavaFX** or Swing.
- **Advanced Export:** Allowing users to export the grade data to a standard format like **CSV** or Excel.
