/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.cliente;

/**
 *
 * @author jean_
 */
public class GestionClientes {

    public static void alta_cliente(cliente c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comienzo de transacción
        tx.begin();

        //persistir objeto
        em.persist(c);

        //Acabamos transacción
        tx.commit();

        //Cerramos EntityManager
        em.close();
    }

    public static void eliminar_cliente(int id_cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comienzo de transacción
        tx.begin();
        cliente c = em.find(cliente.class, id_cliente);

        // remove del objeto
        if (c != null) {
            em.remove(c);
        }

        //Acabamos transacción
        tx.commit();

        //Cerramos EntityManager
        em.close();
    }

    public static List<cliente> recuperar_clientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Comienzo de transacción
        tx.begin();

        //Ejecutamos el Query
        TypedQuery<cliente> qr = em.createNamedQuery("cliente.findAll", cliente.class);

        List<cliente> clientes = qr.getResultList();

        //Acabamos transacción
        tx.commit();

        //Cerramos EntityManager
        em.close();

        return clientes;
    }

    public void actualizar_cliente(cliente c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comienzo de transacción
        tx.begin();

        TypedQuery<cliente> qr = em.createNamedQuery("cliente.update", cliente.class);

        qr.setParameter(1, c.getNombre());
        qr.setParameter(2, c.getApellidos());
        qr.setParameter(3, c.getMail());
        qr.setParameter(4, c.getFecha_nacimiento());
        qr.setParameter(5, c.getDNI());
        
        qr.executeUpdate();
        
        //Acabamo transacción
        tx.commit();
        
        //Cerramos EntityManager
        em.close();

    }
    
    public cliente find_cliente(int id_cliente) {
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comienzo de transacción
        tx.begin();
        cliente c = em.find(cliente.class, id_cliente);
        
        //Si encontramos el cliente
        if (c!=null) {
            encontrado = true;
        }
        
        //Acabamos transacción
        tx.commit();
        
        //Cerramos EntityManager
        em.close();
        
        return c;
        
    }
    public boolean buscar_cliente(int id_cliente) {
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comienzo de transacción
        tx.begin();
        cliente c = em.find(cliente.class, id_cliente);
        
        //Si encontramos el cliente
        if (c!=null) {
            encontrado = true;
        }
        
        //Acabamos transacción
        tx.commit();
        
        //Cerramos EntityManager
        em.close();
        
        return encontrado;
        
    }
}
