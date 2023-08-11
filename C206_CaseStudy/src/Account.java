/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22037707, Jul 31, 2023 3:39:53 PM
 */



/**
 * 
 */
public class Account {
	public Users user;
	public String username;
	public String password;
	public double balance;
	public int contact;
	public String accId;
	
	public Account(Users user, String username, String password, int contact, double balance) {
		this.user = user;
		this.username = username;
		this.password = password;
		this.contact = contact;
		this.balance = balance;
		this.accId = user.getUserID();
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}
	
	
	
	
	
}
