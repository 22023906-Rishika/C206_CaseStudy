import static org.junit.Assert.*;


import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class TestFeedbackMain {

public Feedback Feedback1;
public Feedback Feedback2;
public Feedback Feedback3;
public Feedback Feedback4;
public static LocalDate date = LocalDate.now();
public ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

public TestFeedbackMain() {
  super();
}

public void setup () throws Exception {
  Feedback1 = new Feedback(1,date, 7, "Is good");
  Feedback2 = new Feedback(2,date, 6, "Is not good");
  Feedback3 = new Feedback(3,date, 4, "Is ok");
  Feedback4 = new Feedback(4,date, 9, "Is alrigh");
  
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

  // Item list is not null and it is empty
  assertNotNull("Test if there is valid feedback ArrayList to add to", feedbackList);
  //Test that the list contains elements to delete
  feedbackList.add(Feedback2);
  assertTrue("Test if there are elements in the feedback ArrayList to delete",feedbackList.contains(Feedback2));

  feedbackList.remove(Feedback2);
  assertFalse(feedbackList.contains(Feedback2));

  assertEquals("Test that the feedback ArrayList is empty.", 0, feedbackList.size());
}

//@Test
//public void testviewAllFeedback() {
//  //Item list is not null and it is empty 
//  assertNotNull("Test if there is valid Feedback ArrayList to add to",feedbackList);
//  
//  //Test that if the expected output string is the same as the list of fees retrieved
//  String allfeedback = FeedbackMain.viewAllFeedBack();
//  testOutput = String.format("%-10s %-10s %-15s %-15s\n",1,date, 7, "Is good");
//  testOutput += String.format("%-10s %-10s %-15s %-15s\n", 2,date, 6, "Is not good");
//  
//  assertEquals("Test that viewAllFeedback list", testOutput,allfeedback)
//}

}