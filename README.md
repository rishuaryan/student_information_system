# Student Information System

##  Overview
The **Student Information System (SIS)** is a simple Java-based application that allows users to manage student records.  
It supports adding, viewing, searching, updating, and deleting student details with proper validation and formatted output.  
Each student record includes:
- Student ID
- Name
- Age
- Grade
- Contact Information

This project was built as part of an internship task to demonstrate Java programming, object-oriented design, and documentation skills.

---

##  Setup Instructions
1. Install **JDK (Java Development Kit)** version 8 or higher.
2. Install **IntelliJ IDEA** (or any Java IDE).
3. Clone or download this repository.
4. Open the project in IntelliJ.
5. Navigate to `src/StudentInformationSystem.java`.
6. Run the program → the menu-driven interface will appear.

---

##  Features
- Add new students with validation (age > 0, grade between 0–100).
- View all students in a neatly formatted table.
- Search students by **ID** or **Name**.
- Update existing student details.
- Delete student records.
- Error handling for invalid inputs.
- Data persistence using an **ArrayList**.

---

##  Project Structure
StudentInformationSystem/ ├── README.md ├── src/ │    ├── Student.java │    ├── ValidationUtils.java │    ├── StudentManager.java │    └── StudentInformationSystem.java ├── docs/ │    └── UserManual.md └── test_data/ └── sample_students.txt 

##  Sample Output
=== STUDENT INFORMATION SYSTEM ===
- Add New Student
- View All Students
- Search Student
- Update Student
- Delete Student
- Exit Enter your choice: 1
  
- === ADD NEW STUDENT === Enter Student ID: S001 Enter Name: John Doe Enter Age: 20 Enter Grade: 85.5 Enter Contact: john@email.com ✅ Student added successfully!
  
- === ALL STUDENTS ===

  Student ID      Name                Age     Grade   Contact
  S001            John Doe            20      85.50   john@email.com


---

##  Testing
Use the sample data in `test_data/sample_students.txt` to test the system:
S001, John Doe, 20, 85.5, john@email.com S002, Jane Smith, 21, 92.0, jane@email.com S003, Bob Wilson, 19, 78.5, bob@email.com


---

##  Documentation
- **README.md** → Project overview, setup, features, structure, sample output.
- **docs/UserManual.md** → Step-by-step usage guide with screenshots.
- **test_data/sample_students.txt** → Sample student records for testing.

---

##  Quality Standards Checklist
- Clear project overview ✅
- Step-by-step setup instructions ✅
- Well-organized code structure ✅
- Visual documentation with screenshots (to be added in `docs/`) ✅
- Explanation of algorithms and data structures ✅
- Testing evidence with sample data ✅