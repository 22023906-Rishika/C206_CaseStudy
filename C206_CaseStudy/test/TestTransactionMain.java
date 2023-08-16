import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTransactionMain {
	public Transaction a; 
	public Transaction b; 
	public Transaction c; 
	public Transaction d;
	
	public Account TestAccount;
	
	
	public ArrayList<Transaction> TransactionList = new ArrayList <Transaction>();
	
	public TestTransactionMain() { 
		super();
	}
	@Before 
	public void setUp() throws Exception {
		// prepare test data 
	
	a = new Transaction(0001, TestAccount, 8965, 48231.7, "Yuan");
	b = new Transaction(0002, TestAccount, 6318, 2264.9, "Ringgit");
	c = new Transaction(0003, TestAccount, 187, 549140.46, "Pesco");
	d = new Transaction(0004, TestAccount, 927, 57409.11, "Rupee");
	
}
	
	@Test 
	public void testAddTrans() {
		// Item list is not null and it is empty 
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Transaction ArrayList to add to", TransactionList);
		assertEquals("Test that the Transaction ArrayList is empty.", 0, TransactionList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		TransactionMain.addTransaction(TransactionList);
		assertEquals("Test that the Transaction ArrayList size is 1.", 1, TransactionList.size());

		//Test contents are the same
		assertSame("Test that the Transaction ArrayList's first element is the same object a.",a,TransactionList.get(0));
	}
	
	@Test 
	public void testDelTrans() {
		//Item list is not null and it is empty 
		assertNotNull("Test if there is valid Transction ArrayList to add to", TransactionList);
		//Test that the list contains elements to delete
		TransactionList.add(b);
		assertTrue("Test if there are elements in the Transaction ArrayList to delete",TransactionList.contains(b));

		TransactionList.remove(b);
		assertFalse(TransactionList.contains(b));

		assertEquals("Test that the Transaction ArrayList is empty.", 0, TransactionList.size());

	}
	}
	