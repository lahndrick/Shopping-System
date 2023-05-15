
import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
public class Inventory extends DatabaseManager {

    //array list was chosen as items don't need to be unique
    private ArrayList<Item> stock;

    public Inventory() {
        this.stock = new ArrayList();
    }

    //returns an array containing all the items in inventory
    public String[] getStock() {
        Item[] items = readFromInventory();
        stock = new ArrayList();
        String returnString = "";

        for (int x = 0; x < items.length; x++) {
            returnString += items[x].toString() + "\n";
            stock.add(items[x]);
        }

        if (stock.size() < 1) {
            returnString = "No items in stock";
        }

        return returnString.split("\n");
    }

    @Override
    public String toString() {
        Item[] items = readFromInventory();
        String output = "";

        for (int x = 0; x < items.length; x++) {
            output += items[x].toString() + "\n";
        }

        return output;
    }

    public int getSize() {
        Item[] items = readFromInventory();
        stock = new ArrayList();

        for (int x = 0; x < stock.size(); x++) {
            stock.add(items[x]);
        }

        return stock.size();
    }

    public void addItem(Item item) {
        if (this.checkItemName(item.getName()) && item.getCost() > 0) {
            stock.add(item);
        }
    }

    public void removeItem(Item item) {
        stock.remove(item);
    }

    //takes the inventory and writes it into the inventory.txt file
    public void writeStock() {
        this.writeToInventory(this);
    }

    public Item getItem(int n) {
        if (n < stock.size() && n >= 0) {
            return stock.get(n);
        }
        return null;
    }

    //to check if the name of an item is already used
    public boolean checkItemName(String name) {

        for (int x = 0; x < this.getSize(); x++) {
            if (name.equalsIgnoreCase(this.getItem(x).getName())) {
                return false;
            }
        }
        return true;
    }
}
