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
import modelo.GestionProductos;
import mx.com.gm.sga.domain.producto;

/**
 *
 * @author jean_
 */
@WebServlet("/RecuperarAction_producto")
public class RecuperarAction_producto extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionProductos gestion_pro = new GestionProductos();
        List<producto> productos = gestion_pro.recuperar_productos();
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }
}
