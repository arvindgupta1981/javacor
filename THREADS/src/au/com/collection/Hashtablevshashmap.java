package au.com.collection;

import java.util.HashMap;

public class Hashtablevshashmap{
	public Hashtablevshashmap() {
		HashMap<Person, Person> ht=new HashMap<Person, Person>();
		ht.put(new Person("A"), new Person("A"));
		System.out.println(ht.get(new Person("A")));
		
	}
	public static void main(String...f){
		new Hashtablevshashmap();
	}
}
class Person{
	String name;
	public Person(String name) {
		this.name=name;
	}
	/*@Override
	public boolean equals(Object arg0) {
		Person p=(Person)arg0;		
		if(this==p)return true;
		if(!(p instanceof Person))return false;
		if(this.name==p.name)return true;
		return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode() * 999;
		
	}*/
	
	
}