package SMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class StudentInfo extends JFrame {
    private JPanel BasePanel;
    private JPanel LabelPanel;
    private JPanel TextPanel;
    private JPanel NavigationPanel;
    private JPanel ButtonsPanel;
    private JTextField NameField;
    private JTextField StudentIDField;
    private JTextField AddressField;
    private JTextField DateOfBirthField;
    private JTextField CGPAField;
    private JButton FirstButton;
    private JButton PreviousButton;
    private JButton NextButton;
    private JButton LastButton;
    private JTextField CounterField;
    private JButton AddButton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JLabel NameLabel;
    private JLabel StudentIDLabel;
    private JLabel AddressLabel;
    private JLabel DateOfBirthLabel;
    private JLabel CGPALabel;
    private JMenuBar MenuBar;
    private JMenu Menu;
    private JMenuItem Sort;
    private JMenuItem ClearDatabase;
    private JMenuItem Summary;
    private JMenuItem About;
    private JMenuItem Exit;
    private Database database;
    int counter = 0;
    int numberOfStudents = 0;

    public StudentInfo() {
        initWindow();

        database = IO.readFromFile();

        if (database.isEmpty() == false) {
            numberOfStudents = database.numberOfStudents();

            populateInfoTable(database.getStudent(counter), counter + 1);
        }
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == AddButton) {
                    Student student = createStudent();

                    if (student == null) {
                        JOptionPane.showMessageDialog(StudentInfo.this, "Couldn't create new entry");
                    }
                    else if (database.containsStudent(student) == true) {
                        JOptionPane.showMessageDialog(StudentInfo.this, "Student already exists");
                    }
                    else {
                        database.addStudent(student);

                        numberOfStudents++;
                        counter = numberOfStudents - 1;
                        IO.writeToFile(database);
                        populateInfoTable(database.getStudent(counter), counter + 1);
                    }
                }
            }
        });
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == UpdateButton) {
                    Student student = createStudent();

                    if (student == null) {
                        JOptionPane.showMessageDialog(StudentInfo.this, "Couldn't create new entry");
                    }
                    else {
                        database.updateStudent(counter, student);
                    }

                    IO.writeToFile(database);
                }
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DeleteButton) {
                    Student student = createStudent();

                    if (student == null) {
                        JOptionPane.showMessageDialog(StudentInfo.this, "Invalid entry");
                    }
                    if (database.isEmpty() == false) {
                        database.removeStudent(database.getStudent(counter));

                        numberOfStudents--;

                        IO.writeToFile(database);

                        if (counter == numberOfStudents) {
                            counter--;
                        }

                        if (database.isEmpty() == true) {
                            clearInfoTable();
                        }
                        else {
                            populateInfoTable(database.getStudent(counter), counter + 1);
                        }
                    }
                }
            }
        });
        FirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == FirstButton) {
                    counter = 0;

                    if (database.isEmpty() == false) {
                        populateInfoTable(database.getStudent(counter), counter + 1);
                    }
                }
            }
        });
        LastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == LastButton) {
                    counter = database.numberOfStudents() - 1;
                    if (database.isEmpty() == false) {
                        populateInfoTable(database.getStudent(counter), counter + 1);
                    }
                }
            }
        });
        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == PreviousButton) {
                    if (counter > 0) {
                        counter--;
                    }

                    if (database.isEmpty() == false) {
                        populateInfoTable(database.getStudent(counter), counter + 1);
                    }
                }
            }
        });
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == NextButton) {
                    if (counter < numberOfStudents - 1) {
                        counter++;
                    }

                    if (database.isEmpty() == false) {
                        populateInfoTable(database.getStudent(counter), counter + 1);
                    }
                }
            }
        });
        CounterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == CounterField) {
                    int tempCounter = Integer.parseInt(CounterField.getText());

                    if (tempCounter > numberOfStudents || tempCounter <= 0) {
                        JOptionPane.showMessageDialog(StudentInfo.this, "Invalid entry");
                    }
                    else {
                        counter = tempCounter - 1;
                    }

                    populateInfoTable(database.getStudent(counter), counter + 1);
                }
            }
        });
    }

    public void initWindow() {
        MenuBar = new JMenuBar();

        Menu = new JMenu("Options");

        Sort = new JMenuItem("Sort");
        ClearDatabase = new JMenuItem("Clear Database");
        Summary = new JMenuItem("Summary");
        About = new JMenuItem("About");
        Exit = new JMenuItem("Exit");

        Menu.add(Sort);
        Menu.add(ClearDatabase);
        Menu.add(Summary);
        Menu.add(About);
        Menu.add(Exit);

        MenuBar.add(Menu);

        this.setJMenuBar(MenuBar);

        ImageIcon add = new ImageIcon("Assets/add.png");
        ImageIcon update = new ImageIcon("Assets/update.jpg");
        ImageIcon delete = new ImageIcon("Assets/delete.jpg");

        this.AddButton.setIcon(add);
        this.UpdateButton.setIcon(update);
        this.DeleteButton.setIcon(delete);

        this.setTitle("Student Info");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(500, 700);
        this.add(BasePanel);
        ImageIcon image = new ImageIcon("Assets/ghost.png");
        this.setIconImage(image.getImage());

        Sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Sort) {
                    if (database.isEmpty() == false) {

                        database.sortStudents();

                        populateInfoTable(database.getStudent(counter), counter + 1);

                        JOptionPane.showMessageDialog(StudentInfo.this, "Students have been sorted");

                        IO.writeToFile(database);
                    }
                }
            }
        });

        ClearDatabase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ClearDatabase) {
                    database.clear();
                    clearInfoTable();

                    JOptionPane.showMessageDialog(StudentInfo.this, "Database has been cleared");

                    IO.writeToFile(database);

                    counter = 0;
                    numberOfStudents = 0;
                }
            }
        });

        Summary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Summary) {
                    summaryTable();
                }
            }
        });

        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == About) {
                    JFrame frame = new JFrame("About US");

                    JLabel label = new JLabel();

                    label.setText("<html><p><font size=+2>This Student Management System is a project made by <b><i><font color=red>Ibnul Abrar Shahriar Seam</font></i></b> and <b><i><font color=red>Tarique Shams</font></i></b> from Computer Science and Engineering Discipline of Khulna University. This project was assigned to us by Professor Dr. Md. Anisur Rahman sir for our Object Oriented Programming course. It is made using the Swing package of Java programming language.</font></p></html>");

                    frame.add(label);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Exit) {
                    System.exit(0);
                }
            }
        });
    }

    public void populateInfoTable(Student student, int count) {
        this.NameField.setText(student.getName());
        this.StudentIDField.setText(student.getStudentID());
        this.AddressField.setText(student.getAddress().toString());
        this.DateOfBirthField.setText(student.getDateOfBirth().toString());
        this.CGPAField.setText(student.getCGPA() + "");

        this.CounterField.setText(count + "/" + numberOfStudents);
    }

    public void clearInfoTable() {
        this.NameField.setText("");
        this.StudentIDField.setText("");
        this.AddressField.setText("");
        this.DateOfBirthField.setText("");
        this.CGPAField.setText("");
        this.CounterField.setText("");
    }

    public void summaryTable() {
        String[] headers = {"Name", "Student ID", "Address", "Date of Birth", "Age", "CGPA"};

        String[][] data = database.dataForTable();

        JFrame tableFrame = new JFrame("Student Info");
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tableFrame.setVisible(true);
        tableFrame.pack();
        tableFrame.setLocationRelativeTo(null);
        tableFrame.setResizable(true);
        tableFrame.add(new JScrollPane(new JTable(data, headers)));
        tableFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public Student createStudent() {
        if (NameField.getText().isEmpty() || StudentIDField.getText().isEmpty() || AddressField.getText().isEmpty() || DateOfBirthField.getText().isEmpty() || CGPAField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");

            return null;
        }
        else {
            String name = NameField.getText();
            String studentID = StudentIDField.getText();
            String address = AddressField.getText();
            String dateOfBirth = DateOfBirthField.getText();
            String cgpa = CGPAField.getText();
            Address tempAddress;
            DateOfBirth tempDateOfBirth;
            double tempCGPA;

            try {
                tempAddress = new Address(address);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Address\nFormat address as following:\nStreet, Post Office, District");

                return null;
            }

            try {
                tempDateOfBirth = new DateOfBirth(dateOfBirth);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Date Of Birth\nFormat Date Of Birth as following:\nDD/MM/YYYY");

                return null;
            }

            try {
                tempCGPA = Double.parseDouble(cgpa);

                if (tempCGPA > 4 || tempCGPA < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid CGPA\nEnter a valid floating point number between 0 and 4 (Inclusive)");

                    return null;
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid CGPA\nEnter a valid floating point number between 0 and 4 (Inclusive)");

                return null;
            }

            return new Student(name, studentID, tempAddress, tempDateOfBirth, tempCGPA);
        }
    }
}
