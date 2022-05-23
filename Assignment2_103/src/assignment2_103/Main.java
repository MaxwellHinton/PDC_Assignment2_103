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
public class Main {

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       ViewMain view = new ViewMain();
       Model model = new Model();
       
       Controller controller = new Controller(view, model);
       
    }
    
}
