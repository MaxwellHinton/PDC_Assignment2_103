/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author maxhi
 */
public class AccountsTable 
{
    private JTable accTable;
    private List<Account> savedAccounts;
    
    public AccountsTable()
    {
        this.accTable = new JTable(new DefaultTableModel(new Object[]{"Firstname", "Surname", "Email"}, 0){
       
            @Override 
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        });
        
        accTable.getTableHeader().setReorderingAllowed(false);
        accTable.getTableHeader().setResizingAllowed(false);
        
        savedAccounts = HotelDB.getAllAccounts();
        
        if(!(savedAccounts.isEmpty())) //If database has entries, add them to the table
        {
            for(Account acc : savedAccounts)
            {
                addAccountToTable(acc);
            }
        }
    }
    
    public void addAccountToTable(Account acc)
    {
        DefaultTableModel model = (DefaultTableModel) accTable.getModel();
        model.insertRow(0, new Object[]{acc.getFirstname(), acc.getSurname(), acc.getEmail()});
        model.fireTableDataChanged();
    }
    
    public JTable getAccTable()
    {
        return this.accTable;
    }
}
