/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22037707, Aug 11, 2023 7:07:01 PM
 */

import java.util.ArrayList;

public class CurrencyMain {
	public static ArrayList<Currency> currList =  new ArrayList<Currency>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		currMenu();
		int subOpt = Helper.readInt("Please choose an option: ");
		while(subOpt != 6) {
			switch (subOpt) {
			case 1:
				viewAllCurr(currList);
				break;
			case 2:
				addCurr(currList,getCurrencyAdd());
				break;
			case 3:
				editRate(currList);
				break;
			case 4:
				deleteCurr(currList,getCurrencyDel());
				break;
			case 5:
				searchCurr();
				break;
			default:
				System.out.println("Invalid choice entered");
				break;
			}
			currMenu();
			subOpt = Helper.readInt("Please choose an option: ");
		}

		System.out.println("Exited");	
	}

	public static void currMenu() {
		Helper.line(30, "=");
		System.out.println("Currency Management Menu");
		System.out.println("1. View all currencies");
		System.out.println("2. Add a new currency");
		System.out.println("3. Edit an existing currency");
		System.out.println("4. Delete an existing currency");
		System.out.println("5. Search for a currency");
		System.out.println("6. Exit");
		Helper.line(30, "=");
		System.out.println(" ");
	}





	public static void editRate(ArrayList<Currency> currList) {

		boolean found = true;
		String code = Helper.readString("Enter country code to edit exchange rate: ");
		for(Currency curr : currList) {
			if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
				double rate = Helper.readDouble("Enter new rate: ");
				curr.setExchangeRate(rate);
				System.out.println(curr.getCurrencyCode() + "rate changed successfully!");
				found = true;
				break;
			}
			if (!found) {
				System.out.println("Unknown currency code");
			}
		}


	}

	public static void deleteCurr(ArrayList<Currency> currList, Currency currency) {


		currList.remove(currency);
		System.out.println(currency.getCurrencyCode() + " successfully deleted.");

	}
	
	public static void addCurr(ArrayList<Currency> currList,Currency currency) {
		{
			if(MoneyExchange.isAdmin == true){
				currList.add(currency);
				System.out.println("Currency successfully added");
			} 
		}
	}



	public static Currency getCurrencyAdd() {
		Currency currency = null;
		
		if(MoneyExchange.isAdmin == true) {
		String country = Helper.readString("Enter country name: ");
		String code = Helper.readString("Enter country code: ");
		String currName = Helper.readString("Enter currency name: ");
		double rate = Helper.readDouble("Enter exhange rate: ");
		currency = new Currency(country,code,currName,rate);
		} else {
			System.out.println("No admin rights");
		}

		return currency;
	}

	public static Currency getCurrencyDel() {
		Currency currency = null;
		boolean found = true;
		if(MoneyExchange.isAdmin == true) {
			String code = Helper.readString("Enter country code: ");
			for(Currency curr : currList) {
				if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
					currency = curr;
					found = true;
					break;
				} else {
					found = false;
				}
			}

			if(!found) {
				System.out.println("Country code not found");
			}
		} else {
			System.out.println("No Admin Rights");
		}

		return currency;
	}
	
	

	public static void viewAllCurr(ArrayList<Currency> currList) {
		String output = String.format("%-10s %-10s %-10s %-10s\n","COUNTRY","CODE","CURRENCY","RATE");

		for(Currency curr : currList) {
			output += String.format("%-10s %-10s %-10s %-10.2f\n", curr.getCountry(),curr.getCurrencyCode(),curr.getCurrencyName(),curr.getExchangeRate());
		}

		System.out.print(output);

	}

	public static void searchCurr() {
		String input = Helper.readString("Enter country or country code: ");

	}


}

