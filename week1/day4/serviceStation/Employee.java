package serviceStation;

public class Employee extends Person{
	private static int noOfEmployees = 0;
	private int empId;

	public Employee(String name, int age, double contact){
		super(name,age,contact);
		this.empId = ++noOfEmployees;
	}

}