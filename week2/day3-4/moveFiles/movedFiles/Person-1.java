package phoneDirectory;
import java.util.ArrayList;

public class Person{
	private String name;
	private String address;
	//private HashMap<String,String> phoneNumbers = new HashMap<String,String>();
	private ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();

	Person(String name,String address, ArrayList<Phone> phoneNumbers){
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

	public ArrayList<Phone> getPhoneNumbers(){
		return(phoneNumbers);
	}	

	public Boolean hasPhoneNumber(String phoneNumber){
		for(Phone phone : phoneNumbers){
			if(phone.getNumber().equals(phoneNumber)){
				return true;
			}
		}
		return false;
	}

	
	public void print(){
		System.out.println("\nName : " + name + "	Address : " + address + "\nPhone Numbers :");
		/*for(String tag : phoneNumbers.keySet()){
			System.out.print(tag + " - " + phoneNumbers.get(tag) + "	");
		}*/
		phoneNumbers.forEach((phone) -> {
			System.out.println(phone.getTag() + " - " + phone.getNumber() + "	");
		});

		System.out.println("\n");
	}

	/*@Override
	public String toString(){
		String str = "\nName : " + name + "	Address : " + address + "\nPhone Numbers :" + phoneNumbers;
		return str;
		//System.out.println(phoneNumbers);
	}*/
}