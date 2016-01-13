package phoneDirectory;

import java.util.*;

public class PhoneDirectory{
	private HashMap<String,ArrayList<Person>> pplList= new HashMap<String,ArrayList<Person>>();

	public PhoneDirectory(HashMap<String,ArrayList<Person>> pplList){
		this.pplList = pplList;
	}

	public void display(){
		for(String name : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(name);
			ppl.forEach((person) -> {
				person.print();
			});		
		}
	}

	public void namesMatched(String name){
		ArrayList<Person> ppl = pplList.get(name);
		if(ppl != null){
			ppl.forEach((person) -> {
				person.print();
			});
		}else{
			System.out.println("No entries matched with "+name);
		}
	}

	public void namesPartialMatched(String name){
		for(String key : pplList.keySet()){
			if(key.contains(name)){
				namesMatched(key);
			}
		}		
	}
	
	public void phoneMatched(String phoneNumber){
		for(String key : pplList.keySet()){
			ArrayList<Person> ppl = pplList.get(key);
			for(Person person : ppl){
				if(person.hasPhoneNumber(phoneNumber)){
					person.print();
				}	
			}
		}

	}
		
}