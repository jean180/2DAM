/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtablemysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author jeaagu
 */
public class Frame extends JFrame {

    JTable jTable1;
    DefaultTableModel modelo = new DefaultTableModel();

    public Frame() {
        setTitle("Clientes");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jTable1 = new JTable();
        jTable1.setModel(modelo);
        //Configuration columns of the DefaultTableModel
        Object[] tags = new Object[2];
        tags[0] = "id";
        tags[1] = "notes";
        modelo.setColumnIdentifiers(tags);
        anydefFilarDeDatos(modelo);

        JScrollPane jscrollpanel1 = new JScrollPane(jTable1);

        add(jscrollpanel1);
    }

    public static void anydefFilarDeDatos(DefaultTableModel modelo) {
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Connection con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "123456"));
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM clients");
            int rowNumber = 0;
            while (rs.next()) {
                Object[] rowData = new Object[modelo.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                modelo.addRow(rowData);
                rowNumber++;
            }
            rs.close();
            s.close();
            con.close();
        } catch (SQLException e) {
        }
    }

}
