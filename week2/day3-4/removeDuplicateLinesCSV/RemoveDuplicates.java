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

		final String [] FILE_HEADER_MAPPING = {"id","firstname","lastname","gender","age"};

		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;

		BufferedWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;

		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
		CSVFormat csvFileWriteFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

		try{
			fileReader = new BufferedReader(new FileReader("removeDuplicateLinesCSV/student.csv"));
			fileWriter = new BufferedWriter(new FileWriter("removeDuplicateLinesCSV/students.csv"));

			csvFileParser = new CSVParser(fileReader,csvFileFormat);
			csvFilePrinter = new CSVPrinter(fileWriter,csvFileWriteFormat);

			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			Set<String> csvRecordsSet = new LinkedHashSet<String>();

			for(int i = 0; i < csvRecords.size(); i++){
				CSVRecord record = csvRecords.get(i);
				String student = record.get("id") + record.get("firstname") + record.get("lastname") + record.get("gender") + record.get("age");
				if(!csvRecordsSet.add(student)){
					csvRecords.remove(i);
				}
			}
			
			Iterator<CSVRecord> records = csvRecords.iterator();

			while(records.hasNext()){
				CSVRecord record = records.next();
				csvFilePrinter.printRecord(record);
			}

		}
		catch (Exception e){
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			fileReader.close();
			fileWriter.flush();
			fileWriter.close();
			csvFileParser.close();
			csvFilePrinter.close();
		}
	}
}