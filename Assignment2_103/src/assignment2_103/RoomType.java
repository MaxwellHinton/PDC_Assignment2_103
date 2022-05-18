/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_103;

/**
 *
 * @author maxhi
 */
public enum RoomType 
{
    SINGLE(1),
    DOUBLE(2);

    private final int label;
    
    private RoomType(int label)
    {
        this.label = label;
    }
    
    public int getLabel()
    {
        return this.label;
    }
    
    public static RoomType valueOf(int label) 
    {
        if(label == 1)
        {
            return SINGLE;
        }
        else
        {
            return DOUBLE;
        }
    }
}
