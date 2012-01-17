package au.com.thread;

public class RunnablevsThread {	
	public RunnablevsThread() {
		Runnable r=new MyThread();
		
		Thread thread1=new Thread(r);
		Thread thread2=new Thread(r);
		Thread thread3=new Thread(r);
	
		thread1.start();
		thread2.start();
		thread3.start();
		
	
	}
	public static void main(String[] h){
		new RunnablevsThread();
	}
	
	class MyThread extends Thread{
		int count=0;
		public MyThread() {
			//start();
		}
		@Override
		public void run() {
			++count;
			System.out.println(count);
		}
	}
	class MyRunnable implements Runnable{
		int count=0;
		@Override
		public void run() {
			++count;
		}
	}
}
