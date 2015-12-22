package animal;

import java.util.Scanner;

class Animal{

	String name,category,breed;
	int age;

	public static int noOfAnimals = 0;

	public Animal(){
		noOfAnimals++;
	}

	public String getAnimalName(Animal a){
		return(a.name);
	}

	public String getAnimalCategory(Animal a){
		return(a.category);
	}

	public String getAnimalBreed(Animal a){
		return(a.breed);
	}

	public int getAnimalAge(Animal a){
		return(a.age);
	}

	public void setAnimalName(String name){
		this.name = name;
	}

	public void setAnimalCategory(String category){
		this.category = category;
	}

	public void setAnimalBreed(String breed){
		this.breed = breed;
	}

	public void setAnimalAge(int age){
		this.age = age;
	}


	public static void main(String args[]){
		String ctg,name,breed;
		int age;
		char proceed;

		Scanner scanner = new Scanner(System.in);
		do{

			System.out.println("Enter Animal Details.");
			System.out.print("Category : ");
			ctg = scanner.nextLine();
			System.out.print("Breed : ");
			breed = scanner.nextLine();
			System.out.print("Name : ");
			name = scanner.nextLine();
			System.out.println("Age : ");
			age = nextInt();

			Animal a = new Animal(ctg,breed,name,age);

			System.out.println("Number of animals  =  " + Animal.noOfAnimals);

			System.out.println("Do you enter more animals details(y/n) : ");
			proceed = scanner.nextChar();

		}while(true)


	}
}