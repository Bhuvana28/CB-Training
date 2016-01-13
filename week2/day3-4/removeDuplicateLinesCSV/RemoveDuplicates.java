//Given an input CSV file, write a program to output a new CSV file with all the duplicate lines removed.

package removeDuplicateLinesCSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.util.*;
import java.io.*;

public class RemoveDuplicates{
	public static void main(String args[]) throws IOException{

		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;

		BufferedWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;

		Set<String> fileHeaders;

		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader();
		CSVFormat csvFileWriteFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

		try{
			fileReader = new BufferedReader(new FileReader("removeDuplicateLinesCSV/student.csv"));
			fileWriter = new BufferedWriter(new FileWriter("removeDuplicateLinesCSV/students.csv"));

			csvFileParser = new CSVParser(fileReader,csvFileFormat);
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileWriteFormat);

			//Getting file headers;
			fileHeaders = csvFileParser.getHeaderMap().keySet();

			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			List<String> csvRecordsSet = new LinkedList<String>();

			csvFilePrinter.printRecord(fileHeaders);

			Iterator<CSVRecord> records = csvRecords.iterator();
			while(records.hasNext()){
				CSVRecord record = records.next();
				String student = "";
				for(String header : fileHeaders){
					student += record.get(header);
				}
				//Checking if the record already exits in the list.
				if(!csvRecordsSet.contains(student)){
					csvRecordsSet.add(student);
					csvFilePrinter.printRecord(record);	//writing a record to the output students file.
				}
			}

		}finally{
			fileReader.close();
			fileWriter.close();
			csvFileParser.close();
			csvFilePrinter.close();
		}
	}
}