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
import modelo.GestionCompras;
import mx.com.gm.sga.domain.compra;

/**
 *
 * @author jean_
 */
@WebServlet("/RecuperarAction_compra")
public class RecuperarAction_compra extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionCompras gestion_com = new GestionCompras();
        List<compra> compras = gestion_com.recuperar_compra();

        request.setAttribute("compras", compras);
        request.getRequestDispatcher("compras.jsp").forward(request, response);
    }
}
