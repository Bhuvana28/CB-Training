package phoneDirectory;

import java.sql.*;
import java.io.*;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;  
import org.json.simple.parser.ParseException;  


public class PhoneDirectoryMain{

	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/phone_directory";

   	//  Database credentials
   	static final String USER = "root";
   	static final String PASS = "";

   	public static void loadJSONData(String filename) throws Exception{
   		Connection conn = null;
   		Class.forName("com.mysql.jdbc.Driver");
      	

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		Object obj= parser.parse(new BufferedReader(new FileReader(filename)));
		jsonObject = new JSONObject(obj.toString());
		JSONArray ppl = jsonObject.getJSONArray("persons");

		String personSql,contactSql;
		PreparedStatement insertPerson=null;
		PreparedStatement insertContact = null;

		try{
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			personSql = "insert into persons(name,address) values (?,?)";
			contactSql = "insert into contacts values(?,?,?)";

			insertPerson = conn.prepareStatement(personSql,Statement.RETURN_GENERATED_KEYS);
			insertContact = conn.prepareStatement(contactSql);

			for(int index=0; index < ppl.length();index++){
				try{
					int id = 0;
					JSONObject person = ppl.getJSONObject(index);

					insertPerson.setString(1,person.getString("name"));
					insertPerson.setString(2,person.getString("address"));
					insertPerson.executeUpdate();

					ResultSet idResult =  insertPerson.getGeneratedKeys();
					if(idResult.next()){
						id = idResult.getInt(1);
						if(person.has("mobile")){
							insertContact.setInt(1,id);
							insertContact.setString(2,"mobile");
							insertContact.setString(3,person.getString("mobile"));
							insertContact.executeUpdate();
						}
						
						if(person.has("home")){
							insertContact.setInt(1,id);
							insertContact.setString(2,"home");
							insertContact.setString(3,person.getString("home"));
							insertContact.executeUpdate();
						}
						
						if(person.has("work")){
							insertContact.setInt(1,id);
							insertContact.setString(2,"work");
							insertContact.setString(3,person.getString("work"));
							insertContact.executeUpdate();
						}
					}else{
						System.out.println("Could not get the last inserted row id.");
					}	
				}catch(BatchUpdateException sqlExp){
					System.out.println("Record Already Exists");
				}
				catch(SQLException integritySql){
					System.out.println("Record Already Exists integrity");	
				}
			}

		}
		finally{
			if(insertPerson!=null)
				insertPerson.close();
			if(insertContact!=null)
				insertContact.close();
			if(conn!=null)
            	conn.close();
		}	
	}
	
	public static void main(String args[]) throws Exception{
			Scanner scanner = new Scanner(System.in);
   			Integer choice;
   			String name,phoneNumber;
   			PhoneDirectory pndir = new PhoneDirectory();
      		PhoneDirectoryMain.loadJSONData("persons.json");

      		do{
			System.out.println("1. Retrieve the details of the person(s) matching the given name.");
			System.out.println("2. Retrieve the details of the person(s) by looking for partial match also.");
			System.out.println("3. Retrieve the details of the person matching the given phone number.");
			System.out.println("4. Add an entry to phone directory.");
			System.out.println("5. Exit.");
			System.out.print("Enter your choice:");

			choice = new Integer(scanner.nextInt());

			switch(choice){
				case 1 : System.out.print("Enter name : ");
						 name = scanner.next();
						 pndir.namesMatched(name);
						 break;

				case 2 : System.out.print("Enter partial name : "); 
						 name = scanner.next();
						 pndir.namesPartialMatched(name);
						 break;

				case 3 : System.out.print("Enter phone number : "); 
						 phoneNumber = scanner.next();
						 pndir.phoneMatched(phoneNumber);
						 break;

				case 4 : System.out.println("Enter person details.");
						 System.out.print("Name and Address : ");
						 name = scanner.next();
						 String address = scanner.next();
						 System.out.println("Contact details. To skip just enter a '-'.");
						 System.out.print("Home,work and mobile :");
						 String home = scanner.next();
						 String work = scanner.next();
						 String mobile = scanner.next();
						 pndir.addPerson(name,address,home,work,mobile);
						 break;

				/*case 5 : System.out.println("Enter details to update. Incase no need to update give '-'.");
						 System.out.print("Name and Address: ");
						 name = scanner.next();
						 String address = scanner.next();
						 System.out.print("Home,work and mobile :");
						 String home = scanner.next();
						 String work = scanner.next();
						 String mobile = scanner.next();
						 pndir.updatePerson(name,address,home,work,mobile);
						 break;*/
			}			 

			}while(choice < 5);

	}
}