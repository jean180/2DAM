/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author jeaagu
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();

        /*insertando nuevo objeto de tipo persona
        Persona personaNueva = new Persona(28, "Juan", "Rodriguez", "Juan@gmail.com");
        personaDao.insertar(personaNueva);
        
        actualizando objeto de tipo persona 
        Persona personaActualizar = new Persona(3, 28, "Juan", "Rodriguez Gimenez", "JuanR@gmail.com");
        personaDao.actualizar(personaActualizar); 
        
        Borrando objeto de tipo persona
        Persona personaBorrar = new Persona(2);
        personaDao.borrar(personaBorrar);*/
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }
}
