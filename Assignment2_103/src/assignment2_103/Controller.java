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
public class Controller implements ActionListener
{
    private final ViewMain view;
    private final Model model;
    
    private AdminView adminView;
    private AdminModel adminModel;
    
    public Controller(ViewMain view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Main menu Buttons
        
        if("Reserve a room".equals(e.getActionCommand()))
        {
            view.loginView();
            
            //view.reserveRoomView();
        }
        
        if("Create an account".equals(e.getActionCommand()))
        {
            view.createAccountView();
        }
        
        if("Administrator Menu".equals(e.getActionCommand()))
        {
            
            this.adminView = new AdminView();
            this.adminModel = new AdminModel();
            
            AdminController adminControl = new AdminController(this.adminView, this.adminModel);
            
            //view.ViewAdmin();
        }
        
        if("Exit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
        
        //Login buttons
        
        if("Login".equals(e.getActionCommand()))
        {
            String email = view.getEmailLogin().getText();
            Account acc;
            
            if(model.db.checkAccountEmail(email))
            {
                acc = model.db.getAccountDBEmail(email);
                
                view.reserveRoomView(acc.getFirstname());
            }
            else
            {
                view.loginFailed();
            }
        }
        
        //Admin menu buttons
        
        if("Register a Room".equals(e.getActionCommand()))
        {
            view.registerRoomView();
        }
        
        if("Display all accounts".equals(e.getActionCommand()))
        {
            view.displayAccountsView(this.model.getAccountsJtable());
        }
        
        if("Display all rooms".equals(e.getActionCommand()))
        {
            view.displayRoomsView(this.model.getRoomsJtable());
        }
        
        if("Exit to main menu".equals(e.getActionCommand()))
        {
            view.backToMain();
        }
        
        //Create an Account buttons
        
        if("Create account".equals(e.getActionCommand()))
        {   
            boolean firstnameCheck;
            boolean surnameCheck;
            boolean emailCheck;
            
            String firstname = view.getFirstname().getText();
            String surname = view.getSurname().getText();
            String email = view.getEmail().getText();

            
            if(model.checkAccountInput(firstname))
            {
                firstnameCheck = true;
            }
            else
            {
                view.incorrectInput(view.getFirstname());
                firstnameCheck = false;
            }
            
            if(model.checkAccountInput(surname))
            {
                surnameCheck = true;
            }
            else
            {
                view.incorrectInput(view.getSurname());
                surnameCheck = false;
            }
            
            if(model.checkEmail(email))
            {
                emailCheck = true;
            }
            else
            {
                view.incorrectInput(view.getEmail());
                emailCheck = false;
            }
            
            //The account creation in model will only be called if the firstname and surname text fields contain the proper format, else a pop up will appear.
            
            if(firstnameCheck && surnameCheck && emailCheck)
            {
                if(!(model.db.checkAccountEmail(email)))
                {
                    model.createAccount(firstname, surname, email);
                    view.accountCreationSuccess(email);
                }
                else
                {
                    view.accountExists(email);
                }
            }
        }
        
        //Registering room buttons
        
        if("Register room".equals(e.getActionCommand()))
        {
            boolean roomNumberCheck;
            boolean roomTypeCheck;
            boolean roomPriceCheck;
            
            String roomNumber = view.getRoomNumber().getText();
            String roomType = view.getRoomType().getText();
            String roomPrice = view.getRoomPrice().getText();
            
            if(model.checkRoomNumber(roomNumber))
            {
                roomNumberCheck = true;
            }
            else
            {
                view.incorrectInput(view.getRoomNumber());
                roomNumberCheck = false;
            }
            
            if(model.checkRoomType(roomType))
            {
                roomTypeCheck = true;
            }
            else
            {
                view.incorrectInput(view.getRoomType());
                roomTypeCheck = false;
            }
            
            if(model.checkPrice(roomPrice))
            {
                roomPriceCheck = true;
            }
            else
            {
                view.incorrectInput(view.getRoomPrice());
                roomPriceCheck = false;
            }
            
                        
            //The Room creation in model will only be called if the room number, type and price text fields contain the proper format, else a pop up will appear.
            
            if(roomNumberCheck && roomTypeCheck && roomPriceCheck)
            {
                if(!(model.checkRoomExists(roomNumber)))
                {
                    model.createRoom(roomNumber, roomType, roomPrice);
                    view.roomCreationSuccess(roomNumber);
                }
                else
                {
                    view.roomExists(roomNumber);
                }
            }
        }
        
        if("Exit to admin menu".equals(e.getActionCommand()))
        {
            view.backToAdmin();
        }
        
        
        
        //Registering a room buttons
        
        
        
        
        
    }
    
}
