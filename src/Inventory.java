
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Lahndrick Hendricks
 */
public class Inventory extends FileManager {

    //set was chosen as items need to be unique
    private SortedSet<Item> stock;

    public Inventory() {
        this.stock = new TreeSet();
    }

    //returns an array containing all the items in inventory
    public Item[] getStock() {
        Item[] items = new Item[stock.size()];
        int x = 0;

        for (Item i : stock) {
            items[x] = i;
        }

        return items;
    }

    @Override
    public String toString() {
        String output = "";

        if (stock.size() > 0) {
            int counter = 0;

            for (Item i : stock) {
                counter++;
                output += counter + ". " + i.toString() + "\n";
            }
        } else {
            output = "Currently no stock";
        }

        return output;
    }

    public int getSize() {
        return stock.size();
    }

    public void addItem(Item item) {
        if (this.checkItemName(item.getName())) {
            stock.add(item);
        }
    }

    public void removeItem(Item item) {
        stock.remove(item);
    }

    //reads from the inventory.txt files and adds each line into the stock set
    public void retrieveStock() {
        this.readFromInventory(this);
    }

    //takes the inventory and writes it into the inventory.txt file
    public void writeStock() {
        this.writeToInventoryAfterWipe(this);
    }

    public Item getItem(int n) {
        int currentIndex = 0;

        if (n < stock.size() && n >= 0) {
            //loop through set until desired index is met, then return the Item at that index
            for (Item item : stock) {
                if (currentIndex == n) {
                    return item;
                }
                currentIndex++;
            }
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
