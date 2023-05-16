import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lahndrick Hendricks
 */
public class UserTest {

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetSetPassword() {
        User instance = new User("","");
       
        String expResult = "123";
        instance.setPassword(expResult);
        String result = instance.getPassword();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetSetUsername() {
        User instance = new User("","");
        
        String expResult = "123";
        instance.setUsername(expResult);
        String result = instance.getUsername();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        User instance = new User("test","test");
        
        String expResult = "test, password: ???";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
