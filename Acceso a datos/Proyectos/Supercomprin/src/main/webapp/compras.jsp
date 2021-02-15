<%-- 
    Document   : compras
    Created on : 2-feb-2021, 19:44:14
    Author     : jean_
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="modelo.GestionCompras,java.util.ArrayList,mx.com.gm.sga.domain.compra"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Compras</title>
    </head>
    <body>
        <ul>
            <li><a href="menu.html">Home</a></li>
            <li><a href="Controller?op=doRecuperar_cliente">Clientes</a></li>
            <li><a href="Controller?op=doRecuperar_compra">Compras</a></li>
            <li><a href="Controller?op=doRecuperar_devolucion">devoluciones</a></li>
            <li><a href="Controller?op=doRecuperar_producto">Productos</a></li>
        </ul>
        <c:set var="compras" value="${requestScope.compras}"/>

        <br>
        <center>
            <button onclick="nueva_compra()">Pagar compra</button>
            <button onclick="nueva_devolucion()">Devolver compra</button>
        </center>
        <br>
        <c:choose>

            <c:when test="${!empty compras}">

                <center><table border="1">
                        <tr>
                            <th>id_compra</th>
                            <th>id cliente</th>
                            <th>id_producto</th>
                            <th>Fecha</th>
                            <th>Puntos</th>
                            <th>Importe</th>

                        </tr>

                        <c:forEach var="com" items="${compras}">
                            <tr>
                                <td>${com.id_compra}</td>
                                <td>${com.cliente}</td>
                                <td>${com.id_producto}</td>
                                <td>${com.fecha}</td>
                                <td>${com.puntos}</td>
                                <td>${com.importe}</td>

                            </tr>
                        </c:forEach>

                    </table></center>

            </c:when>
            <c:otherwise>
                <center><h1>No hay Compras</h1></center>
                </c:otherwise>
            </c:choose>
        <script>
            function nueva_compra() {
                window.open("nueva_compra.html", "nueva_compra", "width=600,height=600", false);
            }
            function nueva_devolucion() {
                window.open("nueva_devolucion.html", "nueva_devolucion", "width=600,height=600", false);
            }
        </script>
    </body>
</html>
