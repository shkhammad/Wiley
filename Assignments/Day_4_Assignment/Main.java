import java.io.PrintWriter;

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		int openingBalance1 = 1000;
		AccountType accountType = AccountType.CURRENT;
		
		if(accountType == AccountType.SAVINGS) {
		
			if(openingBalance1 >= 500) {
				BankAccount bankAccount1 = new BankAccount("A123", "Hammad", openingBalance1, accountType);
				out.println(bankAccount1.getAccountHolderName());
				out.println(bankAccount1.getAccountId());
				out.println(bankAccount1.getCurrentBalance());
				out.println(bankAccount1.getOpeningBalance());
				out.println(bankAccount1.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount1.depositAmount(500);
				out.println(bankAccount1.getCurrentBalance());
				
				out.println(bankAccount1.withdrawAmount(400));
				out.println(bankAccount1.getCurrentBalance());
				
				bankAccount1.depositAmount(700);
				out.println(bankAccount1.getCurrentBalance());
				
				out.println(bankAccount1.withdrawAmount(800));
				out.println(bankAccount1.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 500");
		
		}
		
		else if(accountType == AccountType.CURRENT){
			
			if(openingBalance1 >= 1000) {
				BankAccount bankAccount1 = new BankAccount("A123", "Hammad", openingBalance1, accountType);
				out.println(bankAccount1.getAccountHolderName());
				out.println(bankAccount1.getAccountId());
				out.println(bankAccount1.getCurrentBalance());
				out.println(bankAccount1.getOpeningBalance());
				out.println(bankAccount1.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount1.depositAmount(500);
				out.println(bankAccount1.getCurrentBalance());
				
				out.println(bankAccount1.withdrawAmount(400));
				out.println(bankAccount1.getCurrentBalance());
				
				bankAccount1.depositAmount(700);
				out.println(bankAccount1.getCurrentBalance());
				
				out.println(bankAccount1.withdrawAmount(800));
				out.println(bankAccount1.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 1000");
			
		}
		
		out.println(BankAccount.getTotalBalance());
		
		
		
		int openingBalance2 = 1500;
		AccountType accountType2 = AccountType.SAVINGS;
		
		if(accountType2 == AccountType.SAVINGS) {
			if(openingBalance2 >= 500) {
				BankAccount bankAccount2 = new BankAccount("A456", "Sikandar", openingBalance2, accountType2);
				out.println(bankAccount2.getAccountHolderName());
				out.println(bankAccount2.getAccountId());
				out.println(bankAccount2.getCurrentBalance());
				out.println(bankAccount2.getOpeningBalance());
				out.println(bankAccount2.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount2.depositAmount(2500);
				out.println(bankAccount2.getCurrentBalance());
				
				out.println(bankAccount2.withdrawAmount(1500));
				out.println(bankAccount2.getCurrentBalance());
				
				bankAccount2.depositAmount(100);
				out.println(bankAccount2.getCurrentBalance());
				
				out.println(bankAccount2.withdrawAmount(600));
				out.println(bankAccount2.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 500");
		}
		
		else if(accountType2 == AccountType.CURRENT) {
			if(openingBalance2 >= 1000) {
				BankAccount bankAccount2 = new BankAccount("A456", "Sikandar", openingBalance2, accountType2);
				out.println(bankAccount2.getAccountHolderName());
				out.println(bankAccount2.getAccountId());
				out.println(bankAccount2.getCurrentBalance());
				out.println(bankAccount2.getOpeningBalance());
				out.println(bankAccount2.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount2.depositAmount(2500);
				out.println(bankAccount2.getCurrentBalance());
				
				out.println(bankAccount2.withdrawAmount(1500));
				out.println(bankAccount2.getCurrentBalance());
				
				bankAccount2.depositAmount(100);
				out.println(bankAccount2.getCurrentBalance());
				
				out.println(bankAccount2.withdrawAmount(600));
				out.println(bankAccount2.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 1000");
		}
		
		
		out.println(BankAccount.getTotalBalance());
		
		int openingBalance3 = 3000;
		AccountType accountType3 = AccountType.SAVINGS;
		
		if(accountType3 == AccountType.SAVINGS) {
			if(openingBalance3 >= 500) {
				BankAccount bankAccount3 = new BankAccount("A789", "Samina", openingBalance3, AccountType.SAVINGS);
				out.println(bankAccount3.getAccountHolderName());
				out.println(bankAccount3.getAccountId());
				out.println(bankAccount3.getCurrentBalance());
				out.println(bankAccount3.getOpeningBalance());
				out.println(bankAccount3.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount3.depositAmount(500);
				out.println(bankAccount3.getCurrentBalance());
				
				out.println(bankAccount3.withdrawAmount(1000));
				out.println(bankAccount3.getCurrentBalance());
				
				bankAccount3.depositAmount(500);
				out.println(bankAccount3.getCurrentBalance());
				
				out.println(bankAccount3.withdrawAmount(1000));
				out.println(bankAccount3.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 500");
			
		}
		
		else if(accountType3 == AccountType.CURRENT) {
			if(openingBalance3 >= 1000) {
				BankAccount bankAccount3 = new BankAccount("A789", "Samina", openingBalance3, AccountType.SAVINGS);
				out.println(bankAccount3.getAccountHolderName());
				out.println(bankAccount3.getAccountId());
				out.println(bankAccount3.getCurrentBalance());
				out.println(bankAccount3.getOpeningBalance());
				out.println(bankAccount3.getAccountType());
				out.println(BankAccount.getTotalBalance());
				
				
				bankAccount3.depositAmount(500);
				out.println(bankAccount3.getCurrentBalance());
				
				out.println(bankAccount3.withdrawAmount(1000));
				out.println(bankAccount3.getCurrentBalance());
				
				bankAccount3.depositAmount(500);
				out.println(bankAccount3.getCurrentBalance());
				
				out.println(bankAccount3.withdrawAmount(1000));
				out.println(bankAccount3.getCurrentBalance());
				
			}
			
			else
				out.println("Opening Balance should be minimum Rs 1000");
			
		}
		
		
		out.println(BankAccount.getTotalBalance());
		
		
		out.close();
	}
}
