//program to calculate simple and compund interests.

import java.lang.Math;

public class InterestCalculator{
	double principal,interestRate,termOfLoan,simpleInterest, compoundInterest;

	public InterestCalculator(double p, double i, double n){
		principal = p;
		interestRate = i;
		termOfLoan = n;
	}

	public double getSimpleInterest(){
		simpleInterest = principal * interestRate * termOfLoan;
		return simpleInterest;
	}

	public double getCompoundInterest(){
		compoundInterest = principal * Math.pow((1+interestRate),termOfLoan) - principal;
		return compoundInterest;
	}

}
