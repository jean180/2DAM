/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1ejer1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JButton btnSelect;
    private JComboBox combo;
    private String[] Cursos = {"1 DAM", "2 DAM"};
    private JList list;
    private DefaultListModel listModel1 = new DefaultListModel();

    private JPanel panel = new JPanel();
    private JPanel panelIzq;

    public frame() {
        setTitle("Ejercicio 1");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(1, 2));

        panelIzq = new JPanel();
        panelIzq.setLayout(new BorderLayout());
        combo = new JComboBox(Cursos);
        panelIzq.add(combo);
        combo.addItemListener(new ListenerCombo());
        btnSelect = new JButton("Seleccionar");
        btnSelect.addActionListener(new ButtonListener());
        panelIzq.add(btnSelect, BorderLayout.SOUTH);
        panel.add(panelIzq);

        for (int i = 1; i < 10; i++) {
            listModel1.addElement("1 DAM asignatura " + i);
        }
        list = new JList(listModel1);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(list));
        add(panel);
    }

    private class ListenerCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            int indice = combo.getSelectedIndex();
            if (indice == 0) {
                listModel1.removeAllElements();
                for (int i = 1; i < 10; i++) {
                    listModel1.addElement("1 DAM asignatura " + i);
                }
            } else if (indice == 1) {
                listModel1.removeAllElements();
                for (int i = 1; i < 10; i++) {
                    listModel1.addElement("2 DAM asignatura " + i);
                }
            }
        }

    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int[] indices = list.getSelectedIndices();

            String salida = "Asignaturas Escogidas: ";
            for (int i = 0; i < indices.length; i++) {
                if (i == indices.length - 1) {
                    salida += listModel1.getElementAt(indices[i]);

                } else {

                    salida += listModel1.getElementAt(indices[i]) + ", ";
                }
            }
            JOptionPane.showMessageDialog(null, salida);

        }

    }
}
