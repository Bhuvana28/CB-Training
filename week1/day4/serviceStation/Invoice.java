package serviceStation;

public class Invoice{
	private String nameOfOwner;
	private Vehicle vehicle;
	private Employee employeeAssigned;
	private double amountTotal;

	public Invoice(String nameOfOwner,Vehicle vehicle,Employee employeeAssigned){
		this.nameOfOwner=nameOfOwner;
		this.vehicle = vehicle;
		this.employeeAssigned = employeeAssigned;
		amountTotal = setEmpTotalAmt();
	}

	private double setEmpTotalAmt(){
		return(vehicle.getServiceCharge()*(1.2));
	}

	public void print(){
		System.out.println("Name of Owner :	"+nameOfOwner);
		System.out.println("Vehicle :	" + vehicle.getType()+"-"+vehicle.getBrand()+"-"+vehicle.getModel());
		System.out.println("Employee Assigned :	Name - "+ employeeAssigned.getName()+", ID - "+employeeAssigned.getEmpID());
		System.out.println("Service Total Amount :	"+amountTotal);
	}

	public String getInvoiceOwnerName(){
		return(nameOfOwner);
	}

	public Vehicle getInvoiceVehicle(){
		return(vehicle);
	}

	public Employee getInvoiceEmp(){
		return(employeeAssigned);
	}

	public double getInvoiceAmt(){
		return(amountTotal);
	}
}