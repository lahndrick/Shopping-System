
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class ItemTest {

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetSetName() {
        Item item = new Item("test1", 15);
        String expResult = "test2";
        item.setName(expResult);
        String result = item.getName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class Item.
     */
    @Test
    public void testGetSetCost() {
        Item item = new Item("test", 15);
        double expResult = 16;
        item.setCost(expResult);
        double result = item.getCost();
        
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of toString method, of class Item.
     */
    @Test
    public void testToString() {
        Item item = new Item("test", 15);
        
        String result = item.toString();
        String expResult = "test, $15.0";
        
        assertEquals(expResult, result);
    }

}
