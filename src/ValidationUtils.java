// src/ValidationUtils.java
public class ValidationUtils {

    public static Integer parsePositiveInt(String s) {
        try {
            int val = Integer.parseInt(s.trim());
            return val > 0 ? val : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Double parseGrade(String s) {
        try {
            double val = Double.parseDouble(s.trim());
            return (val >= 0 && val <= 100) ? val : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean notBlank(String s) {
        return s != null && !s.trim().isEmpty();
    }
}