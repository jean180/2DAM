/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author jean_
 */
public class frame extends JFrame {
    
    private JList listJListColours;
    private final String namesColours[] = {"Black", "Blue", "Cyan", "Dark grey", "Grey", "Green", "Light grey", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private final Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    private JPanel panel = new JPanel();
    
    public frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Lista simple");
        add(panel);
        //instancio el jlist con el vector namesColours
        listJListColours = new JList(namesColours);
        //muestra cinco filas a la vez, puedo mostrar las que quiera:
        listJListColours.setVisibleRowCount(5);
        //los listpueden ser de selección multiple o simple. Establezco la simple:
        listJListColours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //añado la lista al panel:

        panel.setLayout(new FlowLayout());
        panel.add(new JScrollPane(listJListColours));
        
        listJListColours.addListSelectionListener(new ListListener());        
    }

    private class ListListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            panel.setBackground(colores[listJListColours.getSelectedIndex()]);
        }
    }
}
