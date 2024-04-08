import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class StudentInfo {
    private JTextField Name;
    private JTextField StudentID;
    private JTextField DateOfBirth;
    private JTextField SetCGPA;
    private JPanel StudentPanel;
    private JButton AddStudent;
    private JButton ShowStudents;
    private JTextField textField1;
    protected Database students = new Database();

    public StudentInfo() {
        AddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddStudent) {
                    CreateStudent createStudent = new CreateStudent(Name.getText(), StudentID.getText(), DateOfBirth.getText(), SetCGPA.getText());

                    students.addStudent(createStudent.newStudent());
                }
            }
        });
        ShowStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame table = new JFrame();

                table.setVisible(true);
                table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                int counter = 0;

                String[] columnNames = {"Name", "StudentID", "DOB", "CGPA"};
                String[][] data = new String[students.getSize()][];

                while (counter < students.getSize()) {
                    data[counter] = students.getStudent(counter).studentDetails();
                    counter++;
                }

                JTable studentTable = new JTable(data, columnNames);
                studentTable.setBounds(30, 40, 200, 300);

                table.add(new JScrollPane(studentTable));
                table.setSize(500, 500);

                students.resetCounter();
            }
        });
    }

    public JPanel getPanel() {
        return StudentPanel;
    }
}