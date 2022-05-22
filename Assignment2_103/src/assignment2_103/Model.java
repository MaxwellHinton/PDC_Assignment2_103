/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 *
 * @author maxhi
 */
public class Model extends Observable
{
    public HotelDB db;
    public String email;

    private Map<String, Room> rooms = new HashMap<String, Room>();
    
    
    public Model()
    {
        this.db = new HotelDB();
        this.db.hoteldbSetup();
    }
    
    public void checkAccount(Account acc)
    {
        if(db.checkAccount(acc))
        {
            //
        }
        
    }

    private void reserveRoom() 
    {
        
    }
    
    private void getAllRooms()
    {
        rooms = db.getAllAvailableRooms();
        
        if(rooms.isEmpty())
        {
            System.out.println("No rooms are in the system.");
        }
    }
}
