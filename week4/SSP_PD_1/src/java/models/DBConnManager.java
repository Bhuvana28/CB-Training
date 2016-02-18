/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cb-bhuvana
 */
public class DBConnManager {
    private final Connection connection;
    private final String dbURL = "jdbc:mysql://localhost/self_service_portal_pd1";
    private final String user = "root";
    private final String pwd = "";
    
    public DBConnManager() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(dbURL, user, pwd);
    }
    
    public Connection getConnection(){
        return this.connection;
    }
}
