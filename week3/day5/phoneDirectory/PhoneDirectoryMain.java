package phoneDirectory;

import java.sql.*;
import java.io.*;
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

   	public static void loadJSONData(String filename,Connection conn) throws Exception{
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		Object obj= parser.parse(new BufferedReader(new FileReader(filename)));
		jsonObject = new JSONObject(obj.toString());
		JSONArray ppl = jsonObject.getJSONArray("persons");

		String personSql,contactSql;
		PreparedStatement insertPerson=null;
		PreparedStatement insertContact = null;

		try{
			personSql = "insert into person(name,address) values (?,?)";
			contactSql = "insert into contact values(?,?,?)";

			insertPerson = conn.prepareStatement(personSql,Statement.RETURN_GENERATED_KEYS);
			insertContact = conn.prepareStatement(contactSql);

			for(int index=0; index < ppl.length();index++){
				int id = 0;
				JSONObject person = ppl.getJSONObject(index);

				insertPerson.setString(1,person.getString("name"));
				insertPerson.setString(2,person.getString("address"));
				insertPerson.executeUpdate();

				ResultSet idResult =  insertPerson.getGeneratedKeys();
				if(idResult.next()){
					id = idResult.getInt(1);
				}else{
					System.out.println("Could not get the last inserted row id.");
				}

				if(person.has("mobile")){
					insertContact.setInt(1,id);
					insertContact.setString(2,"mobile");
					insertContact.setString(3,person.getString("mobile"));
					insertContact.executeBatch();
				}
				
				if(person.has("home")){
					insertContact.setInt(1,id);
					insertContact.setString(2,"home");
					insertContact.setString(3,person.getString("home"));
					insertContact.executeBatch();
				}
				
				if(person.has("work")){
					insertContact.setInt(1,id);
					insertContact.setString(2,"work");
					insertContact.setString(3,person.getString("work"));
					insertContact.executeBatch();
				}
			}

		}
		finally{
			if(insertPerson!=null){
				insertPerson.close();
			}
			if(insertContact!=null){
				insertContact.close();
			}
		}	
	}
	
	public static void main(String args[]) throws Exception{
		Connection conn = null;
   		
   		try{
   			Class.forName("com.mysql.jdbc.Driver");
      		conn = DriverManager.getConnection(DB_URL,USER,PASS);
      		PhoneDirectoryMain.loadJSONData("persons.json",conn);

      		/*do{
			System.out.println("1. Retrieve the details of the person(s) matching the given name.");
			System.out.println("2. Retrieve the details of the person(s) by looking for partial match also.");
			System.out.println("3. Retrieve the details of the person matching the given phone number.");
			System.out.println("4. Exit.");
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
			}			 

			}while(choice < 4);*/
		conn.close();
   		}
   		finally{
        	if(conn!=null)
            	conn.close();
   		}

	}
}