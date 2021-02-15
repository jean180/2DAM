/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.devolucion;

/**
 *
 * @author jean_
 */
public class GestionDevoluciones {
    public static void alta_devolucion(devolucion d){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comenzamos transacción
        tx.begin();
        
        //Peristir objeto
        em.persist(d);
        
        //Acabamos transacción
        tx.commit();
        
        //cerramos EntityManager
        em.close();
    }
    
    public static List<devolucion> recuperar_devoluciones() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comenzmos transacción
        tx.begin();
        
        //ejecutamos Query
        TypedQuery<devolucion> qr = em.createNamedQuery("devolucion.findAll", devolucion.class);
        List<devolucion> devoluciones = qr.getResultList();
        
        //Acabamos transacción
        tx.commit();;
        
        //Cerramos EntityManager
        em.close();
        
        return devoluciones;
    }
    
     public devolucion find_devoluciones(int id_devolucion) {
        boolean encontrado = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SupercomprinPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Comienzo de transacción
        tx.begin();
        devolucion c = em.find(devolucion.class, id_devolucion);
        
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
