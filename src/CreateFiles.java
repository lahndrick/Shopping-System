
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CreateFiles {

    public CreateFiles() {
        File file1 = new File("./src/inventory.txt");
        File file2 = new File("./src/transactionlog.txt");
        File file3 = new File("./src/userlist.txt");

        try {
            if (file1.createNewFile() && file2.createNewFile() && file3.createNewFile()) {
                file1.createNewFile();
                file2.createNewFile();
                file3.createNewFile();
            }
        } catch (IOException e) {

        }
    }
}
