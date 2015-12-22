//Program to find the summation of indices of the characters is even or odd.

import java.util.Scanner;

class SumOfCharacterIndices{

	public static void main(String args[]){
		int sum=0;
		String string;
		char[] charArray;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string:");
		string = scanner.nextLine();
		charArray = string.toCharArray();

		for(char character : charArray){
			if((int)character > 96 && (int)character <123){
				sum = sum + (int)character - 96;
			}else if((int)character > 64 && (int)character < 91){
				sum = sum + (int)character - 64;
			}
				
		}

        System.out.println(sum%2 == 0 ? "even": "odd");
	}
}