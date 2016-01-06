import java.util.*;


public class MapLengthWords{

	public static void main(String args[]){

		String[] words = {"abc" , "hit" , "tall" , "four" , "three" , "six" ,"nine" ,"eleven" , "seven" ,"eight" , "twenty"};

		Map<Integer, ArrayList<String>> wordsMap = new HashMap<Integer, ArrayList<String>>();
		
		for(String s:words){
			Integer wordLen = s.length();
			ArrayList<String> wordList = wordsMap.get(wordLen);	
			if(wordList == null){
				wordsMap.put(wordLen,wordList=new ArrayList<String>());				
			}
			wordList.add(s);
		}

		System.out.println(wordsMap);

	}
}