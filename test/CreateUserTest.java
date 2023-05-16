import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class CreateUserTest {

    /**
     * Test of checkUsername method, of class CreateUser.
     */
    @Test
    public void testCheckUsername() {
        CreateUser user = new CreateUser("lahndrick", "123");
        boolean expResult = false;
        boolean result = user.checkUsername("lahndrick");
        assertEquals(expResult, result);
    }

}
