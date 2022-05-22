/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
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
    
    //All admin panels
    
    private JPanel adminPanel = new JPanel();
    private JPanel regRoomPanel = new JPanel();
    
    //All components for main menu
    
    private JLabel mainTitle = new JLabel("Welcome to the Hotel Reservation System");
    private JButton createAccountBtn = new JButton("Create an Account");
    private JButton reserveRoomBtn = new JButton("Reserve a room");
    private JButton adminBtn = new JButton("Administrator Menu");
    private JButton exitBtn = new JButton("Exit");
    
    //All components for reserving room menu
    
    private JLabel reserveRoomTitle = new JLabel("Reserving a room");
    private static final Map<String, Room> rooms = new HashMap<String, Room>();
    
    
    //All components for creating account menu
    
    private JLabel createAccountTitle = new JLabel("Create your account");
    private JTextField firstname = new JTextField("Type here: ");
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

    //Other components
    
    private JButton exitToMainBtn = new JButton("Exit to main menu");
    private Listener L = new Listener(this);
    
    
    public ViewMain()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        //Maybe set resizeable //come back to this
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
        
        createAccountBtn.addActionListener(L);
               
        adminBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        adminBtn.setMaximumSize(new Dimension(200, 35));
        adminBtn.setBackground(Color.DARK_GRAY);
        adminBtn.setForeground(Color.WHITE);
        
        adminBtn.addActionListener(L);
        
        exitBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exitBtn.setMaximumSize(new Dimension(200, 35));
        exitBtn.setBackground(Color.DARK_GRAY);
        exitBtn.setForeground(Color.WHITE);
        
        exitBtn.addActionListener(L);
        
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
        exitToMainBtn.addActionListener(L);
        
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
        createAccountTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
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
        
        exitToMainBtn.addActionListener(L);
        confirmAccountBtn.addActionListener(L);
        
        
        createAccountPanel.add(createAccountTitle);
        createAccountPanel.add(firstnamePrompt);
        createAccountPanel.add(firstname);
        createAccountPanel.add(surnamePrompt);
        createAccountPanel.add(surname);
        createAccountPanel.add(emailPrompt);
        createAccountPanel.add(email);
        createAccountPanel.add(Box.createRigidArea(new Dimension(200, 25)));
        createAccountPanel.add(confirmAccountBtn);
        createAccountPanel.add(Box.createRigidArea(new Dimension(200, 25)));
        createAccountPanel.add(exitToMainBtn);
        
        this.getContentPane().removeAll();
        this.add(createAccountPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void backToMain()
    {
        this.getContentPane().removeAll();
        this.getContentPane().add(mainPanel);
        this.validate();
        this.repaint();
    }

    void registerRoomView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void displayAccountsView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void displayRoomsView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
