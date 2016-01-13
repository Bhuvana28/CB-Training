package phoneDirectory;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  


public class PhoneDirectory{
	private HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

	private void storeInput(){
		//Person 1
		ArrayList<Person> persons1 = new ArrayList<Person>();
		/*HashMap<String,String> phone1 = new HashMap<String,String>();
		phone1.put("mobile","8374628872");*/

		ArrayList<Phone> phones1 = new ArrayList<Phone>();
		phones1.add(new Phone(PhoneType.MOBILE,"8374628872"));

		persons1.add(new Person("bhuvana","OMR",phones1));
		pplList.put("bhuvana",persons1);
		
		//Person 2
	
		/*HashMap<String,String> phone2 = new HashMap<String,String>();
		phone2.put("mobile","6458637368");
		phone2.put("home","5638836");
		phone2.put("work","5638836");*/
		
		ArrayList<Phone> phones2 = new ArrayList<Phone>();
		phones2.add(new Phone(PhoneType.MOBILE,"6458637368"));
		phones2.add(new Phone(PhoneType.HOME,"5638836"));
		phones2.add(new Phone(PhoneType.WORK,"5638834"));

		ArrayList<Person> persons2 = new ArrayList<Person>();
		persons2.add(new Person("vinothini","OMR",phones2));

		pplList.put("vinothini",persons2);		

		//Person 3 and 4
		ArrayList<Person> persons34 = new ArrayList<Person>();
		/*HashMap<String,String> phone3 = new HashMap<String,String>();
		phone3.put("mobile","9458637368");
		phone3.put("work","4658836");
		HashMap<String,String> phone4 = new HashMap<String,String>();
		phone4.put("mobile","7263476486");
		phone4.put("home","24834644");*/
		/* --------------------------------------------------------- */
		ArrayList<Phone> phones3 = new ArrayList<Phone>();
		phones3.add(new Phone(PhoneType.MOBILE,"9458637368"));
		phones3.add(new Phone(PhoneType.WORK,"4658836"));

		ArrayList<Phone> phones4 = new ArrayList<Phone>();
		phones4.add(new Phone(PhoneType.MOBILE,"7263476486"));
		phones4.add(new Phone(PhoneType.HOME,"24834644"));

		persons34.add(new Person("satya","Perungudi",phones3));
		persons34.add(new Person("satya","t Nagar",phones4));
		
		pplList.put("satya",persons34);			

		//Person 5
		/*HashMap<String,String> phone5 = new HashMap<String,String>();
		phone5.put("home","84567453");
		phone5.put("work","54737452");*/

		ArrayList<Phone> phones5 = new ArrayList<Phone>();
		phones5.add(new Phone(PhoneType.MOBILE,"84567453"));
		phones5.add(new Phone(PhoneType.WORK,"54737452"));

		ArrayList<Person> persons5 = new ArrayList<Person>();
		persons5.add(new Person("siva","MGR",phones5));

		pplList.put("siva",persons5);		

	}

	private void storeInputCSV(){
		BufferedReader fileReader = null;
		CSVParser csvFileParser = null;

		final String [] FILE_HEADER_MAPPING = {"name","address","mobile","home","work"};

		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try{
			fileReader = new BufferedReader(new FileReader("phoneDirectory/persons.csv"));

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

		}
		catch (Exception e){
			System.out.println("Error");
			e.printStackTrace();
		}finally{
			try{
				fileReader.close();
				csvFileParser.close();
			}catch(IOException e){
				System.out.println("Error while closing filereader");
				e.printStackTrace();
			}
		}
	}

	public void storeInputJSON(){
		JSONParser parser = new JSONParser();
		try{
			JSONObject jsonObject = (JSONObject)parser.parse(new BufferedReader(new FileReader("phoneDirectory/persons.json")));
			JSONArray ppl = (JSONArray)jsonObject.get("persons");

			for(int index=0; index < ppl.size();index++){
				JSONObject person = (JSONObject)ppl.get(index);
				String name = (String)person.get("name");
				String address = (String)person.get("address");

				ArrayList<Phone> phones = new ArrayList<Phone>();
				String mobile = (String)person.get("mobile");
				if(mobile != null){
					phones.add(new Phone(PhoneType.MOBILE,mobile));
				}
				String home = (String)person.get("home");
				if(home != null){
					phones.add(new Phone(PhoneType.HOME,home));
				}
				String work = (String)person.get("work");
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
	
		}catch (FileNotFoundException e) {  
   			e.printStackTrace();  
  		}catch (IOException e) {  
   			e.printStackTrace();  
  		}catch (ParseException e) {  
   			e.printStackTrace();  
  		}
		

	}

	private void display(){

		for(String name : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(name);
			ppl.forEach((person) -> {
				person.print();
			});		
		}
		//System.out.println(pplList);
	}

	private void namesMatched(String name){
		ArrayList<Person> ppl = pplList.get(name);
		if(ppl != null){
			ppl.forEach((person) -> {
				person.print();
			});
		}else{
			System.out.println("No entries matched with "+name);
		}
	}

	private void namesPartialMatched(String name){
		for(String key : pplList.keySet()){
			if(key.contains(name)){
				namesMatched(key);
			}
		}		
	}
	
	private void phoneMatched(String phoneNumber){
		/*for(String key : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(key);
			for(Person person : ppl){
				HashMap<String,String> phones = person.getPhoneNumbers();
				if(phones.containsValue(phoneNumber)){
					person.print();
				}	
			}	
		}*/

		for(String key : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(key);
			for(Person person : ppl){
				if(person.hasPhoneNumber(phoneNumber)){
					person.print();
				}	
			}
		}

	}

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		Integer choice;
		String name;
		String phoneNumber;

		PhoneDirectory pndir = new PhoneDirectory();
		pndir.storeInputJSON();
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