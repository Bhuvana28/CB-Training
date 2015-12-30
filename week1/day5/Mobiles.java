
import java.util.Random;

class Mobile{
	private String name;
	protected Integer remainingCharge;

	public void remainingCharge(){
		Random random = new Random();
		remainingCharge = random.nextInt(101) + 1;
	}

	public void name(String name){
			this.name = name;
	}

	public void print(){
		System.out.println("Name : " + name);
		System.out.println("Ramaining Charge : " + remainingCharge);
		System.out.println("-----------------------------");
	}

}


public class Mobiles{
	
	public static void main(String args[]){

	Random random = new Random();
	Mobile mob1 = new Mobile(){
		public void remainingCharge(){
			remainingCharge = random.nextInt(101) + 1;
		}
	};
	mob1.name("Samsung Galaxy A5");
	mob1.remainingCharge();

	Mobile mob2 = new Mobile(){
		public void remainingCharge(){
			remainingCharge = random.nextInt(101) + 1;
		}
	};
	mob2.name("iPhone");
	mob2.remainingCharge();

	Mobile mob3 = new Mobile(){
		public void remainingCharge(){
			remainingCharge = random.nextInt(101) + 1;
		}
	};	
	mob3.name("Windows Lumia");
	mob3.remainingCharge();

	mob1.print();
	mob2.print();
	mob3.print();

	}
}