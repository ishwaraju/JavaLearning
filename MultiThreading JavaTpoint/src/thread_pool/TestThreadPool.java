package thread_pool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class WorkerThread implements Runnable{
	private String message;
	public WorkerThread(String s){
		this.message = s;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+ "start_message"+message);
		processmessage();//call processmessage
		System.out.println(Thread.currentThread().getName()+"end");
	}
	private void processmessage(){
		try {Thread.sleep(2000);}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}


public class TestThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating a pool of 5 threads
		ExecutorService executor = Executors.newFixedThreadPool(5); 
		for (int i = 0; i< 5 ; i++){
			Runnable worker = new WorkerThread(""+i);
			executor.execute(worker); //calling execute method of ExecutorService
		}
		executor.shutdown();
		while(!executor.isTerminated()){}
		System.out.println("Finished all threads");
	}

}
