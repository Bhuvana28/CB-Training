package companyDetails;

import java.util.ArrayList;

class CompanyInit{
	
	public static void main(String args[]){
		Company company = new Company("xyz", "plc");
		company.addEmployee("A",'F',180000);
		company.addEmployee("B",'M',190000);
		company.addEmployee("C",'F',390000);
		company.addEmployee("D",'M',890000);
		company.addEmployee("E",'F',570000);

		IncomeTaxCalculator.calculateIncomeTax(company);
	}

}