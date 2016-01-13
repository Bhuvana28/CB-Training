 //Write a program that would take in a text file and a search word as input. The program should write an output
 //file with the line number and the start indices of the search term in that line in the format <line-no>:<start-
 //index-1>,<start-index-2>. The name of the output file should be the <search-word>.locations.
package searchAndWrite;
import java.io.*;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				str = str.toLowerCase();
				line++;
				String regex = "\\b"+search.toLowerCase()+"\\b";
        		Pattern pattern = Pattern.compile(regex);
        		Matcher matcher = pattern.matcher(str);
        		while(matcher.find() == true){
    				String outStr = line +  " : " + matcher.start() + " , " + matcher.end();
					outputStream.println(outStr);
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