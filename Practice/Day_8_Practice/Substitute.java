
public class Substitute {
	
	public static void main(String[] args) {
		
		//an classic example of producer-consumer interaction
		//the producer-thread produces the data
		//the consumer-thread consumes the data
		//as usual, the two threads communicate using a shared object
		//the idea is the consumer thread must not attempt to retrieve 
		//the data before the producer thread has delivered it, 
		//and the producer thread must not attempt to deliver new data 
		//if the consumer hasn't retrieved the old data.
		
		Drop drop = new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
		
	}
}
