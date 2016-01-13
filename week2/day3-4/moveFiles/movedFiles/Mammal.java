package animals;
	
public abstract class Mammal extends Animal{
	private int noOfLegs;
	private float heightInCM;

	public Mammal(int noOfLegs,String color,String name,float heightInCM){
		super(color, name);
		this.noOfLegs = noOfLegs;
		this.heightInCM = heightInCM;
	}

	public abstract void speak();

	public int getNoOfLegs(){
		return(noOfLegs);
	}

	public void graze(){
		System.out.println("Graze");
	}
	
}