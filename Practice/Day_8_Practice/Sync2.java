
public class Sync2 {

	public static void main(String[] args) {
		
		Access access = new Access();
		
		Thread thread1 = new Thread(new Second(access));
		Thread thread2 = new Thread(new Second(access));
		Thread thread3 = new Thread(new Second(access));
		Thread thread4 = new Thread(new Second(access));
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

class Second implements Runnable{
	
	Access access;
	
	public Second(Access access) {
		this.access = access;
	}
	
	@Override
	public void run() {
		access.method1();
		access.method2();
		System.out.println(access.output());
	}
	
}
