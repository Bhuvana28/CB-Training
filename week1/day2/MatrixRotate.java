//Program to rotate a 2D matrix right/left.

import java.util.Scanner;

class MatrixRotate{

	public static void main(String[] args) {
			int rows=3,cols=3,loopVar1,loopVar2;
			int[][] rotatedMatrix;

			/*Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the dimension of the matrix:");
			rows = scanner.nextInt();
			cols = scanner.nextInt(); */

			int[][] matrix = {
						{1,2,3},
						{4,5,6},
						{7,8,9}
					 };

			rotatedMatrix = new int[cols][rows];

			//Roates the matrix left.
			for(loopVar1=(cols-1);loopVar1>=0;loopVar1--){ //Access the matrix column wise.
				for(loopVar2=0;loopVar2<rows;loopVar2++){  //Access the matrix row wise.

					//each value in matrix is stored in its rotated position in rotatedMatrix.
					rotatedMatrix[cols-loopVar1-1][loopVar2] = matrix[loopVar2][loopVar1];
					System.out.print(rotatedMatrix[cols-loopVar1-1][loopVar2] + " ");
				}
				System.out.println();
			}
	}
}