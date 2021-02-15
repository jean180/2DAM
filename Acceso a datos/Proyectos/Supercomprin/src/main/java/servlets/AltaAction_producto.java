/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionProductos;
import mx.com.gm.sga.domain.producto;

/**
 *
 * @author jean_
 */
@WebServlet("/AltaAction_producto")
public class AltaAction_producto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        int puntos = Integer.parseInt(request.getParameter("puntos"));
        
        GestionProductos gestion_pr = new GestionProductos();
        producto p = new producto(nombre, precio, puntos);
        gestion_pr.alta_producto(p);
        request.getRequestDispatcher("close.html").forward(request, response);
    }
}
