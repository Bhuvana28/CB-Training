package serviceStation;

import java.util.ArrayList;

public class Customer extends Person{

	public Customer(String name, int age, String contact){
		super(name,age,contact);
	}

	public Customer(String name, int age, String contact,int empId){
		super(name,age,contact,empId);
	}

	public void print(){
		System.out.println("Customer Details");
		super.print();
		if(super.getEmpID() != 0){
			System.out.println("Emp ID :	"+super.getEmpID());
		}
			
	}

	public void printInvoices(){
		System.out.println("Invoices of services received by " + super.getName());
		ArrayList<Invoice> invoices = super.getInvoices();
		for(Invoice invoice : invoices){
			 Employee emp = invoice.getInvoiceEmp();
			 Vehicle vehicle =invoice.getInvoiceVehicle();
			 System.out.println("Emp : " + emp.getName() + "	ID : " + emp.getEmpID());
			 System.out.println("Vehicle : "  +vehicle.getType() + "-" + vehicle.getBrand() + "-" + vehicle.getModel());
			 System.out.println("Total Service Charge : "+invoice.getInvoiceAmt());
		}	
	}
}