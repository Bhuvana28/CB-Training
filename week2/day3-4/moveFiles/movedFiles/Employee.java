package companyDetails;

class Employee{
	private String name;
	private char gender;
	private double income;
	private double taxableIncome;

	Employee(String name, char gender, double income){
		float basicExemption;
		this.name = name;
		this.gender = gender;
		this.income = income;
		basicExemption = (gender == 'M') ? 180000 : 190000;
		taxableIncome = IncomeTaxCalculator.calculateIncomeTax(income,basicExemption);
	}

	public String getEmployeeName(){
		return(name);
	}
	
	char getEmployeeGender(){
		return(gender);
	}

	public double getEmployeeIncome(){
		return(income);
	}

	public double getEmployeeTaxableAmount(){
		return(taxableIncome);
	}
}