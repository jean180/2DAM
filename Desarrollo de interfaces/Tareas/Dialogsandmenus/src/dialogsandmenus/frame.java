/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogsandmenus;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    public frame() {
        Object selec = JOptionPane.showInputDialog(null, "Select option", "options selector", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"option 1", "option 2", "option 3"}, "option 1");
        System.out.println("The user has chosen " + selec);
    }

}
