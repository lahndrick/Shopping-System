
import javax.swing.JOptionPane;

/**
 * this class is used to finalise the shopping cart and add it to the transaction log table
 */

/**
 * @author Lahndrick Hendricks
 */
public class CartFinaliser extends ShoppingCart {

    private User user;
    private DatabaseManager fileMan;
    private double total;
    //ATTENTION test value is for disabling JOptionPane in test case, do not adjust otherwise  
    private boolean test;

    public CartFinaliser(User user, ShoppingCart cart) {
        this.user = user;
        fileMan = new DatabaseManager();
        this.total = cart.getTotal();
        test = false;
    }

    //write the transaction to transaction log
    public void addTransaction() {
        if (total > 0) {
            if (!test) {
                JOptionPane.showMessageDialog(null, "Transaction completed, thank you for your business");
            }
            fileMan.writeToTransactionLog(user.getUsername(), total);
        } else {
            JOptionPane.showMessageDialog(null, "Cart is empty");
        }
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public double getTotal() {
        return total;
    }

    //ATTENTION this is for disabling JOptionPane in test case, do not adjust otherwise
    public boolean getTest() {
        return test;
    }

    //ATTENTION this is for disabling JOptionPane in test case, do not adjust otherwise
    public void setTest() {
        this.test = true;
    }
}
