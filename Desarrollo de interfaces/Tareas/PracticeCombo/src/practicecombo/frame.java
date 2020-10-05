/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicecombo;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame{
    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String[] images = { "Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;
    public frame(){
        setSize(500,300);
        setTitle("Conbos and images");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
    }
}
