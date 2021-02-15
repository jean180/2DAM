/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.producto;

/**
 *
 * @author jean_
 */
public class GestionProductos {
    public static void alta_producto(producto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Comienzo de transacción
        tx.begin();

        //persistir objeto
        em.persist(p);

        //Acabamos transacción
        tx.commit();

        //Cerramos EntityManager
        em.close();
    }
    public static List<producto> recuperar_productos(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comenzamos transacción
        tx.begin();
        
        //Ejecutamos Query
        TypedQuery<producto> qr = em.createNamedQuery("producto.findAll", producto.class);
        
        List<producto> productos = qr.getResultList();
        
        //Acabamos transacción
        tx.commit();
        
        //Cerramos EntityManager
        em.close();
        
        return productos;
    }
  
     public producto find_productos(int id_producto) {
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comienzo de transacción
        tx.begin();
        producto c = em.find(producto.class, id_producto);
        
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
