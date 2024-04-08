public class Student {
    private String name;
    private String studentID;
    private DateOfBirth DOB;
    private double CGPA;
    private int uniqueID = 0;

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

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        return  "name=" + name +
                ", studentID=" + studentID +
                ", DOB=" + DOB +
                ", CGPA=" + CGPA;
    }

    public String[] studentDetails() {
        String[] details = new String[4];

        details[0] = name;
        details[1] = studentID;
        details[2] = DOB.toString();
        details[3] = "" + CGPA;

        return details;
    }
}
