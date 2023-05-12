
import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
public class LoginUser extends DatabaseManager {

    private User user;
    private boolean proceed;

    public LoginUser(String username, String password, User user) {

        this.user = user;
        this.proceed = false;

        if (testLogin(username, password)) {
            System.out.println("Welcome, " + username);
            this.proceed = true;
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    public boolean testLogin(String username, String password) {
        ArrayList<String[]> users = readFromUserList();
        String[] namePass = new String[2];

        if (users != null) {
            for (int x = 0; x < users.size(); x++) {
                namePass = users.get(x);
                //if username and password combination is found
                if (username.equalsIgnoreCase(namePass[0]) && password.equalsIgnoreCase(namePass[1])) {
                    user.setUsername(username);
                    user.setPassword(password);

                    return true;
                }

            }
        }

        return false;
    }

    public User getUser() {
        return this.user;
    }

    public boolean getProceed() {
        return this.proceed;
    }
}
