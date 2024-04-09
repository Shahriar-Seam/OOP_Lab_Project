package SMS;

import java.io.*;
import java.util.ArrayList;

public class IO {
    private static String filename = "../OOP_Lab_Project/StudentManagementSystem/src/SMS/StudentData.ser";
    private static ArrayList<Student> students;

    public static ArrayList <Student> Read(int counter) {
        try {
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fin);

            students = (ArrayList <Student>) in.readObject();

            fin.close();
            in.close();

            for (Student s : students) {
                s.setUniqueID(counter++);
            }
        }
        catch (IOException e) {
            System.out.println("IOException in Database");
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException in Database");
        }

        return students;
    }

    public static void Write(ArrayList<Student> students) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(students);

            fout.close();
            out.close();
        }
        catch (IOException e) {
            System.out.println("IOException in Database");
        }
    }
}
