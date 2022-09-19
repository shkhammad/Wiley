
public class Producer implements Runnable{
	
	private Drop drop;
	
	public Producer(Drop drop) {
		this.drop = drop;
	}
	
	@Override
	public void run() {
		
		String messages[] =  {"Hammad", "Kaivan", "Kajal", "Gauri"};
		int i,n=messages.length;
		
		for(i=0;i<n;++i) {
			drop.putMessage(messages[i]);
		}
		
		drop.putMessage("End");
	}
}
