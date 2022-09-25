public class Access {
	
	//this is an example of creating custom locks for reducing unnecessary
	//blocking, if there are attributes which are independent of each
	//other i.e changing the value of one will not affect the other, we 
	//can use this, but use it with utmost care
	//this causes the program to interleave the execution of one method
	//and switch or start executing the other method and finally resume back to
	//the execution of previous method
	
	private int val1=0,val2=0;
	//different locks
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void method1() {
		
		//synchronized(this)
		synchronized(lock1){
			++val1;
			System.out.println("val1 " + val1 + " " + Thread.currentThread().getName());
			System.out.println("val2 " + val2);
			
		}
		
	}
	
	public void method2() {
		
		//synchronized(this)
		synchronized(lock2){
			++val2;
			System.out.println("val2 " + val2 + " " + Thread.currentThread().getName());
			System.out.println("val1 " + val1);
		}
	}
	
	public String output() {
		return Thread.currentThread().getName() + " " + (val1+val2);
	}
	
}
