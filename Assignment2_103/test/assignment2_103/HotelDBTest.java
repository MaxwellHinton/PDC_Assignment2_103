/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author maxhi
 */
public class HotelDBTest 
{
    private HotelDB db;
    private final Account testAcc = new Account("test", "test", "test Email");
    private final Room testRoom = new Room("157", RoomType.SINGLE, 35.00);
    
    private final Account testAcc2 = new Account("test2", "test2", "test Email2");
    private final Room testRoom2 = new Room("7", RoomType.DOUBLE, 55.00);
    
    public HotelDBTest(){
    }
    
    @Before
    public void setUpDB()
    {
        this.db = new HotelDB();
        this.db.hoteldbSetup();
    }
    
    @After
    public void shutdownDB()
    {
        try
        {
            this.db.statement.close();
            
        }   
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void getAllRoomsTest()
    {
        List<Room> rooms = new ArrayList<Room>();
        
        this.db.addRoomToDB(testRoom);
        this.db.addRoomToDB(testRoom2);
        
        rooms = HotelDB.getAllRooms();
        
        if(rooms.size() != 2)
        {
            fail();
        }
    }
    
    @Test
    public void reserveRoomTest()
    {
        this.db.addRoomToDB(testRoom2);
        this.db.reserveRoom(testAcc2, testRoom2);
        
        Room room = db.getRoomDB(testRoom2);
        
        if(!(room.getStatus()))
        {
            fail();
        }
    }
    
    @Test     
    public void addAndCheckRoomDBTest() 
    {        
        this.db.addRoomToDB(testRoom2);
        
        Assert.assertTrue(db.checkRoom(testRoom2));
    }

    @Test
    public void addAndCheckAccountDBTest()
    {
        this.db.addAccountToDB(testAcc2);
        
        Assert.assertTrue(db.checkAccount(testAcc2));
    }
    
}
