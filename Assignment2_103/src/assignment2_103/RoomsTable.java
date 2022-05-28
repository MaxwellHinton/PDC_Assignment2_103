/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author maxhi
 */
public class RoomsTable 
{
    private JTable roomsTable;
    private List<Room> savedRooms;
    
    public RoomsTable()
    {
        this.roomsTable = new JTable(new DefaultTableModel(new Object[] {"Room Number", "Room type", "Price", "Status", "Customer"}, 0){
            
            @Override 
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        });
        
        roomsTable.getTableHeader().setReorderingAllowed(false);
        roomsTable.getTableHeader().setResizingAllowed(false);   
        roomsTable.getColumnModel().getColumn(4).setMinWidth(180);
     
        savedRooms = HotelDB.getAllRooms();
        
        if(!(savedRooms.isEmpty())) //If database has entries, add them to the table
        {
            for(Room room : savedRooms)
            {
                addRoomToTable(room);
            }
        }
    }
    

    
    public void addRoomToTable(Room room)
    {
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.insertRow(0, new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice(), room.getStatus(), room.getCustomer()});
        model.fireTableDataChanged();
    }
    
    public JTable getRoomTable()
    {
        return this.roomsTable;
    }

    public void update() 
    {
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        model.fireTableDataChanged();
    }
}
