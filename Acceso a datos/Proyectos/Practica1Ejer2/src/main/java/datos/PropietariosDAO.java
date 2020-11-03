/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Propietarios;
import domain.Coches;

/**
 *
 * @author jeaagu
 */
public class PropietariosDAO {

    private static final String SQL_SELECT = "SELECT DNI, Nombre, Edad FROM propietarios";
    private static final String SQL_INSERT = "INSERT INTO propietarios (DNI, Nombre, Edad) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE propietarios SET DNI = ?, Nombre = ?, Edad = ? WHERE DNI=?";
    private static final String SQL_DELETE = "DELETE FROM propietarios WHERE DNI=?";
    private static final String SQL_DELETE_COCHE = "DELETE FROM coches WHERE DNI=?";

    public List<Propietarios> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietarios propietario = null;
        List<Propietarios> propietarios = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String dni = rs.getString("DNI");
                int edad = rs.getInt("Edad");
                propietario = new Propietarios(edad, dni, nombre);
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return propietarios;

    }

    public int insertar(Propietarios propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, propietario.getDNI());
            stmt.setString(2, propietario.getNombre());
            stmt.setInt(3, propietario.getEdad());
            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException e) {
            }
            try {
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Propietarios propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, propietario.getDNI());
            stmt.setString(2, propietario.getNombre());
            stmt.setInt(3, propietario.getEdad());
            stmt.setString(4, propietario.getDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException e) {
            }
            try {
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int borrar(Propietarios propietario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            CochesDAO cochesDAO = new CochesDAO();
            cochesDAO.borrar_Con_DNI(propietario.getDNI());
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, propietario.getDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {

                close(stmt);
            } catch (SQLException e) {
            }
            try {

                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
