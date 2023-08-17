import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionMain {
	public static ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();
	public static LocalDate date = LocalDate.now();
	public static void main(String[] args) {
		
		

		TransactionMenu();
		int subOpt = Helper.readInt("Please choose an option: ");
		while(subOpt != 5) {
			switch (subOpt) {
			case 1:
				viewAllTransaction();
				break;
			case 2:
				addTransaction(TransactionList, MoneyExchange.currentUser);
				break;
			case 3:
				delTransaction();

				break;
			case 4:
				searchTransaction();
				break;
			default:
				System.out.println("Invalid choice entered");
				break;
			}
			TransactionMenu();
			subOpt = Helper.readInt("Please choose an option: ");
		}
		
		System.out.println("Exited");	
	}

	
	
	public static void editTrans() {
		
	}
	
public static void TransactionMenu() {
	System.out.println(" ");
	System.out.println("1. View All Transactions");
	System.out.println("2. Add a new transaction ");
	System.out.println("3. Delete a transaction");
	System.out.println("4. View Main Menu");
}
	
	
	public static void viewAllTransaction() { 
		String output = String.format("%-10s %-10s %-15s %-15s %-15s %-15s \n","Transaction","TransactionID","AMOUNT","CONVERT AMOUNT", "CURRENCY", "ACCSENTTO");

		for(Transaction trans : TransactionList) {
			output += String.format("%-10s %-10s %-15.2f %-15.2f %-15s %-15s \n", trans.getAcc().getAccId(),trans.getAccId(),trans.getAmount(),trans.getConvertAmt(), trans.getCurrency());
		}

		System.out.println(output);
	}
	
	public static void addTransaction(ArrayList<Transaction> TransactionList, Account acc) {
			
			Transaction trans = MoneyExchange.makeTransaction(acc);
			TransactionList.add(trans);
			System.out.println("Transaction successfully added");
	}
	
	

	public static void delTransaction() {
		boolean found = true;
		int id = Helper.readInt("Enter Transaction ID to delete: ");
		for(Transaction trans : TransactionList) {
			if(trans.getId() == id) {
				char opt = Helper.readChar("Do you wish to proceed to delete Transaction ID " + trans.getId() + " (Y/N): ");
				if(Character.toLowerCase(opt) == 'y' ) {
					TransactionList.remove(trans);
					System.out.println("Transaction ID " + trans + " deleted from database.");
					break;
				} else {
					System.out.println("Transaction successfully deleted");
					break;
				}
			} else {
				found = false;
			}
		}
	}
	


	
	public static void searchTransaction() {
		String input = Helper.readString("Enter transaction code:  ");
		
		
	}
}
