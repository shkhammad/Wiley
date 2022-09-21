
public class BasicThread2 implements Runnable{
	
	@Override
	public void run() {
		
		int i;
		

		for(i=0;i<5;++i) {
			
			//checks whether the current thread is daemon or not
			if(Thread.currentThread().isDaemon())
			System.out.println("Daemon Thread");
				
			else
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
		BasicThread2 b3 = new BasicThread2();
		
		Thread thread1 = new Thread(b1);
		Thread thread2 = new Thread(b2);
		Thread thread3 = new Thread(b3);
		
		
		
		//anonymous class --> a class with no name which implements runnable
		//and overrides the run method
		Runnable runnable = new Runnable(){
			
			@Override
			public void run() {
				System.out.println("Hammad");
			}
			
		};
		
		Thread thread4 = new Thread(runnable);
		
		//thread3 is set to 'daemon' thread
		//'daemon' thread executes in the background
		//and is of very low priority and is generally
		//ignored by the JVM
		//it is used for garbage collection
		//and also provides user threads background-supporting tasks
		thread3.setDaemon(true);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		
	}
}
