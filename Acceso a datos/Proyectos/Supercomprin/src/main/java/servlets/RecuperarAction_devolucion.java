/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionDevoluciones;
import mx.com.gm.sga.domain.devolucion;

/**
 *
 * @author jean_
 */
@WebServlet("/RecuperarAction_devolucion")
public class RecuperarAction_devolucion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionDevoluciones gestion_dev = new GestionDevoluciones();
        List<devolucion> devoluciones = gestion_dev.recuperar_devoluciones();
        request.setAttribute("devoluciones", devoluciones);
        request.getRequestDispatcher("devoluciones.jsp").forward(request, response);

    }
}
