//Program to print numbers in a pattern.

import java.util.Scanner;

class Pattern{
	
	public static void main(String args[]){
		int loopVar1,loopVar2,number,tempRange,value,flag;
		Scanner scanner= new Scanner(System.in);
	
		System.out.print("Enter a number:");
		number = scanner.nextInt();
	
		tempRange =  2*(number-1) + 1;
		
		for(loopVar1 = 1;loopVar1 <= number; loopVar1++){
			value = 1;
			flag = 1;

			//Prints a line. 	
			for(loopVar2 = 1;loopVar2 <= tempRange;loopVar2++){
				
				//Prints required number of spaces before the number.
				if(loopVar2 <= (number-loopVar1)){
					System.out.print("  ");
				}else{	//Prints the numbers first increasing and then decreasing.

					if((loopVar2+(number-loopVar1)) <=  tempRange){ //Checks how many spaces left after printing a number.
						System.out.print(value + " ");
						if(value < loopVar1 && flag == 1){
							value++;
						}else{
							flag = 0;
							value--;
						}
					}else{
						System.out.println();
						break;
					}
				}
				
			}	 
		
		}
		System.out.println(); 		
	}

}
