
//import java.util.Scanner;
//import java.util.ArrayList;
import java.util.*;

class Employee{
	String name;
	Double salary;
	Integer age;

	public Employee(String name, Double salary, Integer age){
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public Double getSalary(){
		return salary;
	}

	public Integer getAge(){
		return age;
	}

	public void print(){
		System.out.println("------------------------------------------------");
		System.out.println("Name : "+name + "	Salary  : " + salary + "	Age: "+ age);
	}
	
}



public class EmployeeProject{
	private ArrayList<Employee> empList = new ArrayList<Employee>();
	
	public void populateEmployees(){
		empList.add(new Employee("g",32434.07,22));
		empList.add(new Employee("b",50000.00,25));
		empList.add(new Employee("e",45434.45,23));
		empList.add(new Employee("d",562434.68,24));
	}

	public void sortName(){
		Collections.sort(empList,new Comparator(){
			public int compare(Object o1,Object o2){  
				Employee emp1 = (Employee)o1;
				Employee emp2 = (Employee)o2;

				return emp1.name.compareTo(emp2.name);  
			} 
		}); 
		display(); 
	}

	public void sortSalary(){
		Collections.sort(empList,new Comparator(){
			public int compare(Object o1,Object o2){  
				Employee emp1 = (Employee)o1;
				Employee emp2 = (Employee)o2;

				if(emp1.salary == emp2.salary)  
					return 0;  
				else if(emp1.salary > emp2.salary)  
					return 1;  
				else  
					return -1;  
			}  

		});  
		display();
	}

	public void sortAge(){
		Collections.sort(empList,new Comparator(){
			public int compare(Object o1,Object o2){  
				Employee emp1 = (Employee)o1;
				Employee emp2 = (Employee)o2;

				if(emp1.age == emp2.age)  
					return 0;  
				else if(emp1.age > emp2.age)  
					return 1;  
				else  
					return -1;  
			} 
		});  
		display();
	}

	public void display(){
		for(Employee emp : empList){
			emp.print();
		}
	}

	public static void main(String[] args){
		int choice;
		Scanner scanner = new Scanner(System.in);
		EmployeeProject empProj = new EmployeeProject();

		empProj.populateEmployees();

		System.out.println("1. Name");
		System.out.println("2. Salary");
		System.out.println("3. Age");
		System.out.println("Choose an attribute to sort the employee list : ");
		choice = scanner.nextInt();

		switch(choice){
			case 1 : empProj.sortName();
					 break;

			case 2 : empProj.sortSalary();
					 break;

			case 3 : empProj.sortAge();
					 break;
		}

	}
}