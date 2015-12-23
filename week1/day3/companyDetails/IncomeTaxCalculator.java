package companyDetails;

class IncomeTaxCalculator{

	public static double calculateIncomeTax(double income,double basicExemption){
		double taxPercent,taxableAmount = 0;

			if (income <= basicExemption) {
	            taxPercent = 0;
	        } else if (income >= basicExemption && income <= 500000) {
	            taxPercent = 0.1;
	            taxableAmount = (income - basicExemption) * taxPercent;
	        } else if (income >= 500001  && income <= 800000) {
	            taxPercent = 0.2;
	            taxableAmount = ((income-500001)*taxPercent) + ((500000-basicExemption) * 0.1); 
	        } else {
	        	taxPercent = 0.3;
	        	taxableAmount = ((income-800000)*taxPercent) + ((800000-500000)*0.2) + ((500000-basicExemption) * 0.1);
	        }

		return taxableAmount;
	}

}