
public class BankAccount {
	private String accountId, accountHolderName;
	private double openingBalance,currentBalance;
	private AccountType accountType;
	static private double totalBalance;
	
	public BankAccount(String accountId, String accountHolderName, double openingBalance, AccountType accountType) {
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.openingBalance = openingBalance;
		this.currentBalance = this.openingBalance;
		this.accountType = accountType;
		
		totalBalance += openingBalance;
	}
	
	public void depositAmount(double amount) {
		currentBalance += amount;
		totalBalance += amount;
	}
	
	
	public String withdrawAmount(double amount) {
		
		if(currentBalance - amount < openingBalance)
			return "Cannot Withdraw from Account";
		
		currentBalance -= amount;
		totalBalance -= amount;
		
		return "Amount Withdrawn, Current Balance Rs " + currentBalance;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public String getAccountHolderName() {
		return this.accountHolderName;
	}
	
	public double getOpeningBalance() {
		return this.openingBalance;
	}
	
	public double getCurrentBalance() {
		return this.currentBalance;
	}
	
	public static double getTotalBalance() {
		return totalBalance;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	
}
