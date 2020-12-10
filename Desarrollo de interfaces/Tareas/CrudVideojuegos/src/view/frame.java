/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.videojuegoDAO;
import model.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panelBtns = new JPanel();
    private JPanel panelcat = new JPanel();
    private JPanel paneltb = new JPanel();
    private JComboBox combocat;
    private String[] cats = {"Todas", "Terror", "Acción", "Simulación", "Aventura"};
    private JButton btnAdd, btnRm, btnUpdate, btnshow;
    private JTable jTable1 = new JTable();
    private DefaultTableModel modelo = new DefaultTableModel() {
        // Las celdas no se pueden editar a mano
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public frame() {
        setTitle("Videojuegos");
        setSize(1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());

        //Combo para elegir categoria
        panelcat.setLayout(new GridLayout(1, 1));
        TitledBorder titlecat = BorderFactory.createTitledBorder("Categoria: ");
        panelcat.setBorder(titlecat);
        combocat = new JComboBox(cats);
        //Listener del combo
        combocat.addItemListener(new ListenerCombo());
        panelcat.add(combocat);
        panel1.add(panelcat, BorderLayout.NORTH);

        //JTable
        jTable1.setModel(modelo);
        Object[] tags = new Object[6];
        tags[0] = "ID";
        tags[1] = "TITULO";
        tags[2] = "CATEGORÍA";
        tags[3] = "MINIMO JUGADORES";
        tags[4] = "MÁXIMO JUGADORES";
        tags[5] = "PEGI";
        modelo.setColumnIdentifiers(tags);
        videojuegoDAO vDAO = new videojuegoDAO();
        modelo = vDAO.select_all(modelo);
        JScrollPane jScrollPane = new JScrollPane(jTable1);
        TitledBorder titletb = BorderFactory.createTitledBorder("Tabla: ");
        paneltb.setLayout(new GridLayout(1, 1));
        paneltb.setBorder(titletb);
        paneltb.add(jScrollPane);
        panel1.add(paneltb, BorderLayout.CENTER);

        //Botones
        panelBtns.setLayout(new FlowLayout());
        btnAdd = new JButton("Añadir");
        panelBtns.add(btnAdd);

        btnUpdate = new JButton("Actualizar");
        panelBtns.add(btnUpdate);

        btnRm = new JButton("Eliminar");
        panelBtns.add(btnRm);

        btnshow = new JButton("Actualizar tabla");
        panelBtns.add(btnshow);

        // Listener de los botones
        btnAdd.addActionListener(new btn_listener());
        btnUpdate.addActionListener(new btn_listener());
        btnRm.addActionListener(new btn_listener());
        btnshow.addActionListener(new btn_listener());

        panel1.add(panelBtns, BorderLayout.SOUTH);
        add(panel1);
    }

    private class btn_listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            // si pulsamos el boton de añadir nos abre una nueva ventana para introducir los datos
            if (source == btnAdd) {
                FrameAdd f = new FrameAdd();
                f.setVisible(true);
            }

            // Si pulsamos el boton de eliminar borraremos el videojuego seleccionado de la base de datos
            if (source == btnRm) {
                if (jTable1.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "Tiene que seleccionar un videojuego", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    int reply = JOptionPane.showConfirmDialog(null, "¿borrar el videojuego  \"" + jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() + "\"?", "BORRAR", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {

                        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                        videojuegoDAO vDAO = new videojuegoDAO();
                        videojuego v = new videojuego(id);
                        try {
                            vDAO.delete(v);
                            //Cambio el source para que posterior a eliminar el videojuego se actualice la tabla automaticamente
                            source = btnshow;
                        } catch (Exception er) {
                        }
                    }
                }
            }

            //Si pulsamos el boton de actualizar primero recogeremos los datos del videojuego seleccionado y luego abrira una ventana para actualizar los datos
            if (source == btnUpdate) {
                if (jTable1.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "Tiene que seleccionar un videojuego", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    String titulo = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                    String categoria = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                    int min = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    int max = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                    int pegi = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
                    videojuego v = new videojuego(id, min, max, pegi, titulo, categoria);
                    FrameUpdate f = new FrameUpdate(v);
                    f.setVisible(true);
                }
            }
            // boton para actualizar la tabla manualmente
            if (source == btnshow) {
                Updatetable(null);
                JOptionPane.showMessageDialog(null, "Tabla actualizada");

            }
        }

    }

    //Actualizar tabla
    public void Updatetable(String category) {
        int indice = combocat.getSelectedIndex();
        int rowcount = modelo.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        videojuegoDAO vidDAO = new videojuegoDAO();
        switch (indice) {
            case 0:
                modelo = vidDAO.select_all(modelo);
                break;
            case 1:
                modelo = vidDAO.select_category(modelo, "Terror");
                break;
            case 2:
                modelo = vidDAO.select_category(modelo, "Acción");
                break;
            case 3:
                modelo = vidDAO.select_category(modelo, "Simulación");
                break;
            case 4:
                modelo = vidDAO.select_category(modelo, "Aventura");
                break;
        }
    }

    //Listener del combo para que nos muestre los juegos segun la categoria
    private class ListenerCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            videojuegoDAO vDAO = new videojuegoDAO();
            int indice = combocat.getSelectedIndex();
            switch (indice) {
                case 0:
                    Updatetable(null);
                    break;
                case 1:
                    Updatetable("Terror");
                    break;
                case 2:
                    Updatetable("Acción");
                    break;
                case 3:
                    Updatetable("Simulación");
                    break;
                case 4:
                    Updatetable("Aventura");
                    break;
            }

        }

    }
}
