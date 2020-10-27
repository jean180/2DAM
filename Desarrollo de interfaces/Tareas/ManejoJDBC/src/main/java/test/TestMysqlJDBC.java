/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "123456");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT idpersona, Nombre, Apellidos, Edad FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(TestMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.out);
        }
    }
}
