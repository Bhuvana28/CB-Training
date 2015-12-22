package animal;

import java.util.Scanner;

class Animal{

	String name,category;
	int age;

	public static int noOfAnimals = 0;

	public Animal(String category,String name, int age){
		this.category = category;
		this.name = name;
		this.age = age;
		noOfAnimals++;
	}

	public String getAnimalName(Animal a){
		return(a.name);
	}

	public String getAnimalCategory(Animal a){
		return(a.category);
	}

	public int getAnimalAge(Animal a){
		return(a.age);
	}

	public static void main(String args[]){
		String ctg,name;
		int age;
		char proceed;
		Scanner scanner = new Scanner(System.in);

		do{

			System.out.println("Enter Animal Details.");
			System.out.print("Category 	: ");
			ctg = scanner.next();
			System.out.print("Name 		: ");
			name = scanner.next();
			System.out.print("Age 		: ");
			age = scanner.nextInt();

			Animal a = new Animal(ctg,name,age);

			System.out.println("Number of animals  =  " + Animal.noOfAnimals);

			System.out.println("Do you want to continue(y/n) : ");
			proceed = scanner.next(".").charAt(0);

		}while(proceed == 'y');

	}
}