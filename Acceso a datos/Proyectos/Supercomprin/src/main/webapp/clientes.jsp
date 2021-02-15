<%-- 
    Document   : clientes
    Created on : 2-feb-2021, 18:44:25
    Author     : jean_
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="modelo.GestionClientes,java.util.ArrayList,mx.com.gm.sga.domain.cliente"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestión de Clientes</title>
    </head>
    <body>
        <ul>
            <li><a href="menu.html">Home</a></li>
            <li><a href="Controller?op=doRecuperar_cliente">Clientes</a></li>
            <li><a href="Controller?op=doRecuperar_compra">Compras</a></li>
            <li><a href="Controller?op=doRecuperar_devolucion">Devoluciones</a></li>
            <li><a href="Controller?op=doRecuperar_producto">Productos</a></li>
        </ul>
        <c:set var="clientes" value="${requestScope.clientes}"/>

        <br><br><br>
        <center>
            <button onclick="nuevo_cliente()">Agregar nuevo cliente</button>
            <button onclick="actualizar_cliente()">Actualizar cliente</button>
        </center>

        <br>
        <c:choose>

            <c:when test="${!empty clientes}">

                <center><table border="1">
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Email</th>
                            <th>Fecha nacimiento</th>
                            <th>Puntos</th>
                            <th>Saldo</th>
                            <th></th>

                        </tr>

                        <c:forEach var="cli" items="${clientes}">
                            <tr>
                                <td>${cli.id_cliente}</td>
                                <td>${cli.DNI}</td>
                                <td>${cli.nombre}</td>
                                <td>${cli.apellidos}</td>
                                <td>${cli.mail}</td>
                                <td>${cli.fecha_nacimiento}</td>
                                <td>${cli.puntos}</td>
                                <td>${cli.saldo}</td>
                                <td><button class="button button1"><a href="Controller?op=doEliminar_cliente&id_cliente=${cli.id_cliente}">Eliminar</button></td>
                            </tr>
                        </c:forEach>

                    </table></center>

            </c:when>
            <c:otherwise>
                <center><h1>No hay Clientes</h1></center>
                </c:otherwise>
            </c:choose>
        <br>

        <script>
            function nuevo_cliente() {
                window.open("nuevo_cliente.html", "nuevo_cliente", "width=600,height=600", false);
            }
            function actualizar_cliente() {
                window.open("actualizar_cliente.html", "actualizar_cliente", "width=600,height=600", false);
            }
        </script>
    </body>
</html>
