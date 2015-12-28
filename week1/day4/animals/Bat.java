package animals;

public class Bat extends Mammal implements Fly, Carnivorous{
	
	public Bat(int noOfLegs,String color,String name, float heightInCM){
		super( noOfLegs, color, name, heightInCM);
	}
	
	public void speak(){
		System.out.println("sshheeeekkwwwweee");
	}
}