import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 *
 * This class is used to create users, it includes the methods checkUsername and constructor CreateUser
 * 
 */
public class CreateUser extends DatabaseManager {

    private User user;
    private boolean check;

    //when user is created, it first checks whether the username is available
    public CreateUser(String username, String password) {
        boolean nameCheck = this.checkUsername(username);
        check = false;

        if (nameCheck) {
            user = new User(username, password);
            check = true;
            writeToUserList(user);
        } else {
            check = false;
        }
    }

    //boolean method used to check whether an username is available
    public boolean checkUsername(String username) {
        ArrayList<String[]> usernames;
        String[] userGrab = new String[2];

        String nameCheck = username.trim();

        if (nameCheck.isEmpty()) {
            return false;
        }

        if (this.readFromUserList() != null) {

            usernames = this.readFromUserList();

            for (int x = 0; x < usernames.size(); x++) {
                //splits user into username (0) and password (1)
                userGrab = usernames.get(x);

                //if username is taken or blank
                if (nameCheck.equalsIgnoreCase(userGrab[0]) || username.equalsIgnoreCase("")) {
                    return false;
                }
            }
        }

        return true;
    }

    public User getUser() {
        return this.user;
    }

    public boolean getCheck() {
        return check;
    }
}
