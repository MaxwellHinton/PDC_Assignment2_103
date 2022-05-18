/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maxhi
 */
public class HotelDBManager 
{
    private static final String USER_NAME = "hotel"; //your DB username
    private static final String PASSWORD = "hotel"; //your DB password
    private static final String URL = "jdbc:derby:HotelDB; create=true";  //url of the DB host
    Connection conn;
    
    public HotelDBManager() 
    {
        establishConnection();
    }

    //Establish connection
    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " has connected successfully ....");
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection() 
    {
        return this.conn;
    }
    
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
