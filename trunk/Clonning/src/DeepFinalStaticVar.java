
public class DeepFinalStaticVar {
	EmployeeT employee=null;;
	public DeepFinalStaticVar() {
		try {
			employee=(EmployeeT) new EmployeeT().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(employee.name);
		System.out.println(employee.id);
	}
	public static void main(String...p){
		new DeepFinalStaticVar();
	}
}

class EmployeeT implements Cloneable{
	final String name="Arvind";
	static String id="XYZ";
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}