/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jeaagu
 */
public class listener implements ActionListener {

    private JTextField id, idSearch;
    private JTextArea notes;
    private JButton backwards, forward, search, all;
    private List<client> clients;
    private int position;

    public listener(JTextField id, JTextArea notes, JTextField idSearch, JButton backwards, JButton forward, JButton search, JButton all) {
        this.id = id;
        this.notes = notes;
        this.idSearch = idSearch;
        this.backwards = backwards;
        this.forward = forward;
        this.search = search;
        this.all = all;
        position = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        client c = new client();
        //FINS A CLIENT
        if (ae.getSource() == this.search) {
            //in search hes disabled movement buttons
            forward.setEnabled(false);
            backwards.setEnabled(false);
            try {
                Connection_DB connection_DB = new Connection_DB();
                Connection con = connection_DB.OpenConnection();
                ClientDAO clientDAO = new ClientDAO();
                c.setId(idSearch.getText());
                c = clientDAO.findByid(con, c);
                connection_DB.CloseConnection(con);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //LOAD ALL CLIENTS
        if (ae.getSource() == this.all) {
            //on all motion buttons enabled
            forward.setEnabled(true);
            backwards.setEnabled(true);
            position = 0;
            //All clients:
            try {
                Connection_DB connection_BD = new Connection_DB();
                Connection con = connection_BD.OpenConnection();
                ClientDAO clientDAO = new ClientDAO();
                clients = clientDAO.findAll(con);
                connection_BD.CloseConnection(con);
                //change the first client
                position = 0;
                c= clients.get(position);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //AHEAD
        if (ae.getSource()== this.forward) {
            position++;
            if (position == clients.size()) {
                position--;
            }
            c = clients.get(position);
        }
        
        //BEHIND
        if (ae.getSource() == this.backwards) {
            if (position>0) {
                position--;
            }
            c = clients.get(position);
        }
        update(c);
    }

    private void update (client c){
        this.id.setText(c.getId());
        this.notes.setText(c.getNotes());
    }
}
