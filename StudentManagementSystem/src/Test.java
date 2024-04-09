import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Test {
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JPanel jPanel1;

    public Test() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    textField2.setText(textField1.getText());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Test test = new Test();

        frame.setTitle("bla");
        frame.setResizable(true);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(test.jPanel1);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.set(0, 20);

        System.out.println(list);
    }
}
