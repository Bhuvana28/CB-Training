import java.util.Scanner;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Factorial implements Iterable<Integer>{
	private Integer lowerLimit;
	private Integer upperLimit;

	Factorial(Integer lowerLimit,Integer upperLimit){
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	class FactorialIterator implements Iterator<Integer>{
  		private Integer currentValue;

  		public FactorialIterator(){
  			currentValue = Factorial.this.lowerLimit;
  		}

		@Override
		public boolean hasNext(){
			return currentValue <= Factorial.this.upperLimit;
		}

		@Override
		public Integer next(){
			if(this.hasNext()){
				Integer current = currentValue;
				currentValue ++ ;
				return current;
			}
			throw new NoSuchElementException();
		}
	}

	@Override
	public Iterator<Integer> iterator(){
		return(new FactorialIterator());
	}

	private Integer factorial(Integer number){
		if(number.equals(0)){
			return 1;
		} else{
			return number * factorial(number-1);
		}
	}

	@Override
	public String toString(){
		String str = "";
		Iterator<Integer> it = iterator();

		while(it.hasNext()){
			Integer value = it.next();
			if(it.hasNext()){
				str = str + factorial(value) + ", ";	
			}else{
				str =str+ factorial(value) +"\n";		
			}	
		}
		
		return str;
	}
}

public class FactorialProj{

	public static void main(String args[]){
		Integer lowerLimit,upperLimit;
		String str;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter lower limit:");
		lowerLimit = scanner.nextInt();
		System.out.print("Enter lower limit:");
		upperLimit = scanner.nextInt();

		Factorial fact = new Factorial(lowerLimit,upperLimit);

		str = fact.toString();
		System.out.print(str);


	}
}