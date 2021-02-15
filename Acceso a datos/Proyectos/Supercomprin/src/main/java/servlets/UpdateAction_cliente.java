/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/UpdateAction_cliente")
public class UpdateAction_cliente extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        String DNI = request.getParameter("DNI");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String fecha = request.getParameter("fecha");
        String mail = request.getParameter("mail");

        java.util.Date fecha_parse;
        java.sql.Date fecha_final = null;

        try {
            fecha_parse = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            fecha_final = new java.sql.Date(fecha_parse.getTime());
        } catch (ParseException e) {
            Logger.getLogger(AltaAction_cliente.class.getName()).log(Level.SEVERE, null, e);
        }

        GestionClientes gestion_cl = new GestionClientes();

        if (!gestion_cl.buscar_cliente(id_cliente)) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('la id del cliente no existe en la base de datos');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("actualizar_cliente.html");
            rd.include(request, response);
        } else {
        cliente c = new cliente(DNI, nombre,apellidos, fecha_final, mail);
        
        gestion_cl.actualizar_cliente(c);
        request.getRequestDispatcher("close.html").forward(request, response);
        }
    }
}
