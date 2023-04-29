/**
 *
 * @author Lahndrick Hendricks
 */
//interface created instead of class as central manager (FileManager.java) needs to interact with 3 different files (userlist.txt, transactionlog.txt and inventory.txt)
//therefor needs to implement three instead of extend to only one
public abstract interface TransactionManager {

    public String readFromTransactionLog(String username);
    public void writeToTransactionLog(CartFinaliser cart);
}
