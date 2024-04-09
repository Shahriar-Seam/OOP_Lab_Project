package SMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfo {
    private JTextField Name;
    private JTextField StudentID;
    private JTextField DateOfBirth;
    private JTextField SetCGPA;
    private JPanel StudentPanel;
    private JButton AddStudent;
    private JButton ShowStudents;
    private JButton Edit;
    private JLabel uniqueID;
    private JButton Update;
    private JButton Save;
    protected Database students = new Database();
    private static int UniqueID = 0;

    public StudentInfo() {
        AddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddStudent) {
                    CreateStudent createStudent = new CreateStudent(Name.getText(), StudentID.getText(), DateOfBirth.getText(), SetCGPA.getText());

                    Student newStudent = createStudent.newStudent();
                    newStudent.setUniqueID(UniqueID);

                    int present = students.getUniqueID(StudentID.getText());

                    if (present == -1) {

                        students.addStudent(createStudent.newStudent());

                        uniqueID.setText("" + UniqueID);

                        UniqueID++;

                        JOptionPane.showMessageDialog(StudentPanel, "Student Added Successfully");
                    }
                    else {
                        JOptionPane.showMessageDialog(StudentPanel, "Student Already Exists");
                    }
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
        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Edit) {
                    String studentID = JOptionPane.showInputDialog("Enter Student ID");

                    int UID = students.getUniqueID(studentID);

                    if (UID != -1) {

                        Student tempStudent = students.getStudent(UID);

                        Name.setText(tempStudent.getName());
                        StudentID.setText(tempStudent.getStudentID());
                        DateOfBirth.setText(tempStudent.getDOB().toString());
                        SetCGPA.setText(tempStudent.getCGPA() + "");
                        uniqueID.setText(UID + "");

                        Update.setVisible(true);

                        Update.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (e.getSource() == Update) {
                                    String studentID = StudentID.getText();
                                    String studentName = Name.getText();
                                    String dateOfBirth = DateOfBirth.getText();
                                    String cGPA = SetCGPA.getText();

                                    int index = students.getIndexOfStudent(UID);

                                    if (index != -1) {
                                        CreateStudent newStudent = new CreateStudent(studentName, studentID, dateOfBirth, cGPA);

                                        students.updateStudent(index, newStudent.newStudent());

                                        JOptionPane.showMessageDialog(null, "Student Updated");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Student does not exist");
                                    }
                                }

                                Update.setVisible(false);
                            }
                        });
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Student does not exist");
                    }
                }
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Save) {
                    IO.Write(students.getStudents());
                }
            }
        });
    }

    public JPanel getPanel() {
        return StudentPanel;
    }
}