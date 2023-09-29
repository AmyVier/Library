import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SavedUserData class
 * Description: retrieves and saves user data
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class SavedUserData {

    // data of users
    private static PasswordManager allUsers = null;

    /**
     * gets data of users
     * 
     * @return data of users in class PasswordManager
     */
    public static PasswordManager getUsers() {
        if (allUsers == null) {
            return new PasswordManager();
        }

        return allUsers.clone();
    }

    /**
     * saves user data
     * 
     * @param updated PasswordManager user data to be saved
     */
    public static void save(PasswordManager updated) {
        try {
            FileOutputStream file = new FileOutputStream("UserData.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(updated);

            out.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught in save " + ex);
        }

        allUsers = updated.clone();
    }

    /**
     * initializes user data
     */
    public static void initialize() {
        try {
            FileInputStream file = new FileInputStream("UserData.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            allUsers = (PasswordManager) in.readObject();

            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught in initialize " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in initialize " + ex);
        }
    }

}
