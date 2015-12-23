package companyDetails;

class IncomeTaxCalculator{
	

	public static int getTax(float income,float basicExemption){
	int taxPercent;
		if (income <= basicExemption) {
            taxPercent = 0;
        } else if (income >= basicExemption && income <= 500000) {
            taxPercent = 10;
        } else if (income >= 500001  && income <= 800000) {
            taxPercent = 20;
        } else {
        	taxPercent = 30;
        }

       return(taxPercent);
	} 

	public static void calculateIncomeTax(Company company){
		int taxPercent;
		float basicExemption,taxableAmount,income;

		for(Employee employee : company.getEmployees()){
			taxableAmount = 0;
			basicExemption = employee.getEmployeeGender() == 'M' ? 180000 : 190000;
			income = employee.getEmployeeIncome();
			taxPercent = getTax(income,basicExemption);
			
			switch(taxPercent){

				case 30 : 	
							taxableAmount = (income - 800000)* ((float)30/100);
							taxableAmount += (800000 - 500000) * ((float)20/100);
							taxableAmount += (500000 - basicExemption) * ((float)10/100);
							break;

				case 20 : 	
							taxableAmount = (income - 500000) * ((float)20/100);
							taxableAmount += (500000 - basicExemption) * ((float)10/100);
							break;

				case 10 :	
							taxableAmount = (500000 - basicExemption) * ((float)10/100);
							break;

			}


			System.out.println(employee.getEmployeeName() + " | " + employee.getEmployeeGender() + " | " + income + " | " + taxableAmount);
	
		}
		
	}

}