package jsonFileReader;

import java.util.HashSet;

public class Teacher{
	private String name;
	private String id;
	private String dateOfJoining;
	private HashSet<String> classesTaking = new HashSet<String>();
	private Long salary;

	public Teacher(String name,String id,String dateOfJoining,HashSet<String> classesTaking,Long salary){
		this.name = name;
		this.id = id;
		this.dateOfJoining = dateOfJoining;
		this.classesTaking = classesTaking;
		this.salary = salary;
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

    public Long getSalary(){
    	return salary;
    }

    public HashSet<String> getClassesTaking(){
    	return classesTaking;
    }

    @Override
    public String toString(){
    	return "Teacher \nName = " + name + ", \nID = " + id + ", \nSalary = " + salary + ", \nDate Of Joining = " + dateOfJoining + " \nClasses Taking Care of " + classesTaking + "\n";
    } 
	
}