//Program to find simple and compound interest.

import java.lang.Math;

class SimpleCompoundInterest{

	public static void main(String args[]){
		double principal,interestRate,termOfLoan,simpleInterest, compoundInterest;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Principal :");
		principal = scanner.nextDouble();
		System.out.print("Interest Rate :");
		interestRate = scanner.nextDouble();
		System.out.print("Term of Loan :");
		termOfLoan = scanner.nextDouble();

		simpleInterest = principal * interestRate * termOfLoan;

		compoundInterest = principal * Math.pow((1+interestRate),termOfLoan) - principal;

		System.out.println("Simple interest = "+ simpleInterest);
		System.out.println("Compound interest = " + compoundInterest);
	}
}
