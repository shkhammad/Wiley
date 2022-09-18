
public class BankAccount {
	private String accountId, accountHolderName;
	private AccountType accountType;
	
	public BankAccount(String accountId, String accountHolderName, AccountType accountType) {
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	
	public double getTotalInterest(double amount, int years) throws DepositAmountException {
		
		if(amount < 0)
			throw new DepositAmountException();
		
		return (double)(amount * accountType.getRateOfInterest() * years)/100;
	}
	
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public String getAccountHolderName() {
		return this.accountHolderName;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	
}
