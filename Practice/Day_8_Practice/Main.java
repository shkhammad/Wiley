import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		
		Task task = new Task("Hammad");
		Task task2 = new Task("Samina");
		
		//creates a thread pool with fixed number of threads
		//at most nthreads --> 4 will be executing/processing tasks
		//If additional tasks are submitted when all threads are active,
		//they will wait in the queue until a thread is available
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		//Submits a value-returning task for execution and 
		//returns a Future representing the pending results of the task. 
		//The Future's get method will return the task's result upon successful completion.
		
		Future<String> result = executorService.submit(task);
		Future<String> result2 = executorService.submit(task2);
		
		try {
			System.out.println(result2.get());
			System.out.println(result.get());
			
		}
		
		catch(InterruptedException | ExecutionException e) {
			
			System.out.println("Error occured while executing the submitted task");
			e.printStackTrace();
		}
		
		// shutdown in which previously submitted tasks are executed, but no new tasks will be accepted
		executorService.shutdown();
	}
}

// designed for classes whose instances are potentially executed by another thread. 
//A Runnable, however, does not return a result and cannot throw a checked exception. 

class Task implements Callable<String>{
	
	private String message;

	public Task(String message) {
		this.message = message;
	}
	
	public String call() {
		return "Hi "+ message + "!";
	}
}
