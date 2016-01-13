
package studentDetails;

class ResultGenerator{
	
	public static void generateResult(Student student){
		float totalMark,avgMark;
		Subject subject = student.getStudentSubjects();
		totalMark = subject.getSubject1Mark() + subject.getSubject2Mark() + subject.getSubject3Mark();
		avgMark = totalMark/3;
		System.out.println("			Student	Report");
		System.out.println("ID : "+student.getStudentId() + "		Name : " + student.getStudentName() + "		Gender : "+student.getStudentGender());
		System.out.println("\n" + subject.getSubject1() + "	 	:	 " + subject.getSubject1Mark());
		System.out.println(subject.getSubject2() + "	 	:	 " + subject.getSubject2Mark());
		System.out.println(subject.getSubject3() + "	 	:	 " + subject.getSubject3Mark());
		System.out.println("Total Mark 	:	 " + totalMark);
		System.out.println("Average Mark 	:	 " + avgMark);
	}
}