package jsonFileReader;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException; 

import java.util.Iterator;

import java.util.ArrayList;
import java.util.HashSet;

public class JsonFileReader{

	public static void main(String args[]){
		JSONParser parser = new JSONParser();

		try{

			Object obj = parser.parse(new BufferedReader(new FileReader("students-teachers.json")));

			JSONObject jsonObject = (JSONObject)obj;
			JSONObject studentObject = (JSONObject)jsonObject.get("Student");
			JSONObject teacherObject = (JSONObject)jsonObject.get("Teacher");

			JSONArray studentMarks = (JSONArray)studentObject.get("Marks");
			Iterator<JSONObject> marksIterator = (Iterator<JSONObject>) studentMarks.iterator();
			ArrayList<Mark> marks = new ArrayList<Mark>();

			while(marksIterator.hasNext()){
				JSONObject markObject = (JSONObject)marksIterator.next();
				marks.add(new Mark((Long)markObject.get("Mark"),(String)markObject.get("Subject")));
			}

			JSONArray teacherClasses = (JSONArray)teacherObject.get("Classes Taking Care Of");
			Iterator<String> classIterator = (Iterator<String>)teacherClasses.iterator();
			HashSet<String> classes = new HashSet<String>();

			while(classIterator.hasNext()){
				classes.add((String)classIterator.next());
			}

			Student student = new Student(	(String)studentObject.get("Date Of Joining"),
											(String)studentObject.get("ID"),
											(String)studentObject.get("Name"),
											(String)studentObject.get("Std"),
											marks
										);
			
			Teacher teacher = new Teacher(
											(String)teacherObject.get("Name"),
											(String)teacherObject.get("ID"),
											(String)teacherObject.get("Date Of Joining"),
											classes,
											(Long)teacherObject.get("Salary")
										);

			
			
			System.out.println(student);
			System.out.println(teacher);

		}catch (FileNotFoundException e) {  
   			e.printStackTrace();  
  		}catch (IOException e) {  
   			e.printStackTrace();  
  		}catch (ParseException e) {  
   			e.printStackTrace();  
  		}		  
	}
}

