/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionClientes;
import modelo.GestionCompras;
import modelo.GestionDevoluciones;
import mx.com.gm.sga.domain.cliente;
import mx.com.gm.sga.domain.compra;
import mx.com.gm.sga.domain.devolucion;

/**
 *
 * @author jean_
 */
@WebServlet("/AltaAction_devolucion")
public class AltaAction_devolucion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_compra = Integer.parseInt(request.getParameter("Id_compra"));

        Date fecha;
        LocalDate now = LocalDate.now();
        fecha = Date.valueOf(now);
        GestionCompras gestion_com = new GestionCompras();
        compra com = gestion_com.find_compas(id_compra);
        
        GestionDevoluciones gestion_dev = new GestionDevoluciones();
        GestionClientes gestion_cl = new GestionClientes();
        cliente cl = gestion_cl.find_cliente(com.getCliente().getId_cliente());
        
        devolucion dev = new devolucion(cl, com.getId_producto(), id_compra, fecha, com.getPuntos(), com.getImporte());
        gestion_dev.alta_devolucion(dev);
        gestion_com.eliminar_compra(id_compra);

        request.getRequestDispatcher("close.html").forward(request, response);

    }
}
