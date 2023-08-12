
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
			currentUser = null;
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
				CurrencyMain.main(null);
			} else if (opt == 5) {
				FeedbackMain.main(null);
			}

			Menu();
			opt = Helper.readInt("Please choose an option: ");
		}
		System.out.println("Logged out");
		System.out.println(" ");
		isAdmin = false;
	}

	


	public static Account validateAcc() { // Asmond
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
			CurrencyMain.viewAllCurr(currList);
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


	



}
