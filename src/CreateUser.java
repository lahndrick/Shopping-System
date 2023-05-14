import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 * 
 * This class is used to create users, it includes the methods checkUsername, addToList and constructor CreateUser
 * 
 * checkUsername: this method reads through the list of users and checks whether the given username has already been granted to someone
 * addToList: this method adds the username to a txt file called userlist.txt that lists all other usernames already chosen
 * CreateUser(2 input): this constructor uses both the checkUsername and addToList methods to first verify whether the chosen username is available, then add that username to the list
 */
public class CreateUser extends DatabaseManager {
    
    private User user;
    private boolean check;
    
    //when user is created, it first checks whether the username is available
    public CreateUser(String username, String password) {
        boolean nameCheck = this.checkUsername(username);
        check = false;
        
        if(nameCheck) {
            user = new User(username, password);
            check = true;
            writeToUserList(user);
        } else {
            System.out.println("Username already taken.");
            check = false;
        }
    }
    
    //boolean method used to check whether an username is available
    public boolean checkUsername(String username) {
        ArrayList<String[]> usernames;
        String[] userGrab = new String[2];
        
        String nameCheck = username.trim();
        
        if(nameCheck.isEmpty()) {
            return false;
        }
        
        if(this.readFromUserList() != null){
            
            usernames = this.readFromUserList();
            
            for(int x = 0;x < usernames.size();x++) {
                //splits user into username (0) and password (1)
                userGrab = usernames.get(x);
                
                //if username is taken or blank
                if(nameCheck.equalsIgnoreCase(userGrab[0]) || username.equalsIgnoreCase("")) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public User getUser(){
        return this.user;
    }
    
    public boolean getCheck() {
        return check;
    }
}
