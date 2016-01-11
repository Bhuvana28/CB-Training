
package miniApplication;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVFile{
	private List<CSVRecord> inputRecords = new ArrayList<CSVRecord>();
	private final String[] INPUT_FILE_HEADER_MAPPING; 
	private final Object[] OUTPUT_FILE_HEADER;

	public CSVFile(String[] inputHeaders, String[] outputHeaders){
		INPUT_FILE_HEADER_MAPPING = inputHeaders;
		OUTPUT_FILE_HEADER = outputHeaders;
	}

	public void readInputCSV() throws IOException{
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(INPUT_FILE_HEADER_MAPPING);

		try{
			fileReader = new BufferedReader(new FileReader("sample-input.csv"));
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
			fileWriter = new BufferedWriter(new FileWriter("miniApplication/output.csv"));			
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileFormat);

			csvFilePrinter.printRecord(OUTPUT_FILE_HEADER);
			
			Iterator<CSVRecord> records = inputRecords.iterator();

			while(records.hasNext()){
				CSVRecord record = records.next();
				String = TransformToConfigFileFormat.transformValueFormat(record);
				//csvFilePrinter.printRecord(record);
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

}