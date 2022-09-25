public class Resource {
	
	//this program is an example of structured lock
	//when a thread is executing increment
	//no thread can access increment or decrement methods until the lock
	//is release by the first thread and we achieve complete concurrency
	
	public void increment() {
		int i;
		
		//a common lock of current instance shared by the threads
		synchronized(this) {
			System.out.println("Increment: " + " " + Thread.currentThread().getName());
			for(i=1;i<=3;++i) {
				System.out.println(i);
				
	//			try {
	//				Thread.sleep(300);
	//			} catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
				
			}
		}
	}
	
	public void decrement() {
		int i;
		
		//a common lock of current instance shared by the threads
		synchronized(this) {
			System.out.println("Decrement: " + " " + Thread.currentThread().getName());
			for(i=3;i>=1;--i) {
				System.out.println(i);
				
	//			try {
	//				Thread.sleep(300);
	//			} catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
			}
		}
	}
	
}
