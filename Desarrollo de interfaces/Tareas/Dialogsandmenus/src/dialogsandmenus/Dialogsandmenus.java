/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogsandmenus;

import javax.swing.JOptionPane;

/**
 *
 * @author jeaagu
 */
public class Dialogsandmenus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JOptionPane.showMessageDialog(null, "Operation Succesful");

        JOptionPane.showMessageDialog(null, "Message inside windows", "Message in the title bar", JOptionPane.WARNING_MESSAGE);
       
        //Showconfirmdialog
        int confirmed = JOptionPane.showConfirmDialog(null, "Do you confim this?");
        if (JOptionPane.OK_OPTION == confirmed) {
            System.out.println("confirmed");
        } else {
            System.out.println("ok... I don't delete anything...");
        }
        
        
        //ShowoptionDialog
        Object selec = JOptionPane.showInputDialog(null, "Select option", "options selector", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"option 1", "option 2", "option 3"}, "option 1");
        System.out.println("The user has chosen " + selec);

//        frame f = new frame();
//        f.setVisible(true);
    }

}
