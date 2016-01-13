package miniApplication;

import java.io.*;

public class TransformCSVFormat{

	public static void main(String args[]) throws Exception{
		
		CSVFile csv = new CSVFile();
		csv.readInputCSV("miniApplication/Input.csv");
		csv.parseConfigJson("miniApplication/config1.json");
		csv.writeOutputCSV("miniApplication/output.csv");

	}
}