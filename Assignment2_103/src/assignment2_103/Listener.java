/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author maxhi
 */
public class Listener implements ActionListener
{
    private final ViewMain view;
    
    public Listener(ViewMain view)
    {
        this.view = view;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Main menu Buttons
        
        if("Reserve a room".equals(e.getActionCommand()))
        {
            view.reserveRoomView();
        }
        
        if("Create an Account".equals(e.getActionCommand()))
        {
            view.createAccountView();
        }
        
        if("Administrator Menu".equals(e.getActionCommand()))
        {
            view.ViewAdmin();
        }
        
        if("Exit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
        
        //Admin menu buttons
        
        if("Register a Room".equals(e.getActionCommand()))
        {
            view.registerRoomView();
        }
        
        if("Display all accounts".equals(e.getActionCommand()))
        {
            view.displayAccountsView();
        }
        
        if("Display all rooms".equals(e.getActionCommand()))
        {
            view.displayRoomsView();
        }
        
        if("Exit to main menu".equals(e.getActionCommand()))
        {
            view.backToMain();
        }
        
        //Create an accuont buttons
        
        if("Create account".equals(e.getActionCommand()))
        {
            System.out.println("creating account stuff");
            //implement.
        }
        
        //Reserving room buttons
        
        
        
        
        
        //Registering a room buttons
        
        
        
        
        
    }
    
}
