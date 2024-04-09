package SMS;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        StudentInfo studentInfo = new StudentInfo();

        frame.setTitle("Student Information");
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.add(studentInfo.getPanel());
    }
}
