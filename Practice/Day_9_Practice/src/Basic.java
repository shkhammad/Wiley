import java.io.Console;

public class Basic {
	
	public static void main(String[] args) {
		
		//this class will work only on the default system console (not on IDE)
		//for windows it is cmd prompt
		//mainly used for reading passwords (invisible) --> echoing disabled
		
		Console console = System.console();
		
		System.out.print("Enter your username: ");
		String userName = console.readLine();
		System.out.print("Enter your password: ");
		char password[] = console.readPassword();
		
		System.out.println(userName);
		System.out.println(password);
		
	}
	
}
