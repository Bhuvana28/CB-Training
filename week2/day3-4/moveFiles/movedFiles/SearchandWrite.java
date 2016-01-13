 //Write a program that would take in a text file and a search word as input. The program should write an output
 //file with the line number and the start indices of the search term in that line in the format <line-no>:<start-
 //index-1>,<start-index-2>. The name of the output file should be the <search-word>.locations.
package searchAndWrite;
import java.io.*;
import java.util.*;

public class SearchandWrite{
	public static void main(String args[]) throws IOException{
		Scanner inputReader = new Scanner(System.in);
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		String search,outputFile;
		System.out.print("Enter the word to search : ");
		search = inputReader.next();
		outputFile = "searchAndWrite/" + search + ".locations";

		try{
 			inputStream = new BufferedReader(new FileReader("wordOccurrenceinFile/input.txt"));
			outputStream = new PrintWriter(new FileWriter(outputFile));
 
			String str;
			Integer line = 0;
			while(( str = inputStream.readLine()) != null){
				line++;
				String[] words = str.split(" ");
				for(String word : words){
					if(word.toLowerCase().equals(search)){
						Integer indice = str.indexOf(word);
						String outStr = String.format( line +  " : " + indice + " , " + (indice + search.length()-1));
						outputStream.println(outStr);
					}
				}
					
			}	
		}finally{
			if(inputStream!=null){
				inputStream.close();
			}
			if(outputStream != null){
				outputStream.close();
			}
		}


	}
}