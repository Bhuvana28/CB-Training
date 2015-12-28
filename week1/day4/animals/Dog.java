package animals;

public class Dog extends Mammal implements Walk, Carnivorous{

	public Dog(int noOfLegs,String color,String name,float heightInCM){
		super( noOfLegs, color, name, heightInCM);
	}

	public void speak(){
		System.out.println("Boowh Boowh");
	}
	
}