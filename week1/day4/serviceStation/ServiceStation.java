package serviceStation;

import java.util.ArrayList;
import java.util.Scanner;


public class ServiceStation{
	private String name;
	private String address;
	private String contact;
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	

	public ServiceStation(String name, String address,String contact){
		this.name = name;
		this.address = address;
		this.contact = contact;
		storeEmployeeData();
		storeVehicleData();
		storeCustomerData();
	}

	public void storeEmployeeData(){
		/*Employee e = new Employee("a",28,"9383487631");
		Customer c = new Customer("aa",28,"8758736993");
		Vehicle v = new Vehicle("bus","Orange","Seater","Blue",300);
		Invoice invoice= new Invoice(c,v,e);
		c.addInvoice(invoice);
		e.addInvoice(invoice);*/

		employees.add(new Employee("a",28,"9383487631"));
		employees.add(new Employee("b",25,"8383487631"));
		employees.add(new Employee("c",27,"9723643543"));
	}

	public void storeCustomerData(){
		customers.add(new Customer("aa",28,"8758736993"));
		customers.add(new Customer("b",25,"8383487631",2));
		customers.add(new Customer("cc",27,"9523643543"));
	}

	public void storeVehicleData(){
		vehicles.add(new Vehicle("bus","Orange","Seater","Blue",300));
		vehicles.add(new Vehicle("bus","KPN","Seater","White",250));
		vehicles.add(new Vehicle("bike","Honda","Unicon","Black",80));
		vehicles.add(new Vehicle("bike","Honda","Activa","Grey",80));
		vehicles.add(new Vehicle("car","Swift","Dezier","White",200));
		vehicles.add(new Vehicle("car","Wolkswagan","Polo","White",180));
	}

	public void displayServiceCharges(){
		for(Vehicle vehicle:vehicles){
			System.out.println(vehicle.getType()+"  :  " + vehicle.getBrand() + "  :  " + vehicle.getModel() + "  :  " + vehicle.getServiceCharge());
		}
	}

	public void generateInvoices(){
		Invoice invoice= new Invoice(customers.get(0).getName(),vehicles.get(2),employees.get(0));
		customers.get(0).addInvoice(invoice);
		employees.get(0).addInvoice(invoice);
	}

	public void printCustomerInvoices(){
		for(Customer cust : customers){
			cust.printInvoices();	
		}
		

	}

	public void printEmployeeInvoices(){
		for(Employee emp : employees){
			emp.printInvoices();	
		}
		
	}


	public static void main(String args[]){
		ServiceStation servStatn = new ServiceStation("XYZ","add@","9234834857");
		servStatn.displayServiceCharges();
		servStatn.generateInvoices();
		servStatn.printEmployeeInvoices();
		servStatn.printCustomerInvoices();
	}
}