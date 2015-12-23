package companyDetails;

import java.util.ArrayList;

class CompanyInit{
	
	public static void main(String args[]){
		Company company = new Company("xyz", "plc");
		company.addEmployee(new Employee("A",'F',180000));
		company.addEmployee(new Employee("B",'M',190000));
		company.addEmployee(new Employee("C",'F',390000));
		company.addEmployee(new Employee("D",'M',890000));
		company.addEmployee(new Employee("E",'F',570000));

		company.printEmployeesDetails();
	}

}