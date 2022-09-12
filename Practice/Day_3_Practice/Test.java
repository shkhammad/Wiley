import java.io.IOException;
import java.io.PrintWriter;


public class Test {
	
	final static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String ... args) throws IOException {
		
		out.println(new Calculator().addNumbers(2, 3));
		out.println(new Calculator().subtractNumbers(5, 3));
		out.println(new Calculator().multiplyNumbers(3, 3));
		out.println(new Calculator().divideNumbers(100, 10));
		out.println(new Calculator().checkEvenOdd(11));
		
		int numbers[] = {4,2,3,6};
		out.println(new Calculator().getSum(numbers));
		out.println(new Calculator().getProduct(numbers));
		out.println(new Calculator().getDay(6));
		out.println(new Calculator().traverse(numbers));
		
		int data[] = {2,4,8},key=8;
		out.println(new Calculator().search(data, key));
		
		
		Pair pair1 = new Pair();
		out.println(pair1.getFirst());
		out.println(pair1.getSecond());
		
		Pair pair2 = new Pair(7,9);
		out.println(pair2.getFirst());
		out.println(pair2.getSecond());
		
		
		out.close();
	}
}

class Calculator{
	
	public int addNumbers(int num1, int num2){
		return num1+num2;
	}
	
	public int subtractNumbers(int num1, int num2){
		return num1-num2;
	}
	
	public int multiplyNumbers(int num1, int num2){
		return num1*num2;
	}
	
	public int divideNumbers(int num1, int num2){
		return num1/num2;
	}
	
	public String checkEvenOdd(int num) {
		return ((num&1) == 1) ? "Odd" : "Even";	
	}
	
	public int getSum(int numbers[]) {
		
		int sum=0;
		for(int val: numbers) 
			sum+=val;
			
		return sum;
	}
	
	public String getDay(int day) {
		
		switch(day){
			
			case 1:
				return "Monday";
			
			case 2:
				return "Tuesday";
			
			case 3:
				return "Wednesday";
			
			case 4:
				return "Thursday";
			
			case 5:
				return "Friday";
			
			case 6:
				return "Saturday";
			
			case 7:
				return "Sunday";	
				
		}
		
		return "Invalid";
	}
	
	public int getProduct(int numbers[]) {
		
		int i=0,res=1,n=numbers.length;
		do {
			res *= numbers[i];
		}while(i++ < n-1);
		
		return res;
	}
	
	public int search(int numbers[], int key) {
		
		int n=numbers.length,beg=0,end=n-1,mid,position=-1;
		
		while(beg<=end) {
			mid = beg+(end-beg)/2;
			
			if(numbers[mid] == key) {
				position = mid;
				break;
			}
					
			else if(numbers[mid] > key)
				end = mid-1;
			
			else
				beg = mid+1;
		}
		
		return position;
	}
	
	public int traverse(int numbers[]) {
		
		int i,n=numbers.length,sum=0;
		
		for(i=0;i<n;++i) {
			
			if((i& 1) == 1)
				continue;
			
			sum+=numbers[i];
		}
		
		return sum;
	}
	
}