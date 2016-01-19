package jsonFileReader;

import org.json.JSONObject;
import org.json.JSONArray;
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

	public static void main(String args[]) throws Exception{
		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new BufferedReader(new FileReader("students-teachers.json")));

		JSONObject jsonObject = new JSONObject(obj.toString());

		JSONObject studentObject = jsonObject.getJSONObject("Student");
		JSONObject teacherObject = jsonObject.getJSONObject("Teacher");

		JSONArray studentMarks = studentObject.getJSONArray("Marks");
		ArrayList<Mark> marks = new ArrayList<Mark>();

		for(int index=0;index<studentMarks.length();index++){
			JSONObject markObject = studentMarks.getJSONObject(index);
			marks.add(new Mark(markObject.getLong("Mark"),markObject.getString("Subject")));
		}
			
		Student student = new Student(	studentObject.getString("Date Of Joining"),
										studentObject.getString("ID"),
										studentObject.getString("Name"),
										studentObject.getString("Std"),
										marks
									);


		JSONArray teacherClasses = teacherObject.getJSONArray("Classes Taking Care Of");
		HashSet<String> classes = new HashSet<String>();

		for(int index=0;index<teacherClasses.length();index++){
			classes.add(teacherClasses.getString(index));
		}
	
		Teacher teacher = new Teacher(
										teacherObject.getString("Name"),
										teacherObject.getString("ID"),
										teacherObject.getString("Date Of Joining"),
										classes,
										teacherObject.getLong("Salary")
									);	
		
		System.out.println(student);
		System.out.println(teacher);

	}
}

