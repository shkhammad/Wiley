import java.util.ArrayList;
import java.util.List;

public class Test {
	
	//lambda expressions override 'abstract' methods only
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello World !");
			}
			
		});
		
		t1.start();
		
		//overriding the run method of runnable interface
		//using lambda expressions 
		Thread t2 = new Thread(() -> System.out.println("Hello Hammad !"));
		t2.start();
		
		
		Interface1 i1 = new Interface1() {
			
			@Override
			public void solve() {
				System.out.println("Solved");
			}
			
			@Override
			public void print() {
				System.out.println("Printed");
			}
			
		};
		
		i1.solve();
		i1.print();
		Interface1.method();
		
		//overriding using lambda expressions
		Interface1 i2 = () -> System.out.println("Hi Guys !");
		i2.solve();
		
		
		Interface2 i3 = (val1,val2) -> {
			return val1+val2;
		};
	
		System.out.println(i3.add(5, 6));
	
		Interface2 i4 = (val1,val2) -> val1+val2; 
		System.out.println(i4.add(7, 8));
		
		
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		
		ls.forEach(val -> System.out.println(val));
		
		
		
		
		
		
		
		
		
	
	}
}
