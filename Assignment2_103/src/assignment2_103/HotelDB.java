/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author maxhi
 */
public class HotelDB 
{
    private static Connection conn;
    private final String URL = "jdbc:derby:HotelDB;create=true";
    private final String dbusername = "hotel";
    private final String dbpassword = "hotel";
    
    public HotelDB(){}
    
    public void hoteldbSetup()
    {
        try 
        {
            conn = DriverManager.getConnection(URL, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String accountsTable = "ACCOUNTS";
            String roomsTable = "ROOMS";
            
            //statement.executeUpdate("DROP TABLE ROOMS");
            //statement.executeUpdate("DROP TABLE ACCOUNTS");
            //Make Accounts table if doesnt exist
            if (!checkExistingTable(accountsTable)) 
            {
                statement.executeUpdate("CREATE TABLE " + accountsTable + " (FIRSTNAME VARCHAR(20), SURNAME VARCHAR(20), EMAIL VARCHAR(40))");
                System.out.println("Accounts table has been created successfully.\n");
            }
            //Make Rooms table if doesnt exist
            if(!checkExistingTable(roomsTable))
            {
                statement.executeUpdate("CREATE TABLE " + roomsTable + " (ROOMNUMBER VARCHAR(10), ROOMTYPE VARCHAR(10), PRICE DOUBLE, STATUS BOOLEAN, CUSTOMER VARCHAR(40))");
                System.out.println("Rooms table has been created successfully.");
            }  
            statement.close();
        }    
        catch (Throwable e) 
        {
            System.out.println(e.getMessage());
        }
    }
    /*
     * Gets account from database via the email
     *
    */ 
    public Account getAccountDBEmail(String e)
    {
        String firstname;
        String surname;
        String email;
        Account acc = new Account(null, null, null);
                
        try
        {
            String sql = "SELECT * FROM ACCOUNTS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    if(e.equals(rs.getString(3)))
                    {
                        firstname = rs.getString(1);
                        surname = rs.getString(2);
                        email = rs.getString(3);

                        acc.setFirstname(firstname);
                        acc.setSurname(surname);
                        acc.setEmail(email);

                        break;
                    }

                }while(rs.next());
            }

            statement.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return acc;
    }
    /*
     * Gets room from database via the room number
     *
    */ 
    public Room getRoomRoomNumber(String number)
    {
        RoomType type;
        String roomType;
        Double price;
        Room room = new Room(null, null, 0);
                
        try
        {
            String sql = "SELECT * FROM ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    if(number.equals(rs.getString(1)))
                    {
                        roomType = rs.getString(2);
                        
                        if("SINGLE".equals(roomType))
                        {
                            type = RoomType.SINGLE;
                        }
                        else
                        {
                            type = RoomType.DOUBLE;
                        }


                        room.setRoomNumber(rs.getString(1));
                        room.setRoomType(type);
                        room.setPrice(rs.getDouble(3));
                        room.setStatus(rs.getBoolean(4));
                        room.setCustomerByEmail(rs.getString(5));

                        break;
                    }

                }while(rs.next());
            }

            statement.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

        return room;
    }
    /*
     * Gets account from database via the account
     *
    */ 
    public Account getAccountDB(Account account)
    {
        String firstname;
        String surname;
        String email;
        Account acc = new Account(null, null, null);

        try
        {
            String sql = "SELECT * FROM ACCOUNTS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    if(account.getEmail().equals(rs.getString(3)))
                    {
                        firstname = rs.getString(1);
                        surname = rs.getString(2);
                        email = rs.getString(3);

                        acc.setFirstname(firstname);
                        acc.setSurname(surname);
                        acc.setEmail(email);

                        break;
                    }

                }while(rs.next());
            }

            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return acc;
    }
    /*
     * Gets room from database via the room.
     *
    */
    public Room getRoomDB(Room room)
    {
        Room rm = new Room(null, null, 0);     
        RoomType type; 
        String roomType;
        
        try
        {
            String sql = "SELECT * FROM ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    if(room.getRoomNumber().equals(rs.getString(1)))
                    {
                        roomType = rs.getString(2);

                        if("SINGLE".equals(roomType))
                        {
                            type = RoomType.SINGLE;
                        }
                        else
                        {
                            type = RoomType.DOUBLE;
                        }


                        rm.setRoomNumber(rs.getString(1));
                        rm.setRoomType(type);
                        rm.setPrice(rs.getDouble(3));
                        rm.setStatus(rs.getBoolean(4));
                        rm.setCustomerByEmail(rs.getString(5));
                    }

                }while(rs.next());
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return rm;
    }     
    /*
     * Returns all accounts from database in a List
     *
    */
    public static List<Account> getAllAccounts()
    {        
        List<Account> accounts = new ArrayList<Account>();
        
        try
        {
            String sql = "SELECT * FROM ACCOUNTS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next())
            {
                do
                {
                    Account acc = new Account();
                    
                    acc.setFirstname(rs.getString("FIRSTNAME"));
                    acc.setSurname(rs.getString("SURNAME"));
                    acc.setEmail(rs.getString("EMAIL"));
                    accounts.add(acc);
                    
                }while(rs.next());
            }
            else
            {
                System.out.println("No accounts were found.");
            }
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
  
        
        return accounts;
    }
    
    public static List<Room> getAllAvailableRooms()
    {
        List<Room> availableRooms = new ArrayList<Room>();
        RoomType type;
        
        try
        {
            String sql = "select * from ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    if(!(rs.getBoolean(4)))
                    {

                        Room room = new Room(null, null, 0);

                        room.setRoomNumber(rs.getString(1));
                        room.setPrice(rs.getDouble(3));
                        room.setStatus(rs.getBoolean(4));
                        room.setCustomerByEmail(rs.getString(5));

                        if("SINGLE".equals(rs.getString(2)))
                        {
                            type = RoomType.SINGLE;
                        }
                        else
                        {
                            type = RoomType.DOUBLE;
                        }
                        room.setRoomType(type);

                        availableRooms.add(room);
                    }
                    
                }while(rs.next());
            }         
            else
            {
                System.out.println("Records not found, Rooms table must be empty.");
            }
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return availableRooms;
    }
    /*
     * Returns all rooms from database in a List
     *
    */
    public static List<Room> getAllRooms()
    {  
        List<Room> rooms = new ArrayList<Room>();
        RoomType type;
        
        try
        {
            String sql = "select * from ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    Room room = new Room(null, null, 0);
                    
                    room.setRoomNumber(rs.getString(1));
                    room.setPrice(rs.getDouble(3));
                    room.setStatus(rs.getBoolean(4));
                    room.setCustomerByEmail(rs.getString(5));
                    
                    if("SINGLE".equals(rs.getString(2)))
                    {
                        type = RoomType.SINGLE;
                    }
                    else
                    {
                        type = RoomType.DOUBLE;
                    }
                    room.setRoomType(type);
                    
                    rooms.add(room);
                    
                }while(rs.next());
            }         
            else
            {
                System.out.println("Records not found, Rooms table must be empty.");
            }
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return rooms;
    }
    /*
     * Changes room's status to true and attatches customer
     *
    */ 
    public void reserveRoom(Account account, Room room)
    {
        try
        {
            String sql = "UPDATE ROOMS SET STATUS = ?, CUSTOMER = ? WHERE ROOMNUMBER = ?";
            Statement statement = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2, account.getEmail());
            ps.setString(3, room.getRoomNumber());
            ps.executeUpdate();
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*
     * Adds room to database
     *
    */
    public void addRoomToDB(Room room) //Writing function 2/3
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
    /*
     * Adds account to database
     *
    */ 
    public void addAccountToDB(Account account) //Writing function 3/3
    {
        try
        {   
            if(!checkAccount(account))
            {
                String sql = "INSERT INTO ACCOUNTS(FIRSTNAME, SURNAME, EMAIL) " + "VALUES(?,?,?)";

                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, account.getFirstname());
                st.setString(2, account.getSurname());
                st.setString(3, account.getEmail());
                st.executeUpdate();

                System.out.println("Account with email: " +account.getEmail() +" has been added successfully.");
            }
            else
            {
                System.out.println("Account: " + account.getEmail() + " already exists");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*
     * Checks if account exists in databse via email
     *
    */
    public boolean checkAccountEmail(String email)
    {   
        boolean exists = false;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ACCOUNTS");
            
            if(rs.next())
            {
                do
                {
                    if(rs.getString("EMAIL").equals(email))
                    {
                        exists = true;
                        break;
                    }
                }while(rs.next());
            }
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return exists;
                
    }
    /*
     * Checks if account exists in databse
     *
    */
    public boolean checkAccount(Account account)
    {
        String email = account.getEmail();
        boolean exists = false;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ACCOUNTS");
            
            if(rs.next())
            {
                do
                {
                    if(rs.getString("EMAIL").equals(email))
                    {
                        // Account does exist
                        exists = true;
                        break;
                    }
                }while(rs.next());
            } 
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
   
        return exists;
    }
    
    public boolean checkRoomRoomNumber(String roomNumber)
    {
        boolean exists = false;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ROOMS");
            
            if(rs.next())
            {
                do
                {
                    if(rs.getString("ROOMNUMBER").equals(roomNumber))
                    {
                        exists = true;
                        break;
                    }
                }while(rs.next());
            }
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return exists;
    }
    /*
     * Checks if room exists in databse
     *
    */
    public boolean checkRoom(Room room)
    {
        boolean exists = false;
        
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ROOMS");
            
            if(rs.next())
            {
                do
                {
                    if(rs.getString("ROOMNUMBER").equals(room.getRoomNumber()))
                    {
                        //Room does exist
                        exists = true;
                        break;
                    }
                }while(rs.next());
            }
            else
            {
                //Room does not exist
                exists = false;
            }
            
            statement.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
      
        return exists;       
    }
    /*
     *  Checks if the table exists in the database
     *  Returns true if it does
    */
    private boolean checkExistingTable(String tablename) //Reading function
    {
        boolean exists = false;
        try 
        {

            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, null, null);
            Statement statement = conn.createStatement();
            
            
            while (rs.next()) 
            {
                String tableName = rs.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(tablename) == 0) 
                {
                    System.out.println(tableName + "  is there");
                    exists = true;
                    break;
                }
            }
            if (rs != null) 
            {
                rs.close();
            }
            
            statement.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("error in checkExistingTable");
        }
        return exists;
    }
}
