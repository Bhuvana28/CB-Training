package phoneDirectory;

import java.util.*;
import java.io.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  



public class InputJSONFile{
	
	public void storeInputJSON(String filename,HashMap<String,ArrayList<Person>> pplList) throws Exception{
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject = (JSONObject)parser.parse(new BufferedReader(new FileReader(filename)));
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
	}

	public static void main(String args[]) throws Exception{
		Integer choice;
		String name,phoneNumber;

		Scanner scanner = new Scanner(System.in);
		HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

		InputJSONFile inputJSON = new InputJSONFile();
		inputJSON.storeInputJSON("phoneDirectory/persons.json",pplList);

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