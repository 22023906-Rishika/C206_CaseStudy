import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TestUserMain {

	public static ArrayList<Users> userList = new ArrayList<Users>();

    public TestUserMain() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Prepare test data
    	
    }

    @Test
    public void testAddUser() {
        // Given an empty list, after adding 1 item, the size of the list is 1
        Users Alice = new Users("Alice", "Student", false, "22023303");
        UsersMain.addUser(userList, Alice);
        assertEquals("Test that the User ArrayList size is 1.", 1, userList.size());

        // Test contents are the same
        assertSame("Test that the User ArrayList's first element is the same object Alice.", Alice, userList.get(0));
    }

    @Test
    public void testDelUser() {
        // Test that the list contains elements to delete
        Users Dave = new Users("Dave", "Student", false, "21034675");
        userList.add(Dave);
        assertTrue("Test if there are elements in the User ArrayList to delete", userList.contains(Dave));

        userList.remove(Dave);
        assertFalse(userList.contains(Dave));

        assertEquals("Test that the User ArrayList is empty.", 0, userList.size());
    }
}
