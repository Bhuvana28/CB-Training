package phoneDirectory;

import java.sql.*;

class PhoneDirectory{
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/phone_directory";

   	//  Database credentials
   	static final String USER = "root";
   	static final String PASS = "";

   	public void namesMatched(String name) throws Exception{
   		String personSql,contactSql;
   		Connection conn = null;
   		PreparedStatement personStmt = null;
   		PreparedStatement contactStmt = null;

   		personSql = "select id,name,address from persons where name = ?" ;
   		contactSql = "select type,phone from contacts where person_id = ?";

   		try{
   			Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);

   			personStmt = conn.prepareStatement(personSql);
   			contactStmt = conn.prepareStatement(contactSql);
   			personStmt.setString(1,name);
   			ResultSet rs = personStmt.executeQuery();
   			while(rs.next()){
               System.out.println("------------------"); 
   				contactStmt.setInt(1,rs.getInt("id"));
   				ResultSet contacts = contactStmt.executeQuery();
   				System.out.println("Name : "+rs.getString("name") + "\nAddress : "+ rs.getString("address"));
   				while(contacts.next()){
   					String type = contacts.getString("type");
   					System.out.print(type.substring(0,1).toUpperCase()+type.substring(1));
   					System.out.println(" : "+contacts.getString("phone"));
   				}	
               System.out.println("------------------");	
   			}

   			personStmt.close();
   			contactStmt.close();
   			conn.close();

      	}finally{
   			if(personStmt!=null)
   				personStmt.close();
   			if(contactStmt!=null)
   				contactStmt.close();
   			if(conn!=null)
   				conn.close();
   		}
   	}

   	public void namesPartialMatched(String name) throws Exception{
         String personSql,contactSql;
         Connection conn = null;
         PreparedStatement personStmt = null;
         PreparedStatement contactStmt = null;

         personSql = "select id,name,address from persons where name like '%" +name+"%'" ;
         contactSql = "select type,phone from contacts where person_id = ?";

         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            personStmt = conn.prepareStatement(personSql);
            contactStmt = conn.prepareStatement(contactSql);
   
            ResultSet rs = personStmt.executeQuery();
            while(rs.next()){
               System.out.println("------------------"); 
               contactStmt.setInt(1,rs.getInt("id"));
               ResultSet contacts = contactStmt.executeQuery();
               System.out.println("Name : "+rs.getString("name") + "\nAddress : "+ rs.getString("address"));
               while(contacts.next()){
                  String type = contacts.getString("type");
                  System.out.print(type.substring(0,1).toUpperCase()+type.substring(1));
                  System.out.println(" : "+contacts.getString("phone"));
               } 
               System.out.println("------------------");   
            }

            personStmt.close();
            contactStmt.close();
            conn.close();

         }finally{
            if(personStmt!=null)
               personStmt.close();
            if(contactStmt!=null)
               contactStmt.close();
            if(conn!=null)
               conn.close();
         }

   	}

      public void phoneMatched(String phoneNumber) throws Exception{
         String personSql,contactSql,personIdSql;
         Connection conn = null;
         PreparedStatement personStmt = null;
         PreparedStatement contactStmt = null;
         PreparedStatement personIdStmt = null;

         personIdSql = "select distinct(person_id) 'person_id' from contacts where phone = ?";
         personSql = "select name,address from persons where id= ?";
         contactSql = "select type,phone from contacts where person_id = ?";

         try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            personStmt = conn.prepareStatement(personSql);
            contactStmt = conn.prepareStatement(contactSql);
            personIdStmt = conn.prepareStatement(personIdSql);
   
            personIdStmt.setString(1,phoneNumber);
            ResultSet rs = personIdStmt.executeQuery();
            while(rs.next()){
               System.out.println("------------------"); 
               int id = rs.getInt("person_id");
               personStmt.setInt(1,id);
               ResultSet personrs = personStmt.executeQuery();
               if(personrs.next()){
                  System.out.println("Name : "+personrs.getString("name") + "\nAddress : "+ personrs.getString("address"));
                  contactStmt.setInt(1,rs.getInt("person_id"));
                  ResultSet contacts = contactStmt.executeQuery();
                  while(contacts.next()){
                     String type = contacts.getString("type");
                     System.out.print(type.substring(0,1).toUpperCase()+type.substring(1));
                     System.out.println(" : "+contacts.getString("phone"));
                  }
               }
               System.out.println("------------------");   
            }

            personIdStmt.close();
            personStmt.close();
            contactStmt.close();
            conn.close();

         }finally{
            if(personStmt!=null)
               personStmt.close();
            if(contactStmt!=null)
               contactStmt.close();
            if(personIdStmt!=null)
               personIdStmt.close();
            if(conn!=null)
               conn.close();
         }
      }

      public void addPerson(String name,String address,String home,String work,String mobile) throws Exception{
         String personSql,contactSql;
         Connection conn = null;
         PreparedStatement personStmt = null;
         PreparedStatement contactStmt = null;

         personSql = "insert into persons(name,address) values (?,?)";
         contactSql = "insert into contacts values(?,?,?)";
         
         try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn.setAutoCommit(false);
            personStmt = conn.prepareStatement(personSql,Statement.RETURN_GENERATED_KEYS);
            contactStmt = conn.prepareStatement(contactSql);
            
            int id = 0;

            personStmt.setString(1,name);
            personStmt.setString(2,address);
            personStmt.executeUpdate();

            ResultSet idResult =  personStmt.getGeneratedKeys();

            if(idResult.next()){
               id = idResult.getInt(1);
               if(!mobile.equals("-")){
                  contactStmt.setInt(1,id);
                  contactStmt.setString(2,"mobile");
                  contactStmt.setString(3,mobile);
                  contactStmt.executeUpdate();
               }

               if(!home.equals("-")){
                  contactStmt.setInt(1,id);
                  contactStmt.setString(2,"home");
                  contactStmt.setString(3,home);
                  contactStmt.executeUpdate();
               }

               if(!work.equals("-")){
                  contactStmt.setInt(1,id);
                  contactStmt.setString(2,"work");
                  contactStmt.setString(3,work);
                  contactStmt.executeUpdate();
               }
            }else{
               System.out.println("Could not get the last inserted row id.");
            } 
            conn.commit(); 
         }catch(SQLException integritySql){
            System.out.println("Record Already Exists integrity");   
            conn.rollback();
         }finally{
            if(personStmt!=null)
               personStmt.close();
            if(contactStmt!=null)
               contactStmt.close();
            if(conn!=null)
               conn.close();
         }
      }

      public void display() throws Exception{
         String personSql;
         Connection conn = null;
         PreparedStatement personStmt = null;

         personSql = "select * from persons";
         
         try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            personStmt = conn.prepareStatement(personSql);
            ResultSet rs = personStmt.executeQuery();
            System.out.println("-----------------------------------------------------");
            while(rs.next()){
               System.out.println("Id       : " + rs.getInt(1)+ "\nName     : "+rs.getString(2) + "\nAddress  : "+ rs.getString(3));
               System.out.println("-----------------------------------------------------");
            }
         }
         catch(SQLException integritySql){
            System.out.println("Record Already Exists integrity");   
         }finally{
            if(personStmt!=null)
               personStmt.close();
            if(conn!=null)
               conn.close();
         }

      }

      public void updatePerson(int id,String name,String address,String home,String work,String mobile) throws Exception{
         String personSql,contactSql;
         Connection conn = null;
         PreparedStatement personStmt = null;
         PreparedStatement contactStmt = null;

         personSql = "update persons set";
         if(!address.equals("-") && !name.equals("-")){
            personSql += " name = '" +name+"',address = '"+address+"' where id = "+id;
         }else if(!address.equals("-")){
            personSql += " address = '"+address+"' where id = "+id;
         }else if(!name.equals("-")){
            personSql += "name = '" +name+"' where id = "+id;
         }

         contactSql = "update contacts set phone = ? where type = ? and person_id = " + id;
         
         try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            personStmt = conn.prepareStatement(personSql);
            contactStmt = conn.prepareStatement(contactSql);            

            conn.setAutoCommit(false);
            if(!name.equals("-") || !address.equals("-")){
               personStmt.executeUpdate();
            }

            if(!home.equals("-")){
               contactStmt.setString(1,home);
               contactStmt.setString(2,"home");
               contactStmt.executeUpdate();
            }

            if(!work.equals("-")){
               contactStmt.setString(1,work);
               contactStmt.setString(2,"work");
               contactStmt.executeUpdate();
            }

            if(!mobile.equals("-")){
               contactStmt.setString(1,mobile);
               contactStmt.setString(2,"mobile");
               contactStmt.executeUpdate();
            }
            conn.commit();
         }
         catch(SQLException integritySql){
            System.out.println(integritySql);   
            conn.rollback();
         }finally{
            if(personStmt!=null)
               personStmt.close();
            if(contactStmt!=null)
               contactStmt.close();
            if(conn!=null)
               conn.close();
         }
      }
}