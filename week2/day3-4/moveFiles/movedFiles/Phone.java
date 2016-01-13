package phoneDirectory;

public class Phone{
	PhoneType tag;
	String number;

	Phone(PhoneType tag, String number){
		this.tag = tag;
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public PhoneType getTag(){
		return tag;
	}

}