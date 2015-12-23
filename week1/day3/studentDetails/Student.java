package studentDetails;

class Student{
	private int studentId;
	private String studentName;
	private boolean gender;
	private Subject subjects = new Subject();

	//set instance variables methods.
	public void setStudentId(int id){
		studentId = id;
	}

	public void setStudentName(String name){
		studentName = name;
	}	

	public void setStudentGender(String gender){
		this.gender = gender.equals("male")?true:false;
	}

	public void setStudentSubjects(String subject1,String subject2,String subject3,float marks1,float marks2,float marks3){
		subjects.setSubject1(subject1);
		subjects.setSubject2(subject2);
		subjects.setSubject3(subject3);
		subjects.setSubject1Mark(marks1);
		subjects.setSubject2Mark(marks2);
		subjects.setSubject3Mark(marks3);
	}

	//get instance variables methods.
	public int getStudentId(){
		return(this.studentId);
	}

	public String getStudentName(){
		return(this.studentName);
	}	

	public String getStudentGender(){
		return(this.gender?"Male":"Female");
	}

	public Subject getStudentSubjects(){
		return(this.subjects);
	}

}
