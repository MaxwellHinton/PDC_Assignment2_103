/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author maxhi
 */
public class UserRoomsTable 
{
    private JTable roomsTable;
    private List<Room> savedRooms;
    
    public UserRoomsTable()
    {
        this.roomsTable = new JTable(new DefaultTableModel(new Object[] {"Room Number", "Room type", "Price"}, 0){
 
            @Override 
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        });
        
        roomsTable.getTableHeader().setReorderingAllowed(false);
        roomsTable.getTableHeader().setResizingAllowed(false);
        
        savedRooms = HotelDB.getAllAvailableRooms();
        
        if(!(savedRooms.isEmpty())) //If database has entries, add them to the table
        {
            for(Room room : savedRooms)
            {
                addRoomToTable(room);
            }
        }
        
        roomsTable.setPreferredSize(new Dimension(150,300));
    }
    
    public void addRoomToTable(Room room)
    {
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.insertRow(0, new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice()});
        model.fireTableDataChanged();
    }
    
    public JTable getUserRoomsTable()
    {
        return this.roomsTable;
    }
    
}
