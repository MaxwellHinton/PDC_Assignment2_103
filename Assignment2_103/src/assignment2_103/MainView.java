/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 *
 * @author maxhi
 */
public class MainView extends JFrame
{
    //All main panels
    private JPanel mainPanel = new JPanel();
    private JPanel reserveRoomPanel = new JPanel(); 
    private JPanel loginPanel = new JPanel();
    private JPanel createAccountPanel = new JPanel(); 
    private JPanel groupPanel = new JPanel();
    
    //Message prompt frames
    private final JFrame messagePrompt = new JFrame();
    
    //All components for main menu
    private JLabel mainTitle = new JLabel("Welcome to the Hotel Reservation System");
    private JButton createAccountBtn = new JButton("Create an account");
    private JButton reserveRoomBtn = new JButton("Reserve a room");
    private JButton adminBtn = new JButton("Administrator Menu");
    private JButton exitBtn = new JButton("Exit");
    
    //Restart button
    private JButton restartSystem = new JButton("Restart system");
    
    //All components for login panel
    private JLabel loginTitle = new JLabel("Login...");
    private JLabel loginInstructions = new JLabel("Please enter your account email that you wish to use");
    private JButton login = new JButton("Login");
    private JButton createAccountAtLogin = new JButton("Create an account");
    private JTextField emailLogin = new JTextField("Here:");
    
    //Room Reservation components
    private JLabel reserveRoomTitle = new JLabel();
    private JLabel reserveInstructions = new JLabel("Please enter the room you would like to reserve below and press \"Reserve\"");
    private JButton reserveBtn = new JButton("Reserve the room");
    private JTextField roomToReserve = new JTextField("Enter here");
    
    //Account Creation components   
    private JLabel createAccountTitle = new JLabel("Create your account");
    private JTextField firstname = new JTextField("Type here:");
    private JTextField surname = new JTextField();
    private JTextField email = new JTextField();
    private JLabel firstnamePrompt = new JLabel("Firstname:");
    private JLabel surnamePrompt = new JLabel("Surname:");
    private JLabel emailPrompt = new JLabel("Email:");
    private JButton confirmAccountBtn = new JButton("Create account");

    //Exit button
    private JButton exitToMainBtn = new JButton("Exit to main menu");
    
    //Invisible boxes
    private Component rigidArea = Box.createRigidArea(new Dimension(200, 25));
    private Component rigidArea2 = Box.createRigidArea(new Dimension(200, 25));
    
    public void MainViewSetup()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.LIGHT_GRAY);
        
        mainTitle.setFont(new Font("Calibri", Font.PLAIN, 25));
        mainTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        mainTitle.setMaximumSize(new Dimension(460, 200));
        mainTitle.setForeground(Color.black);
        
        reserveBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        reserveRoomBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        reserveRoomBtn.setMaximumSize(new Dimension(200, 35));
        reserveRoomBtn.setBackground(Color.DARK_GRAY);
        reserveRoomBtn.setForeground(Color.WHITE);
        
        createAccountBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        createAccountBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        createAccountBtn.setMaximumSize(new Dimension(200, 35));
        createAccountBtn.setBackground(Color.DARK_GRAY);
        createAccountBtn.setForeground(Color.WHITE);
               
        adminBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        adminBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        adminBtn.setMaximumSize(new Dimension(200, 35));
        adminBtn.setBackground(Color.DARK_GRAY);
        adminBtn.setForeground(Color.WHITE);
 
        exitBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(new Dimension(200, 35));
        exitBtn.setBackground(Color.DARK_GRAY);
        exitBtn.setForeground(Color.WHITE);
        
        restartSystem.setFont(new Font("Calibri", Font.PLAIN, 15));
        restartSystem.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        restartSystem.setMaximumSize(new Dimension(200, 35));
        restartSystem.setBackground(Color.DARK_GRAY);
        restartSystem.setForeground(Color.WHITE);

        mainPanel.add(mainTitle);
        mainPanel.add(reserveRoomBtn);
        mainPanel.add(createAccountBtn);   
        mainPanel.add(adminBtn);
        mainPanel.add(exitBtn);
        mainPanel.add(rigidArea);
        mainPanel.add(restartSystem);
        
        this.getContentPane().removeAll();
        this.add(mainPanel);
        this.revalidate();
        this.repaint();
        this.setVisible(true);     
    } 
    /*
     * The login panel only asks for an email.
     * Passwords are not implemented
     *
    */
    public void loginView()
    {
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(Color.LIGHT_GRAY);
        
        loginTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        loginTitle.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        loginTitle.setMaximumSize(new Dimension(100, 150));
        loginTitle.setForeground(Color.black);
        
        loginInstructions.setFont(new Font("Calibri", Font.PLAIN, 15));
        loginInstructions.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        loginInstructions.setMaximumSize(new Dimension(340, 35));
        loginInstructions.setForeground(Color.BLACK);        
                
        emailLogin.setFont(new Font("Calibri", Font.PLAIN, 15));
        emailLogin.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        emailLogin.setMaximumSize(new Dimension(200, 35));
        emailLogin.setBackground(Color.WHITE);
        emailLogin.setForeground(Color.DARK_GRAY);
        
        login.setFont(new Font("Calibri", Font.PLAIN, 15));
        login.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        login.setMaximumSize(new Dimension(200, 35));
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        
        createAccountAtLogin.setFont(new Font("Calibri", Font.PLAIN, 15));
        createAccountAtLogin.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        createAccountAtLogin.setMaximumSize(new Dimension(200, 35));
        createAccountAtLogin.setBackground(Color.DARK_GRAY);
        createAccountAtLogin.setForeground(Color.WHITE);
        
        exitToMainBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToMainBtn.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        exitToMainBtn.setMaximumSize(new Dimension(200, 35));
        exitToMainBtn.setBackground(Color.DARK_GRAY);
        exitToMainBtn.setForeground(Color.WHITE);
        
        restartSystem.setFont(new Font("Calibri", Font.PLAIN, 15));
        restartSystem.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        restartSystem.setMaximumSize(new Dimension(200, 35));
        restartSystem.setBackground(Color.DARK_GRAY);
        restartSystem.setForeground(Color.WHITE);
        
        loginPanel.add(loginTitle);
        loginPanel.add(loginInstructions);
        loginPanel.add(emailLogin);
        loginPanel.add(rigidArea);
        loginPanel.add(login);
        loginPanel.add(createAccountAtLogin);
        loginPanel.add(exitToMainBtn);
        loginPanel.add(rigidArea2);
        loginPanel.add(restartSystem);

        this.getContentPane().removeAll();
        this.add(loginPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void reserveRoomView(String e, JScrollPane table)
    {
        reserveRoomPanel.setLayout(new BoxLayout(reserveRoomPanel, BoxLayout.Y_AXIS));
        reserveRoomPanel.setBackground(Color.LIGHT_GRAY);

        reserveRoomTitle.setText("Welcome "+ e);
        reserveRoomTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        reserveRoomTitle.setAlignmentX(reserveRoomPanel.CENTER_ALIGNMENT);
        reserveRoomTitle.setMaximumSize(new Dimension(200, 150));
        reserveRoomTitle.setForeground(Color.black);
        
        reserveInstructions.setFont(new Font("Calibri", Font.PLAIN, 15));
        reserveInstructions.setAlignmentX(reserveRoomPanel.CENTER_ALIGNMENT);
        reserveInstructions.setMaximumSize(new Dimension(475, 35));
        reserveInstructions.setForeground(Color.black);
        
        roomToReserve.setFont(new Font("Calibri", Font.PLAIN, 15));
        roomToReserve.setAlignmentX(reserveRoomPanel.CENTER_ALIGNMENT);
        roomToReserve.setMaximumSize(new Dimension(200, 35));
        roomToReserve.setBackground(Color.WHITE);
        roomToReserve.setForeground(Color.DARK_GRAY);
        
        reserveBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        reserveBtn.setAlignmentX(reserveRoomPanel.CENTER_ALIGNMENT);
        reserveBtn.setMaximumSize(new Dimension(200, 75));
        reserveBtn.setBackground(Color.DARK_GRAY);
        reserveBtn.setForeground(Color.WHITE);
        
        exitToMainBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToMainBtn.setAlignmentX(reserveRoomPanel.CENTER_ALIGNMENT);
        exitToMainBtn.setMaximumSize(new Dimension(200, 35));
        exitToMainBtn.setBackground(Color.DARK_GRAY);
        exitToMainBtn.setForeground(Color.WHITE);
        
        restartSystem.setFont(new Font("Calibri", Font.PLAIN, 15));
        restartSystem.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        restartSystem.setMaximumSize(new Dimension(200, 35));
        restartSystem.setBackground(Color.DARK_GRAY);
        restartSystem.setForeground(Color.WHITE);
        
        table.setMinimumSize(new Dimension(300, 150));
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        
        reserveRoomPanel.add(reserveRoomTitle);
        reserveRoomPanel.add(rigidArea);
        reserveRoomPanel.add(reserveInstructions);
        reserveRoomPanel.add(roomToReserve);
        reserveRoomPanel.add(table);       
        reserveRoomPanel.add(reserveBtn);
        reserveRoomPanel.add(exitToMainBtn);
        reserveRoomPanel.add(rigidArea2);
        reserveRoomPanel.add(restartSystem);
        
        this.getContentPane().removeAll();
        this.add(reserveRoomPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void createAccountView()
    {
        createAccountPanel.setLayout(new BoxLayout(createAccountPanel, BoxLayout.Y_AXIS));
        createAccountPanel.setBackground(Color.LIGHT_GRAY);
        
        createAccountTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        createAccountTitle.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        createAccountTitle.setMaximumSize(new Dimension(250, 150));
        createAccountTitle.setForeground(Color.black);
        
        firstnamePrompt.setFont(new Font("Calibri", Font.PLAIN, 15));
        firstnamePrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstnamePrompt.setMaximumSize(new Dimension(100, 35));
        firstnamePrompt.setForeground(Color.BLACK);
        
        surnamePrompt.setFont(new Font("Calibri", Font.PLAIN, 15));
        surnamePrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        surnamePrompt.setMaximumSize(new Dimension(100, 35));
        surnamePrompt.setForeground(Color.BLACK);
        
        emailPrompt.setFont(new Font("Calibri", Font.PLAIN, 15));
        emailPrompt.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        emailPrompt.setMaximumSize(new Dimension(100, 35));
        emailPrompt.setForeground(Color.BLACK);
        
        firstname.setFont(new Font("Calibri", Font.PLAIN, 15));
        firstname.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        firstname.setMaximumSize(new Dimension(200, 35));
        firstname.setBackground(Color.WHITE);
        firstname.setForeground(Color.DARK_GRAY);
        
        surname.setFont(new Font("Calibri", Font.PLAIN, 15));
        surname.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        surname.setMaximumSize(new Dimension(200, 35));
        surname.setBackground(Color.WHITE);
        surname.setForeground(Color.DARK_GRAY);
        
        email.setFont(new Font("Calibri", Font.PLAIN, 15));
        email.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        email.setMaximumSize(new Dimension(200, 35));
        email.setBackground(Color.WHITE);
        email.setForeground(Color.DARK_GRAY);
        
        confirmAccountBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        confirmAccountBtn.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        confirmAccountBtn.setMaximumSize(new Dimension(200, 35));
        confirmAccountBtn.setBackground(Color.DARK_GRAY);
        confirmAccountBtn.setForeground(Color.WHITE);
        
        exitToMainBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToMainBtn.setAlignmentX(createAccountPanel.CENTER_ALIGNMENT);
        exitToMainBtn.setMaximumSize(new Dimension(200, 35));
        exitToMainBtn.setBackground(Color.DARK_GRAY);
        exitToMainBtn.setForeground(Color.WHITE);
        
        restartSystem.setFont(new Font("Calibri", Font.PLAIN, 15));
        restartSystem.setAlignmentX(loginPanel.CENTER_ALIGNMENT);
        restartSystem.setMaximumSize(new Dimension(200, 35));
        restartSystem.setBackground(Color.DARK_GRAY);
        restartSystem.setForeground(Color.WHITE);
        
        createAccountPanel.add(createAccountTitle);
        createAccountPanel.add(firstnamePrompt);
        createAccountPanel.add(firstname);
        createAccountPanel.add(surnamePrompt);
        createAccountPanel.add(surname);
        createAccountPanel.add(emailPrompt);
        createAccountPanel.add(email);
        createAccountPanel.add(rigidArea);
        createAccountPanel.add(confirmAccountBtn);
        createAccountPanel.add(exitToMainBtn);
        createAccountPanel.add(rigidArea2);
        createAccountPanel.add(restartSystem);
        
        this.getContentPane().removeAll();
        this.add(createAccountPanel);
        this.revalidate();
        this.repaint();
    }

    public void addActionListener(ActionListener L)
    {
        //Main buttons
        this.reserveRoomBtn.addActionListener(L);
        this.confirmAccountBtn.addActionListener(L);
        this.createAccountBtn.addActionListener(L);
        this.exitBtn.addActionListener(L);
        this.exitToMainBtn.addActionListener(L);
        this.adminBtn.addActionListener(L);
        this.restartSystem.addActionListener(L);
        
        //Login buttons
        this.login.addActionListener(L);
        this.createAccountAtLogin.addActionListener(L);
        
        //Reserve buttons
        this.reserveBtn.addActionListener(L);
    }
    /*
     *  Error message views
     *
    */
    public void incorrectInput(JTextField field)
    {
        if(field.equals(firstname))
        {
            JOptionPane.showMessageDialog(messagePrompt, "Firstname cannot be left empty, or contain numbers/special characters !");
            firstname.setText("");     
        }
        else if(field.equals(surname))
        {
            JOptionPane.showMessageDialog(messagePrompt, "Surname cannot be left empty, or contain numbers/special characters !");
            surname.setText("");
        }
        else if(field.equals(email))
        {
            JOptionPane.showMessageDialog(messagePrompt, "Email cannot be left empty");
            email.setText("");
        }
        else if(field.equals(roomToReserve))
        {
            JOptionPane.showMessageDialog(messagePrompt, "You must enter a valid room number!");
            roomToReserve.setText("");
        }
    }
    
    public void roomIsReserved()
    {
        JOptionPane.showMessageDialog(messagePrompt, "That room has already been reserved!");
        roomToReserve.setText("");
    }
    
    public void loginFailed()
    {
        JOptionPane.showMessageDialog(messagePrompt, "Unfortunately, that email was not found in the system.\n"
                                                    + "Please make an account or re-enter an email");
        emailLogin.setText("");
    }
    
    public void accountExists(String e)
    {
        JOptionPane.showMessageDialog(messagePrompt, "An account under the email:  " + e + " already exists!");
        firstname.setText("");
        surname.setText("");
        email.setText("");
    }
    
    public void roomReservationSuccess(String room, String acc)
    {
        JOptionPane.showMessageDialog(messagePrompt, "Room " + room + " has been reserved successfully by " + acc);
        roomToReserve.setText("");
    }
    
    public void accountCreationSuccess(String e)
    {
        JOptionPane.showMessageDialog(messagePrompt, "Account with email: " + e + " has been created successfully! \n"
                                                    + "Please either create another account or exit to the main menu.");
        firstname.setText("");
        surname.setText("");
        email.setText("");
    }
    /*
     *  Getter methods
     *
    */ 
    public JTextField getRoomToReserve() { return roomToReserve; }
    
    public JTextField getFirstname() { return firstname; }

    public JTextField getSurname() { return surname; }

    public JTextField getEmail() { return email; }

    public JTextField getEmailLogin(){ return emailLogin; }
}
