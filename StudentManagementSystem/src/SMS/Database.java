package SMS;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    ArrayList<Student> students;

    public Database() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void updateStudent(int index, Student student) {
        students.set(index, student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public int getIndexOfStudent(Student student) {
        return students.indexOf(student);
    }

    public boolean containsStudent(Student student) {
        return students.contains(student);
    }

    public int numberOfStudents() {
        return students.size();
    }

    public void sortStudents() {
        students.sort(Student::compareTo);
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public void clear() {
        students.clear();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (Student student : students) {
            sb.append(student);
        }

        return sb.toString();
    }

    public String[][] dataForTable() {
        String[][] data = new String[students.size()][6];

        for (int i = 0; i < students.size(); i++) {
            data[i] = students.get(i).getDetails();
        }

        return data;
    }
}
