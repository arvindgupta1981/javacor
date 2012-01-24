import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Deep {
	public static void main(String[] args) {

	}
}
class DeepAutomatic implements Cloneable {
	
	Employee employee;
	DeepAutomatic(){
		
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(String name) {
		this.employee = new Employee(name);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		this.employee=(Employee)employee.clone();
		return super.clone();
	}
	
	
}
class DeepManual implements Cloneable {
	EmployeeNotClonned employee;
	DeepManual(){
		employee = new EmployeeNotClonned("arvind");
	}
	public EmployeeNotClonned getEmployee() {
		return employee;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//Manual if employee does not implement cloneable interface
		DeepManual manual=new DeepManual();
		manual.employee=new EmployeeNotClonned(this.employee.name);
		return super.clone();
	}
}
class DeepSerializable implements Cloneable {
	//Use for clonning of arrays
	// By useing of serialization process we create many clones
	EmployeeNotClonned[] employeeNotClonned=new EmployeeNotClonned[2500];
	ByteArrayOutputStream out=null;
	private void setEmployee(){
		for(int x=0;x<2500;x++){
			employeeNotClonned[x]=new EmployeeNotClonned("Arvind:"+x);
		}		
	}
	private void serializeEmployee(){
		try {
			out = new ByteArrayOutputStream();
			ObjectOutputStream stream=new ObjectOutputStream(out);
			for(int x=0;x<2500;x++){
				stream.writeObject(employeeNotClonned[x]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		DeepSerializable deepcopy=new DeepSerializable();
		try {
			ObjectInputStream  stream=new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
			for(int x=0;x<2500;x++){
				try {
					deepcopy.employeeNotClonned[x]=(EmployeeNotClonned) stream.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.clone();
	}
	
}
class Employee implements Cloneable{
	String name;
	public Employee(String name) {
		this.name=name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
class EmployeeNotClonned implements Serializable{
	String name;
	public EmployeeNotClonned(String name) {
		this.name=name;
	}
}