/**
 *
 * @author Lahndrick Hendricks
 */

//interface created instead of class as central manager (FileManager.java) needs to interact with 3 different files (userlist.txt, transactionlog.txt and inventory.txt)
//therefor needs to implement 3 instead of extend to only 1
public abstract interface InventoryManager {
    
    public void writeToInventory(Inventory inv);
    public void readFromInventory(Inventory inv);
}