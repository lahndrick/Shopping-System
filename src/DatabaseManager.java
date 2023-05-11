
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManager implements TransactionManager, InventoryManager, UserListManager {

    private static final String USER_NAME = "lahn"; //DB username
    private static final String PASSWORD = "lahn"; //DB password
    private static final String URL = "jdbc:derby:ShoppingDatabase;create=true";  //url of the DB

    //method to read from transaction table and return it as a string[]
    @Override
    public String[] readFromTransactionLog() {
        String[] result = null;

        try {
            ArrayList<String> list = new ArrayList<>();
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT username, total_paid FROM Transactions";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                double totalPaid = resultSet.getDouble("total_paid");
                list.add(user + "," + totalPaid);
            }

            result = list.toArray(new String[list.size()]);

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while reading from transaction log.");
        }

        return result;
    }

    //method to write to transaction table
    @Override
    public void writeToTransactionLog(String username, Double cost) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "INSERT INTO Transactions (username, total_paid) VALUES ('" + username + "', " + cost + ")";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while writing to transaction log.");
        }
    }

    //method to write inventory object to the inventory table
    @Override
    public void writeToInventory(Inventory inv) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = null;
            Statement statement = null;

            for (int x = 0; x < inv.getSize(); x++) {
                String name = inv.getItem(x).getName();
                Double cost = inv.getItem(x).getCost();

                query = "INSERT INTO Inventory (item, cost) VALUES ('" + name + "', " + cost + ")";
                statement = conn.createStatement();
                statement.executeUpdate(query);
            }

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while writing to inventory list.");
        }
    }

    //method to read from inventory table and update the inventory object with it
    @Override
    public void readFromInventory(Inventory inv) {
        try {
            ArrayList<String> list = new ArrayList<>();
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT username, total_paid FROM Transactions";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            //wipe the existing inventory to add the items from database
            inv = new Inventory();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                double totalPaid = resultSet.getDouble("total_paid");
                inv.addItem(new Item(user, totalPaid));
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while reading from inventory list.");
        }
    }

    //method to add a user to user table
    @Override
    public void writeToUserList(User user) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String name = user.getUsername();
            String password = user.getUsername();

            String query = "INSERT INTO userlist (item, password) VALUES ('" + name + "', " + password + ")";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while writing to inventory list.");
        }
    }

    //method to read from user table
    @Override
    public ArrayList<String> readFromUserList() {
        ArrayList<String> list = null;

        try {
            list = new ArrayList<>();
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT * FROM Transactions";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                list.add(resultSet.getString("username") + ":" + resultSet.getString("password"));
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while reading from inventory list.");
        }

        return list;
    }

    //method to remove a user from user table if username and password known
    @Override
    public void removeUser(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "DELETE FROM userlist WHERE username = '" + username + "', and password = '" + password + "'  ";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while writing to inventory list.");
        }
    }

    //same as removeUser method but only username is required, used by the admin user
    public void removeUserAdmin(String username) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "DELETE FROM userlist WHERE username = '" + username;

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while writing to inventory list.");
        }
    }
}
