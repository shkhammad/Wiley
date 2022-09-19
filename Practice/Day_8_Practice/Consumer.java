
public class Consumer implements Runnable{
	
	private Drop drop;
	
	public Consumer(Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		while(true) {
			String message = drop.getMessage();
			if(message.equals("End")) break;
			System.out.println(message);
			
		}
	}
}
