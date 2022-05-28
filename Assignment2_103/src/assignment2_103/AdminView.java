/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

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
public class AdminView extends JFrame
{
    //All panels
    private JPanel adminPanel = new JPanel();
    private JPanel regRoomPanel = new JPanel();
    private JPanel displayAccountsPanel = new JPanel();
    private JPanel displayRoomsPanel = new JPanel();
    private JFrame errorPrompt = new JFrame();
    
    //Admin main components
    private JLabel adminTitle = new JLabel("Administrator Menu");
    private JButton regRoomBtn = new JButton("Register a Room");
    private JButton displayAccountsBtn = new JButton("Display all accounts");
    private JButton displayRoomsBtn = new JButton("Display all rooms");
    
    private JButton exitToMainBtn = new JButton("Exit admin menu");
    private JButton exitToAdminBtn = new JButton("Exit to admin menu");
    
    //Register Room componenets
    private JLabel regRoomTitle = new JLabel("Register a room");
    private JTextField roomNumber = new JTextField("Type here:");
    private JTextField roomType = new JTextField();
    private JTextField roomPrice = new JTextField();
    private JLabel numberPrompt = new JLabel("Room Number (e.g. 7):");
    private JLabel typePrompt = new JLabel("Room Type (\"single\" or \"double\")");
    private JLabel pricePrompt = new JLabel("Price (e.g. 50.00):");
    private JButton confirmRoomBtn = new JButton("Register room");
    
    //Display accounts components
    private JLabel allAccountsTitle = new JLabel("Displaying all accounts");
    
    //Display rooms components
    private JLabel allRoomsTitle = new JLabel("Displaying all rooms");
    
    private Component rigidArea = Box.createRigidArea(new Dimension(200, 25));
    private Component rigidArea2 = Box.createRigidArea(new Dimension(200, 25));
    
    public AdminView()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setBackground(Color.LIGHT_GRAY);
        
        adminTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        adminTitle.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        adminTitle.setMaximumSize(new Dimension(250, 200));
        adminTitle.setForeground(Color.black);
        
        regRoomBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        regRoomBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        regRoomBtn.setMaximumSize(new Dimension(200, 35));
        regRoomBtn.setBackground(Color.DARK_GRAY);
        regRoomBtn.setForeground(Color.WHITE);
        
        displayAccountsBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        displayAccountsBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        displayAccountsBtn.setMaximumSize(new Dimension(200, 35));
        displayAccountsBtn.setBackground(Color.DARK_GRAY);
        displayAccountsBtn.setForeground(Color.WHITE);
        
        displayRoomsBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        displayRoomsBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        displayRoomsBtn.setMaximumSize(new Dimension(200, 35));
        displayRoomsBtn.setBackground(Color.DARK_GRAY);
        displayRoomsBtn.setForeground(Color.WHITE);
        
        exitToMainBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToMainBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
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
        this.revalidate();
        this.repaint();
        this.setVisible(false);
    }
    
    public void registerRoomView() 
    {
        regRoomPanel.setLayout(new BoxLayout(regRoomPanel, BoxLayout.Y_AXIS));
        regRoomPanel.setBackground(Color.LIGHT_GRAY);
        
        regRoomTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        regRoomTitle.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        regRoomTitle.setMaximumSize(new Dimension(200, 150));
        regRoomTitle.setForeground(Color.black);
        
        numberPrompt.setFont(new Font("Calibri", Font.PLAIN, 15));
        numberPrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        numberPrompt.setMaximumSize(new Dimension(200, 35));
        numberPrompt.setForeground(Color.BLACK);
        
        typePrompt.setFont(new Font("Calibri", Font.PLAIN, 14));
        typePrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        typePrompt.setMaximumSize(new Dimension(200, 35));
        typePrompt.setForeground(Color.BLACK);
        
        pricePrompt.setFont(new Font("Calibri", Font.PLAIN, 15));
        pricePrompt.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        pricePrompt.setMaximumSize(new Dimension(200, 35));
        pricePrompt.setForeground(Color.BLACK);
        
        roomNumber.setFont(new Font("Calibri", Font.PLAIN, 15));
        roomNumber.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomNumber.setMaximumSize(new Dimension(200, 35));
        roomNumber.setBackground(Color.DARK_GRAY);
        roomNumber.setForeground(Color.WHITE);
        
        roomType.setFont(new Font("Calibri", Font.PLAIN, 15));
        roomType.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomType.setMaximumSize(new Dimension(200, 35));
        roomType.setBackground(Color.DARK_GRAY);
        roomType.setForeground(Color.WHITE);
        
        roomPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
        roomPrice.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        roomPrice.setMaximumSize(new Dimension(200, 35));
        roomPrice.setBackground(Color.DARK_GRAY);
        roomPrice.setForeground(Color.WHITE);
        
        confirmRoomBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        confirmRoomBtn.setAlignmentX(regRoomPanel.CENTER_ALIGNMENT);
        confirmRoomBtn.setMaximumSize(new Dimension(200, 35));
        confirmRoomBtn.setBackground(Color.DARK_GRAY);
        confirmRoomBtn.setForeground(Color.WHITE);
        
        exitToAdminBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
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
    
    public void displayAccountsView(JScrollPane table) 
    {         
        displayAccountsPanel.setLayout(new BoxLayout(displayAccountsPanel, BoxLayout.Y_AXIS));
        displayAccountsPanel.setBackground(Color.LIGHT_GRAY);
        
        allAccountsTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        allAccountsTitle.setAlignmentX(displayAccountsPanel.CENTER_ALIGNMENT);
        allAccountsTitle.setMaximumSize(new Dimension(280, 150));
        allAccountsTitle.setForeground(Color.black);
        
        exitToAdminBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToAdminBtn.setAlignmentX(displayAccountsPanel.CENTER_ALIGNMENT);
        exitToAdminBtn.setMaximumSize(new Dimension(200, 35));
        exitToAdminBtn.setBackground(Color.DARK_GRAY);
        exitToAdminBtn.setForeground(Color.WHITE);
        
        displayAccountsPanel.add(allAccountsTitle);
        displayAccountsPanel.add(rigidArea);
        displayAccountsPanel.add(table);
        displayAccountsPanel.add(rigidArea2);
        displayAccountsPanel.add(exitToAdminBtn);
        
        this.getContentPane().removeAll();
        this.add(displayAccountsPanel);
        this.revalidate();
        this.repaint();
    }

    public void displayRoomsView(JScrollPane table) 
    {
        displayRoomsPanel.setLayout(new BoxLayout(displayRoomsPanel, BoxLayout.Y_AXIS));
        displayRoomsPanel.setBackground(Color.LIGHT_GRAY);

        allRoomsTitle.setFont(new Font("Calibri", Font.PLAIN, 30));
        allRoomsTitle.setAlignmentX(displayRoomsPanel.CENTER_ALIGNMENT);
        allRoomsTitle.setMaximumSize(new Dimension(280, 150));
        allRoomsTitle.setForeground(Color.black);
        
        exitToAdminBtn.setFont(new Font("Calibri", Font.PLAIN, 15));
        exitToAdminBtn.setAlignmentX(displayRoomsPanel.CENTER_ALIGNMENT);
        exitToAdminBtn.setMaximumSize(new Dimension(200, 35));
        exitToAdminBtn.setBackground(Color.DARK_GRAY);
        exitToAdminBtn.setForeground(Color.WHITE);
        
        displayRoomsPanel.add(allRoomsTitle);
        displayRoomsPanel.add(rigidArea);
        displayRoomsPanel.add(table);
        displayRoomsPanel.add(rigidArea2);
        displayRoomsPanel.add(exitToAdminBtn);
        
        this.getContentPane().removeAll();
        this.add(displayRoomsPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void backToAdmin() 
    {
       this.getContentPane().removeAll();
       this.getContentPane().add(adminPanel);
       this.validate();
       this.repaint();
    }
    
    public void addActionListener(ActionListener L)
    {
        this.confirmRoomBtn.addActionListener(L);
        this.regRoomBtn.addActionListener(L);
        this.displayAccountsBtn.addActionListener(L);
        this.displayRoomsBtn.addActionListener(L);
        this.exitToAdminBtn.addActionListener(L);
        this.exitToMainBtn.addActionListener(L);
    }

    public JTextField getRoomNumber() 
    {  
        return this.roomNumber;
    }

    public JTextField getRoomType() 
    {
        return this.roomType;
    }

    public JTextField getRoomPrice() 
    {
        return this.roomPrice;
    }

    public void incorrectInput(JTextField field) 
    {
        if(field.equals(roomNumber))
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

    public void roomCreationSuccess(String e)
    {
        JOptionPane.showMessageDialog(errorPrompt, "Room with Room number: " + e + " has been registered\n"
                                        + "Please either register additional rooms or exit to the main menu.");
        roomNumber.setText("");
        roomType.setText("");
        roomPrice.setText("");
    }

    public void roomExists(String e)
    {
        JOptionPane.showMessageDialog(errorPrompt, "A room with room number " + e + " already exists!");
        roomNumber.setText("");
        roomType.setText("");
        roomPrice.setText("");
    }
    
}
