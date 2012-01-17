package au.com.ExecutorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
	ExecutorService executor=Executors.newFixedThreadPool(10);
	public static void main(String...g){
		
	}
}
class TestService implements Runnable{
	private static ThreadLocal<Integer> local=new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 10;
		}		
		
	};
	
	TestService(){
		
	}
	
	public void update(){
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Beforexxxxxxxxx:"+local.get());
		local.set(100);
		System.out.println("Afterxxxxxxxxx:"+local.get());
	}
	@Override
	public void run() {
		update();
		
	}
	
} 