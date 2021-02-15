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
import modelo.GestionClientes;
import mx.com.gm.sga.domain.cliente;

/**
 *
 * @author jean_
 */
@WebServlet("/RecuperarAction_cliente")
public class RecuperarAction_cliente extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        GestionClientes gestion_cl = new GestionClientes();
        List<cliente> clientes = gestion_cl.recuperar_clientes();
        
        request.setAttribute("clientes", clientes);
        
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
    
}
