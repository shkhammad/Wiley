//Remember, the order of execution of threads cannot be determined
//and will always be weird :)

public class BasicThread extends Thread{
	
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);;
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Hi");
		
	}
	
	public static void main(String[] args) {
		
		//instance of the current class
		//for creating a thread we can extend the thread class
		BasicThread thread = new BasicThread(); 
		BasicThread thread2 = new BasicThread(); 
	
		
		//anonymous class --> a class with no name that extends
		//thread class and we override the run method
		Thread thread3 = new Thread() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("Hello World !");
			}
			
		};
		
		//setPriority method doesn't guarantee order of execution 
		//may/may not be true
		
		//normal priority
		thread.setPriority(5);
		thread2.setPriority(5);
		
		//high priority
		thread3.setPriority(10);
		
	 	
		thread3.start();
		
		try {
			
			//waits for the current thread to die
			//and then only start the second (next) thread
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
