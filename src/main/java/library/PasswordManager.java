package library;

/**
 * PasswordManager class
 * Description: manages passwords
 *
 * @author (Amy Vier)
 * @version (October 12, 2023)
 */
public class PasswordManager extends SavedUserData {

    /**
     * finds if the user provided with a password and a username exists within the
     * PasswordManager
     * 
     * @param username String username
     * @param password String password
     * @return boolean if the user exists or not
     */
    public static boolean findUser(String username, String password) {
        if (username_password.containsKey(username) &&
                username_password.get(username).equals(password)) {
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
     * adds a user to the PasswordManager
     * 
     * @param username String username
     * @param password String password
     */
    public static void addUser(String username, String password) {
        username_password.put(username, password);
    }

}
