/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JScrollPane;



/**
 *
 * @author maxhi
 */
public class Model
{
    public HotelDB db;
    public String email;

    private Map<String, Room> rooms = new HashMap<String, Room>();
    private Map<String, Account> accounts = new HashMap<String, Account>();
    
    private AccountsTable accTable;
    private JScrollPane accountTableScrollPane;
    
    private RoomsTable roomTable;
    private JScrollPane roomTableScrollPane;
       
    public Model()
    {
        this.db = new HotelDB();
        this.db.hoteldbSetup();
        this.accTable = new AccountsTable();
        this.roomTable = new RoomsTable();
        this.accountTableScrollPane = new JScrollPane(this.accTable.getAccTable());
        this.roomTableScrollPane = new JScrollPane(this.roomTable.getRoomTable());
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
        boolean flag = false;
        char c;
        
        if(input.length() != 0)
        {
            if(!(checkOnlyLetters(input)))
            {   
                flag = false;
            }
            else
            {
                switch (input) 
                {
                    case "single":
                        flag = true;
                        break;
                    case "double":
                        flag = true;
                        break;
                    default:
                        flag = false;
                        break;
                }
            }
        }
        else
        {
            flag = false;
        }

        return flag;
        
    }
    /*
     * Returns true if the room exists via the rooms Map
     *
    */
    public boolean checkRoomExists(String roomNumber)
    {
        if(rooms.containsKey(roomNumber))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean checkAccountExistsEmail(String email)
    {
        if(accounts.containsKey(email))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
     * Returns true if the account exists via the accounts Map
     *
    */
    public boolean checkAccountExists(Account account)
    {
        if(db.checkAccount(account))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*
     * Checks if the room number entered is a number.
     * Returns true if room number is a number
    */
    public boolean checkRoomNumber(String input)
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
            int i = Integer.parseInt(input);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        
        return flag;
    }
    /*
     *  Checks if the input has any special characters
     *  Returns true if it does
    */
    public static boolean checkSpecialChars(String input)
    {
        boolean flag = false;
        char c;
        String specialChars = "!@#$%&*()'+,-./:;<=>?[]^_`{|} ";
                
        for(int i = 0; i < input.length(); i++)
        {
            c = input.charAt(i);

            if(specialChars.contains(Character.toString(c))) //check for special characters
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    /*
     *  Checks if the input does not contain special characters or numbers. 
     *  Returns true if it only contains letters
    */
    public static boolean checkOnlyLetters(String input)
    {
        boolean flag = true;

        if(checkSpecialChars(input)) //check for special characters
        {
            flag = false;
        }
        if(input.matches(".*[0-9].*")) //check for numbers
        {
            flag = false;
        }
        
        return flag;
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

    private void reserveRoom() 
    {
        
    }
    /*
     *  Returns the account table inside of its scrollpane
     *
    */    
    public JScrollPane getAccountsJtable()
    {
        return this.accountTableScrollPane;
    }
    
    public JScrollPane getRoomsJtable()
    {
        return this.roomTableScrollPane;
    }
    
    public Account getAccount(String email)
    {
        return accounts.get(email);
    }

    public void createAccount(String firstname, String surname, String email) 
    {
        Account acc = new Account(firstname, surname, email);
       
        accounts.put(email, acc);
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
        
        rooms.put(roomNumber, room);
        db.addRoomToDB(room);
        roomTable.addRoomToTable(room);
        
        System.out.println((db.getRoomDB(room)).toString());

    }

}
