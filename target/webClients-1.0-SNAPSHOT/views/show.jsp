<%-- 
    Document   : list
    Created on : 08/02/2018, 04:24:08 PM
    Author     : george
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
    <h1>Lista  Artículos</h1>
    <table>
        <tr>
            <td><a href="cliente?action=index" >Ir al menú</a> </td>
        </tr>
    </table>

    <table border="1" width="100%">
        <tr>
            <td> ID</td>
            <td> CÉDULA</td>
            <td> NOMBRES</td>
            <td> APELLIDOS</td>
            <td colspan=2>ACCIONES</td>
        </tr>
        <c:forEach var="client" items="${lista}">
        <tr>
            <td><c:out value="${client.id}"/></td>
            <td><c:out value="${client.cedula}"/></td>
            <td><c:out value="${client.nombres}"/></td>
            <td><c:out value="${client.apellidos}"/></td>
            <td><a href="cliente?action=updateForm&id=<c:out value="${client.id}" />">Editar</a></td>
            <td><a href="cliente?action=delete&id=<c:out value="${client.id}"/>">Eliminar</a> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
