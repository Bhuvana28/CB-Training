package autoShop;

public class MyOwnAutoShop{
	
	public static void main(String[] args){
		Sedan sedan = new Sedan(50,500000,"red",15);

		Ford ford1 = new Ford(65,550000,"white",2009,15000);
		Ford ford2 = new Ford(75,670000,"grey",2019,13000);

		Car car = new Car(70,300000,"white");

		car.toDisplay();
		sedan.toDisplay();
		ford1.toDisplay();
		ford2.toDisplay();
	}
}




