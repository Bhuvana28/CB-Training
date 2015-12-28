package animals;

public class Ostrich extends Bird implements Walk, Carnivorous{
	
	public Ostrich(float sizeInM,String color,String name){
		super( sizeInM, color, name);
	}
}