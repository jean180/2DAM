/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeaagu
 */
public class Frame extends JFrame {

    Object[][] data = new Object[][]{
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true},
        {"Alfonso González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Aturias", new Long(984454454), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(612804804), true}
    };
    String[] headers = new String[]{
        "Name", "Address", "Telephone", "car?"
    };

    public Frame() {
        setSize(400, 500);
        setTitle("Telephone numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Headers for the columns of the table
        //Data for the table
        JTable jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(data, headers) {
            Class[] tipoColumn = {String.class, String.class, Long.class, Boolean.class};

            //Override the getColumncClass method
            @Override
            public Class getColumnClass(int indColumn) {
                return tipoColumn[indColumn];
            }
        });

        JScrollPane jscrollpanel1 = new JScrollPane(jTable1);
        add(jscrollpanel1);

    }

}
