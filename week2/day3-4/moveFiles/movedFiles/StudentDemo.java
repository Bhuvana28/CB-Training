package studentDetails;

import java.util.Scanner;

class StudentDemo{

	public void storeStudentData(Student student,int id,String name,String gender,String subject1,String subject2,String subject3,float marks1,float marks2,float marks3){
			student.setStudentId(id);
			student.setStudentName(name);
			student.setStudentGender(gender);
			student.setStudentSubjects(subject1,subject2,subject3,marks1,marks2,marks3);
	}

	public static void main(String args[]){
		int studentId;
		String studentName,subject1,subject2,subject3,gender;
		float marks1,marks2,marks3;

		Student student = new Student();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Student ID : ");
		studentId = scanner.nextInt();
		System.out.print("Student Name : ");
		studentName = scanner.next();
		System.out.print("Gender (male/female) : ");
		gender = scanner.next();
		
		System.out.print("Subject 1 and marks : ");
		subject1 = scanner.next();
		marks1 = scanner.nextFloat();

		
		System.out.print("Subject 2 and marks : ");
		subject2 = scanner.next();
		marks2 = scanner.nextFloat();

		System.out.print("Subject 3 and marks : ");
		subject3 = scanner.next();
		marks3 = scanner.nextFloat();
		
		StudentDemo stud = new StudentDemo();
		stud.storeStudentData(student,studentId,studentName,gender,subject1,subject2,subject3,marks1,marks2,marks3);
		ResultGenerator.generateResult(student);

	}
}