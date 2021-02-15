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
import modelo.GestionClientes;

/**
 *
 * @author jean_
 */
@WebServlet("/EliminarAction_cliente")
public class EliminarAction_cliente extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        GestionClientes gestion_cl = new GestionClientes();
        gestion_cl.eliminar_cliente(id_cliente);
        request.getRequestDispatcher("RecuperarAction_cliente").forward(request, response);
    }
}
