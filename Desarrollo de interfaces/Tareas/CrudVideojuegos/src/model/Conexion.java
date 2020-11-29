/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jeaagu
 */
import java.sql.*;

public class Conexion {

    public static Connection OpenConnection() throws Exception {
        Connection con = null; //Install a connection
        try {
            String urlOdbc = "jdbc:mysql://localhost:3306/id?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            // create connection
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "123456"));
            return con;
        } catch (Exception e) {//SQLException and classNotFoundException
            e.printStackTrace();
            throw new Exception("Connection could not be established" + e.getMessage());
        }
    }

    public static void CloseConnection(Connection con) throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("it was impossible to lose the connection" + e.getMessage());
        }
    }
}
