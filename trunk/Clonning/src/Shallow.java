
public class Shallow {
	public static void main(String...k){
		ShallowAutomatic automatic=new ShallowAutomatic();
		ShallowManual manual=new ShallowManual(2,"Arvind");
		try {
			System.out.println(automatic.hashCode() +":::"+((ShallowAutomatic)automatic.clone()).hashCode());
			System.out.println(manual.hashCode() +":::"+((ShallowManual)manual.clone()).hashCode());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
class ShallowAutomatic implements Cloneable{
	private int x;
	private String y;
	ShallowAutomatic(){
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}	
}
class ShallowManual implements Cloneable{
	private int x;
	private String y;
	ShallowManual(int x,String y){
		this.x=x;
		this.y=y;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ShallowManual manual=new ShallowManual(this.x, this.y);
		return manual;
	}	
}