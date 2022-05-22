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
public class Account implements AccountInfo
{
    private String firstName;
    private String surname;
    private String email;
    
    public Account(final String firstname, final String lastname, final String email)
    {
        this.firstName = firstname;
        this.surname = lastname;
        this.email = email;
    }
    
    public void setFirstname(String firstname)
    {
        this.firstName = firstname;
    }
    
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    @Override
    public String getEmail()
    {
        return this.email;
    }
    
    @Override
    public String getFirstname() 
    {
        return this.firstName;
    }

    @Override
    public String getSurname() 
    {
        return this.surname;
    } 
    
    @Override 
    public String toString()
    {
        return "\nFirst Name: " +this.firstName+ "\nLast Name: " +this.surname+ "\nEmail: " +this.email;
    }
    
}
