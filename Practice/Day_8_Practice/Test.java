import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		
			System.out.println(
	            "A count-down-clock program that counts from 10 to 0");
	  
	        // creating a ScheduledExecutorService object
			//Creates a thread pool that can schedule threads 
			//to run after a given delay, or to execute periodically.
	        ScheduledExecutorService scheduler
	            = Executors.newScheduledThreadPool(11);
	  
	        // printing the current second
	        System.out.println(
	            "Current time : "
	            + Calendar.getInstance().get(Calendar.SECOND));
	  
	        
	        int i;
	        
	        // Scheduling the tasks
	        for (i = 10; i >= 0; i--) {
	            scheduler.schedule(new Tasks(i), 10-i,
	                               TimeUnit.SECONDS);
	        }
	  
	        // remember to shutdown the scheduler
	        // so that it no longer accepts
	         // any new tasks
	        scheduler.shutdown();
	    
		
		
	}
}

class Tasks implements Runnable {
    private int num;
    public Tasks(int num) { this.num = num; } 
    public void run()
    {
        System.out.println(
            "Number " + num + " Current time : "
            + Calendar.getInstance().get(Calendar.SECOND));
    }
}
