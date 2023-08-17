import java.util.ArrayList;



public class AccountMain {
	public static ArrayList<Account> AccList = new ArrayList<Account>();
	public static void main(String[]args) {

		AccountMenu();
		int subOpt = Helper.readInt("Please choose and option");
		while(subOpt != 6) {
			switch (subOpt) {
			case 1:
				viewAllAccount();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				deleteAccount();
				break;
			case 4:
				searchAccount();
				break;	
			default:
				System.out.println("Invalid User");
				break;
			}
			AccountMenu();
			subOpt = Helper.readInt("Please choose an option: ");
		}

		System.out.println("Exited");	
	}

	public static void AccountMenu() {
		System.out.println(" ");
		System.out.println("1. View All Account");
		System.out.println("2. Add a new account");
		System.out.println("3. Edit an existing account");
		System.out.println("4. Delete an account");
		System.out.println("5. Search for account");
		System.out.println("6. View Main Menu");
	}

	public static void viewAllAccount() {
		String output = String.format("%-10s %-10s %-15s %-15s %-15s %-15s \n","User","Username","Balance","Password", "Contact", "AccountID");

		for(Account accts : AccList) {
			output += String.format("%-10s %-10s %-15.2f %-15.2f %-15s %-15s \n", accts.getUser(),accts.getUsername(),accts.getBalance(),accts.getPassword(), accts.getContact(), accts.getAccId());
		}

		System.out.println(output);
	}

	public static void addAccount() {
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role: ");
		boolean admin = Helper.readBoolean(role);
		String userID = Helper.readString("Enter User ID: ");
		String user = Helper.readString("Enter User: ");
		String accId = Helper.readString("Enter Account ID: ");
		String username = Helper.readString("Enter Username: ");
		double balance = Helper.readDouble("Enter Balance: ");
		String password = Helper.readString("Enter Password: ");
		int contact = Helper.readInt("Enter Contact: ");
		Users newUser = new Users(name, role, admin, userID);
		Account newAccount = new Account(newUser, username, password,contact, balance);
		AccList.add(newAccount);

		System.out.println("Account successfully added");
	}

	public static void deleteAccount() {
		String accId = Helper.readString("Enter Account ID to be deleted: ");
		boolean found = false; 

		for (Account accts : AccList) {
			if (accts.getAccId() == accId) {
				found = true; 
				char opt = Helper.readChar("Do you wish to proceed to delete Account ID " + accId + " (Y/N): ");
				if (Character.toLowerCase(opt) == 'y') {
					AccList.remove(accts);
					System.out.println("Account ID " + accId + " deleted from database.");
					break;
				} else {
					System.out.println("Account deletion cancelled.");
				}
			}
		}

		if (!found) {
			System.out.println("Account ID" + accId + " not found.");
		}

	}

	public static void searchAccount() {
		String input = Helper.readString("Enter Account ID:  ");

		for (Account accts : AccList) {
			if (String.valueOf(accts.getAccId()).equals(input)) {
				System.out.println("Account ID: " + accts.getAccId());
				System.out.println("Account Balance: " + accts.getBalance());
				return; 
			}
		}

		System.out.println("Account with ID " + input + " not found.");
	}




}

