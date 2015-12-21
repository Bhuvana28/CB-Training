
package smallestLargestNumbers;

class findSmallandLargeNumbers{
		
	int n;
	int[] array;

	public findSmallandLargeNumbers(int n, int[] array){
		this.n = n;
		this.array = new int[n];
		this.array = array;
	}

	public int getMin(){
		int loopVar,min;
		min = array[0];
		for(loopVar=1;loopVar<n;loopVar++){
			if(min > array[loopVar]){
				min = array[loopVar];
			}
		}
		return min;
	}

	public int getMax(){
		int loopVar,max;
		max = array[0];
		for(loopVar = 1;loopVar<n;loopVar++){
			if(max < array[loopVar]){
				max = array[loopVar];
			}
		}
		return max;
	}
}