/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstjradiobutton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class FirstJRadioButton extends JFrame {

    /**
     * @param args the command line arguments
     */
    private JTextField fieldText;
    private Font simpleLettertype;
    private Font boldLettertype;
    private Font ItalicLetter;
    private Font ItalicBoldLetter;
    private JRadioButton simpleJRadioButton;
    private JRadioButton boldJRadioButton;
    private JRadioButton italicJRadioButton;
    private JRadioButton boldCursiveJRadioButton;
    private ButtonGroup group_options;

    public FirstJRadioButton() {
        setTitle("RadioButton Test");
        setLayout(new FlowLayout());
        setSize(500, 100); // size
        fieldText = new JTextField("Notice the change in font style", 28);
        add(fieldText);

        simpleJRadioButton = new JRadioButton("Simple", true);
        boldJRadioButton = new JRadioButton("Bold", false);
        italicJRadioButton = new JRadioButton("Italic", false);
        boldCursiveJRadioButton = new JRadioButton("Bold/Italic", false);
        add(simpleJRadioButton);
        add(boldJRadioButton);
        add(italicJRadioButton);
        add(boldCursiveJRadioButton);

        group_options = new ButtonGroup();
        group_options.add(simpleJRadioButton);
        group_options.add(boldJRadioButton);
        group_options.add(italicJRadioButton);
        group_options.add(boldCursiveJRadioButton);

        simpleLettertype = new Font("serif", Font.PLAIN, 14);
        boldLettertype = new Font("serif", Font.BOLD, 14);
        ItalicLetter = new Font("Serif", Font.ITALIC, 14);
        ItalicBoldLetter = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
        fieldText.setFont(simpleLettertype);
        simpleJRadioButton.addItemListener(new HandlerButtonOption(simpleLettertype));
        boldJRadioButton.addItemListener(new HandlerButtonOption(boldLettertype));
        italicJRadioButton.addItemListener(new HandlerButtonOption(ItalicLetter));
        boldCursiveJRadioButton.addItemListener(new HandlerButtonOption(ItalicBoldLetter));
    }

    private class HandlerButtonOption implements ItemListener {

        private Font lettertype;

        public HandlerButtonOption(Font f) {
            lettertype = f;
        }

        public void itemStateChanged(ItemEvent event) {
            fieldText.setFont(lettertype);
        }
    }
}
