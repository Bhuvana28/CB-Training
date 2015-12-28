package animals;

public class Cow extends Mammal implements Walk, Herbivorous{

	public Cow(int noOfLegs,String color,String name, float heightInCM){
		super( noOfLegs, color, name, heightInCM);
	}
	
	public void speak(){
		System.out.println("Mooooo");
	}
}