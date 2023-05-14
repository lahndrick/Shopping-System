
/**
 *
 * @author Lahndrick Hendricks
 */
//interface created instead of class as central manager (DatabaseManager.java) needs to interact with 3 different tables (userlist, transaction log and inventory)
public abstract interface TransactionManager {

    public String[] readFromTransactionLog();
    public void writeToTransactionLog(String username, Double total);
}
