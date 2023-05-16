
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class InventoryTest {

    /**
     * Test of getStock method, of class Inventory.
     */
    @Test
    public void testGetStock() {
        Inventory instance = new Inventory();
        String[] result = instance.getStock();
        assertNotNull(result);
    }

    /**
     * Test of toString method, of class Inventory.
     */
    @Test
    public void testToString() {
        Inventory instance = new Inventory();
        String result = instance.toString();
        assertNotNull(result);
    }

    /**
     * Test of addItem method, of class Inventory.
     */
    @Test
    public void testAddItem() {
        Item item = new Item("invtest", 15);
        Inventory instance = new Inventory();

        int expResult = instance.getSize() + 1;
        instance.addItem(item);
        instance.writeToInventory(instance);
        int result = instance.getSize();

        instance.removeItemFromInventory(item.getName());
        assertEquals(expResult, result);
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void testRemoveItem() {
        Item item = new Item("invtest", 15);
        Inventory instance = new Inventory();
        instance.addItem(item);
        int expResult = instance.getSize() - 1;

        instance.removeItem(item);
        int result = instance.getSize();

        assertEquals(expResult, result);
    }
}
