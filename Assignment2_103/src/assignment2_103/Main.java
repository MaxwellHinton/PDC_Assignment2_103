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

    public static void main(String[] args) 
    {
       MainView view = new MainView();
       view.MainViewSetup();
       AdminView admin = new AdminView();
       admin.AdminViewSetup();
       Model model = new Model();
       model.ModelSetup();
       Controller controller = new Controller(view, model, admin);
    } 
}
