/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogspractica;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JButton btnInfo, btnAdv, btnError, btnConfirm, btnTxt, btnCombo, btnMas;
    private JPanel panel;

    public frame() {
        setTitle("Montones de JOptionPane");
        setSize(500, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        btnInfo = new JButton("Info");
        btnAdv = new JButton("Advertencia");
        btnError = new JButton("Error");
        btnConfirm = new JButton("Confirmación");
        btnTxt = new JButton("Texto");
        btnCombo = new JButton("Combo");
        btnMas = new JButton("Más");
        panel.add(btnInfo);
        panel.add(btnAdv);
        panel.add(btnError);
        panel.add(btnConfirm);
        panel.add(btnTxt);
        panel.add(btnCombo);
        panel.add(btnMas);

        buttonsListener bl = new buttonsListener();
        btnInfo.addActionListener(bl);
        btnAdv.addActionListener(bl);
        btnError.addActionListener(bl);
        btnConfirm.addActionListener(bl);
        btnTxt.addActionListener(bl);
        btnCombo.addActionListener(bl);
        btnMas.addActionListener(bl);

        add(panel);
    }

    class buttonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnInfo) {
                JOptionPane.showMessageDialog(null, "Este es un mensaje Simple tipo Información");
                JOptionPane.showMessageDialog(null, "Este es un mensaje Simple tipo Información pero con titulo", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);

            }
            if (ae.getSource() == btnAdv) {
                JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            }
            if (ae.getSource() == btnError) {
                JOptionPane.showMessageDialog(null, "Este es un mensaje de Error", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            if (ae.getSource() == btnConfirm) {
                JOptionPane.showMessageDialog(null, "Este es un mensaje de confirmación o pregunta", "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE);
            }
            if (ae.getSource() == btnTxt) {

                String num = JOptionPane.showInputDialog(null, "Escribe un numero para multiplicarlos por 2", JOptionPane.QUESTION_MESSAGE);
                try {
                    int numero = Integer.parseInt(num);
                    JOptionPane.showMessageDialog(null, "el resultado es: 2*" + numero + " = " + (numero * 2));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El Valor ingresado debe ser númerico", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
            if (ae.getSource() == btnCombo) {
                Object selec = JOptionPane.showInputDialog(null, "Selecione un color", "COLORES", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Seleccione", "Rojo", "Azul", "Amarillo"}, "Seleccione");
                JOptionPane.showMessageDialog(null, "Color seleccionado: " + selec);

            }
            if (ae.getSource() == btnMas) {
                int opcion = JOptionPane.showConfirmDialog(null, "Usas mucho el JOptionPane?");
                if (JOptionPane.OK_OPTION == opcion) {
                    JCheckBox chAveces = new JCheckBox("A veces");
                    JCheckBox chMenudo = new JCheckBox("A menudo");
                    JCheckBox chSiempre = new JCheckBox("Siempre");
                    JOptionPane.showOptionDialog(null, "Seleccione una opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{chAveces, chMenudo, chSiempre}, "");
                } else {
                    JOptionPane.showMessageDialog(null, "Pues es muy útil");

                }
            }
        }

    }
}
