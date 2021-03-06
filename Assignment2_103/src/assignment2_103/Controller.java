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
    private MainView view;
    private AdminView adminView;
    private Model model;
    private Account currentUser;
    
    public Controller(MainView view, Model model, AdminView admin)
    {
        this.view = view;
        this.adminView = admin; 
        this.model = model;
        this.adminView.setVisible(false);
        this.view.addActionListener(this);
        this.adminView.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //Main menu Buttons
        
        if("Reserve a room".equals(e.getActionCommand()))
        {
            view.loginView();
        }
        
        if("Create an account".equals(e.getActionCommand()))
        {
            view.createAccountView();
        }
        
        if("Administrator Menu".equals(e.getActionCommand()))
        {
            this.adminView.setVisible(true);
        }
        
        if("Exit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
        
        if("Restart system".equals(e.getActionCommand()))
        {            
            System.out.println("-------------------");
            System.out.println("System is restarted");
            System.out.println("-------------------");
            
            this.view.dispose();
            this.adminView.dispose();
            
            this.view = new MainView();
            this.adminView = new AdminView();
            this.model = new Model();
            this.model.restarted = true;
            
            this.model.ModelSetup();
            this.view.MainViewSetup();
            this.adminView.AdminViewSetup();
            
            Controller controller = new Controller(this.view, this.model, this.adminView);

        }
                
        //Login buttons
        
        if("Login".equals(e.getActionCommand()))
        {
            String email = view.getEmailLogin().getText();
            Account acc;
            
            if(model.db.checkAccountEmail(email))
            {
                acc = model.db.getAccountDBEmail(email);
                this.currentUser = acc;
                view.reserveRoomView(acc.getFirstname(), this.model.getUserRoomsJtable());
            }
            else
            {
                view.loginFailed();
            }
        }
        
        //Reserve room buttons
        
        if("Reserve the room".equals(e.getActionCommand()))
        {   
            
            String roomNumber = view.getRoomToReserve().getText();
            String result = model.checkRoomReservation(roomNumber, currentUser);
            
            switch(result)
            {
                case "success":
                    view.roomReservationSuccess(roomNumber, currentUser.getEmail());
                    break;
                case "invalid input":
                    view.incorrectInput(view.getRoomToReserve());
                    break;
                case "reserved":
                    view.roomIsReserved();
                    break;
            }
        }
        
        //Admin menu buttons
        
        if("Register a Room".equals(e.getActionCommand()))
        {
            adminView.registerRoomView();
        }
        
        if("Display all accounts".equals(e.getActionCommand()))
        {
            adminView.displayAccountsView(this.model.getAccountsJtable());
        }
        
        if("Display all rooms".equals(e.getActionCommand()))
        {
            adminView.displayRoomsView(this.model.getRoomsJtable());
        }
        
        if("Exit admin menu".equals(e.getActionCommand())) //Closes admin frame
        {
            adminView.dispose();
        }
        
        if("Exit to admin menu".equals(e.getActionCommand())) //Used to exit back to the admin menu
        {
            adminView.reset = true;
            adminView.AdminViewSetup();
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
                if(!(model.checkAccountExistsEmail(email)))
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
            
            String roomNumber = adminView.getRoomNumber().getText();
            String roomType = adminView.getRoomType().getText();
            String roomPrice = adminView.getRoomPrice().getText();
            
            if(model.checkRoomNumber(roomNumber))
            {
                roomNumberCheck = true;
            }
            else
            {
                adminView.incorrectInput(adminView.getRoomNumber());
                roomNumberCheck = false;
            }
            
            if(model.checkRoomType(roomType))
            {
                roomTypeCheck = true;
            }
            else
            {
                adminView.incorrectInput(adminView.getRoomType());
                roomTypeCheck = false;
            }
            
            if(model.checkPrice(roomPrice))
            {
                roomPriceCheck = true;
            }
            else
            {
                adminView.incorrectInput(adminView.getRoomPrice());
                roomPriceCheck = false;
            }
                           
            //The Room creation in model will only be called if the room number, type and price text fields contain the proper format, else a pop up will appear.
            
            if(roomNumberCheck && roomTypeCheck && roomPriceCheck)
            {
                if(!(model.checkRoomExists(roomNumber)))
                {
                    model.createRoom(roomNumber, roomType, roomPrice);
                    adminView.roomCreationSuccess(roomNumber);
                }
                else
                {
                    adminView.roomExists(roomNumber);
                }
            }
        }
        
        if("Exit to main menu".equals(e.getActionCommand()))
        {
            view.MainViewSetup();
        }
    }
}
