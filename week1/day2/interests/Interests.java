//Program to find simple and compound interest

package interests;

import java.util.Scanner;

class Interests{

	public static void main(String args[]){
		double principal,interestRate,termOfLoan,simpleInterest, compoundInterest;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Principal : ");
		principal = scanner.nextDouble();
		System.out.print("Interest Rate : ");
		interestRate = scanner.nextDouble();
		System.out.print("Term of Loan : ");
		termOfLoan = scanner.nextDouble();

		InterestCalculator calc = new InterestCalculator(principal,interestRate,termOfLoan);

		simpleInterest = calc.getSimpleInterest();
		compoundInterest = calc.getCompoundInterest();

		System.out.println("Simple Interest = " + simpleInterest);
		System.out.println("Compound Interest = " + compoundInterest);

	}

}