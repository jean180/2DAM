/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import java.util.*;
import java.sql.*;
import domain.Persona;

/**
 *
 * @author jeaagu
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_personas, Nombre, Apellidos, Email, Edad FROM personas";

    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String email = rs.getString("Email");
                int edad = rs.getInt("Edad");
                persona = new Persona(idPersona, edad, nombre, apellidos, email);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;

    }
}
