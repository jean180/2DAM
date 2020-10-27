/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {
    
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton print, izquierda, derecha;
    private JList list1, list2;
    private int position;
    
    private List<client> clients;
    
    private DefaultListModel listModel1 = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    
    public frame() {
        setTitle("Selection and print");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel principal
        panel1.setLayout(new GridLayout(1, 3));
        client c = new client();
        try {
            Connection_DB connection_BD = new Connection_DB();
            Connection con = connection_BD.OpenConnection();
            ClientDAO clientDAO = new ClientDAO();
            clients = clientDAO.findAll(con);
            connection_BD.CloseConnection(con);
            //change the first client
            position = 0;
            c = clients.get(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Iterator<client> it = clients.iterator();
        while (it.hasNext()) {
            client next = it.next();
            listModel1.addElement(client);
        }
        for (int i = 0; i < 10; i++) {
            listModel1.addElement("ID" + i);
        }
        list1 = new JList(listModel1);
        list1.setVisibleRowCount(20);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel1.add(new JScrollPane(list1));
        derecha = new JButton(">>>");
        izquierda = new JButton("<<<");
        print = new JButton("Print");
        panel2.setLayout(new GridLayout(3, 1));
        panel2.add(derecha);
        panel2.add(izquierda);
        panel2.add(print);
        panel1.add(panel2);
        list2 = new JList(listModel2);
        list2.setVisibleRowCount(20);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel1.add(new JScrollPane(list2));
        add(panel1);

        //Acciones
        derecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Obtengo el indice del elemento seleccionado de la list1
                int index = list1.getSelectedIndex();
                if (index >= 0) {
                    //Si hay algún elemento seleccionado de la list1
                    listModel2.addElement(listModel1.getElementAt(index));
                    listModel1.remove(index);
                }
                
            }
        });
        
        izquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = list2.getSelectedIndex();
                if (index >= 0) {
                    //Si hay algún elemento seleccionado de la list1
                    listModel1.addElement(listModel2.getElementAt(index));
                    listModel2.remove(index);
                }
                
            }
        });
        
    }
}
