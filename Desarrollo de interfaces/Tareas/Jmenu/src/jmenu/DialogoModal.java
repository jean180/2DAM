/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class DialogoModal extends JDialog {

    private JTextField textField;

    public DialogoModal(JFrame parent) {
        super(parent, true);
        //I Invoke the constructor of the case, with two
        //parameters: who is your father
        //then true for modal and flase for non-modal
        setTitle("Enter a data");
        textField = new JTextField(20);
        add(textField);

        // The window is hidden when pressing <enter> on the textfield
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
    }

    public String getText() {
        return textField.getText();
    }
}
