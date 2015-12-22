package companyDetails;

class Employee{
	private String name;
	private char gender;
	private float income;

	Employee(String name, char gender){
		this.name = name;
		this.gender = gender;
	}

	public Sring getEmployeeName(){
		return(name);
	}

	public char getEmployeeGender(){
		return(gender);
	}

	public int getEmployeeIncome(){
		return(income);
	}

	public void setEmployeeIncome(float income){
		this.income = income;
	}
s
}