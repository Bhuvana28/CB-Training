package companyDetails;

import java.util.ArrayList;

class Company{
	private String name,place;
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	Company(String name,String place){
		this.name = name;
		this.place = place;
	}

	Company(String name, String place, Employee employee){
		this.name = name;
		this.place = place;
		this.employees.add(employee);
	}

	Company(String name,String place,ArrayList<Employee> employees){
		this.name = name;
		this.place = place;
		this.employees = employees;
	}

	public String getCompanyName(){
		return(name);
	}

	public String getCompanyPlace(){
		return(place);
	}

	public void printEmployeesDetails(){
		System.out.println("Employees : ");
		for(Employee employee : employees){
			System.out.println(employee.getEmployeeName() + " | " + employee.getEmployeeGender() + " | " + employee.getEmployeeIncome() + " | " + employee.getEmployeeTaxableAmount());
		}	
	}

	public void addEmployee(Employee employee){
		employees.add(employee);
	}

	public ArrayList<Employee> getEmployees(){
		return(employees);
	}
}