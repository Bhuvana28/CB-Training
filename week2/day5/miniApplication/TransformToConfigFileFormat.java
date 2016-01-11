package miniApplication;

import java.io.*;

import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

public class TransformToConfigFileFormat{

	public static String transformValueFormat(CSVRecord record){
		JSONParser parser = new JSONParser();

		try{

			JSONObject obj = (JSONObject)parser.parse(new BufferedReader(new FileReader("students-teachers.json")));
			
			

			

		}catch (FileNotFoundException e) {  
   			e.printStackTrace();  
  		}catch (IOException e) {  
   			e.printStackTrace();  
  		}catch (ParseException e) {  
   			e.printStackTrace();  
  		}		  
	}
	
}
