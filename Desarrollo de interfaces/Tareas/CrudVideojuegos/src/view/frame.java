/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    JPanel panel1 = new JPanel();
    JPanel panelTabla = new JPanel();
    JPanel panelBtns = new JPanel();
    JButton btnAdd, btnRm, btnUpdate;
    JTable jTable1 = new JTable();
    DefaultTableModel modelo = new DefaultTableModel();

    public frame() {
        setTitle("Videojuegos");
        setSize(1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());

        jTable1.setModel(modelo);
        Object[] tags = new Object[7];
        tags[0] = "ID";
        tags[1] = "TITULO";
        tags[2] = "CATEGORÍA";
        tags[3] = "MINIMO JUGADORES";
        tags[4] = "MÁXIMO JUGADORES";
        tags[5] = "PEGI";
        tags[6] = "MULTIJUGADOR";
        modelo.setColumnIdentifiers(tags);
        JScrollPane jScrollPane = new JScrollPane(jTable1);
        panelTabla.add(jScrollPane);
        panel1.add(panelTabla);

        btnAdd = new JButton("Añadir");

        panel1.add(btnAdd);

        btnUpdate = new JButton("Actualizar");

        panel1.add(btnUpdate);

        btnRm = new JButton("Eliminiar");

        panel1.add(btnRm);
        add(panel1);
    }
}
