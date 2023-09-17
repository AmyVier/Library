import java.util.HashMap;

public class PasswordManager {
    HashMap<String, String> username_password= new HashMap<>();

    public boolean findUser(String username, String password) {
        if (username_password.containsKey(username) && username_password.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findUsername(String username) {
        if (username_password.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(String username, String password) {
        username_password.put(username, password);
    }
}
