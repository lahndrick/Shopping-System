
/**
 *
 * @author Lahndrick Hendricks
 */
public class RemoveItemFromCart {

    private ShoppingCart cart;

    public RemoveItemFromCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public String greetMessage() {
        String output = "";
        output += "Items currently in cart:" + "\n";
        output += cart.toString() + "\n";
        output += "Which item would you like to remove?" + "\n";

        return output;
    }

    public boolean remove(int n) {
        n--;
        int size = cart.getSize();
        cart.removeItem(n);

        if (size == cart.getSize()) {
            System.out.println("Error removing stock.");
            return false;
        } else {
            System.out.println("Item removed successfully.");
            return true;
        }
    }
}
