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
        String[] items = new String[stock.size()];

        for (int x = 0;x < stock.size();x++) {
            items[x] = getItem(x).toString();
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