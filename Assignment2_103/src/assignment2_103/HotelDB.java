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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author maxhi
 */
public class HotelDB 
{
    private Connection conn;
    private final String URL = "jdbc:derby:HotelDB;create=true";
    private final String dbusername = "hotel";
    private final String dbpassword = "hotel";
    private Map<String, Room> allRooms = new HashMap<String, Room>(); 
    private Map<String, Account> allAccounts = new HashMap<String, Account>();
    private Map<Account, Room> allReservations = new HashMap<Account, Room>();
    
    public HotelDB(){}
    
    public void hoteldbSetup()
    {
        try 
        {
            conn = DriverManager.getConnection(URL, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String accountsTable = "ACCOUNTS";
            String roomsTable = "ROOMS";
            
            statement.executeUpdate("DROP TABLE ROOMS");
            statement.executeUpdate("DROP TABLE ACCOUNTS");
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

           // allAccounts = this.getAllAccounts();
            
           // if(allAccounts.isEmpty())
          //  {
             //   System.out.println("Accounts table is empty");
           // }
           // else
          //  {
              //  for(String acc : allAccounts.keySet())
              //  {
              //      System.out.println(allAccounts.get(acc).toString());
               // }
          //  }
            
            //allRooms = this.getAllAvailableRooms();
            //if(allRooms.isEmpty())
            //{
              //  System.out.println("rooms table is empty");
            //}
           // else
            //{
               // for(String room : allRooms.keySet())
               // {
                //    System.out.println(allRooms.get(room).toString());
                //    System.out.println(allRooms.get(room).getStatus() + " CUSTOMER: " + allRooms.get(room).getCustomer());
                //    System.out.println("------------------------");
                //}
            //}

        }
            
        catch (Throwable e) 
        {
            System.out.println(e.getMessage());
        }
    }
    
    public Account getAccountDB(Account account)
    {
        String firstname;
        String surname;
        String email;
        Account acc = new Account(null, null, null);
        
        if(checkAccount(account)) //Make sure acc exists
        {
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
        }
        else
        {
            System.out.println("Account you are asking for does not exist");
        }
        return acc;
    }
    
    public Room getRoomDB(Room room)
    {
        Room rm = new Room(null, null, 0);     
        
        String roomNumber;      
        RoomType type; 
        String roomType;
        double price;
        boolean status = false;
        String customer;
        
        if(checkRoom(room))
        {
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

                            roomNumber = rs.getString(1);
                            roomType = rs.getString(2);
                            price = rs.getDouble(3);
                            status = rs.getBoolean(4);
                            customer = rs.getString(5);


                            if("SINGLE".equals(roomType))
                            {
                                type = RoomType.SINGLE;
                            }
                            else
                            {
                                type = RoomType.DOUBLE;
                            }

                            //Setting methods for new room

                            rm.setRoomNumber(roomNumber);
                            rm.setRoomType(type);
                            rm.setPrice(price);
                            rm.setStatus(status);
                            rm.setCustomerByEmail(customer);
                        }

                    }while(rs.next());
                }
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("Room you are asking for does not exist.");
        }
        return rm;
        
    }
    
    public Map<String, Account> getAllAccounts() // Read function 3/3
    {
        String firstname;
        String surname;
        String email;
        
        Map<String, Account> accounts = new HashMap<String, Account>();
        
        try
        {
            String sql = "SELECT * FROM ACCOUNTS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next())
            {
                do
                {
                    firstname = rs.getString("FIRSTNAME");
                    surname = rs.getString("SURNAME");
                    email = rs.getString("EMAIL");
                    
                    Account acc = new Account(firstname, surname, email);
                    accounts.put(email, acc);
                    
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
    
    public Map<Account, Room> getAllReservations()
    {
        String roomNumber;
        String roomType;  //RoomType enum String version
        RoomType type; 
        Double price;
        Boolean status;
        String customer;
        
        Map<Account, Room> reservations = new HashMap<Account, Room>();
        
        try
        {
            String sql = "select * from ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs.next())
            {
                do
                {
                    if(rs.getBoolean("STATUS") && (rs.getString("CUSTOMER") != null)) //Check if the records status is true & there is a customer attatched.
                    {
                        
                        roomNumber = rs.getString(1);
                        roomType = rs.getString(2);
                        price = rs.getDouble(3);
                        status = rs.getBoolean(4);
                        customer = rs.getString(5);

                        if("SINGLE".equals(roomType))
                        {
                            type = RoomType.SINGLE;
                        }
                        else
                        {
                            type = RoomType.DOUBLE;
                        }
                        
                        Room room = new Room(roomNumber, type, price);        
                    }
                    
                }while(rs.next());
            }
            statement.close();
           
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return reservations;
    }
    
    public Map<String, Room> getAllAvailableRooms() //Read function
    {
        String roomNumber;
        String roomType;  //RoomType enum String version
        RoomType type; 
        Double price;
        Boolean status;
        String customer;
        
        Map<String, Room> rooms = new HashMap<String, Room>();
        
        try
        {
            String sql = "select * from ROOMS";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next())
            {
                do
                {
                    roomNumber = rs.getString(1);
                    roomType = rs.getString(2);
                    price = rs.getDouble(3);
                    status = rs.getBoolean(4);
                    customer = rs.getString(5);
                    
                    if("SINGLE".equals(roomType))
                    {
                        type = RoomType.SINGLE;
                    }
                    else
                    {
                        type = RoomType.DOUBLE;
                    }
                    
                    Room room = new Room(roomNumber, type, price);
                    room.setStatus(status);
                    room.setCustomerByEmail(customer);
                    
                    rooms.put(roomNumber, room);
                    
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
    
    public boolean reserveRoom(Account account, Room room) //writing function 1/3
    {
        boolean reserved = false;
        
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
        
        return reserved;
    }
    
    public void addRoomToDB(Room room) //Writing function 2/3
    {        
        try
        {
            if(!checkRoom(room))
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
            else
            {
                System.out.println("Room:" + room.getRoomNumber() + " already exists");
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    
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
    
    public boolean checkAccount(Account account) // Read function 1/3
    {
        boolean exists = false;
        String email = account.getEmail();
        
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
            else
            {
                //Account does not exist
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
    
    public boolean checkRoom(Room room) //Read function 2/3
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
