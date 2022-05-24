/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author maxhi
 */
public class AdminView extends JFrame
{
    private JPanel adminPanel = new JPanel();
    private JPanel regRoomPanel = new JPanel();
    private JPanel displayAccountsPanel = new JPanel();
    private JPanel displayRoomsPanel = new JPanel();
    
    
    private JLabel adminTitle = new JLabel("Administrator Menu");
    private JButton regRoomBtn = new JButton("Register a Room");
    private JButton displayAccountsBtn = new JButton("Display all accounts");
    private JButton displayRoomsBtn = new JButton("Display all rooms");
    
    private JButton exitToMainBtn = new JButton("Exit to main menu");
    private JButton exitToAdminBtn = new JButton("Exit to admin menu");
    
    
    public AdminView()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 600);
        
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setBackground(Color.LIGHT_GRAY);
        
        adminTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        adminTitle.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        adminTitle.setMaximumSize(new Dimension(250, 200));
        adminTitle.setForeground(Color.black);
        
        regRoomBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        regRoomBtn.setMaximumSize(new Dimension(200, 35));
        regRoomBtn.setBackground(Color.DARK_GRAY);
        regRoomBtn.setForeground(Color.WHITE);
     
        displayAccountsBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        displayAccountsBtn.setMaximumSize(new Dimension(200, 35));
        displayAccountsBtn.setBackground(Color.DARK_GRAY);
        displayAccountsBtn.setForeground(Color.WHITE);
        
        displayRoomsBtn.setAlignmentX(adminPanel.CENTER_ALIGNMENT);
        displayRoomsBtn.setMaximumSize(new Dimension(200, 35));
        displayRoomsBtn.setBackground(Color.DARK_GRAY);
        displayRoomsBtn.setForeground(Color.WHITE);
        
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
        adminPanel.setVisible(true);
        this.revalidate();
        this.repaint();
        
        this.setVisible(true);
    }
}
