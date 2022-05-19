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
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    
    private JButton createAccountBtn = new JButton("Create an Account");
    private JLabel mainTitle = new JLabel("Welcome to the Hotel Reservation System");
    private JButton reserveRoomBtn = new JButton("Reserve a room");
    private JButton adminBtn = new JButton("Administrator Menu");
    private JButton exitBtn = new JButton("Exit");
    
    //All components for admin menu
    
    private JLabel adminTitle = new JLabel("Administrator Menu");
    private JButton regRoomBtn = new JButton("Register a Room");
    private JButton displayAccountsBtn = new JButton("Display all Accounts");
    private JButton displayRoomsBtn = new JButton("Display all rooms");
    private JButton exitMainBtn = new JButton("Exit to main menu");
    
    public ViewMain()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        //Maybe set resizeable //come back to this
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.LIGHT_GRAY);
        
        mainTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        mainTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        mainTitle.setMaximumSize(new Dimension(340, 200));
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
        adminPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        adminPanel.setBackground(Color.LIGHT_GRAY);
        
        adminTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        adminTitle.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        adminTitle.setMaximumSize(new Dimension(340, 200));
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
        
        exitMainBtn.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exitMainBtn.setMaximumSize(new Dimension(200, 35));
        exitMainBtn.setBackground(Color.DARK_GRAY);
        exitMainBtn.setForeground(Color.WHITE);
        
        adminPanel.add(adminTitle);
        adminPanel.add(regRoomBtn);
        adminPanel.add(displayAccountsBtn);
        adminPanel.add(displayRoomsBtn);
        adminPanel.add(exitMainBtn);
        
        this.getContentPane().removeAll();
        adminPanel.setVisible(true);
        this.add(adminPanel);
        this.revalidate();
        this.repaint();
        
    }
    
    public void addActionListener(ActionListener listener)
    {
        //main menu listeners
   
        this.reserveRoomBtn.addActionListener(listener);
        this.createAccountBtn.addActionListener(listener);
        this.adminBtn.addActionListener(listener);
        this.exitBtn.addActionListener(listener);
        
        //admin menu listeners
        
        this.regRoomBtn.addActionListener(listener);
        this.displayAccountsBtn.addActionListener(listener);
        this.displayRoomsBtn.addActionListener(listener);
        this.exitMainBtn.addActionListener(listener);
    }
    
    
}
