/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maxhi
 */
public class AccountsTable 
{
    private JTable accTable;
    
    public AccountsTable()
    {
        this.accTable = new JTable(new DefaultTableModel(new Object[]{"Firstname", "Surname", "Email"}, 20));
    }
    
    public void addAccountToTable(Account acc)
    {
        DefaultTableModel model = (DefaultTableModel) accTable.getModel();
        model.addRow(new Object[]{acc.getFirstname(), acc.getSurname(), acc.getEmail()});
    }
    
    public JTable getAccTable()
    {
        return this.accTable;
    }
}
