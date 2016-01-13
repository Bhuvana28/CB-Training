
package fibonacci;

class FibonacciSeries{
	private int n;

	public FibonacciSeries(int n){
		this.n = n;
	}

	public void getFiboSeries(){
		int loopVar,preNum1,preNum2,value=1;
		preNum1 = 0;
		preNum2 = 0;
		
		System.out.print(value + " ");
		for(loopVar = 1;loopVar < n;loopVar++){
			preNum2 = preNum1;
			preNum1 = value;
			value = preNum1 + preNum2;
			System.out.print(value + " ");
		}
	}
		
}
