/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Conexion;
import model.videojuego;

/**
 *
 * @author jean_
 */
public class videojuegoDAO {

    // Sentencias SQL
    private static String SQL_SELECT_ALL = "SELECT * FROM videojuegos";
    private static String SQL_SELECT_CATEGORY = "SELECT * FROM videojuegos WHERE categoria = ?";
    private static String SQL_INSERT = "INSERT INTO videojuegos (titulo, categoria, min_jugadores, max_jugadores, PEGI) VALUES (?,?,?,?,?)";
    private static String SQL_DELETE = "DELETE FROM videojuegos WHERE id_videojuegos = ?";
    private static String SQL_UPDATE = "UPDATE videojuegos SET titulo = ?, categoria = ?, min_jugadores = ?, max_jugadores = ?, PEGI = ? WHERE id_videojuegos = ?";

    //Seleccionar todos
    public DefaultTableModel select_all(DefaultTableModel model) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        videojuego v;

        try {
            con = Conexion.OpenConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_SELECT_ALL);

            while (rs.next()) {
                v = new videojuego(rs.getInt("id_videojuegos"), rs.getInt("min_jugadores"), rs.getInt("max_jugadores"), rs.getInt("PEGI"), rs.getString("titulo"), rs.getString("categoria"));
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = v.getId();
                rowData[1] = v.getTitulo();
                rowData[2] = v.getCategoria();
                rowData[3] = v.getMin_jugadores();
                rowData[4] = v.getMax_jugadores();
                rowData[5] = v.getPegi();
                model.addRow(rowData);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return model;
    }

    
    //Seleccionar por categoria
    public DefaultTableModel select_category(DefaultTableModel model, String category) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        videojuego v;

        try {
            con = Conexion.OpenConnection();
            stmt = con.prepareStatement(SQL_SELECT_CATEGORY);
            stmt.setString(1, category);
            rs = stmt.executeQuery();

            while (rs.next()) {
                v = new videojuego(rs.getInt("id_videojuegos"), rs.getInt("min_jugadores"), rs.getInt("max_jugadores"), rs.getInt("PEGI"), rs.getString("titulo"), rs.getString("categoria"));
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = v.getId();
                rowData[1] = v.getTitulo();
                rowData[2] = v.getCategoria();
                rowData[3] = v.getMin_jugadores();
                rowData[4] = v.getMax_jugadores();
                rowData[5] = v.getPegi();
                model.addRow(rowData);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return model;
    }

    //Insertar nuevo videojuego
    public int insert(videojuego v) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = Conexion.OpenConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, v.getTitulo());
            stmt.setString(2, v.getCategoria());
            stmt.setInt(3, v.getMin_jugadores());
            stmt.setInt(4, v.getMax_jugadores());
            stmt.setInt(5, v.getPegi());
            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return registros;
    }

    //Borrar videojuego
    public int delete(videojuego v) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = Conexion.OpenConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, v.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return registros;
    }

    //Actualizar videojuego
    public int update(videojuego v) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = Conexion.OpenConnection();
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, v.getTitulo());
            stmt.setString(2, v.getCategoria());
            stmt.setInt(3, v.getMin_jugadores());
            stmt.setInt(4, v.getMax_jugadores());
            stmt.setInt(5, v.getPegi());
            stmt.setInt(6, v.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return registros;
    }
}
