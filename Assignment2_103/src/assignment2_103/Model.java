/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import javax.swing.JScrollPane;
/**
 *
 * @author maxhi
 */
public class Model
{
    public HotelDB db;
    public String email;
    private AccountsTable accTable;
    private JScrollPane accountTableScrollPane;
    private RoomsTable roomTable;
    private JScrollPane roomTableScrollPane;
    private UserRoomsTable userRoomTable;
    private JScrollPane userTableScrollPane;
    public boolean restarted = false; //If user restarts program using button, this becomes true and drops the data tables.
       
    public void ModelSetup()
    {
        this.db = new HotelDB();
        this.db.restarted = restarted;
        this.db.hoteldbSetup();
        this.accTable = new AccountsTable();
        this.roomTable = new RoomsTable();
        this.userRoomTable = new UserRoomsTable();
        this.accountTableScrollPane = new JScrollPane(this.accTable.getAccTable());
        this.roomTableScrollPane = new JScrollPane(this.roomTable.getRoomTable());
        this.userTableScrollPane = new JScrollPane(this.userRoomTable.getUserRoomsTable());
    }
    /*
     *  Checks if the input is not null and only letters.
     *  Returns true if there is input, and it is only letters
    */
    public boolean checkAccountInput(String input)
    {
        boolean flag = false;
        char c;
        
        if(input.length() != 0)
        {
            if(checkOnlyLetters(input))
            {
                 flag = true;
            }
        }
        else
        {
            flag = false;
        }
  
        return flag;
    }
    /*
     *  Checks the price input was in double format
     *  Returns true if the price is a double
    */
    public boolean checkPrice(String input)
    {
        boolean flag = true;
        
        if(!(input.length() != 0))
        {
            return false;
        }
        
        if(!(input.matches(".*[0-9].*")))
        {
            return false;
        }
        
        try
        {
            Double d = Double.parseDouble(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        
        return flag;
    }
    /*
     *  Checks if the room type is of correct format
     *  Returns true if its either single or double
    */
    public boolean checkRoomType(String input) 
    { 
        if(input.length() != 0)
        {
            if(!(checkOnlyLetters(input)))
            {   
                return false;
            }
            else
            {
                switch (input) 
                {
                    case "single":
                        return true;
                        
                    case "double":
                        return true;
                        
                    default:
                        return false;        
                }
            }
        }
        else
        {
            return false;
        }
    }
    /*
     * Returns true if the room exists via the rooms Map
     *
    */
    public boolean checkRoomExists(String roomNumber)
    {
        if(db.checkRoomRoomNumber(roomNumber))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
     * Returns true if the accounts exists in the database via an email input
     *
    */
    public boolean checkAccountExistsEmail(String email)
    {
        if(db.checkAccountEmail(email))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
     * Returns true if the account exists in the database via an account input
     *
    */
    public boolean checkAccountExists(Account account)
    {
        if(db.checkAccount(account))
        {
            System.out.println("Account does exists");
            return true;
        }
        else
        {
            System.out.println("Account does not exist");
            return false;
        }
    }
    /*
     * Checks if the room number entered is a number.
     * Returns true if room number is a number
    */
    public boolean checkRoomNumber(String input)
    {
        if(!(input.length() != 0))
        {
            return false;
        }
        
        if(!(input.matches(".*[0-9].*")))
        {
            return false;
        }
        try
        {
            int i = Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    
        return true;
    }
    /*
     *  Checks if the input has any special characters
     *  Returns true if it does
    */
    public boolean checkSpecialChars(String input)
    {
        char c;
        String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|} ";
                
        for(int i = 0; i < input.length(); i++)
        {
            c = input.charAt(i);

            if(specialChars.contains(Character.toString(c)))
            {
                return true;
            }
        }
        return false;
    }
    /*
     *  Checks if the input does not contain special characters or numbers. 
     *  Returns true if it only contains letters
    */
    public boolean checkOnlyLetters(String input)
    {
        if(checkSpecialChars(input)) //check for special characters
        {
            return false;
        }
        if(input.matches(".*[0-9].*")) //check for numbers
        {
            return false;
        }
        
        return true;
    }
    /*
    *  Checks if the email contains a string and is not null
    *  Returns true if email is a string
    */
    public boolean checkEmail(String input)
    {
        if(input.length() == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    /*
     * Checks if the room reservation input is mathcing a room that hasnt been reserved
     *
    */    
    public String checkRoomReservation(String roomNumber, Account currentUser) 
    {
        if(checkRoomNumber(roomNumber))
        {
            if(checkRoomExists(roomNumber))
            {
                if(checkRoomStatus(getRoomViaRoomNumber(roomNumber)))
                {
                    return "reserved";
                }
                else
                {
                    Room room = getRoomViaRoomNumber(roomNumber);
                    reserveRoom(currentUser, room);
                    System.out.println(room.getStatus());
                    System.out.println(room.getCustomer());
                }
            }
            else
            {
                return "invalid input";
            }
        }
        else
        {
            return "invalid input";
        }
        
        return "success";
    }
    

    public void reserveRoom(Account currentUser, Room room) 
    {
        room.setStatus(true);
        room.setCustomer(currentUser);
        db.reserveRoom(currentUser, room);
        roomTable.updateRoom(room);
        userRoomTable.removeRoom(room);
    }
    /*
     * Checks if the rooms status is true on database
     * Returns true if the room status is true (reserved)
    */
    public boolean checkRoomStatus(Room room)
    {
        if(db.getRoomDB(room).getStatus())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void addAccount(Account account)
    {
        db.addAccountToDB(account);
        accTable.addAccountToTable(account);
        
        System.out.println(db.getAccountDB(account).getEmail() + " added successfully.");
    }
    
    public void addRoom(Room room)
    {
        db.addRoomToDB(room);
        roomTable.addRoomToTable(room);
        userRoomTable.addRoomToTable(room);
        
        System.out.println("Room:" + db.getRoomDB(room).getRoomNumber() + " added successfully.");
    }
    
    public void createAccount(String firstname, String surname, String email) 
    {
        Account acc = new Account(firstname, surname, email);
        
        db.addAccountToDB(acc);
        accTable.addAccountToTable(acc);
        
        System.out.println((db.getAccountDB(acc).toString()));
    }
    
    public void createRoom(String roomNumber, String roomType, String roomPrice) 
    {
        RoomType type;
        Double price = Double.parseDouble(roomPrice);
        
        if(roomType.equals("single"))
        {
            type = RoomType.SINGLE;
        }
        else
        {
            type = RoomType.DOUBLE;
        }
        
        Room room = new Room(roomNumber, type, price);
        
        db.addRoomToDB(room);
        roomTable.addRoomToTable(room);
        userRoomTable.addRoomToTable(room);
        
        System.out.println((db.getRoomDB(room)).toString());
    } 
    /*
     *  Getters
     *
    */    
    public JScrollPane getAccountsJtable(){ return this.accountTableScrollPane; }
    
    public JScrollPane getRoomsJtable(){ return this.roomTableScrollPane; }
    
    public JScrollPane getUserRoomsJtable(){ return this.userTableScrollPane; }
    
    public Account getAccountViaEmail(String email){ return db.getAccountDBEmail(email); }
    
    public Account getAccount(Account acc) { return db.getAccountDB(acc); }
    
    public Room getRoom(Room room) { return db.getRoomDB(room); }
    
    public Room getRoomViaRoomNumber(String roomNumber){ return db.getRoomRoomNumber(roomNumber); }


}
