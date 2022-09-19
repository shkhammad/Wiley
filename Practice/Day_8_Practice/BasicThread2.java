
public class BasicThread2 implements Runnable{
	
	@Override
	public void run() {
		
		int i;
		

		for(i=0;i<5;++i) {
			System.out.println(Thread.currentThread().getName());
			
			//explicitly gives a hint to the scheduler to consider
			//other thread for processing, the scheduler can 
			//ignore this as well and is rarely used
			Thread.yield();
		}
	
	}
	
	public static void main(String[] args) {
		
		//the other way is by implementing the Runnable interface
		BasicThread2 b1 = new BasicThread2();
		BasicThread2 b2 = new BasicThread2();
		
		Thread thread1 = new Thread(b1);
		Thread thread2 = new Thread(b2);
		
		
		
		//anonymous class --> a class with no name which implements runnable
		//and overrides the run method
		Runnable runnable = new Runnable(){
			
			@Override
			public void run() {
				System.out.println("Hammad");
			}
			
		};
		
		Thread thread3 = new Thread(runnable);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		
	}
}
