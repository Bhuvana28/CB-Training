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
			System.out.println("Name : "+ employee.getEmployeeName() + "		Gender : " + employee.getEmployeeGender() + "	Income : " + employee.getEmployeeIncome());
		}
	}

	public void addEmployee(String name, char gender, float income){
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeGender(gender);
		employee.setEmployeeIncome(income);
		employees.add(employee);
	}

	public ArrayList<Employee> getEmployees(){
		return(employees);
	}
}