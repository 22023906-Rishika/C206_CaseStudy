import java.time.LocalDate;
import java.util.ArrayList;

public class FeedbackMain {
  public static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
  public static LocalDate date = LocalDate.now();
  
  public static void main(String[] args) {
    
    

    feedbackMenu();
    int subOpt = Helper.readInt("Please choose an option: ");
    while(subOpt != 6) {
      switch (subOpt) {
      case 1:
        viewAllFeedBack();
        break;
      case 2:
        addFeedback(feedbackList, getFeedback(1,feedbackList));
        break;
      case 3:
        delFeedback();

        break;
      case 4:
        searchFeedback();
        break;
      default:
        System.out.println("Invalid choice entered");
        break;
      }
      feedbackMenu();
      subOpt = Helper.readInt("Please choose an option: ");
    }
    
    System.out.println("Exited");  
  }

  
  
  
  
  public static void feedbackMenu() {
    System.out.println(" ");
    System.out.println("1. View All Feeback");
    System.out.println("2. Add a new Feedback ");
    System.out.println("3. Delete a feedback");
    System.out.println("4. Search for Customer Feedback");
    System.out.println("5. View Main Menu");
  }
  
  
  public static void viewAllFeedBack() { // Manfred
    String output = String.format("%-10s %-10s %-15s %-15s\n","ID","DATE","RATING (/10)","MESSAGE");

    for(Feedback fb : feedbackList) {
      output += String.format("%-10s %-10s %-15s %-15s\n", fb.getID(),fb.getDate(),fb.getRating(),fb.getMessage());
    }

    System.out.println(output);
  }
  
  
  public static void addFeedback(ArrayList<Feedback> feedbackList, Feedback feedback ) { // Manfred
    {
      if(feedback != null) {
        feedbackList.add(feedback);
        System.out.println("Feedback successfully added");
      }
    }
  }

  public static void delFeedback() {
    boolean found = true;
    int id = Helper.readInt("Enter feedback ID to delete: ");
    for(Feedback fb : feedbackList) {
      if(fb.getID() == id) {
        char opt = Helper.readChar("Do you wish to proceed to delete feedback ID " + id + " (Y/N): ");
        if(Character.toLowerCase(opt) == 'y' ) {
          feedbackList.remove(fb);
          System.out.println("Feedback ID " + fb + " deleted from database.");
          break;
        } else {
          System.out.println("Delete aborted");
          break;
        }
      } else {
        found = false;
      }
    }
  }
  
  public static int feedbackID = 0;
  public static Feedback getFeedback(int function, ArrayList<Feedback> feedbackList ) {
    Feedback feedback = null;
    if(MoneyExchange.isAdmin == true) {
      if(function == 1 ) {
        {
          int rating = Helper.readInt("Please rate our services out of 10: ");
          String message = Helper.readString("Please leave a feedback on how MeRemit can do better: ");
          feedback = new Feedback(feedbackID+1,date,rating,message);
          feedbackID++;
        } 
      } else if(function == 2) {
        boolean found = true;
        int id  = Helper.readInt("Enter ID to delete: ");
        for(Feedback fb :feedbackList) {
          if(fb.getID()== id ) {
            feedback = fb;      
          } else {
            found = false;
          }
        }

        if(!found) {
          System.out.println("ID not found");
        }
      }
    } 

    return feedback;

  }
  
  public static void searchFeedback() { //Manfred
    
  }
}