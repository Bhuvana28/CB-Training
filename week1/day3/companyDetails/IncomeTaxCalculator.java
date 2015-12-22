package complanyDetails;

class IncomeTaxCalculator{
	private int taxPercent = 0;
	private float taxableAmount = 0;

	public void getTaxAmountForFemale(double income){
        if (income <= 190000) {
            taxPercent = 0;
        }else if (income >= 190001 && income <= 500000) {
            taxPercent = 10;
        }else if (income >= 500001  && income <= 800000) {
            taxPercent = 20;
        }else if(income >= 800001){
        	taxPercent = 30;
        }

	}

	public getTaxAmountForMale(double income){
		if (income <= 180000) {
            taxPercent = 0;
        } else if (income >= 180001 && income <= 500000) {
            taxPercent = 10;
        } else if (income >= 500001  && income <= 800000) {
            taxPercent = 20;
        } else {
        	taxPercent = 30;
        }

	}

	public static double calculateIncomeTax(Employee employee){
		
	}

}