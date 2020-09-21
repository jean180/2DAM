/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcheckbox;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class FirstCheckBox extends JFrame {

    private JTextField fieldText;
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;

    public FirstCheckBox() {
        setTitle("JCheckBox Test");
        setLayout(new FlowLayout());
        setSize(500, 100); // size

        fieldText = new JTextField("Notice how the font style changes", 20);
        fieldText.setFont(new Font("Serif", Font.PLAIN, 14));
        add(fieldText);

        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italicJCheckBox);

        HandlerCheckBox handler = new HandlerCheckBox();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    }

    private class HandlerCheckBox implements ItemListener {

        private int valNegrita = Font.PLAIN;
        private int valCursiva = Font.PLAIN;

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == boldJCheckBox) {
                valNegrita = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
            }
            if (event.getSource() == italicJCheckBox) {
                valCursiva = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
            }
            fieldText.setFont(new Font("serif", valNegrita + valCursiva, 14) {
            });
        }
    }
    /**
     * @param args the command line arguments
     */

}
