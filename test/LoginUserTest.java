
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class LoginUserTest {

    /**
     * Test of testLogin method, of class LoginUser.
     */
    @Test
    public void testTestLogin() {
        String username = "non-existing user";
        String password = "test";
        LoginUser instance = new LoginUser(username, password, new User(username, password));
        boolean expResult = false;
        boolean result = instance.getProceed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class LoginUser.
     */
    @Test
    public void testGetUser() {
        String username = "non-existing user";
        String password = "test";
        LoginUser instance = new LoginUser(username, password, new User(username, password));
        String expResult = username;
        String result = instance.getUser().getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProceed method, of class LoginUser.
     */
    @Test
    public void testGetProceed() {
        String username = "non-existing user";
        String password = "test";
        LoginUser instance = new LoginUser(username, password, new User(username, password));

        int expResult = 2;
        int result = 0;

        if (!instance.getProceed()) {
            result++;
        }

        username = "username";
        password = "password";
        instance = new LoginUser(username, password, new User(username, password));

        if (instance.getProceed()) {
            result++;
        }

        assertEquals(expResult, result);
    }

}
