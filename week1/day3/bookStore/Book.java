package bookStore;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Book{
	private String name;
	private ArrayList<Author> authors = new ArrayList<Author>();
	private double price;
	private int qtyInStock = 0;

	Book(String name, ArrayList<Author> authors,double price,int qtyInStock){
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	Book(String name, Author author, double price, int qtyInStock){
		this.name = name;
		authors.add(author);
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName(){
		return(name);
	}

	public ArrayList<Author> getAuthors(){
		return(authors);
	}

	public double getPrice(){
		return(price);
	}

	public void setPrice(double price){
		this.price = price;
	}

	public int getQtyInStock(){
		return(qtyInStock);
	}

	public void setQtyInStock(int qtyInStock){
		this.qtyInStock = qtyInStock;
	}

	public String toDisplay(){
		String str = "[" + name + "] by";

		for(Author author : authors){
			str += author.getName() + " (" + author.getGender() + ") at " + author.getEmail() + ", ";  
		}	

		str += "\nPrice : $" + price + "\nNo of books available : " + qtyInStock; 

		return(str);
	}

	public void printAuthors(){
		System.out.println("Authors of " + name);
		for(Author author : authors){
			System.out.println(author.toDisplay());
		}
	}

	public void addAuthor(Author author){
		authors.add(author);
	}

	public static void main(String args[]){
		Author author = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
		Author[] authors = new Author[3];
		authors[0] = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
		authors[1] = new Author("J Shale","shalej@gmail.com",'F');
		authors[2] = new Author("Jaswine","jaswine@gmail.com",'F');

		ArrayList<Author> authorList = new ArrayList<Author>();
		authorList.add(authors[0]);
		authorList.add(authors[1]);

		Book[] books = new Book[2]; 
		books[0] = new Book("Malgudi Days",author,1000,2);
		books[1] = new Book("xyz",authorList,750,3);
		
		//Adding an author through addAuthor method.
		books[0].addAuthor(authors[2]);

		//display the authors.
		books[1].printAuthors();

		//print the details for the books available.
		for(Book book : books){
			System.out.println("\n" + book.toDisplay());
		}
	}
}