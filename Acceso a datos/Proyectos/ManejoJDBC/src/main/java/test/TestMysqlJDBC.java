/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeaagu
 */
public class TestMysqlJDBC {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //puede ser que sea requerido lo siguiente
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "123456");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT Id_persona, Nombre, Apellidos, Email,Edad FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("------------------------");
                System.out.println("id Persona: " + resultado.getInt("id_persona"));
                System.out.println("Nombre: " + resultado.getString("Nombre"));
                System.out.println("Apellidos: " + resultado.getString("Apellidos"));
                System.out.println("Email: " + resultado.getString("Email"));
                System.out.println("Edad persona: " + resultado.getInt("Edad"));
                System.out.println("------------------------");

            }
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            //Logger.getLogger(TestMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.out);
        }
    }
}
