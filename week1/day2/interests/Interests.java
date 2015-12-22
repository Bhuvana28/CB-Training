//Program to find simple and compound interest

package interests;

import java.util.Scanner;

class Interests{

	public static void main(String args[]){
		double principal,interestRate,termOfLoan;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Principal : ");
		principal = scanner.nextDouble();
		System.out.print("Interest Percentage : ");
		interestRate = scanner.nextDouble();
		System.out.print("Term of Loan : ");
		termOfLoan = scanner.nextDouble();

		InterestCalculator calc = new InterestCalculator(principal,interestRate,termOfLoan);


		System.out.println("Simple Interest = " + calc.getSimpleInterest());
		System.out.println("Compound Interest = " + calc.getCompoundInterest());

	}

}
