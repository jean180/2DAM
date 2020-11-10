/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author jeaagu
 */
public class TestManejoPersonas {

    public static void main(String[] args){
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Persona cambioPersona = new Persona();
            cambioPersona.setId_Persona(1);
            cambioPersona.setNombre("Karla Ivonnesaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            cambioPersona.setApellidos("Gomez");
            cambioPersona.setEmail("kgomez@gmail.com");
            cambioPersona.setEdad(23);
            personaDAO.actualizar(cambioPersona);
//            Persona nuevaPersona = new Persona();
//            nuevaPersona.setNombre("Carlos");
//            nuevaPersona.setApellidos("Ramirez");
//            nuevaPersona.setEmail("CRamirez@gmail.com");
//            personaDAO.insertar(nuevaPersona);
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace(System.out);
            }
        }

    }
}
