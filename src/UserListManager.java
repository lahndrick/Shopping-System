import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */

//interface created instead of class as central manager (FileManager.java) needs to interact with 3 different files (userlist.txt, transactionlog.txt and inventory.txt)
//therefor needs to implement 3 instead of extend to only 1
public abstract interface UserListManager {
    
    public void writeToUserList(User user);
    public ArrayList<String> readFromUserList();
    public void removeUser(String username,String password);
}