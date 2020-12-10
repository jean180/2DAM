/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.videojuegoDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.TitledBorder;
import model.videojuego;

/**
 *
 * @author jean_
 */
public class FrameUpdate extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelid, panelTitulo, panelCategoria, panelmin, panelmax, panelpegi;
    private JTextField txtTitulo, txtMin, txtMax;
    private JLabel lblId;
    private JComboBox comboCategory, comboPegi;
    private String[] cats = {"Terror", "Acción", "Simulación", "Aventura"};
    private String[] pegis = {"3", "7", "12", "16", "18"};
    private JButton btnEnviar;

    public FrameUpdate(videojuego v) {
        setSize(400, 350);
        setTitle("Actualizar videojuego");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel.setLayout(new GridLayout(6, 1));
        add(panel, BorderLayout.CENTER);

        //Ponemos en los campos a rellenar los datos del juego seleccionado, para que sea mas facil y rapida la edición de dichos datos
        panelid = new JPanel();
        panelid.setLayout(new BorderLayout());
        TitledBorder titleId = BorderFactory.createTitledBorder("Id: ");
        panelid.setBorder(titleId);
        lblId = new JLabel(String.valueOf(v.getId()));
        panelid.add(lblId, BorderLayout.CENTER);
        panel.add(panelid);

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        TitledBorder titleTitulo = BorderFactory.createTitledBorder("Titulo: ");
        panelTitulo.setBorder(titleTitulo);
        txtTitulo = new JTextField();
        txtTitulo.setText(v.getTitulo());
        panelTitulo.add(txtTitulo, BorderLayout.CENTER);
        panel.add(panelTitulo);

        panelCategoria = new JPanel();
        panelCategoria.setLayout(new BorderLayout());
        TitledBorder titleCategoria = BorderFactory.createTitledBorder("Categoria: ");
        panelCategoria.setBorder(titleCategoria);
        comboCategory = new JComboBox(cats);
        for (int i = 0; i < cats.length; i++) {
            if (v.getCategoria().equalsIgnoreCase(cats[i])) {
                comboCategory.setSelectedIndex(i);
            }
        }
        panelCategoria.add(comboCategory, BorderLayout.CENTER);
        panel.add(panelCategoria);

        panelmin = new JPanel();
        panelmin.setLayout(new BorderLayout());
        TitledBorder tituloMin = BorderFactory.createTitledBorder("Minimo Jugadores: ");
        panelmin.setBorder(tituloMin);
        txtMin = new JTextField();
        txtMin.setText(String.valueOf(v.getMin_jugadores()));
        panelmin.add(txtMin);
        panel.add(panelmin, BorderLayout.CENTER);

        panelmax = new JPanel();
        panelmax.setLayout(new BorderLayout());
        TitledBorder titleMax = BorderFactory.createTitledBorder("Máximo Jugadores: ");
        panelmax.setBorder(titleMax);
        txtMax = new JTextField();
        txtMax.setText(String.valueOf(v.getMax_jugadores()));
        panelmax.add(txtMax);
        panel.add(panelmax, BorderLayout.CENTER);

        panelpegi = new JPanel();
        panelpegi.setLayout(new BorderLayout());
        TitledBorder titlePegi = BorderFactory.createTitledBorder("PEGI: ");
        panelpegi.setBorder(titlePegi);
        comboPegi = new JComboBox(pegis);
        for (int i = 0; i < pegis.length; i++) {
            if (String.valueOf(v.getPegi()).equalsIgnoreCase(pegis[i])) {
                comboPegi.setSelectedIndex(i);
            }
        }
        panelpegi.add(comboPegi);
        panel.add(panelpegi, BorderLayout.CENTER);

        btnEnviar = new JButton("Actualizar");
        add(btnEnviar, BorderLayout.SOUTH);
        btnEnviar.addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Si algún de los Jtextfield esta vacio salta un warning
            if (txtTitulo.getText().isBlank() || txtMin.getText().isBlank() || txtMax.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos en blanco", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    int id = Integer.parseInt(lblId.getText().toString());
                    String titulo = txtTitulo.getText();
                    String categoria = null;
                    int indiceCategory = comboCategory.getSelectedIndex();
                    switch (indiceCategory) {
                        case 0:
                            categoria = "Terror";
                            break;
                        case 1:
                            categoria = "Acción";
                            break;
                        case 2:
                            categoria = "Simulación";
                            break;
                        case 3:
                            categoria = "Aventura";
                            break;
                    }
                    int min = Integer.parseInt(txtMin.getText());
                    if (min < 1) { //Si el numero minimo de jugadores es menor a 1 salta un warning
                        JOptionPane.showMessageDialog(null, "el minimo de jugadores no puede ser inferior a 1", "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {

                        int max = Integer.parseInt(txtMax.getText());
                        if (max < min) { //Si el numero minimo de jugadores es menor a el numero minimo salta un warning
                            JOptionPane.showMessageDialog(null, "El máximo de jugadores no puede ser inferior al minimo", "WARNING", JOptionPane.WARNING_MESSAGE);
                        } else {

                            int Pegi = 0;
                            int indicePegi = comboPegi.getSelectedIndex();
                            switch (indicePegi) {
                                case 0:
                                    Pegi = 3;
                                    break;
                                case 1:
                                    Pegi = 7;
                                    break;
                                case 2:
                                    Pegi = 12;
                                    break;
                                case 3:
                                    Pegi = 16;
                                    break;
                                case 4:
                                    Pegi = 18;
                                    break;
                            }
                            int reply = JOptionPane.showConfirmDialog(null, "¿Actualizar el videojuego  \"" + titulo + "\"?", "ACTUALIZAR", JOptionPane.YES_NO_OPTION);
                            if (reply == JOptionPane.YES_OPTION) {

                                videojuego videojuego = new videojuego(id, min, max, Pegi, titulo, categoria);
                                videojuegoDAO vDAO = new videojuegoDAO();
                                vDAO.update(videojuego);
                                JOptionPane.showMessageDialog(null, "Videojuego actualizado");
                            }
                        }
                    }
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "Ha sucedido un error en el proceso", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

}
