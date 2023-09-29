import java.io.Serializable;
import java.util.HashMap;

/**
 * PasswordManager class
 * Description: manages passwords
 *
 * @author (Amy Vier)
 * @version (September 29, 2023)
 */
public class PasswordManager implements Serializable, Cloneable{
    // user list
    private  HashMap<String, String> username_password= new HashMap<>();

    /**
     * finds if the user provided with a password and a username exists within the PasswordManager
     * 
     * @param username String username
     * @param password String password
     * @return boolean if the user exists or not
     */
    public boolean findUser(String username, String password) {
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
    public boolean findUsername(String username) {
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
    public void addUser(String username, String password) {
        username_password.put(username, password);
    }

    /**
     * clones PasswordManager class
     * 
     * @return PasswordManager clone
     */
    @Override
    public PasswordManager clone() {
        PasswordManager copy = new PasswordManager();

        if (username_password == null) {
            return copy;
        }

        username_password.forEach((username, password) -> {
            copy.addUser(username, password);
        });

        return copy;
    }
}
