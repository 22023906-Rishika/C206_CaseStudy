import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class TestTransactionMain {

	// Test data preparation
	public Account testAdminAcc;
	public Users testAdmin;

	public ArrayList<Transaction> transList =  new ArrayList<Transaction>();

	public TestTransactionMain() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		testAdmin = new Users("Admin01","Test Admin",true,"001");
		testAdminAcc = new Account(testAdmin,"Admin0811","12345",92287068,30000);


	}


	@Test
	public void testAddTrans() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Transaction ArrayList to add to", transList);
		assertEquals("Test that the Transaction ArrayList is empty.", 0, transList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		TransactionMain.addTransaction(transList,testAdminAcc);
		assertEquals("Test that the Transaction ArrayList size is 1.", 1, transList.size());

	}

//	@Test
//	public void testDelCurr() {
//
//		// Item list is not null and it is empty
//		assertNotNull("Test if there is valid Transaction ArrayList to add to", transList);
//		//Test that the list contains elements to delete
//		transList.add(INR);
//		assertTrue("Test if there are elements in the Transaction ArrayList to delete",transList.contains(INR));
//
//		transList.remove(INR);
//		assertFalse(transList.contains(INR));
//
//		assertEquals("Test that the Transaction ArrayList is empty.", 0, transList.size());
//
//	}
	
	
	
}
