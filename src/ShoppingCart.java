
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lahndrick Hendricks
 */
public class ShoppingCart {

    private ArrayList<Item> cart;
    private boolean pickup;

    public ShoppingCart() {
        this.cart = new ArrayList();
        this.pickup = false;
    }

    public void setPickup(Boolean pickup) {
        this.pickup = pickup;
    }

    public double getTotal() {
        double total = 0;

        //loop through and add cost of all items
        for (int x = 0; x < cart.size(); x++) {
            total += cart.get(x).getCost();
        }

        //if customer decides to ship instead of pickup, $10 charged for shipping
        if (pickup == false) {
            total += 10;
        }

        return total;
    }

    public void addItem(Item item) {
        if (item != null) {
            this.cart.add(item);
        }
    }

    public void removeItem(Item item) {
        this.cart.remove(item);
    }

    public void removeItem(int n) {
        this.cart.remove(n);
    }

    //loops through the cart and returns each item with a number allocated
    @Override
    public String toString() {
        Collections.sort(cart);
        String output = "";

        for (int x = 0; x < cart.size(); x++) {
            output += (x + 1) + ". " + cart.get(x).toString() + "\n";
        }

        output += "\nTotal: " + (this.getTotal() - 10);

        return output;
    }

    public ArrayList<Item> getCart() {
        return this.cart;
    }

    public void clearCart() {
        this.cart.clear();
    }

    public int getSize() {
        return cart.size();
    }
}
