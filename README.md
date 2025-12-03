# 🎓 Student Grades Manager (Java)

A robust console application built in Java for managing and persisting individual student grades. It leverages modern Java features for efficient and structured data handling.

## ✨ Key Features Implemented

- **Object-Oriented Design (OOP):** Utilizes a dedicated **`Student` class** to encapsulate student data (ID, name, and grades), promoting modularity and maintainability.
- **Efficient Data Storage:** Employs a **`HashMap<Integer, Student>`** for the core data structure, allowing for fast, **O(1)** (constant time) lookups of student records by their **unique Student ID**.
- **Grade Analysis:** Implements a menu option to **calculate the numerical average grade** for any student on record.
- **Persistent Storage:** Implements reliable file input/output (`java.io.*`) to load and save records to a **`student_grades.txt`** file, ensuring data persists across program runs.
- **Console Interface:** Provides a simple menu-driven command-line interface for adding grades, viewing records, and calculating averages.

---

## 🛠️ Technical Skills Demonstrated

| Area | Concept |
| :--- | :--- |
| **Java Fundamentals** | OOP principles (Class design, encapsulation, `toString()` override). |
| **Collections** | Strategic use of **`HashMap` (with `Integer` keys for IDs)** and `ArrayList` (dynamic grade lists). |
| **File I/O** | Implementation of `BufferedReader`, `PrintWriter`, and `FileWriter` for structured persistence (using the `ID;Name:Grades` format). |
| **CLI & Input** | Handling user interaction, parsing input using the `Scanner` class, and implementing basic input validation for IDs. |
| **Data Processing** | Implementing logic for **parsing string grades into numbers** to calculate a precise average. |

---

## ⚙️ Setup & Execution

To run this project locally, follow these steps:

1. **Clone the Repository**

```bash
   git clone [https://github.com/YOUR_USERNAME/student-grades-manager.git](https://github.com/YOUR_USERNAME/student-grades-manager.git)
   cd student-grades-manager
````

2.  **Compile the Code**
    *Ensure both `Main.java` and the `Student` class are accessible.*

    ```bash
    javac Main.java
    ```

3.  **Run the Application**

    ```bash
    java Main
    ```

    The application will automatically attempt to load data from `student_grades.txt` or start fresh if the file doesn't exist.

-----

## 🚀 Future Enhancements

The next steps for this project could include:

  - **Full Student Management:** Implementing commands to **remove** or **modify** existing student records.
  - **Advanced Analysis:** Adding functionality to calculate metrics like **Grade Point Average (GPA)** and **min/max grades** per student.
  - **UI/UX Improvement:** Migrating from a console interface to a graphical user interface (GUI) using technologies like **JavaFX** or Swing.
  - **Advanced Export:** Allowing users to export the grade data to a standard format like **CSV** or Excel.
