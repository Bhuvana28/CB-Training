package companyDetails;

class Employee{
	private String name;
	private char gender;
	private float income;

	/*Employee(String name, char gender, float income){
		this.name = name;
		this.gender = gender;
		this.income = income;
	}*/

	public void setEmployeeName(String name){
		this.name = name;
	}

	public void setEmployeeGender(char gender){
		this.gender = gender;
	}

	public String getEmployeeName(){
		return(name);
	}

	public char getEmployeeGender(){
		return(gender);
	}

	public float getEmployeeIncome(){
		return(income);
	}

	public void setEmployeeIncome(float income){
		this.income = income;
	}

}