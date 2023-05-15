
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManager implements TransactionManager, InventoryManager, UserListManager {

    private static final String USER_NAME = "lahn"; //DB username
    private static final String PASSWORD = "lahn"; //DB password
    private static final String URL = "jdbc:derby:ShoppingDatabase;create=true";  //url of the DB

    public DatabaseManager() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Driver error");
        }
    }

    //method to read from transaction table and return it as a string[]
    @Override
    public String[] readFromTransactionLog() {
        String[] result = null;

        try {
            ArrayList<String> list = new ArrayList<>();
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT total, username FROM transactionlog";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                double totalPaid = resultSet.getDouble("total");
                list.add(user + "," + totalPaid);
            }

            result = new String[list.size()];
            if (result != null) {
                for (int x = 0; x < list.size(); x++) {
                    result[x] = list.get(x);
                }
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return result;
    }

    //method to write to transaction table
    @Override
    public void writeToTransactionLog(String username, Double cost) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "INSERT INTO transactionlog (username, total) VALUES ('" + username + "', " + cost + ")";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    //method to write inventory object to the inventory table
    @Override
    public void writeToInventory(Inventory inv) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String query = "";

            for (int x = 0; x < inv.getSize(); x++) {
                query = "INSERT INTO Inventory (name, cost) VALUES ('" + inv.getItem(x).getName() + "', " + inv.getItem(x).getCost() + ")";
                statement.executeUpdate(query);
            }

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    //method to add one item to the table instead of the whole inventory
    @Override
    public void writeItemToInventory(String name, Double cost) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String query = "";

            query = "INSERT INTO Inventory (name, cost) VALUES ('" + name + "', " + cost + ")";
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    //method to remove on item from the table
    @Override
    public void removeItemFromInventory(String name) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = conn.createStatement();
            String query = "";

            query = "DELETE FROM Inventory WHERE name = '" + name + "'";
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

//method to read from inventory table and update the inventory object with it
    @Override
    public Item[] readFromInventory() {
        Item[] items = null;

        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT name, cost FROM Inventory";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Item> list = new ArrayList();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double totalPaid = resultSet.getDouble("cost");
                list.add(new Item(name, totalPaid));
            }

            items = new Item[list.size()];
            for (int x = 0; x < items.length; x++) {
                items[x] = list.get(x);
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return items;
    }

    //method to add a user to user table
    @Override
    public void writeToUserList(User user) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String name = user.getUsername();
            String password = user.getPassword();

            String query = "INSERT INTO userlist (username, password) VALUES ('" + name + "', '" + password + "')";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    //method to read from user table
    @Override
    public ArrayList<String[]> readFromUserList() {
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "SELECT username,password FROM userlist";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String[] line = {username, password};

                list.add(line);
            }

            //resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        return list;
    }

    //method to remove a user from user table if username and password known
    @Override
    public void removeUser(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "DELETE FROM userlist WHERE username = '" + username + "' AND password = '" + password + "'";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    //same as removeUser method but only username is required, used by the admin user
    public void removeUserAdmin(String username) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String query = "DELETE FROM userlist WHERE username = '" + username + "'";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        return null;
    }
}
