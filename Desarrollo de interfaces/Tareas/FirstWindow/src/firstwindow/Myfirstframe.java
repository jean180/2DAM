/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstwindow;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jeaagu
 */
public class Myfirstframe extends JFrame{
    // Create the object panel
    JPanel panel = new JPanel();
    
    private JButton blue, red, yellow, green;
    
    public Myfirstframe(){
        setTitle ("Example with several buttons");
        setSize (500,400); // size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());        
        blue = new JButton("Blue");
        Dimension d = new Dimension(); 
        d.height = 40;
        d.width = 100;
        blue.setPreferredSize(d);
        blue.addActionListener(new listener_button_blue());
        
        red = new JButton("Red");
        d.height = 40;
        d.width = 100;
        red.setPreferredSize(d);
        red.addActionListener(new listener_button_red());

        yellow = new JButton("Yellow");
        d.height = 40;
        d.width = 100;
        yellow.setPreferredSize(d);
        yellow.addActionListener(new listener_button_yellow());

        green = new JButton("Green");
        d.height = 40;
        d.width = 100;
        green.setPreferredSize(d);
        green.addActionListener(new listener_button_green());

          

        //add button to the panel
        panel.add(blue, BorderLayout.SOUTH);   
        panel.add(red, BorderLayout.NORTH);
        panel.add(yellow, BorderLayout.EAST);
        panel.add(green, BorderLayout.WEST);
        add(panel);
        panel.setBackground(Color.red);
    }
    
    //class to listen to button events
    class listener_button_blue implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.blue);
        }
    }
    
    class listener_button_red implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.red);
        }
    }
    
    class listener_button_yellow implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.yellow);
        }
    }
    
    class listener_button_green implements ActionListener {
        // The actionPerformed method has to be rewritten, it is the one that responds to the button click
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.green);
        }
    }
}
