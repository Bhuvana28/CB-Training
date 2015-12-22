//Program to print Fibonacci series upto N number.

package fibonacci;
import java.util.Scanner;

class Fibonacci{
	
	public static void main(String args[]){
		int n;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter N:");
		n = scanner.nextInt();

		FibonacciSeries fibo = new FibonacciSeries(n);
		fibo.getFiboSeries();
	}
}