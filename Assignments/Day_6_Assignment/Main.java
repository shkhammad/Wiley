import java.io.PrintWriter;

public class Main {
	
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		
		//reverse a string
		StringBuilder s = new StringBuilder("hammad");
		int i=0,j=s.length()-1;
		
		while(i<j) {
			char c = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, c);	
			++i;
			--j;
		}
		
		out.println(s.toString());
		
		//occurrence of a character in the string
		char a = 'm';
		int mp[] = new int[26];
		
		for(char c: s.toString().toCharArray())
			++mp[c - 'a'];
		
	
		out.println(mp[a - 'a']);
		
		int arr[] = {1,2,3,4,5,6,7,8,9,1323};
		
		if(arr[0] == arr[arr.length-1])
			out.println("Yes");
		
		else
			out.println("No");
		
		
		Anagram anagram = new Anagram("abbd","babd");
		out.println(anagram.getAnagram());
		
			
		Email email = new Email("shkhammad00@gmail.com");
		
		try {
			out.println(email.isValid());
		}
		
		catch(EmailException e) {
			out.println(e);
		}
		
		
		Address addresses[] = new Address[2];
		
		//0 --> Temporary Address
		addresses[0] = new Address("B-103", "Samina Sikandar Bakht", "Hydri Chowk", "Mumbai");
		//1 --> Permanent Address
		addresses[1] = new Address("A-504", "Sikandar Bakht", "Pooja Nagar", "Mira Road");
		
		Employee employee = new Employee(1,"Hammad",addresses);
		
		out.println(employee.getEmpId());
		out.println(employee.getEmpName());
		
		
		Address addresses2[] = employee.getEmpAddress();
		
		//temporary
		out.println(addresses2[0].getFlatNumber());
		out.println(addresses2[0].getFlatName());
		out.println(addresses2[0].getCityName());
		out.println(addresses2[0].getRoadName());
		
		//permanent
		out.println(addresses2[1].getFlatNumber());
		out.println(addresses2[1].getFlatName());
		out.println(addresses2[1].getCityName());
		out.println(addresses2[1].getRoadName());
		
		
		BankAccount bankaccount = new BankAccount("A123","Hammad", AccountType.SAVINGS);
		out.println(bankaccount.getAccountId());
		out.println(bankaccount.getAccountHolderName());
		out.println(bankaccount.getAccountType());
		
		try {
			out.println(bankaccount.getTotalInterest(10000, 5));
		} catch (DepositAmountException d) {
			out.println(d);
		}
		
		
		BankAccount bankaccount2 = new BankAccount("B786","Sikandar", AccountType.CURRENT);
		out.println(bankaccount2.getAccountId());
		out.println(bankaccount2.getAccountHolderName());
		out.println(bankaccount2.getAccountType());
		
		try {
			out.println(bankaccount2.getTotalInterest(5000, 3));
		} catch (DepositAmountException d) {
			out.println(d);
		}
		
		
		out.close();
	}
}
