import java.util.HashMap;

/**
 * LibraryOfBooks class
 * Description: stores books
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class PasswordManager {
    // user list
    private static HashMap<String, String> username_password= new HashMap<>();

    /**
     * finds if the user provided with a password and a username exists within the PasswordManager
     * 
     * @param username String username
     * @param password String password
     * @return boolean if the user exists or not
     */
    public static boolean findUser(String username, String password) {
        if (username_password.containsKey(username) && username_password.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * finds if the user provided with a username exists within the PasswordManager
     * 
     * @param username String username
     * @return boolean if the user exists or not
     */
    public static boolean findUsername(String username) {
        if (username_password.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * adds a user to ther PasswordManager
     * 
     * @param username String username
     * @param password String password
     */
    public static void addUser(String username, String password) {
        username_password.put(username, password);
    }
}
