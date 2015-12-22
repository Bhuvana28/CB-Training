//program to calculate simple and compund interests.

package interests;
import java.lang.Math;

public class InterestCalculator{
	double principal,interestRate,termOfLoan;

	public InterestCalculator(double p, double i, double n){
		principal = p;
		interestRate = i;
		termOfLoan = n;
	}

	public double getSimpleInterest(){
		return(principal * (interestRate/100) * termOfLoan);
		
	}

	public double getCompoundInterest(){
		return(principal * Math.pow((1+(interestRate/100)),termOfLoan) - principal);
		
	}

}
