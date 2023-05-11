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
    
    //when user is created, it first checks whether the username is available
    public CreateUser(String username, String password) {
        boolean nameCheck = this.checkUsername(username);
        
        if(nameCheck) {
            user = new User(username, password);
            addToList(user);
            System.out.println("User created.");
        } else {
            System.out.println("Username already taken.");
        }
    }
    
    //boolean method used to check whether an username is available
    public boolean checkUsername(String username) {
        ArrayList<String> usernames;
        String[] userGrab = new String[2];
        
        String nameCheck = username.trim();
        
        if(nameCheck.isEmpty()) {
            System.out.println("Username is empty");
            return false;
        }
        
        if(this.readFromUserList() != null){
            
            usernames = this.readFromUserList();
            
            for(int x = 0;x < usernames.size();x++) {
                //splits user into username (0) and password (1)
                userGrab = usernames.get(x).split(":");
                
                //if username is taken or blank
                if(nameCheck.equalsIgnoreCase(userGrab[0]) || username.equalsIgnoreCase("")) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //add to txt file
    public void addToList(User user) {
        this.writeToUserList(user);
    }
    
    public User getUser(){
        return this.user;
    }
}
