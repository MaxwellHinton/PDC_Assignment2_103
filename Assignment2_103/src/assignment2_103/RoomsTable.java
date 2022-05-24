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
public class RoomsTable 
{
    private JTable roomsTable;
    
    public RoomsTable()
    {
        this.roomsTable = new JTable(new DefaultTableModel(new Object[] {"Room Number", "Room type", "Price", "Status", "Customer"}, 20));
    }
    
    public void addRoomToTable(Room room)
    {
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.addRow(new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice(), room.getStatus(), room.getCustomer()});
    }
    
    public JTable getRoomTable()
    {
        return this.roomsTable;
    }
}
