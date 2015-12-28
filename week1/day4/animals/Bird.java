package animals;

public class Bird extends Animal{
	private float sizeInM;

	public Bird(float sizeInM,String color,String name){
		super(color, name);
		this.sizeInM = sizeInM;
	}
	
	public float getBirdSize(){
		return(sizeInM);
	}
}