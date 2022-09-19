//synchronized -------------->
//object-level intrinsic lock
//Every object has an intrinsic lock associated with it. 
//By convention, a thread that needs exclusive and consistent access 
//to an object's fields has to acquire the object's intrinsic lock 
//before accessing them, and then release the intrinsic lock when 
//it's done with them. A thread is said to own the intrinsic lock 
//between the time it has acquired the lock and released the lock. 
//As long as a thread owns an intrinsic lock, no other thread can 
//acquire the same lock. The other thread will block when it attempts 
//to acquire the lock.


//static synchronized --------------->
//class-level intrinsic lock
// a static method is associated with a class, not an object. 
//In this case, the thread acquires the intrinsic lock for the 
//Class object associated with the class. Thus access to class's 
//static fields is controlled by the lock 


//synchronized is much preferred then static synchronized (in my opinion)

class Test1 {
    	
	  //this program would give unexpected output
	  //since we have one method as synchronized and one as static-synchronized
      //to attain complete concurrency either both methods should be
	  //synchronized or both should be static-synchronized
	
	  public synchronized void countIncrement() { 
        System.out.println("Increment values");
        for (int i = 0; i < 3; i++) { 
            System.out.println(i); 
            try { 
                Thread.sleep(100); 
            } 
            catch (Exception e) { 
                System.out.println(e); 
            } 
        } 
    } 

	 public static synchronized void countDecrement() {
		System.out.println("Decrement values");
		for (int i = 3; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

class TestThread extends Thread {

	Test1 test;

	TestThread(Test1 test) {
		this.test = test;
	}

	@Override
	public void run() {
		test.countIncrement();
		Test1.countDecrement();
	}
}

public class StaticSynchronizedMethod {
	public static void main(String[] args) {
		
		// Object of Test1 class that is shared among threads
		Test1 obj = new Test1(); 

		TestThread thread1 = new TestThread(obj);
		TestThread thread2 = new TestThread(obj);

		thread1.start();
		thread2.start();
	}
}