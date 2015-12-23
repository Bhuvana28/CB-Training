
package bookStore.author;

import java.util.Scanner;

public class Author{
	//private final static String publication = null;
	private String name, email;
	private char gender;

	public Author(String name,String email,char gender){
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName(){
		return(name);
	}

	public String getEmail(){
		return(email);
	}

	public void setEmail(String email){
		this.email = email;
	}

	public char getGender(){
		return(gender);
	}

	public String toDisplay(){
		return(("["+name+"]"+"["+gender+"]"+" at ["+email+"]"));
	}

	public static void main(String args[]){
		Author author = new Author("R.K. Narayan", "rknarayan@gmail.com", 'M');
		System.out.println(author.toDisplay());
		author.setEmail("narayanRK@gmail.com");
		System.out.println(author.toDisplay());

	}
}
