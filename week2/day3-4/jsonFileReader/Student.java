package jsonFileReader;
import java.util.ArrayList;

public class Student{
	private String dateOfJoining;
	private String id;
	private ArrayList<Mark> marks = new ArrayList<Mark>();
	private String name;
	private String std;

    public Student(String dateOfJoining,String id,String name, String std, ArrayList<Mark> marks){
    	this.dateOfJoining = dateOfJoining;
    	this.id = id;
    	this.name = name;
    	this.std = std;
    	this.marks = marks;
    }    

    public String getDateOfJoining(){
    	return dateOfJoining;
    }
    
    public String getId(){
    	return id;
    }

    public String getName(){
    	return name;
    }

    public String getStd(){
    	return std;
    }

    public ArrayList<Mark> getMarks(){
    	return marks;
    }

    @Override
    public String toString(){
    	    return "Student \nName = " + name + ", \nID = " + id + ", \nStd = " + std + ", \nDate Of Joining = " + dateOfJoining + " \nMarks = \n " + marks + "\n";
    }
}