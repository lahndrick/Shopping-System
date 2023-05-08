import java.util.ArrayList;

/**
 *
 * @author Lahndrick Hendricks
 */
public class DatabaseManager implements TransactionManager, InventoryManager, UserListManager{

    //method to read from transaction table
    @Override
    public String readFromTransactionLog(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to write to transaction table
    @Override
    public void writeToTransactionLog(CartFinaliser cart) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to write to inventory table
    @Override
    public void writeToInventory(Inventory inv) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to read from inventory table
    @Override
    public void readFromInventory(Inventory inv) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to write to inventory table after deleting table
    @Override
    public void writeToInventoryAfterWipe(Inventory inv) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to write to user table
    @Override
    public void writeToUserList(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to read from user table
    @Override
    public ArrayList<String> readFromUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }

    //method to remove a user from user table
    @Override
    public void removeUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO
    }
    
}
