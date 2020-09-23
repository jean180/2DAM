/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsttextfield;

/**
 *
 * @author jeaagu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstTextField extends JFrame {

    JTextField textField1, textField2;
    JPanel panel = new JPanel();

    /**
     * @param args the command line arguments
     */
    public FirstTextField() {
        setTitle("JTextField example");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1, 5, 5));
        //Create two testfields and a button
        textField1 = new JTextField("Type something and press return", 20);//20 columns wide
        //Add a listener
        textField1.addActionListener(new TextFieldListener());
        //Assign a black border line
        textField1.setBorder(BorderFactory.createLineBorder(Color.black));
        textField2 = new JTextField(20);
        textField2 = new JTextField(20);
        textField2.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton button = new JButton("clear");
        button.addActionListener(new ButtonListener());
        //Add the elements to the panel
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button);
        add(panel);
    }

    //testfield listener
    class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //get the text typed in textfield1
            //add assign it to the other textfield
            String text = textField1.getText();
            textField2.setText(text);
        }
    }

    //listener of the button
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //clean the textfields
            textField1.setText("");
            textField1.requestFocus();//Give focus to textfield1
            textField2.setText("");
        }
    }

}
