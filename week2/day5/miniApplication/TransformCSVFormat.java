
package miniApplication;

import java.io.*;

public class TransformCSVFormat{

	public static void main(String args[]) throws IOException{
		
		String[] inputHeaders = {"Customer Id","Subscription Id","Invoice Number","Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice","Customer First Name","Customer Last Name","Customer Email","Customer Company","Tax Total"};	
		String[] outputHeaders = {"Customer Id","Subscription Id","Invoice Number","Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice","Tax Total","Customer Details"};
		CSVFile csv = new CSVFile(inputHeaders,outputHeaders);
		csv.readInputCSV();
		csv.writeOutputCSV();

	}
}