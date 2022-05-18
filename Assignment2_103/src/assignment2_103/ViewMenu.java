/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author maxhi
 */
public class ViewMenu extends JFrame 
{
    //All components for main menu
    
    private JButton createAccountBtn;
    private JLabel mainTitle;
    private JButton adminBtn;
    private JButton exitBtn;
    private JButton reserveRoomBtn;
    
    public ViewMenu() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")                   
    private void initComponents() 
    {

        mainTitle = new JLabel("Welcome to the Hotel Reservation System");
        reserveRoomBtn = new JButton("Reserve a Room");
        createAccountBtn = new JButton("Create an Account");
        adminBtn = new JButton("Administrator Menu");
        exitBtn = new JButton("Exit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTitle.setFont(new java.awt.Font("Tahoma", 0, 15));
        
        //Adding action listeners
        
        reserveRoomBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                reserveRoomBtnActionPerformed(e);
            }
        });
        
        createAccountBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                createAccountBtnActionPerformed(e);
            }
        });
        
        adminBtn.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               adminBtnActionPerformed(e);
           }
        });
        
        exitBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitBtnActionPerformed(e);
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
                                .addComponent(adminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(reserveRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(mainTitle)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(reserveRoomBtn)
                .addGap(18, 18, 18)
                .addComponent(createAccountBtn)
                .addGap(18, 18, 18)
                .addComponent(adminBtn)
                .addGap(18, 18, 18)
                .addComponent(exitBtn)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        this.setVisible(true);
    }                        
    
    
    private void reserveRoomBtnActionPerformed(ActionEvent e)
    {
        
    }
    
    private void createAccountBtnActionPerformed(ActionEvent e) 
    {
                
    }
    
    private void adminBtnActionPerformed(ActionEvent e)
    {
        ViewAdmin adminMenu = new ViewAdmin();
    }
    
    private void exitBtnActionPerformed(ActionEvent e) 
    {
        System.out.println("System will now exit.");
        
        System.exit(0);
    }
   
}

