package au.com.softreference;
import java.lang.ref.WeakReference; 
import java.lang.ref.*; 
import java.util.*; 

public class ReferenceExample 
{ 
    public static void main(String[] args) 
    { 
        ReferenceQueue referenceQueue = new ReferenceQueue(); 
         
        Object object = new Object() 
        { 
            public String toString() 
            { 
                return "Referenced Object"; 
            } 
        }; 

        Object data = new Object() 
        { 
            public String toString() 
            { 
                return "Data"; 
            } 
        }; 
         
        HashMap map = new HashMap(); 
         
        Reference reference = null; 

    //Create the reference to the object 
     
    if ((args.length==0) || args[0].equalsIgnoreCase("-soft")) 
    { 
        System.out.println("Testing SoftReference."); 
        System.out.println("-------------------------"); 
        System.out.println(); 
        reference = new SoftReference(object, 
        referenceQueue); 
    } 
    else if (args[0].equalsIgnoreCase("-weak")) 
    { 
        System.out.println("Testing WeakReference."); 
        System.out.println("-------------------------"); 
        System.out.println(); 
        reference = new WeakReference(object, 
        referenceQueue); 
    } 
    else 
    { 
        System.out.println("Testing PhantomReference."); 
        System.out.println("-------------------------"); 
        System.out.println(); 
        reference = new PhantomReference(object, 
        referenceQueue); 
    } 
     
     
    //Associate data (value) with reference (key) in map 
    map.put(reference, data); 
     
    //Check that a reference to an object was created 
    System.out.println("Contents of reference: " + reference.get()); 
    System.out.println("Contents of Map: " + map.get(reference)); 
     
    //Check whether the Reference Object is enqueued 
    System.out.println("reference.isEnqueued(): " + reference.isEnqueued()); 
     
    //Run the garbage collector, and 
    //Check the reference objects referent 
    System.out.println("-----------------Running garbage collector now.------------------"); 
    System.gc(); 
    System.out.println("Contents of reference: " + reference.get()); 
    System.out.println("Contents of Map: " + map.get(reference)); 
    //Check whether the reference object is enqueued 
    System.out.println("reference.isEnqueued(): " + reference.isEnqueued()); 
     
    System.out.println(); 
    System.out.println("****Clearing all the strong references, thus freeing up objects for garbage collection."); 
    object = null; 
    data = null; 
     
    System.out.println("-----------------Running garbage collector now.------------------"); 
    System.gc(); 
    System.out.println("Contents of reference: " + reference.get()); 
    System.out.println("Contents of Map: " + map.get(reference)); 
    //Check whether the reference object is enqueued 
    System.out.println("reference.isEnqueued(): " + reference.isEnqueued()); 
} 
}