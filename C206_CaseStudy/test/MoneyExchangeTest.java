/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22037707, Aug 17, 2023 2:18:12 AM
 */

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */
public class MoneyExchangeTest {
	
	public Feedback Feedback1;
	public Feedback Feedback2;
	public Feedback Feedback3;
	public Feedback Feedback4;
	public static LocalDate date = LocalDate.now();
	public ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	
	public static ArrayList<Users> userList = new ArrayList<Users>();

	public Currency MYR;
	public Currency INR;
	public Currency CNY;
	public Currency COP;
	
	public Account testAdminAcc;
	public Users testAdmin;

	public ArrayList<Transaction> transList =  new ArrayList<Transaction>();
	

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
	public ArrayList<Currency> currList =  new ArrayList<Currency>();

	public MoneyExchangeTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		CNY = new Currency("China", "CNY","Yuan",5.38);
		MYR = new Currency("Malaysia","MYR","Ringgit",3.55);
		COP = new Currency("Columbia","COP","Peso", 2936.58);
		INR = new Currency("India","INR","Rupee",61.93);

		Feedback1 = new Feedback(1,date, 7, "Is good");
		Feedback2 = new Feedback(2,date, 6, "Is not good");
		Feedback3 = new Feedback(3,date, 4, "Is ok");
		Feedback4 = new Feedback(4,date, 9, "Is alrigh");

		System.setOut(new PrintStream(outputStreamCaptor));
		
		testAdmin = new Users("Admin01","Test Admin",true,"001");
		testAdminAcc = new Account(testAdmin,"Admin0811","12345",92287068,30000);

	}
	
	@Test
	public void testAddCurr() {
		MoneyExchange.isAdmin = true;
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Currency ArrayList to add to", currList);
		assertEquals("Test that the Currency ArrayList is not empty.", 0, currList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		CurrencyMain.addCurr(currList,CNY);
		assertEquals("Test that the Currency ArrayList size is 1.", 1, currList.size());

		//Test contents are the same
		assertSame("Test that the Currency ArrayList's first element is the same object CNY.",CNY,currList.get(0));
	}

	@Test
	public void testDelCurr() {
		MoneyExchange.isAdmin = true;
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Currency ArrayList to add to", currList);
		//Test that the list contains elements to delete
		
		CurrencyMain.addCurr(currList, INR);
		assertTrue("Test if there are elements in the Currency ArrayList to delete",currList.contains(INR));

		
		CurrencyMain.deleteCurr(currList, INR);
		assertFalse("Test deletion of INR object ",currList.contains(INR));
		
		
		CurrencyMain.deleteCurr(currList, COP);
		assertEquals("Test deletion of objects not in the list", 0, currList.size());

	}
	

	
	
	@Test
	public void testViewAllCurr() {
		
		
		assertNotNull("Test if there is valid Currency Arraylist",currList);
		
		String output = null;
		
		
		currList.add(CNY);
		currList.add(COP);
		CurrencyMain.currList.add(CNY);
		CurrencyMain.currList.add(COP);
		
		output = String.format("%-10s %-10s %-10s %-10s\n","COUNTRY","CODE","CURRENCY","RATE");

		for(Currency curr : currList) {
			output += String.format("%-10s %-10s %-10s %-10.2f\n", curr.getCountry(),curr.getCurrencyCode(),curr.getCurrencyName(),curr.getExchangeRate());
		}
		
		CurrencyMain.viewAllCurr(CurrencyMain.currList);
		
		assertEquals(output, outputStreamCaptor.toString());
		
	}
	
	@Test 
	public void testaddFeedback(){


		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Feedback ArrayList to add to", feedbackList);
		assertEquals("Test that the Feedback ArrayList is empty.", 0, feedbackList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		FeedbackMain.addFeedback(feedbackList,Feedback1);
		assertEquals("Test that the Feedback ArrayList size is 1.", 1, feedbackList.size());

		//Test contents are the same
		assertSame("Test that the Feedback ArrayList's first element is the same object feedback1.",Feedback1,feedbackList.get(0));
	}

	@Test
	public void testdelFeedback(){
		MoneyExchange.isAdmin = true;

		// Item list is not null and it is empty
		assertNotNull("Test if there is valid feedback ArrayList to add to", feedbackList);
		//Test that the list contains elements to delete
		FeedbackMain.addFeedback(feedbackList, Feedback1);
		assertTrue("Test if there are elements in the feedback ArrayList to delete",feedbackList.contains(Feedback2));


		FeedbackMain.delFeedback(feedbackList, Feedback1);
		assertFalse("Test deletion of INR object ",feedbackList.contains(Feedback1));


		FeedbackMain.delFeedback(feedbackList, Feedback2);
		assertEquals("Test deletion of objects not in the list", 0, feedbackList.size());
	}

	@Test
	public void testViewAllFeedback() {

		Feedback1 = new Feedback(1,date, 7, "Is good");
		Feedback2 = new Feedback(2,date, 6, "Is not good");

		assertNotNull("Test if there is valid Feedback Arraylist",feedbackList);

		String output = null;


		feedbackList.add(Feedback1);
		feedbackList.add(Feedback2);
		FeedbackMain.feedbackList.add(Feedback1);
		FeedbackMain.feedbackList.add(Feedback2);

		output = String.format("%-10s %-10s %-15s %-15s\n","ID","DATE","RATING (/10)","MESSAGE");


		output += String.format("%-10s %-10s %-15s %-15s\n", Feedback1.getID(),Feedback1.getDate(),Feedback1.getRating(),Feedback1.getMessage());
		output += String.format("%-10s %-10s %-15s %-15s\n", Feedback2.getID(),Feedback2.getDate(),Feedback2.getRating(),Feedback2.getMessage());
		
		String mainOutput = FeedbackMain.getFeedbacks(feedbackList);

		assertEquals(output, mainOutput);

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
