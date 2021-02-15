<%-- 
    Document   : devoluciones
    Created on : 2-feb-2021, 19:48:02
    Author     : jean_
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="modelo.GestionDevoluciones,java.util.ArrayList,mx.com.gm.sga.domain.devolucion"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de devoluciones</title>
    </head>
    <body>
        <ul>
            <li><a href="menu.html">Home</a></li>
            <li><a href="Controller?op=doRecuperar_cliente">Clientes</a></li>
            <li><a href="Controller?op=doRecuperar_compra">Compras</a></li>
            <li><a href="Controller?op=doRecuperar_devolucion">Devoluciones</a></li>
            <li><a href="Controller?op=doRecuperar_producto">Productos</a></li>
        </ul>
        <c:set var="devoluciones" value="${requestScope.devoluciones}"/>
        <br>
        <c:choose>

            <c:when test="${!empty devoluciones}">

                <center><table border="1">
                        <tr>
                            <th>id_devolucion</th>
                            <th>id_cliente</th>
                            <th>id_producto</th>
                            <th>Fecha</th>
                            <th>Puntos</th>
                            <th>Importe</th>

                        </tr>

                        <c:forEach var="dev" items="${devoluciones}">
                            <tr><td>${dev.id_devolucion}</td>
                                <td>${dev.cliente}</td>
                                <td>${dev.id_producto}</td>
                                <td>${dev.fecha}</td>
                                <td>${dev.puntos}</td>
                                <td>${dev.importe}</td>
                            </tr>
                        </c:forEach>

                    </table></center>

            </c:when>
            <c:otherwise>
                <center><h1>No hay compras devueltas</h1></center>
                </c:otherwise>
            </c:choose>


    </body>
</html>
