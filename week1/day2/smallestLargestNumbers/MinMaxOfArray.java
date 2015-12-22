
package smallestLargestNumbers;

import java.util.ArrayList; 
import java.util.Collections; 

class MinMaxOfArray{
	ArrayList<Integer> array = new ArrayList<Integer>();

	public MinMaxOfArray(ArrayList<Integer> array){
		this.array = array;
		Collections.sort(this.array);
	}

	public int getMin(){
		return(array.get(0));
	}

	public int getMax(){
		return(array.get(array.size()-1));
	}

}