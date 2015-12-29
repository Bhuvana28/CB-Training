package serviceStation;

public class Vehicle{
	private String type;
	private String model;
	private String brand;
	private String color;
	private double serviceCharge;

	public Vehicle(String type,String brand,String model,String color,double serviceCharge){
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.serviceCharge = serviceCharge;
	}

	public double getServiceCharge(){
		return(serviceCharge);
	}

	public String getType(){
		return(type);
	}

	public String getBrand(){
		return(brand);
	}

	public String getColor(){
		return(color);
	}

	public String getModel(){
		return(model);
	}

	public void print(){
		System.out.println(type + "		-	" + brand + "	-	" + model);
		System.out.println("Color 	:	"+color);
		System.out.println("Service Charge 	:"+serviceCharge);
	}
}