import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class StudentInfo {
    private JTextField Name;
    private JTextField StudentID;
    private JTextField DateOfBirth;
    private JTextField SetCGPA;
    private JButton setNameButton;
    private JButton setStudentIDButton;
    private JButton setDateOfBirthButton;
    private JButton setCGPAButton;
    private JPanel Student;
    private JButton AddStudent;
    private String name;
    private String studentID;
    private DateOfBirth DOB;
    private double CGPA;
    private Student student;

    public StudentInfo() {
        setNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setNameButton) {
                    name = Name.getText();
                }
            }
        });

        setStudentIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setStudentIDButton) {
                    studentID = StudentID.getText();
                }
            }
        });
        setDateOfBirthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setDateOfBirthButton) {
                    String dob = DateOfBirth.getText();

                    StringTokenizer token = new StringTokenizer(dob);

                    int date = Integer.parseInt(token.nextToken("/"));
                    int month = Integer.parseInt(token.nextToken("/"));
                    int year = Integer.parseInt(token.nextToken("/"));

                    DOB = new DateOfBirth(year, month, date);
                }
            }
        });
        setCGPAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == setCGPAButton) {
                    CGPA = Double.parseDouble(SetCGPA.getText());
                }
            }
        });
        AddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddStudent) {
                    student = new Student(name, studentID, DOB, CGPA);

                    JOptionPane.showMessageDialog(null, "Student Added Successfully");
                    JOptionPane.showMessageDialog(null, student);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        StudentInfo studentInfo = new StudentInfo();

        frame.setTitle("Student Information");
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.add(studentInfo.Student);
    }
}
