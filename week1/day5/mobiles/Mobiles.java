package mobiles;

import java.util.Random;

class Mobile{
	protected String name;
	private Integer remainingCharge;

	public void remainingCharge(){
		Random random = new Random();
		remainingCharge = random.nextInt(101) + 1;
	}

	public void name(){
			this.name = "XYZ";
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
		@Override
		public void name(){
			name  = "Samsung Galaxy A5";
		}
	};
	mob1.name();
	mob1.remainingCharge();

	Mobile mob2 = new Mobile(){
		@Override
		public void name(){
			name = "iPhone";
		}
	};
	mob2.name();
	mob2.remainingCharge();

	Mobile mob3 = new Mobile(){
		@Override
		public void name(){
			name = "Windows Lumia";
		}
	};	
	mob3.name();
	mob3.remainingCharge();

	mob1.print();
	mob2.print();
	mob3.print();

	}
}