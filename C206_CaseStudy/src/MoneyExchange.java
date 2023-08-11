
import java.util.ArrayList;
import java.util.Random;   
import java.time.LocalDate;

public class MoneyExchange {

	public static ArrayList<Currency> currList =  new ArrayList<Currency>();
	public static ArrayList<Account> accList = new ArrayList<Account>();
	public static ArrayList<Transaction> transactList = new ArrayList<Transaction>();
	public static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
	public static Account currentUser;
	public static boolean isAdmin = false;
	public static void validateAdmin(Account acc) {
		if (acc.getUser().getAdmin() == true) {
			isAdmin = true;
		}
	}
	
	public static LocalDate date = LocalDate.now();

	public static void main(String[] args) {
		// Test data
		currList.add(new Currency("China", "CNY","Yuan",5.38));
		currList.add(new Currency("Columbia","COP","Peso", 2936.58));
		currList.add(new Currency("India","INR","Rupee",61.93));
		currList.add(new Currency("Malaysia","MYR","Ringgit",3.55));

		Users scrumMaster = new Users("Rishika","Scrum Master",true,"001"); // Admin user
		accList.add(new Account(scrumMaster,"rishika05","12345",92287068,22000));

		Users softwareEng = new Users("Asmond","Software Engineer",true,"002"); // Second admin user
		accList.add(new Account(softwareEng,"asmond0811","12345",93387077,22000));

		for(int x = 1; x < 15; x++) { // Creating a group of normal users
			accList.add(new Account(
					new Users("Account" + x, "Account " + x, false, "00" + (2 + x) ),
					"account"+x,"12345",91297930+x,22000+x
					));
		}
		
		feedbackList.add(new Feedback(date,10,"Great service"));
		feedbackList.add(new Feedback(date,2,"Terrible service"));

		System.out.println("Welcome to RemitNow !!!");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		int opt = Helper.readInt("Enter option: ");
		while(opt!=3) {

			if(opt == 1) {
				// Asmond
				Account acc = validateAcc();
				if(acc!=null) {
					validateAdmin(acc);
					loggedInMenuMain();
				} else {
					System.out.println("Invalid username or password entered!!!");
				}
			} else if(opt == 2) {
				signUp();
			}
			System.out.println("Welcome to RemitNow !!!");
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.println("3. Exit");
			opt = Helper.readInt("Enter option: ");

		}


		System.out.println("Thank you for using MeRemit!!!");

	}


	public static void signUp() {
		Random ran = new Random();
		int id = ran.nextInt(1000);
		for(Account acc : accList) {
			while (String.valueOf(id) != acc.getUser().getUserID()) {
				id = ran.nextInt(1000);
			}
		}
		String name = Helper.readString("Enter your name: ");
		int num = Helper.readInt("Enter your contact number: ");
		String usr = Helper.readString("Enter your username: ");
		String pwd = Helper.readString("Enter your password: ");
		double balance = Helper.readDouble("Enter amount to deposit into account");

		accList.add(new Account(
				new Users(name, "User", false, String.valueOf(id) ),
				usr,pwd,num,balance
				));
	}


	public static void Menu() {
		System.out.println(" ");
		System.out.println("Menu");
		System.out.println("1. Users");
		System.out.println("2. Accounts");
		System.out.println("3. Transactions");
		System.out.println("4. Currencies");
		System.out.println("5. Feedback");
		System.out.println("6. Log out");
		System.out.println(" ");
	}

	public static void currMenu() {
		System.out.println(" ");
		System.out.println("1. View all currencies");
		System.out.println("2. Add a new currency");
		System.out.println("3. Edit an existing currency");
		System.out.println("4. Delete an existing currency");
		System.out.println("5. Search for a currency");
		System.out.println("6. View Main Menu");
		System.out.println(" ");
	}

	private static void feedbackMenu() {
		System.out.println(" ");
		System.out.println("1. View All Feeback");
		System.out.println("2. Add a new Feedback ");
		System.out.println("3. Delete a feedback");
		System.out.println("4. Search for Customer Feedback");
		System.out.println("5. View Main Menu");
	}

	public static void loggedInMenuMain() {
		Menu();
		int opt = Helper.readInt("Please choose an option: ");
		while(opt !=6) {
			if (opt == 1) {
				// Add users selection menu
			} else if (opt == 2) {
				// Add accounts selection menu
			} else if (opt == 3) {
				System.out.println("1. Make a transaction");
				int subOpt = Helper.readInt("Please choose an option: ");
				while(subOpt != 6) {
					switch(subOpt) {
					case 1:
						makeTransaction(currentUser);
						break;
					}
				}
			} else if (opt == 4) {

				currMenu();
				int subOpt = Helper.readInt("Please choose an option: ");
				while(subOpt != 6) {
					switch (subOpt) {
					case 1:
						viewAllCurr();
						break;
					case 2:
						addCurr();
						break;
					case 3:
						editRate();

						break;
					case 4:
						deleteCurr();
						break;
					case 5:
						searchCurr();
						break;
					default:
						System.out.println("Invalid choice entered");
					}
					currMenu();
					subOpt = Helper.readInt("Please choose an option: ");
				}

			} else if (opt == 5) {
				feedbackMenu();
				int subOpt = Helper.readInt("Please choose an option: ");
				while(subOpt != 5 ) {
					switch(subOpt) {
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
					}
					feedbackMenu();
					subOpt = Helper.readInt("Please choose an option: ");
				}
			}

			Menu();
			opt = Helper.readInt("Please choose an option: ");
		}
		System.out.println("Logged out");
		System.out.println(" ");
		isAdmin = false;
	}
	
	public static void viewAllFeedBack() {
		
	}
	public static final int feedbackID = 0;
	public static void addFeedback() {
		int rating = Helper.readInt("Please rate our services out of 10: ");
		String message = Helper.readString("Please leave a feedback on how MeRemit can do better: ");
		
		feedbackList.add(new Feedback(feedbackID+1,date,rating,message));
	}
	
	public static void delFeedback() {
		boolean found = true;
		int id = Helper.readInt("Enter feedback ID to delete: ");
		for(Feedback fb : feedbackList) {
			if(fb.getID() == id) {
				feedbackList.remove(fb);
				System.out.println("Feedback ID " + fb + " deleted from database.");
				break;
			} else {
				found = false;
			}
		}
	}
	

	public static Account validateAcc() {
		Account validAcc = null;
		String usr = Helper.readString("Enter username: ");
		String pwd = Helper.readString("Enter password: ");

		for (Account acc : accList) {
			if(acc.getUsername().equalsIgnoreCase(usr) && acc.getPassword().equals(pwd)) {
				validAcc = acc;
				currentUser = acc;
			}
		}
		return validAcc;
	}

	

	public static void makeTransaction(Account current) { // Asmond 
		double amt = Helper.readDouble("Enter amount to exchange ($SGD): ");
		String curr = Helper.readString("Enter currency code to exchange to or 2 to view available currencies: ");
		if(curr.equals("2")) {
			viewAllCurr();
			curr = Helper.readString("Enter currency code to exchange: ");

		}

		for(Currency currency : currList) {
			if(currency.getCurrencyCode().equalsIgnoreCase(curr)) {
				if(amt>current.getBalance()) {
					System.out.println("Amount entered is more than balance !!!");
				} else {
					double exchanged = currency.getExchangeRate() * amt;
					current.setBalance(current.getBalance()-amt);
					transactList.add(new Transaction(current,amt,exchanged,currency.getCurrencyCode()));
					System.out.println(currency.getCurrencyCode() + " " + exchanged + " exchanged");

				}


			}
		}
	}


	public static void addCurr() {
		if(isAdmin == true) {
			String country = Helper.readString("Enter country name: ");
			String code = Helper.readString("Enter country code: ");
			String currName = Helper.readString("Enter currency name: ");
			double rate = Helper.readDouble("Enter exhange rate: ");

			currList.add(new Currency(country,code,currName,rate));
			System.out.println("Currency successfully added");
		} else {
			System.out.println("Administrative rights required!!!");
		}


	}

	public static void editRate() {
		if (isAdmin == true) {
			boolean found = true;
			String code = Helper.readString("Enter country code to edit exchange rate: ");
			for(Currency curr : currList) {
				if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
					double rate = Helper.readDouble("Enter new rate: ");
					curr.setExchangeRate(rate);
					System.out.println(curr.getCurrencyCode() + "rate changed successfully!");
					found = true;
					break;
				} else {
					found = false;
				}
			}
			if (!found) {
				System.out.println("Unknown currency code");
			}
		} else {
			System.out.println("Administrative rights required!!!");
		}
	}

	public static void deleteCurr() {
		boolean found = true;
		String code = Helper.readString("Enter country code to delete: ");
		for(Currency curr : currList) {
			if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
				char opt = Helper.readChar("Do you wish to delete " + curr.getCurrencyCode() + " > (Y/N) ");
				if (Character.toLowerCase(opt) == 'y') {
					currList.remove(curr);
					System.out.println("Currency of code " + curr.getCurrencyCode() + " successfully deleted.");
					found = true;
					break;
				}
			} else {
				found = false;
			}
		}
		if (!found) {
			System.out.println("Unknown currency code");
		}
	}

	public static void viewAllCurr() {
		String output = String.format("%-10s %-10s %-10s %-10s\n","COUNTRY","CODE","CURRENCY","RATE");

		for(Currency curr : currList) {
			output += String.format("%-10s %-10s %-10s %-10.2f\n", curr.getCountry(),curr.getCurrencyCode(),curr.getCurrencyName(),curr.getExchangeRate());
		}

		System.out.println(output);

	}

	public static void searchCurr() {
		String input = Helper.readString("Enter country or country code: ");

	}




}
