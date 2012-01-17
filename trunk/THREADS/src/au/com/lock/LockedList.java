package au.com.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedList {
	List<String> l1=new ArrayList<String>();
	Lock lock=new ReentrantLock(); 
	ListDelete lo=new ListDelete(l1,lock);
	ListWrite lw=new ListWrite(l1,lock);
	
	Thread read=new Thread(lo);
	Thread write=new Thread(lw);
	LockedList(){
		for(int x=0;x<1000000;x++){
			l1.add(x+"");
		}
		read.start();
		write.start();
	}
	public static void main(String...g){
		new LockedList();
	}	
}

class ListDelete implements Runnable{
	List<String> l1;
	Lock lock;
	public ListDelete(List<String> l1, Lock lock) {
		this.l1=l1;
		this.lock=lock;
	}
	@Override
	public void run() {
		read();
	}
	
	public void read(){
		lock.lock();
		try{
			for(String str:l1){
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(str);
			}
		}catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		finally{
			lock.unlock();
		}
		
	}	
}
class ListWrite implements Runnable{
	List<String> l1;
	Lock lock;
	public ListWrite(List<String> l1, Lock lock) {
		this.l1=l1;
		this.lock=lock;
	}
	@Override
	public void run() {
		delete();
	}
	public void delete(){
		lock.lock();
		try{
			for(String str:l1){
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				l1.remove(str);	
			}
		}catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}finally{
			lock.unlock();
		}
	}
		
}