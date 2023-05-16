
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CartFinaliserTest extends DatabaseManager {

    @After
    public void cleanDatabaseTransactions() {
        try {
            Connection conn = super.getConnection();
            String query = "DELETE FROM TRANSACTIONLOG WHERE username = 'CartFinaliserTest'";

            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Test of addTransaction method, of class CartFinaliser.
     */
    @Test
    public void testAddTransaction() {
        User user = new User("CartFinaliserTest", "123");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("test", 1585.75));
        CartFinaliser instance = new CartFinaliser(user, cart);

        instance.setTest();
        instance.addTransaction();
        String[] transactions = super.readFromTransactionLog();

        boolean expResult = true;
        boolean result = false;
        String[] line = transactions[transactions.length - 1].split(",");

        if (line[0].equalsIgnoreCase("CartFinaliserTest")) {
            result = true;
        }
        
        assertEquals(expResult, result);
    }
}
