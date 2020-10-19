/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JButton backwards, forward, search, all;
    private JLabel e1, e2, e3;
    private JTextField id, idSearch;
    private JTextArea notes;
    private listener myListener;//This line will fail until the istener class is created

    public frame() {
        //Usual properties of windows
        setSize(800, 200);
        setTitle("Acces to MySQL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Instance of design panels
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        add(panel1);
        panel1.add(panel3, BorderLayout.SOUTH);
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.NORTH);

        //SOuth panel with scroll buttons
        backwards = new JButton("<");
        forward = new JButton(">");
        panel3.add(backwards);
        panel3.add(forward);

        //central panel with data
        e1 = new JLabel("ID");
        id = new JTextField(10);
        panel2.add(e1);
        panel2.add(id);
        e2 = new JLabel("notes");
        notes = new JTextArea(5, 40);
        panel2.add(e2);
        panel2.add(notes);

        //north panel with searches
        e3 = new JLabel("ID to find:");
        idSearch = new JTextField(10);
        search = new JButton("Search");
        all = new JButton("All");
        panel4.add(e2);
        panel4.add(idSearch);
        panel4.add(search);
        panel4.add(all);

        // add listeners, this line will fail until the listener class is not created
        myListener = new listener(id, notes, idSearch, backwards, forward, search, all);
        backwards.addActionListener((ActionListener) myListener);
        forward.addActionListener((ActionListener) myListener);
        search.addActionListener((ActionListener) myListener);
        all.addActionListener((ActionListener) myListener);
        //initially motion buttons disabled
        forward.setEnabled(false);
        backwards.setEnabled(false);

    }
}
