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
				addFeedback();
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
	
	public static final int feedbackID = 0;
	public static void addFeedback() { // Manfred
		int rating = Helper.readInt("Please rate our services out of 10: ");
		String message = Helper.readString("Please leave a feedback on how MeRemit can do better: ");

		feedbackList.add(new Feedback(feedbackID+1,date,rating,message));
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
	
	public static void searchFeedback() { //Manfred
		
	}
}
