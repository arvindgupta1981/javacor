package au.com.collection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class IteratorvsEnumuration {
	List<Person> list=new ArrayList<Person>();
	Vector<Person> v=new Vector<Person>();
	
	public IteratorvsEnumuration() {
		list.add(new Person("1000"));
		list.add(new Person("1000"));
		list.add(new Person("1000"));
		
		v.add(new Person("1000"));
		v.add(new Person("1000"));
		v.add(new Person("1000"));
		Iterator<Person> it=list.iterator();
		while(it.hasNext()){
			it.next().setAge("10");
		}
		System.out.println(list);
		
		Enumeration<Person> e=v.elements();
		while(e.hasMoreElements()){
			e.nextElement().setAge("20");
		}
		System.out.println(v);
	}
	public static void main(String...j){
		new IteratorvsEnumuration();
	}	 
	private class Person{
		private String age;
		
		public Person(String age) {
			super();
			this.age = age;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [age=" + age + "]";
		}
		
	}
}
