import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCurrencyMain {

	// Test data preparation
	public Currency MYR;
	public Currency INR;
	public Currency CNY;
	public Currency COP;
	

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
	public ArrayList<Currency> currList =  new ArrayList<Currency>();

	public TestCurrencyMain() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		// prepare test data
		CNY = new Currency("China", "CNY","Yuan",5.38);
		MYR = new Currency("Malaysia","MYR","Ringgit",3.55);
		COP = new Currency("Columbia","COP","Peso", 2936.58);
		INR = new Currency("India","INR","Rupee",61.93);


		System.setOut(new PrintStream(outputStreamCaptor));
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
}
