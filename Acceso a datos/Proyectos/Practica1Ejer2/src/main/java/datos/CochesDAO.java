/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Coches;
import domain.Propietarios;

/**
 *
 * @author jeaagu
 */
public class CochesDAO {
    
    private static final String SQL_SELECT_PROPIETARIO = "SELECT * FROM propietarios";
    private static final String SQL_SELECT = "SELECT Matricula, Marca, Precio, DNI FROM coches";
    private static final String SQL_SELECT_GENERAL = "SELECT * FROM Propietarios, Coches WHERE Propietarios.DNI=Coches.DNI AND Propietarios.DNI=?";
    
    private static final String SQL_INSERT = "INSERT INTO coches (Matricula, Marca, Precio, DNI) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE coches SET Matricula = ?, Marca = ?, Precio = ?, DNI = ? WHERE Matricula=?";
    private static final String SQL_DELETE = "DELETE FROM coches WHERE Matricula=?";
    private static final String SQL_DELETE_COCHE = "DELETE FROM coches WHERE DNI=?";
    
    public List<Coches> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Coches coche = null;
        List<Coches> coches = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int precio = rs.getInt("Precio");
                String matricula = rs.getString("Matricula");
                String marca = rs.getString("Marca");
                String dni = rs.getString("DNI");
                coche = new Coches(precio, matricula, marca, dni);
                coches.add(coche);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return coches;
    }
    
    public String seleccionar_general(String dni) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Propietarios propietario = null;
        String resultado = "";
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GENERAL);
            stmt.setString(1, dni);
            rs = stmt.executeQuery();
            resultado = "Coches del usuario con DNI: " + dni + ":\n";
            while (rs.next()) {
                resultado += rs.getString("DNI");
                resultado += ", " + rs.getString("Nombre");
                resultado += ", " + rs.getInt("Edad");
                resultado += ", " + rs.getString("Matricula");
                resultado += ", " + rs.getString("Marca");
                resultado += ", " + rs.getInt("Precio") + "\n";
            }
        } catch (Exception e) {
        }
        return resultado;
    }
    
    public int insertar(Coches coche) {
        Connection conn = null;
        Connection conn2 = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        int registros = 0;
        try {
            conn2 = Conexion.getConnection();
            stmt2 = conn2.prepareStatement(SQL_SELECT_PROPIETARIO);
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            rs = stmt2.executeQuery();
            while (rs.next()) {
                if (coche.getDNI().equalsIgnoreCase(rs.getString("DNI"))) {
                    stmt.setString(1, coche.getMatricula());
                    stmt.setString(2, coche.getMarca());
                    stmt.setInt(3, coche.getPrecio());
                    stmt.setString(4, coche.getDNI());
                    registros = stmt.executeUpdate();
                    System.out.println("introducido");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt2);
                close(stmt);
            } catch (SQLException e) {
            }
            try {
                close(conn2);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Coches coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, coche.getMatricula());
            stmt.setString(2, coche.getMarca());
            stmt.setInt(3, coche.getPrecio());
            stmt.setString(4, coche.getDNI());
            stmt.setString(5, coche.getMatricula());
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
    
    public int borrar(Coches coche) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, coche.getMatricula());
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
    
    public int borrar_Con_DNI(String DNI) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_COCHE);
            stmt.setString(1, DNI);
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
