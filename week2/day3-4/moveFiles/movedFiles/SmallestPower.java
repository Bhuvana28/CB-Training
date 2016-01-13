//To find the smallest power of x that is greater than y.

import java.util.Scanner;

class SmallestPower{
	
	public static void main(String args[]){
		int x,y,z,power=1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the values of x and y:");
		x = scanner.nextInt();
		y = scanner.nextInt();
		z = x;
		//Calculates the smallest power.
		while(z < y){
			z = z * x;
			power++;
		}

		System.out.println("The smallest power of " + x + " that is greater than " + y + " is " + power); 
	}
}
