// src/Student.java
public class Student {
    private String name;
    private int age;
    private double grade;       // 0–100
    private String studentId;   // unique
    private String contact;

    public Student(String name, int age, double grade, String studentId, String contact) {
        setName(name);
        setAge(age);
        setGrade(grade);
        setStudentId(studentId);
        setContact(contact);
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
        this.age = age;
    }

    public double getGrade() { return grade; }
    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) throw new IllegalArgumentException("Grade must be between 0 and 100.");
        this.grade = grade;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        this.studentId = studentId.trim();
    }

    public String getContact() { return contact; }
    public void setContact(String contact) {
        if (contact == null || contact.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact cannot be empty.");
        }
        this.contact = contact.trim();
    }

    // Pretty single-record display
    public String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(studentId).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Grade: ").append(String.format("%.2f", grade)).append("\n");
        sb.append("Contact: ").append(contact).append("\n");
        sb.append("-".repeat(30));
        return sb.toString();
    }
}
