package miniApplication;

import java.io.*;

import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

import java.util.HashMap;
import java.util.ArrayList;

public class TransformToConfigFileFormat{

	public static void transformValueFormat(CSVRecord record){
		JSONParser parser = new JSONParser();

		try{
			JSONObject obj = (JSONObject)parser.parse(new BufferedReader(new FileReader("miniApplication/config1.json"))); 
			LinkedMap<String,String> csvRecordMap = (LinkedMap<String,String>)record.toMap();

			ArrayList<String> formattedValues = new ArrayList<String>();

			for(String heading : csvRecordMap.keySet()){
				String jsonValue;
				jsonValue = (String)obj.get(heading);	
				System.out.println(heading);
			}

		}catch (FileNotFoundException e) {  
			System.out.println("File not found");
   			e.printStackTrace();  
  		}catch (IOException e) {  
   			e.printStackTrace();  
  		}catch (ParseException e) {  
   		//	e.printStackTrace();  
  		}		  
	}
	
}
