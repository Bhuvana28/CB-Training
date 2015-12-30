class A{
	private int a = 1;
	public int b = 2;
	public static int s = 1;
	class B{
		public void print(){
			a=3;
		}
	}

	static class C{
		System.out.println("a = " +a);
		System.out.println("b = " +b);
		System.out.println("s = " +s);
	}
}


public class Sample{

	public static void main(String args[]){
		
	}	
}


