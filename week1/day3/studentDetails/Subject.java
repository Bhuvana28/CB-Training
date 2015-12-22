package studentDetails;

class Subject{
	String subject1,subject2,subject3;
	float marks1,marks2,marks3;

	//set methods for instance variables.
	public void setSubject1(String subject){
		subject1 = subject;
	}

	public void setSubject2(String subject){
		subject2 = subject;
	}

	public void setSubject3(String subject){
		subject3 = subject;
	}

	public void setSubject1Mark(float mark){
		marks1 = mark;
	}

	public void setSubject2Mark(float mark){
		marks2 = mark;
	}

	public void setSubject3Mark(float mark){
		marks3 = mark;
	}

	//get methods for instance variables.

	public String getSubject1(){
		return(this.subject1);
	}

	public String getSubject2(){
		return(this.subject2);
	}

	public String getSubject3(){
		return(this.subject3);
	}

	public float getSubject1Mark(){
		return(this.marks1);
	}

	public float getSubject2Mark(){
		return(this.marks2);
	}

	public float getSubject3Mark(){
		return(this.marks3);
	}	
}