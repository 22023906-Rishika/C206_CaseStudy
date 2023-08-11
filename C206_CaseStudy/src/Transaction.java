
public class Transaction {
	private Account acc;
	private String accId;
	private double amount;
	private double convertAmt;
	private String currency;
	private String accSentTo;
	public Transaction(Account acc, double amount, double convertAmt, String currency) {
		this.acc = acc;
		this.accId = acc.getUsername();
		this.amount = amount;
		this.convertAmt = convertAmt;
		this.currency = currency;
	}
	
	public String getAccSentTo() {
		return this.accSentTo;
	}
	public void setAccSentTo(String accSentTo) {
		this.accSentTo = accSentTo;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getConvertAmt() {
		return convertAmt;
	}
	public void setConvertAmt(int convertAmt) {
		this.convertAmt = convertAmt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
	
}
