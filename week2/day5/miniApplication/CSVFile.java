
package miniApplication;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.text.SimpleDateFormat;

import java.io.*;
import java.util.*;

public class CSVFile{
	private List<CSVRecord> inputRecords = new ArrayList<CSVRecord>();
	private JSONObject jsonObject;
	private Set<String> fileHeaders;

	public CSVFile(){
		
	}

	public void readInputCSV(String filename) throws IOException{
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader();
			fileReader = new BufferedReader(new FileReader(filename));
			csvFileParser = new CSVParser(fileReader,csvFileFormat);

			inputRecords = csvFileParser.getRecords();
			fileHeaders = csvFileParser.getHeaderMap().keySet();
			
		}finally{
			fileReader.close();
			csvFileParser.close();	
		}
		
	}

	public void parseConfigJson(String filename) throws Exception{
		JSONParser parser = new JSONParser();
		Object obj =parser.parse(new BufferedReader(new FileReader(filename))); 
		jsonObject = new JSONObject(obj.toString());
	}

	public void writeOutputCSV(String filename) throws Exception{
		BufferedWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;	
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");	
		try{
			fileWriter = new BufferedWriter(new FileWriter(filename));			
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileFormat);

			setOutputFileHeader(csvFilePrinter);

			Iterator<CSVRecord> records = inputRecords.iterator();
			while(records.hasNext()){
				//System.out.println(records.next());
				transformValueFormat(csvFilePrinter,records.next());	
			}
		}finally{
			fileWriter.flush();
			fileWriter.close();
			csvFilePrinter.close();
		}
	}

	private void setOutputFileHeader(CSVPrinter csvPrinter) throws Exception{
		LinkedHashSet<String> headersList = new LinkedHashSet<String>();
		LinkedHashSet<String> jsonColumnHeaders = new LinkedHashSet<String>();
		
		for(String header : fileHeaders){
			JSONObject valueObject = jsonObject.optJSONObject(header);
			if(valueObject != null && (valueObject.getString("type")).equals("json")){
				jsonColumnHeaders.add(valueObject.getString("Column Name"));
			}else{
				headersList.add(header);	
			}
		}
		for(String header : jsonColumnHeaders){
			headersList.add(header);
		}

		csvPrinter.printRecord(headersList);
	}

	public String changeDateFormat(String fromPattern, String toPattern,String value) throws Exception{
		SimpleDateFormat datePattern = new SimpleDateFormat(fromPattern);
		SimpleDateFormat dateFormat = new SimpleDateFormat(toPattern);
		
		Date date = datePattern.parse(value);
		return dateFormat.format(date);
	}

	public String changetoDouble(Double decimalValue, Double value){
		return Double.toString(value*decimalValue);
	}

	public void changetoJSON(JSONObject columnObject,LinkedHashMap<String,JSONObject> columnMap,String value) throws JSONException{
		if(value != null && !value.isEmpty()){
			String colName = columnObject.getString("Column Name");
			JSONObject column = columnMap.containsKey(colName)? columnMap.get(colName) : new JSONObject();
			column.put(columnObject.getString("Field Name"),value);	
			columnMap.put(colName,column);		
		}
	}


	private void transformValueFormat(CSVPrinter csvPrinter,CSVRecord record) throws Exception{
		 
		//LinkedList<String> formattedValues = new LinkedList<String>();
		LinkedHashMap<String,JSONObject> newColumnMap = new LinkedHashMap<String,JSONObject>();

		//This loop converts all the column values to congig file format.
		for(String heading : fileHeaders){
			
			JSONObject valueObject = jsonObject.optJSONObject(heading);	
			String type = (valueObject != null) ? valueObject.getString("type") : null;
			if(type != null){
				switch(type){
					case "dateTime"	:	
										csvPrinter.print(changeDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'","M/dd/yyyy HH:mm:ss",record.get(heading)));	
										break;
					case "money"	:	
										csvPrinter.print(changetoDouble(0.01,Double.parseDouble(record.get(heading))));	
										break;
					case "json"		:	
										changetoJSON(valueObject,newColumnMap,record.get(heading));
										break;
				}
			}else{
				csvPrinter.print(record.get(heading));
			}
		}

		for(JSONObject jsonObj : newColumnMap.values()){
			csvPrinter.print(jsonObj.toString());		
		}

  		csvPrinter.println();
	}
	
}