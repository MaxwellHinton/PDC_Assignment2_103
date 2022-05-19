/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author maxhi
 */
public class HotelDB 
{
    HotelDBManager dbManager;
    Connection conn;
    Statement statement;
    String URL = "";
    
    public HotelDB() 
    {
        dbManager = new HotelDBManager();
        conn = dbManager.getConnection();
        
        try 
        {
            statement = conn.createStatement();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createRoomsTable()
    {   
        try
        {
            this.checkExistedTable("ROOMS");
            this.statement.addBatch("CREATE TABLE ROOMS (ROOMNUMBER VARCHAR(5), ROOMTYPE VARCHAR(10), PRICE DOUBLE, STATUS BOOLEAN, CUSTOMER VARCHAR(40))");
            this.statement.executeBatch();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        System.out.println("ROOMS table has been created successfully.");
    }
    
    public void displayAllRooms() //reading function
    {
        //Need to iterate through room table and display/collect all rooms currently in the system
    }
    
    
    public void reserveRoom(Account account, String roomNumber) //writing function 1/3
    {
        //Need to iterate through the room table till it finds the correct room number
        //Then set the room status to true and the room customer to the account specified.
        
        
        //rooms.getRoom(room).setStatus(true);
        //rooms.getRoom(room).setCustomer(customer);
    }
    
    public void addRoomToTable(Room room) //writing function 2/3
    {        
        try
        {
            String sql = "INSERT INTO ROOMS(ROOMNUMBER, ROOMTYPE, PRICE, STATUS, CUSTOMER)" + "VALUES(?,?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, room.getRoomNumber());
            st.setString(2, room.getRoomType().name());
            st.setDouble(3, room.getPrice());
            st.setBoolean(4, room.getStatus());
            st.setString(5, room.getCustomer());
            st.executeUpdate();
            
            System.out.println("Room number: " + room.getRoomNumber() +" has been added successfully!");
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void createAccountsTable()
    {
        try
        {
            this.checkExistedTable("ACCOUNTS");
            this.statement.addBatch("CREATE TABLE ACCOUNTS (FIRSTNAME VARCHAR(20), SURNAME VARCHAR(20), EMAIL VARCHAR(40))");
            this.statement.executeBatch();
            String sql = "INSERT INTO ACCOUNTS(FIRSTNAME, SURNAME, EMAIL) " + "VALUES(?,?,?)";
  
            PreparedStatement st = conn.prepareStatement(sql); // Examples accounts.
            st.setString(1, "Maxwell");
            st.setString(2, "Hinton");
            st.setString(3, "qwv9850@autuni.ac.nz");
            st.executeUpdate();
            st.setString(1, "Mathew");
            st.setString(2, "Glass");
            st.setString(3, "mathewglass@example.co.nz");
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
        System.out.println("Accounts table has been created successfully.");
    }
    
    public void addAccountToTable(Account account) //writing function 3/3
    {
        String sql = "INSERT INTO ACCOUNTS(FIRSTNAME, SURNAME, EMAIL) " + "VALUES(?,?,?)";
        
        try
        {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, account.getFirstname());
            st.setString(2, account.getSurname());
            st.setString(3, account.getEmail());
            st.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    private void checkExistedTable(String table) 
    {
        try
        {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);
            
            while(rs.next())
            {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if(table_name.equalsIgnoreCase(table))
                {
                    statement.executeUpdate("Drop table " + table);
                    System.out.println("Table " + table + " has been deleted.");
                    break;
                }
            }
            rs.close();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void closeConnection() 
    {
        this.dbManager.closeConnections();
    }
}
