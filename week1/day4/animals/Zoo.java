package animals;

import java.util.ArrayList;
import java.util.Scanner;

/*enum Diet{
	HERBIVOROUS,CARNIVOROUS,OMNIVOROUS
} */

public class Zoo{

	public void storeInput(ArrayList<Animal> animalList){
		Scanner scanner = new Scanner(System.in);
		String name,color,proceed = "yes";
		int choice;
		float height,size;

		do{
			System.out.println("Enter animal details:");
			System.out.println("1.Dog");
			System.out.println("2.Cow");
			System.out.println("3.Bat");
			System.out.println("4.Ostrich");
			System.out.println("5.Parrot");
			System.out.println("Enter your choice : ");
			choice = scanner.nextInt();

			System.out.print("Enter the name : ");
			name = scanner.next();

			System.out.print("Enter the color : ");
			color = scanner.next();

			switch(choice){
				case 1 : 
						System.out.print("Enter the height (CM) : ");
						height = scanner.nextFloat();
						Animal dog = new Dog(4,color,name,height);
						animalList.add(dog);
						break;

				case 2 : 
						System.out.print("Enter the height(in CM) : ");
						height = scanner.nextFloat();
						Animal cow = new Cow(4,color,name,height);
						animalList.add(cow);
						break;

				case 3 :
						System.out.print("Enter the height(in CM) : ");
						height = scanner.nextFloat();
						Animal bat = new Bat(0,color,name,height);
						animalList.add(bat);
						break;		

				case 4 :
						System.out.print("Enter the size(in M) : ");
						size = scanner.nextFloat();
						Animal ostrich = new Ostrich(size,color,name);
						animalList.add(ostrich);
						break;		

				case 5 :								
						System.out.print("Enter the size(in M) : ");
						size = scanner.nextFloat();
						Animal parrot = new Parrot(size,color,name);
						animalList.add(parrot);
						break;		
			}

			System.out.println("Do you want to continue (yes/no) :");
			proceed = scanner.next();
			
		}while(proceed.equals("yes"));

		
	}

	public void displayHerbivores(ArrayList<Animal> animalList){
		System.out.println("List of Herbivorous animals :");
			for(Animal animal : animalList){
				if(animal instanceof Herbivorous){
					System.out.println(animal.getName());
				}
			}
	}

	public void displayFly(ArrayList<Animal> animalList){
		System.out.println("List of animals can fly:");
			for(Animal animal : animalList){
				if(animal instanceof CanFly){
					System.out.println(animal.getName());
				}
			}
	}

	public static void main(String  args[]){
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		Zoo zoo = new Zoo();

		zoo.storeInput(animalList);
		zoo.displayFly(animalList);
		zoo.displayHerbivores(animalList);
	}
}