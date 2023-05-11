
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManagerTest {

    /**
     * Test of readFromTransactionLog method, of class DatabaseManager.
     */
    @Test
    public void testReadFromTransactionLog() {
        System.out.println("readFromTransactionLog");
        DatabaseManager instance = new DatabaseManager();
        String[] expResult = null;
        String[] result = instance.readFromTransactionLog();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToTransactionLog method, of class DatabaseManager.
     */
    @Test
    public void testWriteToTransactionLog() {
        System.out.println("writeToTransactionLog");
        String username = "";
        Double cost = null;
        DatabaseManager instance = new DatabaseManager();
        instance.writeToTransactionLog(username, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToInventory method, of class DatabaseManager.
     */
    @Test
    public void testWriteToInventory() {
        System.out.println("writeToInventory");
        Inventory inv = null;
        DatabaseManager instance = new DatabaseManager();
        instance.writeToInventory(inv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFromInventory method, of class DatabaseManager.
     */
    @Test
    public void testReadFromInventory() {
        System.out.println("readFromInventory");
        Inventory inv = null;
        DatabaseManager instance = new DatabaseManager();
        instance.readFromInventory(inv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToUserList method, of class DatabaseManager.
     */
    @Test
    public void testWriteToUserList() {
        System.out.println("writeToUserList");
        User user = null;
        DatabaseManager instance = new DatabaseManager();
        instance.writeToUserList(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFromUserList method, of class DatabaseManager.
     */
    @Test
    public void testReadFromUserList() {
        System.out.println("readFromUserList");
        DatabaseManager instance = new DatabaseManager();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.readFromUserList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class DatabaseManager.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String username = "";
        String password = "";
        DatabaseManager instance = new DatabaseManager();
        instance.removeUser(username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUserAdmin method, of class DatabaseManager.
     */
    @Test
    public void testRemoveUserAdmin() {
        System.out.println("removeUserAdmin");
        String username = "";
        DatabaseManager instance = new DatabaseManager();
        instance.removeUserAdmin(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
