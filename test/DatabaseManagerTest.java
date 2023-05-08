
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManagerTest {
    
    public DatabaseManagerTest() {
    
    }

    /**
     * Test of readFromTransactionLog method, of class DatabaseManager.
     */
    @Test
    public void testReadFromTransactionLog() {
        System.out.println("readFromTransactionLog");
        String username = "";
        DatabaseManager instance = new DatabaseManager();
        String expResult = "";
        String result = instance.readFromTransactionLog(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToTransactionLog method, of class DatabaseManager.
     */
    @org.junit.Test
    public void testWriteToTransactionLog() {
        System.out.println("writeToTransactionLog");
        CartFinaliser cart = null;
        DatabaseManager instance = new DatabaseManager();
        instance.writeToTransactionLog(cart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToInventory method, of class DatabaseManager.
     */
    @org.junit.Test
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
    @org.junit.Test
    public void testReadFromInventory() {
        System.out.println("readFromInventory");
        Inventory inv = null;
        DatabaseManager instance = new DatabaseManager();
        instance.readFromInventory(inv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToInventoryAfterWipe method, of class DatabaseManager.
     */
    @org.junit.Test
    public void testWriteToInventoryAfterWipe() {
        System.out.println("writeToInventoryAfterWipe");
        Inventory inv = null;
        DatabaseManager instance = new DatabaseManager();
        instance.writeToInventoryAfterWipe(inv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToUserList method, of class DatabaseManager.
     */
    @org.junit.Test
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
    @org.junit.Test
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
    @org.junit.Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        String username = "";
        String password = "";
        DatabaseManager instance = new DatabaseManager();
        instance.removeUser(username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
