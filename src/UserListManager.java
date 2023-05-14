
import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
//interface created instead of class as central manager (DatabaseManager.java) needs to interact with 3 different tables (userlist, transaction log and inventory)
public abstract interface UserListManager {

    public void writeToUserList(User user);
    public ArrayList<String[]> readFromUserList();
    public void removeUser(String username, String password);
}
