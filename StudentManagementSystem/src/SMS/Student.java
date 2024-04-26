package SMS;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Person implements Serializable, Comparable <Person> {
    private String StudentID;
    private double CGPA;

    public Student(String Name, String StudentID, Address address, DateOfBirth dateOfBirth, double CGPA) {
        super(Name, address, dateOfBirth);

        this.StudentID = StudentID;
        this.CGPA = CGPA;
    }

    public String getStudentID() {
        return StudentID;
    }

    public double getCGPA() {
        return CGPA;
    }

    @Override
    public int compareTo(Person person) {
        Student student = (Student) person;

        if (this.CGPA < student.CGPA) {
            return 1;
        }
        else if (this.CGPA > student.CGPA) {
            return -1;
        }
        else {
            return this.StudentID.compareTo(student.StudentID);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Student student = (Student) o;

        if (this.StudentID.equals(student.getStudentID())) {
            return true;
        }
        else {
            return Age == student.Age && Double.compare(CGPA, student.CGPA) == 0 && Objects.equals(Name, student.Name) && Objects.equals(StudentID, student.StudentID) && Objects.equals(address, student.address) && Objects.equals(dateOfBirth, student.dateOfBirth);
        }
    }

    public String[] getDetails() {
        String[] details = new String[6];

        details[0] = this.getName();
        details[1] = this.getStudentID();
        details[2] = this.getAddress().toString();
        details[3] = this.getDateOfBirth().toString();
        details[4] = this.getAge() + "";
        details[5] = this.getCGPA() + "";

        return details;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", StudentID='" + StudentID + '\'' +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                ", CGPA=" + CGPA +
                '}';
    }
}
