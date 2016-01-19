package phoneDirectory;

import java.util.*;
import java.io.*;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  



public class InputJSONFile{
	
	public void storeInputJSON(String filename,HashMap<String,ArrayList<Person>> pplList) throws Exception{
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		Object obj= parser.parse(new BufferedReader(new FileReader(filename)));
		jsonObject = new JSONObject(obj.toString());
		JSONArray ppl = jsonObject.getJSONArray("persons");

		for(int index=0; index < ppl.length();index++){
			JSONObject person = ppl.getJSONObject(index);
			String name = person.getString("name");
			String address = person.getString("address");

			ArrayList<Phone> phones = new ArrayList<Phone>();
			
			if(person.has("mobile")){
				phones.add(new Phone(PhoneType.MOBILE,person.getString("mobile")));
			}
			
			if(person.has("home")){
				phones.add(new Phone(PhoneType.HOME,person.getString("home")));
			}
			
			if(person.has("work")){
				phones.add(new Phone(PhoneType.WORK,person.getString("work")));
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