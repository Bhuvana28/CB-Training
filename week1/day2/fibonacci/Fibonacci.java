//Program to print Fibonacci series upto N number.

package fibonacci;
import java.util.Scanner;

class Fibonacci{
	
	public static void main(String args[]){
		int N;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter N:");
		N = scanner.nextInt();

		FibonacciSeries fibo = new FibonacciSeries(N);
		fibo.getFiboSeries();
	}
}