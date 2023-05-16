
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManagerTest {

    private DatabaseManager manager;

    @Before
    public void setUp() {
        manager = new DatabaseManager();
    }

    @After
    public void cleanDatabaseTransactions() {
        try {
            Connection conn = manager.getConnection();
            String query = "DELETE FROM TRANSACTIONLOG WHERE username = 'TestUser'";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Test of readFromTransactionLog and writeToTransactionLog methods, of
     * class DatabaseManager.
     */
    @Test
    public void testTransactionReadAndWrite() {
        manager.writeToTransactionLog("TestUser", 12.00);
        String[] result = manager.readFromTransactionLog();
        String expResult = "TestUser,12.0";

        assertEquals(expResult, result[result.length - 1]);

    }

    /**
     * Test of writeItemToInventory method, of class DatabaseManager.
     */
    @Test
    public void testWriteItemToInventory() {
        String name = "TEST";
        Double cost = 0.5;
        DatabaseManager instance = new DatabaseManager();
        instance.writeItemToInventory(name, cost);
        Item[] returns = instance.readFromInventory();

        String result = returns[returns.length - 1].toString();
        String expResult = name + ", $" + cost;

        assertEquals(expResult, result);
    }

    /**
     * Test of removeItemFromInventory method, of class DatabaseManager.
     */
    @Test
    public void testRemoveItemFromInventory() {
        String name = "TEST";
        DatabaseManager instance = new DatabaseManager();

        instance.removeItemFromInventory(name);
        Item[] testArray = instance.readFromInventory();

        boolean expResult = false;
        boolean result = false;

        for (int x = 0; x < testArray.length; x++) {
            if (testArray[x].getName().equalsIgnoreCase(name)) {
                result = true;
            }
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of writeToUserList method, of class DatabaseManager.
     */
    @Test
    public void testWriteToUserList() {
        User user = new User("test", "test");
        DatabaseManager instance = new DatabaseManager();
        instance.writeToUserList(user);

        ArrayList<String[]> testCases = instance.readFromUserList();

        int expResult = 1;
        int result = 0;

        for (int x = 0; x < testCases.size(); x++) {
            if (testCases.get(x)[0].equalsIgnoreCase(user.getUsername())) {
                result++;
            }
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of removeUser method, of class DatabaseManager.
     */
    @Test
    public void testRemoveUser() {
        DatabaseManager instance = new DatabaseManager();
        instance.removeUserAdmin("test");
        int expResult = 0;
        int result = 0;

        ArrayList<String[]> testCases = instance.readFromUserList();

        for (int x = 0; x < testCases.size(); x++) {
            if (testCases.get(x)[0].equalsIgnoreCase("test")) {
                result++;
            }
        }

        assertEquals(expResult, result);
    }

}
