
/**
 *
 * @author Lahndrick Hendricks
 */

//interface created instead of class as central manager (DatabaseManager.java) needs to interact with 3 different tables (userlist, transaction log and inventory)
public abstract interface InventoryManager {

    public void writeToInventory(Inventory inv);
    public Item[] readFromInventory();
    public void writeItemToInventory(String name, Double cost);
    public void removeItemFromInventory(String name);
}
