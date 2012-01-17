package au.com.Exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExc {
	List<String> l1=new ArrayList<String>();
	ListDelete lo=new ListDelete(l1);
	ListWrite lw=new ListWrite(l1);
	Thread read=new Thread(lo);
	Thread write=new Thread(lw);
	ConcurrentModificationExc(){
		for(int x=0;x<1000000;x++){
			l1.add(x+"");
		}
		read.start();
		write.start();
	}
	public static void main(String...g){
		new ConcurrentModificationExc();
	}
	
	
	
	
}

class ListDelete implements Runnable{
	List<String> l1;
	public ListDelete(List<String> l1) {
		this.l1=l1;
	}
	@Override
	public void run() {
		read();
	}
	
	public void read(){
		Iterator<String> it=l1.iterator();
		while(it.hasNext()){
		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(it.next());
		}
	}	
}
class ListWrite implements Runnable{
	List<String> l1;
	public ListWrite(List<String> l1) {
		this.l1=l1;
	}
	@Override
	public void run() {
		delete();
	}
	public void delete(){
		Iterator<String> it=l1.iterator();
		while(it.hasNext()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l1.remove(it.next());	
		}
	}
		
}

/*
class ListDelete implements Runnable{
	Vector<String> l1;
	public ListDelete(Vector<String> l1) {
		this.l1=l1;
	}
	@Override
	public void run() {
		read();
	}
	
	public void read(){
		Enumeration<String> e=l1.elements();
		//for(String str:l1){
		while(e.hasMoreElements()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.nextElement());
		}
	}	
}
class ListWrite implements Runnable{
	Vector<String> l1;
	public ListWrite(Vector<String> l1) {
		this.l1=l1;
	}
	@Override
	public void run() {
		delete();
	}
	public void delete(){
		Enumeration<String> e=l1.elements();
		//for(String str:l1){
		while(e.hasMoreElements()){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			l1.remove(e.nextElement());	
		}
	}
		
}*/