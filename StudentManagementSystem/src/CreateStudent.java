import java.util.StringTokenizer;

public class CreateStudent {
    private String name;
    private String studentID;
    private String dob;
    private String cgpa;

    public CreateStudent(String name, String studentID, String dob, String cgpa) {
        this.name = name;
        this.studentID = studentID;
        this.dob = dob;
        this.cgpa = cgpa;
    }

    public Student newStudent() {
        StringTokenizer token = new StringTokenizer(dob);

        int date = Integer.parseInt(token.nextToken("/"));
        int month = Integer.parseInt(token.nextToken("/"));
        int year = Integer.parseInt(token.nextToken("/"));

        DateOfBirth DOB = new DateOfBirth(year, month, date);

        double CGPA = Double.parseDouble(cgpa);

        return new Student(name, studentID, DOB, CGPA);
    }
}