<%-- 
    Document   : productos
    Created on : 3-feb-2021, 19:53:52
    Author     : jean_
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="modelo.GestionProductos,java.util.ArrayList,mx.com.gm.sga.domain.producto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gesti�n de Productos</title>
    </head>
    <body>
        <ul>
            <li><a href="menu.html">Home</a></li>
            <li><a href="Controller?op=doRecuperar_cliente">Clientes</a></li>
            <li><a href="Controller?op=doRecuperar_compra">Compras</a></li>
            <li><a href="Controller?op=doRecuperar_devolucion">Devoluciones</a></li>
            <li><a href="Controller?op=doRecuperar_producto">Productos</a></li>
        </ul>    
        <c:set var="productos" value="${requestScope.productos}"/>
        <br>
        <center>
            <button onclick="nuevo_producto()">Agregar nuevo producto</button>
        </center>
        <c:choose>

            <c:when test="${!empty productos}">

                <center><table border="1">
                        <tr>
                            <th>id_producto</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Puntos</th>   
                        </tr>

                        <c:forEach var="pro" items="${productos}">
                            <tr><td>${pro.id_producto}</td>
                                <td>${pro.nombre}</td>
                                <td>${pro.precio}</td>
                                <td>${pro.puntos}</td>

                            </tr>
                        </c:forEach>

                    </table></center>

            </c:when>
            <c:otherwise>
                <center><h1>No hay Productos</h1></center>
                </c:otherwise>
            </c:choose>
        <br>
        <script>
            function nuevo_producto() {
                window.open("nuevo_producto.html", "nuevo_producto", "width=600,height=600", false);
            }
        </script>
    </body>
</html>
