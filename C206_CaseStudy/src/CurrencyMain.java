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

		currList.add(new Currency("China", "CNY","Yuan",5.38));
		currList.add(new Currency("Columbia","COP","Peso", 2936.58));
		currList.add(new Currency("India","INR","Rupee",61.93));
		currList.add(new Currency("Malaysia","MYR","Ringgit",3.55));

		currMenu();
		int subOpt = Helper.readInt("Please choose an option: ");
		while(subOpt != 6) {
			switch (subOpt) {
			case 1:
				viewAllCurr(currList);
				break;
			case 2:
				addCurr(currList,getCurrency(1,currList));
				break;
			case 3:
				editRate(currList);
				break;
			case 4:
				deleteCurr(currList,getCurrency(2,currList));
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
		System.out.println("1. View all currencies");
		System.out.println("2. Add a new currency");
		System.out.println("3. Edit an existing currency");
		System.out.println("4. Delete an existing currency");
		System.out.println("5. Search for a currency");
		System.out.println("6. Exit");
		System.out.println(" ");
	}
	
	
	public static void addCurr(ArrayList<Currency> currList,Currency currency) {
		{

			if(currency != null ) {
				currList.add(currency);
				System.out.println("Currency successfully added");
			} 
		}
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
		if(currency != null) {
			currList.remove(currency);
			System.out.println(currency.getCurrencyCode() + "successfully deleted.");
		}
	}

	public static Currency getCurrency(int function, ArrayList<Currency> currList ) {
		Currency currency = null;
		if(MoneyExchange.isAdmin == true) {
			if(function == 1 ) {

				{
					String country = Helper.readString("Enter country name: ");
					String code = Helper.readString("Enter country code: ");
					String currName = Helper.readString("Enter currency name: ");
					double rate = Helper.readDouble("Enter exhange rate: ");
					currency = new Currency(country,code,currName,rate);
				} 
			} else if(function == 2) {
				boolean found = true;
				String code = Helper.readString("Enter country code to delete: ");
				for(Currency curr : currList) {
					if(curr.getCurrencyCode().equalsIgnoreCase(code)) {
						currency = curr;			
					} else {
						found = false;
					}
				}

				if(!found) {
					System.out.println("Country code not found");
				}
			}
		} else {
			System.out.println("Administrative rights required");
		}

		return currency;

	}

	public static void viewAllCurr(ArrayList<Currency> currList) {
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
