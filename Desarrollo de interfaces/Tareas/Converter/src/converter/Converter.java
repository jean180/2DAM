/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class Converter extends JFrame {

    JTextField textField1, textField2;
    JPanel panel = new JPanel();
    JLabel label1, label2;
    JButton button;

    /**
     * @param args the command line arguments
     */
    public Converter() {
        // TODO code application logic here
        setTitle("Converter");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 2));
        label1 = new JLabel("celsius Grades");
        label2 = new JLabel("Kelvins grades");
        textField1 = new JTextField();
        textField1.addActionListener(new TextFieldListener1());
        textField2 = new JTextField();
        textField2.addActionListener(new TextFieldListener2());
        button = new JButton("Clean");
        button.addActionListener(new ButtonListener());

        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button);
        add(panel);

    }

    class TextFieldListener1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double f = Double.parseDouble(textField1.getText());
            f += 273.15;
            textField2.setText(String.valueOf(f));
        }
    }

    class TextFieldListener2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            double f = Double.parseDouble(textField2.getText());
            f -= 273.15;
            textField1.setText(String.valueOf(f));
        }
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //clean the textfields
            textField1.setText("");
            textField1.requestFocus();//Give focus to textfield1
            textField2.setText("");
        }
    }

}
