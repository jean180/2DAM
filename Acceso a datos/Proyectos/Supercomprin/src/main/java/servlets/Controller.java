package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String url = "";
        switch (op) {
            case "doAlta_cliente":
                url = "AltaAction_cliente";
                break;

            case "doUpdate_cliente":
                url = "UpdateAction_cliente";
                break;

            case "doEliminar_cliente":
                url = "EliminarAction_cliente";
                break;

            case "doRecuperar_cliente":
                url = "RecuperarAction_cliente";
                break;

            case "doAlta_compra":
                url = "AltaAction_compra";
                break;

            case "doRecuperar_compra":
                url = "RecuperarAction_compra";
                break;

            case "doEliminar_compra":
                url = "EliminarAction_compra";
                break;

            case "doAlta_devolucion":
                url = "AltaAction_devolucion";
                break;

            case "doRecuperar_devolucion":
                url = "RecuperarAction_devolucion";
                break;

            case "doRecuperar_producto":
                url = "RecuperarAction_producto";
                break;
            case "doAlta_producto":
                url = "AltaAction_producto";
                break;

            case "toMenu":
                url = "menu.html";
                break;

        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
