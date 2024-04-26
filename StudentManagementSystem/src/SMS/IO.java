package SMS;

import javax.swing.*;
import java.io.*;

public class IO {
    private static String filename = "Assets/Database.ser";

    public static void writeToFile(Database database) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(database);

            oos.close();
            fos.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not write to file");
        }
    }

    public static Database readFromFile() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Database database = (Database) ois.readObject();

            ois.close();
            fis.close();

            return database;
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not read from file");

            return null;
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found");

            return null;
        }
    }
}
