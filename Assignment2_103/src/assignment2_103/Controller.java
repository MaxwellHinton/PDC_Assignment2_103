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
    public ViewMain view;
    
    public Controller(ViewMain view)
    {
        this.view = view;
        //this.view.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        
        switch(command)
        {
            case "Exit":
                System.out.println("Main exit button was pressed");
                //Model.exit();
                break;
            default:
                break;

        }
    }
}
