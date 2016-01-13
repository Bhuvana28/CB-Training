
package miniApplication;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.HashSet;

public class CSVFile{
	private List<CSVRecord> inputRecords = new ArrayList<CSVRecord>();
	private final String[] INPUT_FILE_HEADER; 
	private final Object[] OUTPUT_FILE_HEADER;

	public CSVFile(String[] inputHeaders, String[] outputHeaders){
		INPUT_FILE_HEADER = inputHeaders;
		OUTPUT_FILE_HEADER = outputHeaders;
	}

	public void readInputCSV() throws IOException{
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(INPUT_FILE_HEADER);

		try{
			fileReader = new BufferedReader(new FileReader("miniApplication/sample-input.csv"));
			csvFileParser = new CSVParser(fileReader,csvFileFormat);
			inputRecords = csvFileParser.getRecords();
		}catch(Exception e){
			System.out.println(e);
		}finally{
			fileReader.close();
			csvFileParser.close();
		}
	}

	public void writeOutputCSV() throws IOException{
		BufferedWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;	
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");	
		try{
			fileWriter = new BufferedWriter(new FileWriter("miniApplication/output1.csv"));			
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileFormat);

			//csvFilePrinter.printRecord(OUTPUT_FILE_HEADER);
			Iterator<CSVRecord> records = inputRecords.iterator();
			LinkedList<String> record = transformValueFormat(records.next(),true);
			csvFilePrinter.printRecord(record);

			for(int index = 1; index<inputRecords.size();index++){
				record = transformValueFormat(inputRecords.get(index),false);	
				csvFilePrinter.printRecord(record);
				break;
			}
		}
		catch (Exception e){
			System.out.println("Error in writeOutputCSV");
			e.printStackTrace();
		}finally{
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		}
	}

	private LinkedList<String> transformValueFormat(CSVRecord record,boolean header){
		String dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
		String dateTimeFormat = "M/dd/yyyy HH:mm:ss";
		Double decimalValue = 0.01;
		JSONParser parser = new JSONParser();

		SimpleDateFormat datePattern = new SimpleDateFormat(dateTimePattern);
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
		LinkedList<String> formattedValues = new LinkedList<String>();
		HashSet<String> headersList = new HashSet<String>();

		LinkedHashMap<String,JSONObject> newColumnMap = new LinkedHashMap<String,JSONObject>();

		try{
			JSONObject obj = (JSONObject)parser.parse(new BufferedReader(new FileReader("miniApplication/config1.json"))); 

			for(String heading : INPUT_FILE_HEADER){
				JSONObject columnType = (JSONObject)obj.get(heading);	
				String type = (columnType != null ) ? (String)columnType.get("type") : null;
				if(type != null){
					switch(type){
						case "dateTime"	:	
											if(header){
												formattedValues.add(record.get(heading));
											}else{
												try{
													Date date = datePattern.parse(record.get(heading));
													formattedValues.add(dateFormat.format(date));
												}catch(Exception e){
													System.out.println("date parse error\n");
													e.printStackTrace();
												}
													
											}
											break;
						case "money"	:	
											if(header){
												formattedValues.add(record.get(heading));
											}else{
												double amount = Double.parseDouble(record.get(heading));
												amount = amount * decimalValue;
												formattedValues.add(Double.toString(amount));	
											}
											break;
						case "json"		:
											if(header){
												headersList.add((String)columnType.get("Column Name"));
											}else{
												String colName = (String)columnType.get("Column Name");
												JSONObject column = newColumnMap.containsKey(colName)? newColumnMap.get(colName) : new JSONObject();
												column.put((String)columnType.get("Field Name"),record.get(heading));	
												newColumnMap.put(colName,column);	
											}
											break;
				
					}
				}else{
					formattedValues.add(record.get(heading));
				}
			}
			if(header){
				for(String headerName : headersList){
					formattedValues.add(headerName);
				}
			}else{
				for(JSONObject jsonObj : newColumnMap.values()){
					formattedValues.add(jsonObj.toJSONString());		
				}
			}
			
		}catch (FileNotFoundException e) {  
			System.out.println("File not found");
   			e.printStackTrace();  
  		}catch (IOException e) {  
   			e.printStackTrace();  
  		}catch (ParseException e) {  
   			e.printStackTrace();  
  		}

  		return formattedValues;		  
	}
}