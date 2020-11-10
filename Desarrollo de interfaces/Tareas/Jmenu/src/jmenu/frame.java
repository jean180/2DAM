/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public frame() {
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        //We instantiate the menu bar.
        menuBar = new JMenuBar();
        //The first option on the menu.
        menu = new JMenu("First menu");
        menuBar.add(menu);
        //to the first option of the menu we put two items.
        menuItem = new JMenuItem("Option 1");
        menuItem.addActionListener(new em(this));
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Option 2");
        menu.add(menuItem);
        //Second option in the menu bar without any item.
        menu = new JMenu("Secon menu");
        menuBar.add(menu);
        panel.add(menuBar);
        add(panel);
    }

    //LISTEN OUT
    class em implements ActionListener {

        JFrame miFrame;

        public em(JFrame f) {
            miFrame = f;
        }

        public void actionPerformed(ActionEvent e) {
            DialogoModal dialogoModal = new DialogoModal(miFrame);
            dialogoModal.pack();
            //to automatically resize the window.
            dialogoModal.setVisible(true);
            // As it is a modal window it will not return to this line
            // until the other one is closed
            System.out.println(dialogoModal.getText());
        }
    }
}
