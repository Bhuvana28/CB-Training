package autoShop;

public class Sedan extends Car{
	private int length;

	public Sedan(int speed, double regularPrice,String color,int length){
		super(speed,regularPrice,color);
		this.length = length;
	}
	
	public double getSalePrice(){
		double salePrice = super.getSalePrice();
		if(length > 20){
			return(salePrice - salePrice*0.05);
		}else{
			return(salePrice - salePrice*0.1);
		}
	}	

	public void toDisplay(){
		System.out.println("Sedan");
		System.out.println("Length : "+length);
		super.toDisplay();
		System.out.println("Sale Price with discount  : " + getSalePrice() + "\n");
	}
}