/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author maxhi
 */
class ViewAdmin extends JFrame
{   
    //All components for admin menu.
 
    private JLabel adminMenuTitle;
    private JButton regRoomBtn;
    private JButton displayAccountsBtn;
    private JButton displayRoomsBtn;
    private JButton exitMainBtn;
    
    public ViewAdmin()
    {
        initComponents();
    }
      
    private void initComponents() 
    {


        adminMenuTitle = new JLabel("Administrator Menu");
        regRoomBtn = new JButton("Register a Room");
        displayAccountsBtn = new JButton("Display all Accounts");
        displayRoomsBtn = new JButton("Display all rooms");
        exitMainBtn = new JButton("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminMenuTitle.setFont(new java.awt.Font("Tahoma", 0, 15));

        //Adding action listeners

        regRoomBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                regRoomBtnActionPerformed(e);
            }
        });

        displayAccountsBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                displayAccountsBtnActionPerformed(e);
            }
        });

        displayRoomsBtn.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               displayRoomsBtnActionPerformed(e);
           }
        });

        exitMainBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitMainBtnActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(displayRoomsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitMainBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(displayAccountsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(regRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(adminMenuTitle)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(adminMenuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(regRoomBtn)
                .addGap(18, 18, 18)
                .addComponent(displayAccountsBtn)
                .addGap(18, 18, 18)
                .addComponent(displayRoomsBtn)
                .addGap(18, 18, 18)
                .addComponent(exitMainBtn)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        this.setVisible(true);
    }       
    
    private void regRoomBtnActionPerformed(ActionEvent e)
    {
        
    }
    
    private void displayAccountsBtnActionPerformed(ActionEvent e)
    {
        
    }
    
    private void displayRoomsBtnActionPerformed(ActionEvent e)
    {
        
    }
    
    private void exitMainBtnActionPerformed(ActionEvent e)
    {
        
    }
    
}

