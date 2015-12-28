package serviceStation;

public class Customer extends Person{
	private Employee emp;

	public Customer(String name, int age, double contact){
		super(name,age,contact);
	}

	public void setEmp(Employee emp){
		this.emp = emp;
	}

}