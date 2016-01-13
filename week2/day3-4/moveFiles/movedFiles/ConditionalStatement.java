//Conditional Statement program.

import java.util.Scanner;

class ConditionalStatement{
	
	public static void main(String args[]){
		int x,y,z;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three numbers:");
		x = scanner.nextInt();
		y = scanner.nextInt();		
		z = scanner.nextInt();
		
		//Find minimum of x,y,z
        System.out.println("min = " + ((x < y && x < z) ? x : (y<x && y<z) ? y : z));
		
	}

}
