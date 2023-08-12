import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCurrencyMain {

	// Test data preparation
	public Currency MYR;
	public Currency INR;
	public Currency CNY;
	public Currency COP;
	
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
		
		
	}
	
	
	@Test
	public void testAddCurr() {
		// Item list is not null and it is empty
				assertNotNull("Test if there is valid Camcorder arraylist to add to", currList);
				assertEquals("Test that the Camcorder arraylist is empty.", 0, currList.size());
				// Given an empty list, after adding 1 item, the size of the list is 1
				CurrencyMain.addCurr(currList, CNY);
				assertEquals("Test that the Camcorder arraylist size is 1.", 1, currList.size());
 
	}

}
