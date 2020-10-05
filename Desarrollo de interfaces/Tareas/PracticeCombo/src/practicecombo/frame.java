/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicecombo;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String[] images = {"Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;

    public frame() {
        setSize(500, 300);
        setTitle("Conbos and images");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        add(panel);
        //passing the array of images
        combo = new JComboBox(images);
        panel.add(combo, BorderLayout.NORTH);

        //an object ImageIcon brings the image:
        img = new ImageIcon(getClass().getResource("images/Rabbit.gif"));
        //instantiate label
        label = new JLabel();
        //label text:
        /* label.setText("Rabbit");
        //set icon to label:
        label.setIcon(img); */
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        label.setToolTipText("This is a label");

        panel.add(label, BorderLayout.CENTER);

        //add listener:
        combo.addItemListener(new ListenerCombo());
    }

    private class ListenerCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            int indice = combo.getSelectedIndex();

            String s = images[indice];

            img = new ImageIcon(getClass().getResource("images/" + s + ".gif"));
            label.setIcon(img);
            label.setText(s);
        }
    }
}
