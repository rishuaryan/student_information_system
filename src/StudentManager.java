// src/StudentManager.java
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) {
        if (findById(s.getStudentId()) != null) return false; // prevent duplicate IDs
        students.add(s);
        return true;
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    public Student findById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id.trim())) return s;
        }
        return null;
    }

    public List<Student> findByName(String namePart) {
        List<Student> res = new ArrayList<>();
        if (namePart == null) return res;
        String q = namePart.trim().toLowerCase();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(q)) res.add(s);
        }
        return res;
    }

    public boolean updateStudent(String id, String newName, Integer newAge, Double newGrade, String newContact) {
        Student s = findById(id);
        if (s == null) return false;
        try {
            if (newName != null) s.setName(newName);
            if (newAge != null) s.setAge(newAge);
            if (newGrade != null) s.setGrade(newGrade);
            if (newContact != null) s.setContact(newContact);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean deleteStudent(String id) {
        Student s = findById(id);
        if (s == null) return false;
        return students.remove(s);
    }
}