public class Main {
	public static void main(String[] args) {
		
		int val1 = 2;
		int val2 = 0;
		
		int a[] = new int[1];
		a[0] = 1;
		
		//handling exceptions doesn't obstruct the normal flow of the program
		try {
			System.out.println(a[5]/val2);
			System.out.println(val1/val2);
		}
	
		
		/*cannot write parent exception above child exception since 
		  child exception will never be executed - unreachable
		
			catch(Exception e) {
				
			}
		*/
		
		//unchecked
		catch(ArrayIndexOutOfBoundsException aio) {
			System.out.println(aio);
			System.out.println("index greater than or equal to the size of the array");
			aio.printStackTrace();
			System.err.println("In Red Color");
		}
		
		//unchecked
		catch(ArithmeticException ae) {
			System.out.println(ae);
			System.out.println("You can't divde by zero");
			ae.printStackTrace();
			System.err.println("In Red Color");
		}
		
		System.out.println(1+2);
		
				
	}

}
