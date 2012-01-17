package au.com.ExecutorFramework;

import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

public class ThreadLocalExample {
	/*private static ThreadLocal<testService> threadLocal=new ThreadLocal<testService>();
	public void set(testService ts){
		if()
	}*/
	TestService3 service=new TestService3();
	Thread t1=new Thread(service);
	Thread t2=new Thread(service);
	
	TestService2 service2=new TestService2();
	Thread t12=new Thread(service2);
	Thread t22=new Thread(service2);
	public ThreadLocalExample() {
		t1.start();
		t2.start();
		
		t12.start();
		t22.start();
	}
	public static void main(String...k){
		new ThreadLocalExample();
	}
}
class TestService3 implements Runnable{
	private static ThreadLocal<Integer> local=new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 10;
		}		
		
	};
	
	TestService3(){
		
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
class TestService2 implements Runnable{
	int x=10;	
	public void update(){
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("2Beforexxxxxxxxx:"+x);
		x=100;
		System.out.println("2Afterxxxxxxxxx:"+x);
	}
	
	@Override
	public void run() {
		update();
		
	}
	
}




