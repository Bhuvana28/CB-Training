package companyDetails;

import java.util.ArrayList();

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

	public void printEmployees(){
		System.out.println("Employees : ");
		for(Employee employee : employees){
			System.out.println("Name : "+ employee.getEmployeeName() + "		Gender : " + employee.getEmployeeGender() + "	Income : " + employee.getEmployeeIncome());
		}
	}

	public void addEmployee(Employee employee){
		employees.add(employee);
	}

}