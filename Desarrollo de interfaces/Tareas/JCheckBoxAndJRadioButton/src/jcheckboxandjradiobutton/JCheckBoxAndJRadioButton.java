/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcheckboxandjradiobutton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class JCheckBoxAndJRadioButton extends JFrame {

    private JTextField textfield;
    private JRadioButton MaleJRadioButton, FemaleJRadioButton;
    private ButtonGroup group_options;
    private JCheckBox DaughtersJCheckBox, sonsJCheckBox;
    private JPanel panel = new JPanel();

    public JCheckBoxAndJRadioButton() {
        setTitle("WINDOW");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 2));
        MaleJRadioButton = new JRadioButton("Male", false);
        add(MaleJRadioButton);
        FemaleJRadioButton = new JRadioButton("Female", false);
        add(FemaleJRadioButton);
        group_options = new ButtonGroup();
        group_options.add(MaleJRadioButton);
        group_options.add(FemaleJRadioButton);
        DaughtersJCheckBox = new JCheckBox("Daughters");
        sonsJCheckBox = new JCheckBox("Sons");
        textfield = new JTextField("");
        textfield.setFont(new Font("Serif", Font.PLAIN, 14));
        panel.add(MaleJRadioButton);
        panel.add(FemaleJRadioButton);
        panel.add(DaughtersJCheckBox);
        panel.add(sonsJCheckBox);
        panel.add(textfield);
        add(panel);
        MaleJRadioButton.addItemListener(new HandlerRadioButton("men"));
        FemaleJRadioButton.addItemListener(new HandlerRadioButton("women"));

    }

    private class HandlerRadioButton implements ItemListener {

        public String genero;

        public HandlerRadioButton(String genero) {
            this.genero = genero;
        }

        @Override
        public void itemStateChanged(ItemEvent event) {
            textfield.setText("You are a " + genero);
            String frase = "You are a " + genero;
            HandlerCheckBox handlerChechBox = new HandlerCheckBox(frase);
            DaughtersJCheckBox.addItemListener(handlerChechBox);
            sonsJCheckBox.addItemListener(handlerChechBox);

        }

    }

    private class HandlerCheckBox implements ItemListener {

        private boolean valDaughters = false;
        private boolean valSons = false;
        private String frase;

        public HandlerCheckBox(String frase) {
            this.frase = frase;
        }

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == DaughtersJCheckBox) {
                valDaughters = DaughtersJCheckBox.isSelected() ? Boolean.TRUE : Boolean.FALSE;
            }
            if (event.getSource() == sonsJCheckBox) {
                valSons = sonsJCheckBox.isSelected() ? Boolean.TRUE : Boolean.FALSE;
            }
            if (valDaughters == true && valSons == true) {
                textfield.setText(frase + " and you have 2 childrens");
            } else if (valDaughters == true) {
                textfield.setText(frase + " and you have 1 daughter");
            } else if (valSons == true) {
                textfield.setText(frase + " and you have 1 son");
            } else {
                textfield.setText(frase);
            }
        }
    }

}
