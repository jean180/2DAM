/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionCompras;

/**
 *
 * @author jean_
 */
@WebServlet("/EliminarAction_compra")
public class EliminarAction_compra extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_compra = Integer.parseInt(request.getParameter("id_compra"));
        GestionCompras gestion_com = new GestionCompras();
        gestion_com.eliminar_compra(id_compra);
        request.getRequestDispatcher("RecuperarAction_compra").forward(request, response);
    }
}
