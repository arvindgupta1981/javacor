package au.com.softreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

 class WeakList<T> {
	private List<WeakReference<T>> weakList = new ArrayList<WeakReference<T>>();

	public boolean add(T e) {

		WeakReference<T> weakRef = new WeakReference<T>(e);
		return weakList.add(weakRef);
	}
	public T get(int index){
		return weakList.get(index).get();
	}

	public void read() {
		for (int x = 0; x < 1000; x++) {
			System.out.println(weakList.get(x).get());
			if (weakList.get(x) == null) {
				throw new NullPointerException("Argument Deleted!");
			}

		}
	}
}
 class SoftList<T> {
		private List<SoftReference<T>> softList = new ArrayList<SoftReference<T>>();

		public boolean add(T e) {

			SoftReference<T> weakRef = new SoftReference<T>(e);
			return softList.add(weakRef);
		}
		public T get(int index){
			return softList.get(index).get();
		}

		public void read() {
			for (int x = 0; x < 100000000; x++) {
				System.out.println(softList.get(x).get());
				if (x % 500 == 0)
					System.gc();
				if (softList.get(x).get() == null) {
					throw new NullPointerException("Argument Deleted!");
				}

			}
		}
	}
 
/* class phantomList<T> {
		private List<PhantomReference<T>> softList = new ArrayList<PhantomReference<T>>();

		public boolean add(T e) {

			PhantomReference<T> weakRef = new PhantomReference<T>(e);
			return softList.add(weakRef);
		}
		public T get(int index){
			return softList.get(index).get();
		}

		public void read() {
			for (int x = 0; x < 100000000; x++) {
				System.out.println(softList.get(x).get());
				if (x % 500 == 0)
					System.gc();
				if (softList.get(x).get() == null) {
					throw new NullPointerException("Argument Deleted!");
				}

			}
		}
	}
*/

 public class WeakTest {
	public static void main(String... g) {
		//WeakList<String> list=new WeakList<String>();
		SoftList<String> list=new SoftList<String>();
		for (int x = 0; x < 100000000; x++) {
			list.add(x + "");
			System.out.println("Added" + list.get(x));
			
		}
		list.read();
	}
}
