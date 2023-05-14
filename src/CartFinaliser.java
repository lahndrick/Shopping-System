
import javax.swing.JOptionPane;

/*
* this class is used to finalise the shopping cart and add it to the transaction log table

/**
 *
 * @author Lahndrick Hendricks
 */
public class CartFinaliser extends ShoppingCart {

    private User user;
    private DatabaseManager fileMan;
    private double total;

    public CartFinaliser(User user, ShoppingCart cart) {
        this.user = user;
        fileMan = new DatabaseManager();
        this.total = cart.getTotal();
    }

    //write the transaction to transaction log
    public void addTransaction() {
        if (total > 0) {
            JOptionPane.showMessageDialog(null, "Transaction completed, thank you for your business");
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
}
