//Write a program which reads a text file. List all the words in alphabetical order with number of occurrence for
//each word and write the list into another text file in the format [word]:[number of times it occurred].
package wordOccurrenceinFile;
import java.io.*;
import java.util.*;

public class WordOccurrenceinFile{
	public static void main(String argsp[]) throws IOException{
		//System.out.println("Hello");
		Scanner s = null;
		PrintWriter outputStream = null;
		TreeMap<String,Integer> wordOccurrences = new TreeMap<String,Integer>();

		try{
			s = new Scanner(new BufferedReader(new FileReader("wordOccurrenceinFile/input.txt")));
			outputStream = new PrintWriter(new FileWriter("wordOccurrenceinFile/output.txt"));
			while(s.hasNext()){
				String word = s.next().toLowerCase();
				Integer count = wordOccurrences.get(word);
          		wordOccurrences.put(word,(count == null)? 1 : count +1 );
			}	

			for(String word : wordOccurrences.keySet()){
				Integer count = wordOccurrences.get(word);
				String str = "[" + word + "] : [" + count + "].";
				outputStream.println(str);
			}

		}finally{
			if(s!=null){
				s.close();
			}
			if(outputStream != null){
				outputStream.close();
			}
		}
	}
}
