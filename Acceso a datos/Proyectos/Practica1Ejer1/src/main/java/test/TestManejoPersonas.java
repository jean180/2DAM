/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author jeaagu
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("indica que quieres hacer");
            System.out.println("1-Mostrar usuarios");
            System.out.println("2-Insertar usuario");
            System.out.println("3-Borrar usuario");
            System.out.println("4-Actualizar usuario");
            System.out.println("5-Salir");

            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    Opcion3();
                    break;
                case 4:
                    Opcion4();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
//        UsuarioDAO usuarioDao = new UsuarioDAO();
//        List<Usuario> usuarios = usuarioDao.seleccionar();
//
//        /*insertando nuevo objeto de tipo persona
//        Usuario usuarioNuevo = new Usuario("Juan", "contra");
//        usuarioDao.insertar(usuarioNuevo);*/
//
// /*actualizando objeto de tipo persona 
//        Usuario usuarioActualizar = new Usuario(1, "Juan", "contra1");
//        usuarioDao.actualizar(usuarioActualizar);*/
//
// /*Borrando objeto de tipo persona
//        Usuario usuarioBorrar = new Usuario(1);
//        usuarioDao.borrar(usuarioBorrar);*/
//        usuarios.forEach(usuario -> {
//            System.out.println("usuario = " + usuario);
//        });

    }

    public static void Opcion1() throws SQLException {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
    }

    public static void Opcion2() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("indique el id del usuario");
        int id = teclado.nextInt();
        System.out.println("Indica el nombre del usuario");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        teclado.nextLine();
        System.out.println("Indica la contraseña del usuario");
        String contra = teclado.next();
        Usuario usuario = new Usuario(id, contra, contra);
        usuarioDAO.insertar(usuario);
    }

    public static void Opcion3() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("indique el id del usuario");
        int id = teclado.nextInt();
        teclado.nextLine();
        Usuario usuario = new Usuario(id);
        usuarioDAO.insertar(usuario);
    }

    public static void Opcion4() throws SQLException {
        Scanner teclado = new Scanner(System.in);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("indique el id del usuario");
        int id = teclado.nextInt();
        System.out.println("Indica el nombre del usuario");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        teclado.nextLine();
        System.out.println("Indica la contraseña del usuario");
        String contra = teclado.next();
        Usuario usuario = new Usuario(id, contra, contra);
        usuarioDAO.actualizar(usuario);
    }
}
