package autoShop;

public class Ford extends Car{
	private int year;
	private int manufacturerDiscount;

	public Ford(int speed, double regularPrice,String color,int year,int manufacturerDiscount){
		super(speed,regularPrice,color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	public double getSalePrice(){
		double salePrice = super.getSalePrice();
		return(salePrice-manufacturerDiscount);
	}

	public void toDisplay(){
		System.out.println("Ford");
		System.out.println("Year : "+year);
		super.toDisplay();
		System.out.println("Manufacturer Discount : " + manufacturerDiscount);
		System.out.println("Sale Price with discount  : " + getSalePrice()+ "\n");
	}
}