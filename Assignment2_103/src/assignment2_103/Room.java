/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

/**
 *
 * @author maxhi
 */
public class Room implements RoomInfo
{
    private double price;
    private String roomNumber;
    private RoomType roomtype;
    private boolean status = false;
    private String customer; // The customer that has booked the room
    
    public Room(final String roomNumber,final RoomType roomtype, final double price)
    {
        this.roomNumber = roomNumber;
        this.roomtype = roomtype;
        this.price = price;       
        this.status = false;
        this.customer = "No Customer";
    }
    
    public void setRoomNumber(String roomnumber)
    {
        this.roomNumber = roomnumber;
    }
    
    public void setRoomType(RoomType type)
    {
        this.roomtype = type;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setStatus(boolean t)
    {
        this.status = t;
    }
    
    public void setCustomer(Account customer)
    {
        this.customer = customer.getEmail();
    }
    
    public void setCustomerByEmail(String email)
    {
        this.customer = email;
    }

    @Override
    public String getRoomNumber() 
    {
        return this.roomNumber;
    }

    @Override
    public double getPrice() 
    {
        return this.price;
    }
    
    @Override
    public RoomType getRoomType() 
    {
        return this.roomtype;
    }
    
    @Override
    public boolean getStatus() 
    {
        return this.status;
    }
    
    @Override
    public String getCustomer()
    {
        return this.customer;
    }
    
    @Override
    public String toString()
    {
        return "Room number: " +this.roomNumber+ "\nPrice: $" +this.price+ "\nType of room: " +this.roomtype; 
    }
}
