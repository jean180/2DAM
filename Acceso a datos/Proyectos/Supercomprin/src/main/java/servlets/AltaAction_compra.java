/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionClientes;
import modelo.GestionCompras;
import modelo.GestionProductos;
import mx.com.gm.sga.domain.cliente;
import mx.com.gm.sga.domain.compra;
import mx.com.gm.sga.domain.producto;

/**
 *
 * @author jean_
 */
@WebServlet("/AltaAction_compra")
public class AltaAction_compra extends HttpServlet {

    private static final long SerialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_producto = Integer.parseInt(request.getParameter("id_producto"));
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Date fecha;
        LocalDate now = LocalDate.now();
        fecha = Date.valueOf(now);
        GestionCompras gestion_com = new GestionCompras();
        GestionProductos gestion_pro = new GestionProductos();
        producto pro = gestion_pro.find_productos(id_producto);
        GestionClientes gestion_cli = new GestionClientes();
        cliente cl = gestion_cli.find_cliente(id_cliente);
        if (!gestion_cli.buscar_cliente(id_cliente)) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('la id del cliente no existe en la base de datos');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("nueva_compra.html");
            rd.include(request, response);
        } else if (!gestion_pro.buscar_producto(id_producto)) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('la id del producto no existe en la base de datos');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("nueva_compra.html");
            rd.include(request, response);
        }else if (cl.getSaldo() - pro.getPrecio() <= 0) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('El saldo no es suficiente');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("nueva_compra.html");
            rd.include(request, response);
        } else {
            cl.setPuntos(cl.getPuntos() + pro.getPuntos());
            cl.setSaldo(cl.getSaldo() - pro.getPrecio());
            compra com = new compra(cl, id_producto, fecha, pro.getPuntos(), pro.getPrecio());
            gestion_com.alta_compra(com, cl);

            request.getRequestDispatcher("close.html").forward(request, response);
        }

    }

}
