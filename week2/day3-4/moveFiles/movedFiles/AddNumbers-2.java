// Program to add two numbers.

import java.util.Scanner;

class AddNumbers{

	public static void main(String args[]){
		int x,y,z;
		//Creates an object 'in' to accept input from terminal window.
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two numbers to add:");
		
		//Accepts one integer.
		x = in.nextInt();
		y = in.nextInt();
	
		//Addition of x and y is stored in z.
		z = x + y;

		//Prints the sum of two numbers.
		System.out.println("The sum of two numbers is " + z);
	}
}
