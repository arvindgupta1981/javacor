class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      // This should never happen: It's Cloneable already!
      throw new RuntimeException(e);
    }
  }
}

class MadScientist extends Scientist {
}

public class DeepInheritence {
  public static void main(String[] args) {
	  //Clonning can be add at any level in inheritence it works perfectly for others.
    Person p = new Person();
    Hero h = new Hero();
    Scientist s = new Scientist();
    MadScientist m = new MadScientist();
    //! p = (Person)p.clone(); // Compile error
    //! h = (Hero)h.clone(); // Compile error
    s = (Scientist) s.clone();
    m = (MadScientist) m.clone();
  }
}