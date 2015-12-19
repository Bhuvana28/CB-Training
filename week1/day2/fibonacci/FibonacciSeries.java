
class FibonacciSeries{
	int N;

	public FibonacciSeries(int N){
		this.N = N;
	}

	public void getFiboSeries(){
		int loopVar,preNum1,preNum2,value=0;
		preNum1 = 0;
		preNum2 = 0;

		for(loopVar = 0;loopVar < N;loopVar++){
			if(preNum1==0 && preNum2==0){
				value = 1;
				System.out.print(value + " ");
			}else{
				value = preNum1 + preNum2;
				System.out.print(value + " ");
			}
			preNum2 = preNum1;
			preNum1 = value;
		}
	}
		
}
