
public class Drop {
	
	//an example of wait and notifyAll methods
	//when wait is invoked the current thread 
	//releases the lock and suspends execution. 
	//At some future time, another thread will acquire 
	//the same lock and invoke Object.notifyAll, informing all threads waiting 
	//on that lock that something important has happened
	
	
	//notify method wakes up a single thread, it is generally used with
	//programs with large number of threads
	
	private String message;
	
	//here 'key' is that lock
	private boolean key = true;
	
	public synchronized String getMessage() {
		
		while(key) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		key = true;
		notifyAll();
		return message;
	}
	
	public synchronized void putMessage(String message) {
		
		while(!key) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		key = false;
		this.message = message;
		notifyAll();
	}
	
}
