import java.util.ArrayList;
import java.util.Comparator;

public class Database implements Comparator <Student> {
    private ArrayList <Student> students = new ArrayList<>();
    private int counter = 0;
    private static int uniqueID = 0;

    public Database() {
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public Student getStudentByUniqueID(Student student) {
        for (Student s : students) {
            if (s.getUniqueID() == student.getUniqueID()) {
                return student;
            }
        }

        return null;
    }

    public int getIndexOfStudent(int UID) {
        for (int count = 0; count < students.size(); count++) {
            if (students.get(count).getUniqueID() == UID) {
                return count;
            }
        }

        return -1;
    }

    public int getUniqueID(String studentID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                return students.get(i).getUniqueID();
            }
        }

        return -1;
    }

    public void addStudent(Student student) {
        student.setUniqueID(uniqueID++);

        students.add(student);
    }

    public void removeStudent(Student student) {
        uniqueID--;

        students.remove(student);
    }

    public void removeStudent(int index) {
        uniqueID--;

        students.remove(index);
    }

    public int getSize() {
        return students.size();
    }

    public void updateStudent(int index, Student student) {
        students.set(index, student);
    }

    public int compare(Student s1, Student s2) {
        if (s1.getCGPA() > s2.getCGPA()) {
            return 1;
        }
        else if (s1.getCGPA() < s2.getCGPA()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public void sortStudents() {
        students.sort(new Database());
    }
}
