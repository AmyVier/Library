import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@SuppressWarnings("unchecked") // warning shows when getting saved hashmap data from ser file

/**
 * SavedUserData class
 * Description: retrieves and saves user data
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class SavedUserData {

    // data of users
   protected static HashMap<String, String> username_password = new HashMap<>();

    /**
     * saves user data
     * 
     * @param updated PasswordManager user data to be saved
     */
    public static void save() {
        try {
            FileOutputStream file = new FileOutputStream("UserData.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(username_password);

            out.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught in save " + ex);
        }
    }

    /**
     * initializes user data
     */
    public static void initialize() {
        try {
            FileInputStream file = new FileInputStream("UserData.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            username_password = (HashMap<String, String>) in.readObject();

            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught in initialize " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught in initialize " + ex);
        }
    }

}
