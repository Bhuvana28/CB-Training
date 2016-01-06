
package studyExercise;


/*
//interface extends abstract class
//(error: interface expected instead of abstract class)
abstract class ab{
	public abstract void abstractMethod();
}

interface A extends ab{

}
*/


class A implements B{
	@Override
	public void print(){
		System.out.println("Hai");
	}
}

class c implements B{
	@Override
	public void print(){
		System.out.println("Hai");
	}
}

interface B {
	public void print();
}

public class StudyExercise{
	public static void main(String[] args){
		B b1 = new c();
		B b2 = new A();
		b.print();
		System.out.println("Hello");
	}
}