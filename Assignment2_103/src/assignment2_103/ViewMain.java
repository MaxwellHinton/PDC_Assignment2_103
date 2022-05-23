/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author maxhi
 */
public class ViewMain extends JFrame
{
    //All main panels
    private JPanel mainPanel = new JPanel();        //If button gets a panel, then the GUI will refresh instead of creating new GUI.
    private JPanel reserveRoomPanel = new JPanel(); 
    private JPanel createAccountPanel = new JPanel();
    
    //All Admin panels
    private JPanel adminPanel = new JPanel();
    private JPanel regRoomPanel = new JPanel();
    private JPanel displayAccountsPanel = new JPanel();
    private JPanel displayRoomsPanel = new JPanel();
    
    //Error prompt frames
    private final JFrame errorPrompt = new JFrame();
    
    //All components for main menu
    private JLabel mainTitle = new JLabel("Welcome to the Hotel Reservation System");
    private JButton createAccountBtn = new JButton("Create an Account");
    private JButton reserveRoomBtn = new JButton("Reserve a room");
    private JButton adminBtn = new JButton("Administrator Menu");
    private JButton exitBtn = new JButton("Exit");
    //Room Reservation components
    private JLabel reserveRoomTitle = new JLabel("Reserving a room");
    //private static final Map<String, Room> rooms = new HashMap<String, Room>();
    
    //Account Creation components   
    private JLabel createAccountTitle = new JLabel("Create your account");
    private JTextField firstname = new JTextField("Type here:");
    private JTextField surname = new JTextField();
    private JTextField email = new JTextField();
    private JLabel firstnamePrompt = new JLabel("Firstname:");
    private JLabel surnamePrompt = new JLabel("Surname:");
    private JLabel emailPrompt = new JLabel("Email:");
    private JButton confirmAccountBtn = new JButton("Create account");
    
    //All components for admin menu
    private JLabel adminTitle = new JLabel("Administrator Menu");
    private JButton regRoomBtn = new JButton("Register a Room");
    private JButton displayAccountsBtn = new JButton("Display all Accounts");
    private JButton displayRoomsBtn = new JButton("Display all rooms");
    //Room creation components
    private JLabel regRoomTitle = new JLabel("Register a room");
    private JTextField roomNumber = new JTextField("Type here:");
    private JTextField roomType = new JTextField();
    private JTextField roomPrice = new JTextField();
    private JLabel numberPrompt = new JLabel("Room Number (e.g. 7):");
    private JLabel typePrompt = new JLabel("Room Type (\"single\" or \"double\"):");
    private JLabel pricePrompt = new JLabel("Price (e.g. 50.00):");
    private JButton confirmRoomBtn = new JButton("Register room");
    //Display all accounts components
    private JLabel allAccountsTitle = new JLabel("Displaying all accounts");
    private JTable accountsTable = new JTable();
    
    private JButton exitToMainBtn = new JButton("Exit to main menu");
    private JButton exitToAdminBtn = new JButton("Exit to admin menu");
    
    private Component rigidArea = Box.createRigidArea(new Dimension(200, 25));
    private Component rigidArea2 = Box.createRigidArea(new Dimension(200, 25));
    
    public ViewMain()
    {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.LIGHT_GRAY);
        
        mainTitle.setFont(new Font("Serif", Font.PLAIN, 25));
        mainTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        mainTitle.setMaximumSize(new Dimension(460, 200));
        mainTitle.setForeground(Color.black);
        
        reserveRoomBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        reserveRoomBtn.setMaximumSize(new Dimension(200, 35));
        reserveRoomBtn.setBackground(Color.DARK_GRAY);
        reserveRoomBtn.setForeground(Color.WHITE);
        
        createAccountBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        createAccountBtn.setMaximumSize(new Dimension(200, 35));
        createAccountBtn.setBackground(Color.DARK_GRAY);
        createAccountBtn.setForeground(Color.WHITE);
               
        adminBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        adminBtn.setMaximumSize(new Dimension(200, 35));
        adminBtn.setBackground(Color.DARK_GRAY);
        adminBtn.setForeground(Color.WHITE);
 
        exitBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(new Dimension(200, 35));
        exitBtn.setBackground(Color.DARK_GRAY);
        exitBtn.setForeground(Color.WHITE);

        mainPanel.add(mainTitle);
        mainPanel.add(reserveRoomBtn);
        mainPanel.add(createAccountBtn);   
        mainPanel.add(adminBtn);
        mainPanel.add(exitBtn);

        this.add(mainPanel);
        this.setVisible(true);     
    } 
    
    public void ViewAdmin()
    {
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setBackground(Color.LIGHT_GRAY);
        
        adminTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        adminTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        adminTitle.setMaximumSize(new Dimension(250, 200));
        adminTitle.setForeground(Color.black);
        
        regRoomBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        regRoomBtn.setMaximumSize(new Dimension(200, 35));
        regRoomBtn.setBackground(Color.DARK_GRAY);
        regRoomBtn.setForeground(Color.WHITE);
     
        displayAccountsBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        displayAccountsBtn.setMaximumSize(new Dimension(200, 35));
        displayAccountsBtn.setBackground(Color.DARK_GRAY);
        displayAccountsBtn.setForeground(Color.WHITE);
        
        displayRoomsBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        displayRoomsBtn.setMaximumSize(new Dimension(200, 35));
        displayRoomsBtn.setBackground(Color.DARK_GRAY);
        displayRoomsBtn.setForeground(Color.WHITE);
        
        exitToMainBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exitToMainBtn.setMaximumSize(new Dimension(200, 35));
        exitToMainBtn.setBackground(Color.DARK_GRAY);
        exitToMainBtn.setForeground(Color.WHITE);
                
        adminPanel.add(adminTitle);
        adminPanel.add(regRoomBtn);
        adminPanel.add(displayAccountsBtn);
        adminPanel.add(displayRoomsBtn);
        adminPanel.add(exitToMainBtn);
        
        this.getContentPane().removeAll();
        
        this.add(adminPanel);
        adminPanel.setVisible(true);
        this.revalidate();
        this.repaint();
        
    }
    
    public void reserveRoomView()
    {
        reserveRoomPanel.setLayout(new BoxLayout(createAccountPanel, BoxLayout.Y_AXIS));
        reserveRoomPanel.setBackground(Color.LIGHT_GRAY);
        
        
        
    }
    
    public void createAccountView()
    {
        createAccountPanel.setLayout(new BoxLayout(createAccountPanel, BoxLayout.Y_AXIS));
        createAccountPanel.setBackground(Color.LIGHT_GRAY);
        
        createAccountTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        createAccountTitle.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        createAccountTitle.setMaximumSize(new Dimension(250, 150));
        createAccountTitle.setForeground(Color.black);
        
        firstnamePrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstnamePrompt.setMaximumSize(new Dimension(100, 35));
        firstnamePrompt.setForeground(Color.BLACK);
        
        surnamePrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        surnamePrompt.setMaximumSize(new Dimension(100, 35));
        surnamePrompt.setForeground(Color.BLACK);
        
        emailPrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        emailPrompt.setMaximumSize(new Dimension(100, 35));
        emailPrompt.setForeground(Color.BLACK);
        
        firstname.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstname.setMaximumSize(new Dimension(200, 35));
        firstname.setBackground(Color.DARK_GRAY);
        firstname.setForeground(Color.WHITE);
        
        surname.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        surname.setMaximumSize(new Dimension(200, 35));
        surname.setBackground(Color.DARK_GRAY);
        surname.setForeground(Color.WHITE);
        
        email.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        email.setMaximumSize(new Dimension(200, 35));
        email.setBackground(Color.DARK_GRAY);
        email.setForeground(Color.WHITE);
        
        confirmAccountBtn.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        confirmAccountBtn.setMaximumSize(new Dimension(200, 35));
        confirmAccountBtn.setBackground(Color.DARK_GRAY);
        confirmAccountBtn.setForeground(Color.WHITE);
        
        exitToMainBtn.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        exitToMainBtn.setMaximumSize(new Dimension(200, 35));
        exitToMainBtn.setBackground(Color.DARK_GRAY);
        exitToMainBtn.setForeground(Color.WHITE);
        
        createAccountPanel.add(createAccountTitle);
        createAccountPanel.add(firstnamePrompt);
        createAccountPanel.add(firstname);
        createAccountPanel.add(surnamePrompt);
        createAccountPanel.add(surname);
        createAccountPanel.add(emailPrompt);
        createAccountPanel.add(email);
        createAccountPanel.add(rigidArea);
        createAccountPanel.add(confirmAccountBtn);
        createAccountPanel.add(rigidArea2);
        createAccountPanel.add(exitToMainBtn);
        
        this.getContentPane().removeAll();
        this.add(createAccountPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void inputTextView()
    {
        firstnamePrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstnamePrompt.setMaximumSize(new Dimension(100, 35));
        firstnamePrompt.setForeground(Color.BLACK);
        
        firstname.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstname.setMaximumSize(new Dimension(200, 35));
        firstname.setBackground(Color.DARK_GRAY);
        firstname.setForeground(Color.WHITE);
        firstname.setText("");
        
        this.getContentPane().remove(firstnamePrompt);
        this.getContentPane().remove(firstname);
        
        this.add(firstnamePrompt);
        this.add(firstname);
        this.revalidate();
        this.repaint();
    }
    
    public void incorrectInput(JTextField field)
    {
        if(field.equals(firstname))
        {
            JOptionPane.showMessageDialog(errorPrompt, "Firstname cannot be left empty, or contain numbers/special characters !");
            firstname.setText("");
            
        }
        else if(field.equals(surname))
        {
            JOptionPane.showMessageDialog(errorPrompt, "Surname cannot be left empty, or contain numbers/special characters !");
            surname.setText("");
        }
        else if(field.equals(email))
        {
            JOptionPane.showMessageDialog(errorPrompt, "Email cannot be left empty");
            email.setText("");
        }
        else if(field.equals(roomNumber))
        {
            JOptionPane.showMessageDialog(errorPrompt, "Room number has to be an integer e.g. 4");
            roomNumber.setText("");
        }
        else if(field.equals(roomType))
        {
            JOptionPane.showMessageDialog(errorPrompt, "Room Type has to be either \"single\" or \"double\"");
            roomType.setText("");
        }
        else if(field.equals(roomPrice))
        {
            JOptionPane.showMessageDialog(errorPrompt, "The price has to be a double e.g. 75.00");
            roomPrice.setText("");
        }
    }
    
    public void accountCreationSuccess(String e)
    {
        JOptionPane.showMessageDialog(errorPrompt, "Account with email: " + e + " has been created successfully! \n"
                                                    + "Please either create another account or exit to the main menu.");
        firstname.setText("");
        surname.setText("");
        email.setText("");
    }

    public void registerRoomView() 
    {
        regRoomPanel.setLayout(new BoxLayout(regRoomPanel, BoxLayout.Y_AXIS));
        regRoomPanel.setBackground(Color.LIGHT_GRAY);
        
        regRoomTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        regRoomTitle.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        regRoomTitle.setMaximumSize(new Dimension(200, 150));
        regRoomTitle.setForeground(Color.black);
        
        numberPrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        numberPrompt.setMaximumSize(new Dimension(200, 35));
        numberPrompt.setForeground(Color.BLACK);
        
        typePrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        typePrompt.setMaximumSize(new Dimension(200, 35));
        typePrompt.setForeground(Color.BLACK);
        
        pricePrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        pricePrompt.setMaximumSize(new Dimension(200, 35));
        pricePrompt.setForeground(Color.BLACK);
        
        roomNumber.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomNumber.setMaximumSize(new Dimension(200, 35));
        roomNumber.setBackground(Color.DARK_GRAY);
        roomNumber.setForeground(Color.WHITE);
        
        roomType.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomType.setMaximumSize(new Dimension(200, 35));
        roomType.setBackground(Color.DARK_GRAY);
        roomType.setForeground(Color.WHITE);
        
        roomPrice.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomPrice.setMaximumSize(new Dimension(200, 35));
        roomPrice.setBackground(Color.DARK_GRAY);
        roomPrice.setForeground(Color.WHITE);
        
        confirmRoomBtn.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        confirmRoomBtn.setMaximumSize(new Dimension(200, 35));
        confirmRoomBtn.setBackground(Color.DARK_GRAY);
        confirmRoomBtn.setForeground(Color.WHITE);
        
        exitToAdminBtn.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        exitToAdminBtn.setMaximumSize(new Dimension(200, 35));
        exitToAdminBtn.setBackground(Color.DARK_GRAY);
        exitToAdminBtn.setForeground(Color.WHITE);
        
        regRoomPanel.add(regRoomTitle);
        regRoomPanel.add(numberPrompt);
        regRoomPanel.add(roomNumber);
        regRoomPanel.add(typePrompt);
        regRoomPanel.add(roomType);
        regRoomPanel.add(pricePrompt);
        regRoomPanel.add(roomPrice);
        regRoomPanel.add(rigidArea);
        regRoomPanel.add(confirmRoomBtn);
        regRoomPanel.add(rigidArea2);
        regRoomPanel.add(exitToAdminBtn);
        
        this.getContentPane().removeAll();
        this.add(regRoomPanel);
        this.revalidate();
        this.repaint();
    }

    public void displayAccountsView() 
    {
        displayAccountsPanel.setLayout(new BoxLayout(displayAccountsPanel, BoxLayout.Y_AXIS));
        displayAccountsPanel.setBackground(Color.LIGHT_GRAY);
        
        allAccountsTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        allAccountsTitle.setAlignmentX(displayAccountsPanel.CENTER_ALIGNMENT);
        allAccountsTitle.setMaximumSize(new Dimension(200, 150));
        allAccountsTitle.setForeground(Color.black);
        
        displayAccountsPanel.add(allAccountsTitle);
        //displayAccountsPanel.add(exitToAdminBtn);
        
        this.getContentPane().removeAll();
        this.add(displayAccountsPanel);
        this.revalidate();
        this.repaint();
    }

    void displayRoomsView() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addActionListener(ActionListener L)
    {
        this.exitToMainBtn.addActionListener(L);
        this.confirmRoomBtn.addActionListener(L);
        this.confirmAccountBtn.addActionListener(L);
        this.createAccountBtn.addActionListener(L);
        this.regRoomBtn.addActionListener(L);
        this.adminBtn.addActionListener(L);
        this.exitToAdminBtn.addActionListener(L);
        this.exitBtn.addActionListener(L);
    }
    
    public void backToAdmin() 
    {
       this.getContentPane().removeAll();
       this.getContentPane().add(adminPanel);
       this.validate();
       this.repaint();
    }
    
    public void backToMain()
    {
        this.getContentPane().removeAll();
        this.getContentPane().add(mainPanel);
        this.validate();
        this.repaint();
    }
    //Getters For text boxes
    
    public JTextField getRoomNumber() {
        return roomNumber;
    }

    public JTextField getRoomType() {
        return roomType;
    }

    public JTextField getRoomPrice() {
        return roomPrice;
    }
    
    public JTextField getFirstname() {
        return firstname;
    }

    public JTextField getSurname() {
        return surname;
    }

    public JTextField getEmail() {
        return email;
    }
    
}
