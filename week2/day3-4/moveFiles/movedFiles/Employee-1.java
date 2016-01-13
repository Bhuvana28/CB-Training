package serviceStation;

import java.util.ArrayList;

public class Employee extends Person{
	private static int noOfEmployees = 0;

	public Employee(String name, int age, String contact){
		super(name,age,contact,++noOfEmployees);
	}

	public void print(){
		System.out.println("Employee Details");
		super.print();
		System.out.println("Emp ID :	"+super.getEmpID());
	}

	public void printInvoices(){
		System.out.println("Invoices of services done by " + super.getName() + "	ID : " + super.getEmpID());
		ArrayList<Invoice> invoices = super.getInvoices();
		for(Invoice invoice : invoices){
			 Vehicle vehicle =invoice.getInvoiceVehicle();
			 System.out.println("Customer Name : " + invoice.getInvoiceOwnerName());
			 System.out.println("Vehicle : "  +vehicle.getType() + "-" + vehicle.getBrand() + "-" + vehicle.getModel());
			 System.out.println("Total Service Charge : "+invoice.getInvoiceAmt());
		}	
	}
}