
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lahndrick Hendricks
 */
//class for removing a user if person knows both username and password
public class RemoveUser extends FileManager {

    private String username;
    private String password;    

    //for users removing their own account
    public RemoveUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");

        while (true) {
            username = scan.nextLine();

            if (!username.trim().isEmpty()) {
                break;
            }

            System.out.println("Input error.");
        }

        System.out.println("Password:");

        while (true) {
            password = scan.nextLine();

            if (!password.trim().isEmpty()) {
                break;
            }

            System.out.println("Input error.");
        }

        new FileManager().removeUser(username, password);
    }

    //for when an admin removes the user
    public RemoveUser(String confirm, String username) {
        ArrayList users = new FileManager().readFromUserList();
        String[] line = new String[2];

        for (int x = 0; x < users.size(); x++) {
            line = users.get(x).toString().split(":");

            if (username.equalsIgnoreCase(line[0])) {
                new FileManager().removeUser(username, line[1]);
            }
        }
    }
}
