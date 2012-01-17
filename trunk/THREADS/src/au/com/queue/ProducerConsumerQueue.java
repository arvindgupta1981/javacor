package au.com.queue;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerQueue {
	BlockingQueue<Pizza> pizzaQueue=new SynchronousQueue<Pizza>();
	
	Producer producer=new Producer(pizzaQueue);
	Consumer consumer=new Consumer(pizzaQueue);
	Thread producerT=new Thread(producer);
	Thread consumerT=new Thread(consumer);
	
	public static void main(String...g){
		ProducerConsumerQueue producerConsumerQueue= new ProducerConsumerQueue();
		producerConsumerQueue.producerT.start();
		producerConsumerQueue.consumerT.start();
	}
}	
class Producer implements Runnable{
	BlockingQueue<Pizza> pizzaQueue=null;
	int count=0;
	public Producer(BlockingQueue<Pizza> pizzaQueue) {
		this.pizzaQueue=pizzaQueue;
		
		
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			try {
				this.pizzaQueue.put(new Pizza(1));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(++count+":::Producer:::::"+pizzaQueue.size());
			//if(count==5)this.pizzaQueue.clear();
			
		}
	}
	
	
}
class Consumer implements Runnable{
	BlockingQueue<Pizza> pizzaQueue=null;
	int count=0;
	public Consumer(BlockingQueue<Pizza> pizzaQueue) {
		this.pizzaQueue=pizzaQueue;
		
		
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
				//new LinkedList<String>(null); //null pointer exception
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(++count+"::::Consumer:::::"+pizzaQueue.size());
			this.pizzaQueue.poll();
			
		}
	}	
}
class Pizza {
	private int size;
	public Pizza(int size) {		
		this.size = size;
	}
	
}