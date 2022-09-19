
public class Sync{
	
	public static void main(String[] args) {
		
		//synchronization is done for avoiding race condition
		//only one (common) object
		Resource resource = new Resource();
		
		Thread first = new Thread(new First(resource));
		Thread second = new Thread(new First(resource));
	
		first.setName("Thread1");
		second.setName("Thread2");
		
		second.start();
		first.start();
		
	}
}


class First implements Runnable{
	
	Resource resource;
	public First(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		resource.increment();
		resource.decrement();
	}
}


