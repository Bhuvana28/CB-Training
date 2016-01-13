package phoneDirectory;

import java.util.*;
import java.io.*;

public class InputCollections{

	private void storeInput(HashMap<String,ArrayList<Person>> pplList){
		//Person 1
		ArrayList<Person> persons1 = new ArrayList<Person>();

		ArrayList<Phone> phones1 = new ArrayList<Phone>();
		phones1.add(new Phone(PhoneType.MOBILE,"8374628872"));
		persons1.add(new Person("bhuvana","OMR",phones1));
		pplList.put("bhuvana",persons1);
		
		//Person 2
	
		ArrayList<Phone> phones2 = new ArrayList<Phone>();
		phones2.add(new Phone(PhoneType.MOBILE,"6458637368"));
		phones2.add(new Phone(PhoneType.HOME,"5638836"));
		phones2.add(new Phone(PhoneType.WORK,"5638834"));

		ArrayList<Person> persons2 = new ArrayList<Person>();
		persons2.add(new Person("vinothini","OMR",phones2));

		pplList.put("vinothini",persons2);		

		//Person 3 and 4
		ArrayList<Person> persons34 = new ArrayList<Person>();
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
		ArrayList<Phone> phones5 = new ArrayList<Phone>();
		phones5.add(new Phone(PhoneType.MOBILE,"84567453"));
		phones5.add(new Phone(PhoneType.WORK,"54737452"));

		ArrayList<Person> persons5 = new ArrayList<Person>();
		persons5.add(new Person("siva","MGR",phones5));

		pplList.put("siva",persons5);		

	}

	public static void main(String args[]){
		Integer choice;
		String name,phoneNumber;

		Scanner scanner = new Scanner(System.in);
		HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

		InputCollections input = new InputCollections();
		input.storeInput(pplList);

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
