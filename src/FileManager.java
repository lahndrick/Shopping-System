
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
public class FileManager implements TransactionManager, InventoryManager, UserListManager {

    private File inventoryFile;
    private File transactionLog;
    private File userList;

    public FileManager() {
        inventoryFile = new File("./src/inventory.txt");
        transactionLog = new File("./src/transactionlog.txt");
        userList = new File("./src/userlist.txt");
    }

    //this method takes the inventory and writes each items name and cost to a txt file
    @Override
    public void writeToInventory(Inventory inv) {
        String stock = "";

        try {
            //overwrites the txt file instead of adding to it
            PrintWriter pw = new PrintWriter(new FileOutputStream(inventoryFile, true));

            for (int x = 0; x < inv.getSize(); x++) {
                stock += inv.getItem(x).toString() + "\n";
            }
            pw.write(stock);
            pw.close();

        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }
    }

    //similar to writeToInventory except wipes the previous information in the txt file first
    @Override
    public void writeToInventoryAfterWipe(Inventory inv) {
        String stock = "";

        try {
            //overwrites the txt file instead of adding to it
            PrintWriter pw = new PrintWriter(new FileOutputStream(inventoryFile));

            for (int x = 0; x < inv.getSize(); x++) {
                stock += inv.getItem(x).toString() + "\n";
            }
            pw.write(stock);
            pw.close();

        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }
    }

    //reads from the inventory.txt files and adds items into the inventory
    @Override
    public void readFromInventory(Inventory inv) {

        String line;
        String[] seperatedLine = new String[2];

        try {
            BufferedReader br = new BufferedReader(new FileReader(inventoryFile));

            while ((line = br.readLine()) != null) {
                seperatedLine = line.split(", \\$");
                inv.addItem(new Item(seperatedLine[0].trim(), Double.parseDouble(seperatedLine[1].trim())));
            }

            br.close();
        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }
    }

    //writes all completed transactions to a txt file
    @Override
    public void writeToTransactionLog(CartFinaliser cart) {

        try {
            String line;
            PrintWriter pw = new PrintWriter(new FileOutputStream(transactionLog, true));

            line = cart.getUser().getUsername() + ":" + cart.getTotal();
            pw.println(line);

            pw.close();
        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }
    }

    //reads from transactionlog.txt and adds together all the completed transactions of a user
    @Override
    public String readFromTransactionLog(String username) {

        String returnLine = "";
        String line = "";
        String[] seperatedLine = new String[2];

        try {
            BufferedReader br = new BufferedReader(new FileReader(transactionLog));

            while ((line = br.readLine()) != null) {

                //split username and total cost
                seperatedLine = line.split(":");

                //if the usernames match, transaction is added to list
                if (seperatedLine[0].equalsIgnoreCase(username)) {
                    returnLine += seperatedLine[0] + ", total: $" + seperatedLine[1] + "\n";
                }
            }

            br.close();
        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }

        return returnLine;
    }

    //writes the given user's username and password to a txt file
    @Override
    public void writeToUserList(User user) {

        if (user != null) {
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(userList, true));
                pw.println(user.getUsername().trim().toLowerCase() + ":" + user.getPassword().trim());
                pw.close();
            } catch (Exception e) {
                //creates necessary files if they arent created
                new CreateFiles();
            }
        }
    }

    //similar to writeToUserList except wipes the previous information in the txt file first
    public void writeToUserListAfterWipe(ArrayList list) {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(userList));

            for (int x = 0; x < list.size(); x++) {
                pw.println(list.get(x));
            }

            pw.close();

        } catch (Exception e) {
            //creates necessary files if they arent created
            new CreateFiles();
        }
    }

    //returns an array containing all the usernames extracted from a txt file
    @Override
    public ArrayList<String> readFromUserList() {

        String line = "";
        ArrayList<String> list = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader(userList));
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();
        } catch (IOException ex) {
            //creates necessary files if they arent created
            new CreateFiles();
        }

        return list;
    }

    //uses 2 checks and information gathered using readFromUserList() to remove a user from the txt file
    @Override
    public void removeUser(String username, String password) {
        int passCount = 0;
        String checkedUser = username + ":" + password;
        ArrayList<String> newUserList = new ArrayList();
        ArrayList<String> oldUserList = readFromUserList();

        //adding all users into a new 
        for (int x = 0; x < oldUserList.size(); x++) {
            if (!checkedUser.equalsIgnoreCase(oldUserList.get(x))) {
                newUserList.add(oldUserList.get(x));
            }
        }

        //first count added if new list is 1 less than old
        if (newUserList.size() == (oldUserList.size() - 1)) {
            passCount++;
        }

        //second check takes away a count if the user is still in the ArrayList
        for (int x = 0; x < newUserList.size(); x++) {
            if (newUserList.get(x).equalsIgnoreCase(checkedUser)) {
                passCount--;
            }
        }

        //if both checks are passed 
        if (passCount == 1) {
            writeToUserListAfterWipe(newUserList);
            System.out.println("User removed successfully");
        } else {
            System.out.println("User removal unsuccessful");
        }
    }
}
