//Program to find the summation of indices of the characters is even or odd.

import java.util.Scanner;

class SumOfCharacterIndices{

	public static void main(String args[]){
		int loopVar,sum=0;
		String string;
		char[] charArray;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string:");
		string = scanner.nextLine();
		charArray = string.toCharArray();

		for(loopVar=0;loopVar<charArray.length;loopVar++){
			
			if((int)charArray[loopVar] > 96 && (int)charArray[loopVar] <123){
				sum = sum + (int)charArray[loopVar]-96;
			}else if((int)charArray[loopVar] > 64 && (int)charArray[loopVar] < 91){
				sum = sum + (int)charArray[loopVar] - 64;
			}
				
		}

		if(sum%2 == 0){
			System.out.println("even");
		}else{
			System.out.println("odd");
		}
	}
}