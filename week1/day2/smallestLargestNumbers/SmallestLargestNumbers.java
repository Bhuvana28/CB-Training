//Program to print the smallest and largest number in an integer array.

package smallestLargestNumbers;

import java.util.Scanner;
import java.util.ArrayList; 

class SmallestLargestNumbers{

	public static void main(String args[]){
		ArrayList<Integer> intArray = new ArrayList();
		int loopVar,n;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size : ");
		n = scanner.nextInt();

		System.out.println("Enter the array elements :");
		for(loopVar = 0 ; loopVar < n; loopVar++ ){
			intArray.add(scanner.nextInt());
		}

		MinMaxOfArray num = new MinMaxOfArray(intArray);

		System.out.println("Smallest = " + num.getMin() + " ,Largest  = " + num.getMax());

	}
	
	
}