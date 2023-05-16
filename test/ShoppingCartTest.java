
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class ShoppingCartTest {

    /**
     * Test of getTotal method, of class ShoppingCart.
     */
    @Test
    public void testGetTotal() {
        ShoppingCart instance = new ShoppingCart();
        Item item = new Item("test", 15);
        instance.addItem(item);

        double expResult = item.getCost();
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     */
    @Test
    public void testRemoveItem_Item() {
        Item item = new Item("test", 15);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(item);
        int expResult = instance.getSize() - 1;
        
        instance.removeItem(item);
        int result = instance.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of removeItem method, of class ShoppingCart.
     */
    @Test
    public void testRemoveItem_int() {
        Item item = new Item("test", 15);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(item);
        int expResult = instance.getSize() - 1;
        
        instance.removeItem(0);
        int result = instance.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ShoppingCart.
     */
    @Test
    public void testToString() {
        Item item = new Item("test", 15);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(item);
        
        String expResult = "1. test, $15.0\n";
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of clearCart method, of class ShoppingCart.
     */
    @Test
    public void testClearCart() {
        Item item = new Item("test", 15);
        ShoppingCart instance = new ShoppingCart();
        instance.addItem(item);
        
        int expResult = instance.getSize() - 1;
        
        instance.clearCart();
        int result = instance.getSize();
        
        assertEquals(expResult, result);
    }

}
