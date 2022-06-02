/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author maxhi
 */
public class ModelTest 
{
    
    private Model model;
    
    private final Account testAcc = new Account("modelTest", "modelTest", "modelTest Email");
    
    public ModelTest() {
    }
    
    @Before
    public void setUpModel() 
    {
        this.model = new Model();
        this.model.ModelSetup();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void reserveRoomTest()
    {
        Account acc = new Account("Mat", "Hinton", "mathinton@gmail.com");
        Room room = new Room("38", RoomType.DOUBLE, 90.00);
        
        model.addAccount(acc);
        model.addRoom(room);
        
        model.reserveRoom(acc, room);
        
        assertTrue(model.getRoom(room).getStatus());
    }
    
    @Test
    public void checkInputsTest()
    {
        Account acc = new Account("max", "hinton", "qwv9850@autuni.ac.nz");
        Room room = new Room("37", RoomType.SINGLE, 45.00);
        
        String roomnumber = "37";
        String roomType = "single";
        String price = "55.00";
        
        String firstname = "max";
        String surname = "1234";
        
        String specialChars = "abc!@#$";
        
        assertTrue(model.checkRoomNumber(room.getRoomNumber()));
        System.out.println("Assertion 1 - Checks room number input is int format");
        
        assertTrue(model.checkRoomType(roomType));
        System.out.println("Assertion 2 - Checks RoomType input is either 'single' or 'double'");
        
        assertTrue(model.checkPrice(price));
        System.out.println("Assertion 3 - Checks room price input is double format");
        
        assertTrue(model.checkAccountInput(firstname));
        System.out.println("Assertion 4 - Checks firstname input is not 'nothing', and it doesn't contain numbers or special chars.");
        
        assertFalse(model.checkAccountInput(surname));
        System.out.println("Assertion 5 - Checks surname input which is 1234 - will return false");
        
        assertTrue(model.checkSpecialChars(specialChars));
        System.out.println("Assertion 6 - Checks specialChars input which does contain special characters - will return true");
    }

    @Test
    public void getAccountTest()
    {
        Account acc = new Account("a", "b", "email");
        model.addAccount(acc);
        
        Account actual = model.getAccountViaEmail(acc.getEmail());
        
        Assert.assertEquals(acc, actual);
        
    }
    
    @Test
    public void checkAccountExists()
    {
        model.checkAccountExists(testAcc);
    }
    
    @Test
    public void getRoomExists()
    {
        Room room = new Room("400", RoomType.DOUBLE, 105.00);
        
        model.addRoom(room);
        
        Room actual = model.getRoomViaRoomNumber(room.getRoomNumber());
        
        Assert.assertEquals(room, actual);
    }
    
    
}
