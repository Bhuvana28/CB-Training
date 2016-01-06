package phoneDirectory;
import java.util.*;


class Person{
	private String name;
	private String address;
	private HashMap<String,String> phoneNumbers = new HashMap<String,String>();

	Person(String name,String address,HashMap<String,String> phoneNumbers){
		this.name =name;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
	}

	public String getName(){
		return(name);
	}

	public String getAddress(){
		return(address);
	}

	public HashMap<String,String> getPhoneNumbers(){
		return(phoneNumbers);
	}	

	public void print(){
		System.out.println("\nName : " + name + "	Address : " + address + "\nPhone Numbers :");
		for(String tag : phoneNumbers.keySet()){
			System.out.print(tag + " - " + phoneNumbers.get(tag) + "	");
		}
		System.out.println("\n");
	}
}


public class PhoneDirectory{
	private HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

	private void storeInput(){
		

		//Person 1
		ArrayList<Person> persons1 = new ArrayList<Person>();
		HashMap<String,String> phone1 = new HashMap<String,String>();
		phone1.put("mobile","8374628872");
		persons1.add(new Person("bhuvana","OMR",phone1));

		pplList.put("bhuvana",persons1);
		
		//Person 2
	
		HashMap<String,String> phone2 = new HashMap<String,String>();
		phone2.put("mobile","6458637368");
		phone2.put("home","5638836");
		phone2.put("work","5638836");
		ArrayList<Person> persons2 = new ArrayList<Person>();
		persons2.add(new Person("vinothini","OMR",phone2));

		pplList.put("vinothini",persons2);		

		//Person 3 and 4
		ArrayList<Person> persons34 = new ArrayList<Person>();
		HashMap<String,String> phone3 = new HashMap<String,String>();
		phone3.put("mobile","9458637368");
		phone3.put("work","4658836");
		HashMap<String,String> phone4 = new HashMap<String,String>();
		phone4.put("mobile","7263476486");
		phone4.put("home","24834644");

		persons34.add(new Person("satya","Perungudi",phone3));
		persons34.add(new Person("satya","t Nagar",phone4));
		
		pplList.put("satya",persons34);			

		//Person 5
		HashMap<String,String> phone5 = new HashMap<String,String>();
		phone5.put("home","84567453");
		phone5.put("work","54737452");
		ArrayList<Person> persons5 = new ArrayList<Person>();
		persons5.add(new Person("siva","MGR",phone5));

		pplList.put("siva",persons5);		

	}


	private void display(){

		for(String name : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(name);
			ppl.forEach((person) -> {
				person.print();
			});		
		}
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
		for(String key : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(key);
			for(Person person : ppl){
				HashMap<String,String> phones = person.getPhoneNumbers();
				if(phones.containsValue(phoneNumber)){
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
		pndir.storeInput();
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