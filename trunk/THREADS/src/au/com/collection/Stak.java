package au.com.collection;



class Stack<T> {
	private T t[]=(T[])new Object[100];
	int pos=-1;
	Stack(){
		//t[]=(T[])new Object[100];
	}
	public void push(T e){
		t[++pos]=e;
	}
	public T pop(){
		return t[pos--];
	}
}
class StackList<T>{
	private Node topNode;
	public void push(T e){
		topNode=new Node(e,topNode);
	}
	public T pop(){
		T e=(T)topNode.element;
		topNode=topNode.next;
		return e;
	}
	class Node<T>{
		T element;
		Node next;		
		Node(T t){
			element=t;
			next=null;
			
		}
		Node(T t,Node topNode){
			next=topNode;
			element=t;
			
		}
	}
}
class BST<T extends Comparable<T>>{
	 BSTNode rootNode=null;
	public void insert(Comparable<T> e,BSTNode rootNode) throws Exception{
		if(this.rootNode==null){
			this.rootNode=new BSTNode(e, null, null);
			return;
		}
		if(this.rootNode.getElement().compareTo(e)>0){
			rootNode=new BSTNode(e,rootNode.leftNode, rootNode.rightNode);
		}else if(this.rootNode.getElement().compareTo(e)<0){
			
		}else{
			throw new Exception("Duplicate:");
		}
	}
	class BSTNode<T extends Comparable<T>>{
		public T element;
		public BSTNode leftNode;
		public BSTNode rightNode;
		public BSTNode(T element,BSTNode leftNode,BSTNode rightNode) {
			this.element=element;
			this.leftNode=leftNode;
			this.rightNode=rightNode;
		}		
		public T getElement() {
			return element;
		}
		
	}
	
}

class Agent{
	int age;
	Agent(int age){
		this.age=age;
	}
}
public class Stak{
	StackList<Agent> s=new StackList<Agent>();
	public void create(){
		for(int x=0;x<100;x++){
			s.push(new Agent(x));
		}
	}
	public void read(){
		for(int x=0;x<100;x++){
			System.out.println(s.pop().age);
		}
	}
	public static void main(String...f){
		Stak s=new Stak();
		s.create();
		s.read();
	}
}