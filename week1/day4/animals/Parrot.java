package animals;

public class Parrot extends Bird implements Fly, Omnivorous{

	public Parrot(float sizeInM,String color,String name){
		super( sizeInM, color, name);
	}
	
}