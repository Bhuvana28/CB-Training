package phoneDirectory;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class InputCSVFile{
	
	private void storeInputCSV(String filename,HashMap<String,ArrayList<Person>> pplList) throws Exception{
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;

		final String [] FILE_HEADER_MAPPING = {"name","address","mobile","home","work"};

		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try{
			fileReader = new BufferedReader(new FileReader(filename));
			csvFileParser = new CSVParser(fileReader,csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();

			for(int i = 1; i < csvRecords.size(); i++){
				CSVRecord record = csvRecords.get(i);
			
				String name = record.get("name");
				String address = record.get("address");

				ArrayList<Phone> phones = new ArrayList<Phone>();
				String mobile = record.get("mobile");
				if(mobile != null){
					phones.add(new Phone(PhoneType.MOBILE,mobile));
				}
				String home = record.get("home");
				if(home != null){
					phones.add(new Phone(PhoneType.HOME,home));
				}
				String work = record.get("work");
				if(work != null){
					phones.add(new Phone(PhoneType.WORK,work));
				}
				ArrayList<Person> persons = new ArrayList<Person>();
				if(pplList.containsKey(name)){
					persons = pplList.get(name);
				}
				persons.add(new Person(name,address,phones));
				pplList.put(name,persons);	
			}

		}finally{
				fileReader.close();
				csvFileParser.close();
		}
	}


	
	public static void main(String args[]) throws Exception{

		Integer choice;
		String name,phoneNumber;

		Scanner scanner = new Scanner(System.in);
		HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

		InputCSVFile inputCSV = new InputCSVFile();
		inputCSV.storeInputCSV("phoneDirectory/persons.csv",pplList);

		PhoneDirectory pndir = new PhoneDirectory(pplList);
		pndir.display();

		do{
			System.out.println("1. Retrieve the details of the person(s) matching the given name.");
			System.out.println("2. Retrieve the details of the person(s) by looking for partial match also.");
			System.out.println("3. Retrieve the details of the person matching the given phone number.");
			System.out.println("4. Exit.");
			System.out.print("Enter your choice:");

			choice = new Integer(scanner.nextInt());

			switch(choice){
				case 1 : System.out.print("Enter name : ");
						 name = scanner.next();
						 pndir.namesMatched(name);
						 break;

				case 2 : System.out.print("Enter partial name : "); 
						 name = scanner.next();
						 pndir.namesPartialMatched(name);
						 break;

				case 3 : System.out.print("Enter phone number : "); 
						 phoneNumber = scanner.next();
						 pndir.phoneMatched(phoneNumber);
						 break;
			}			 

		}while(choice < 4);
	}
}
