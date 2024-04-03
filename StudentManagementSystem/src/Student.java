public class Student {
    private String name;
    private String studentID;
    private DateOfBirth DOB;
    private double CGPA;

    public Student(String name, String studentID, DateOfBirth DOB, double CGPA) {
        this.name = name;
        this.studentID = studentID;
        this.DOB = DOB;
        this.CGPA = CGPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public DateOfBirth getDOB() {
        return DOB;
    }

    public void setDOB(DateOfBirth DOB) {
        this.DOB = DOB;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return  "name=" + name +
                ", studentID=" + studentID +
                ", DOB=" + DOB +
                ", CGPA=" + CGPA;
    }
}
