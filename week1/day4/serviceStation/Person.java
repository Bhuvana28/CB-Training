package serviceStation;

import java.util.ArrayList;

public abstract class Person{
	private String name;
	private int age;
	private String contact;
	private int empID = 0;
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

	public Person(String name,int age,String contact){
		this.name = name;
		this.age = age;
		this.contact = contact;
	}

	public Person(String name,int age,String contact,int empID){
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.empID = empID;
	}

	public int getEmpID(){
		return(this.empID);
	}

	public String getName(){
		return(name);
	}

	public int getAge(){
		return(age);
	}

	public String contact(){
		return(contact);
	}

	public ArrayList<Invoice> getInvoices(){
		return(invoices);
	}
	
	public void print(){
		System.out.println("Name :	"+name);
		System.out.println("Age :	" + age);
		System.out.println("Contact 	:	"+contact);
	}

	public void addInvoice(Invoice invoice){
		invoices.add(invoice);
	}

	public abstract void printInvoices();
}