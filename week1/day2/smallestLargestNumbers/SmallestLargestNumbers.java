//Program to print the smallest and largest number in an integer array.

import java.util.Scanner;


class SmallestLargestNumbers{

	public static void main(String args[]){
		int[] array;
		int loopVar,n,small,large;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size : ");
		n = scanner.nextInt();
		array = new int[n];

		System.out.println("Enter the array elements :");
		for(loopVar = 0 ; loopVar < n; loopVar++ ){
			array[loopVar] = scanner.nextInt();
		}

		findSmallandLargeNumbers num = new findSmallandLargeNumbers(n,array);
		small = num.getMin();
		large = num.getMax();

		System.out.println("Smallest = " + small + " ,Largest  = " + large);

	}
	
	
}