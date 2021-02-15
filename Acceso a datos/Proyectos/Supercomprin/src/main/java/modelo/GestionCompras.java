/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.cliente;
import mx.com.gm.sga.domain.compra;

/**
 *
 * @author jean_
 */
public class GestionCompras {

    public static void alta_compra(compra c, cliente cl) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comenzamos transacción
        tx.begin();
        
        em.merge(cl);
        //persistencia de objeto
        em.persist(c);

        //Acabamos tranasacción
        tx.commit();

        //Cerramos EntityManager
        em.close();
    }

    public static void eliminar_compra(int id_compra) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comenzamos transacción
        tx.begin();
        compra c = em.find(compra.class, id_compra);

        //Eliminar objeto
        if (c != null) {
            em.remove(c);
        }

        //Acabamos transaccion
        tx.commit();

        //Cerramos EntityManager
        em.close();
    }

    public static List<compra> recuperar_compra() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comenzamos transacción
        tx.begin();

        //ejecutamos el query
        TypedQuery<compra> qr = em.createNamedQuery("compra.findAll", compra.class);
        List<compra> compras = qr.getResultList();

        //Acabamos la transacción
        tx.commit();

        //cerramos el objeto EntityManeger
        em.close();
        
        return compras;
    }
    
     public compra find_compas(int id_compra) {
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comienzo de transacción
        tx.begin();
        compra c = em.find(compra.class, id_compra);
        
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
}
