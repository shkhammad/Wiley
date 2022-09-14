
public class Demo {
	
	public static void main(String[] args) {
		
		int val1 = 2;
		int val2 = 0;
		
		int a[] = new int[1];
		a[0] = 1;
		
		
		try {
			
			System.out.println(val1/val2);
			System.out.println(a[5]/val2);
		}
	
		//unchecked
		catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			
			if(e instanceof ArithmeticException)
				System.out.println("Cannot divide by zero");
			
			else if(e instanceof ArrayIndexOutOfBoundsException)
				System.out.println("index greater than or equal to the size of the array");
		}	
	
	}
}
