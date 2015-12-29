
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
	public void print(){
		System.out.println("Hai");
	}
}

interface B {
}

public class StudyExercise{
	public static void main(String[] args){
		B b = new A();
		b.print();
		System.out.println("Hello");
	}
}