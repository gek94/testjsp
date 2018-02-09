<%-- 
    Document   : edit
    Created on : 08/02/2018, 04:23:24 PM
    Author     : george
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Clientes</title>
</head>
<body>
<h1>Actualizar Cliente</h1>
    <form action="cliente?action=update" method="post" >
        <table>
            <tr>
                <td><label>Id</label></td>
                <td><input readonly="readonly" type="text" name="id" value='<c:out value="${client.id}"></c:out>' ></td>
            </tr>
            <tr>
                <td><label>Cédula</label></td>
                <td><input type="text" name="cedula" value='<c:out value="${client.cedula}"></c:out>' ></td>
            </tr>
            <tr>
                <td><label>Nombres</label></td>
                <td><input type="text" name="nombres" value='<c:out value="${client.nombres}"></c:out>' ></td>
            </tr>
            <tr>
                <td><label>Apellidos</label></td>
                <td><input type="text" name="apellidos" value='<c:out value="${client.apellidos}"></c:out>' ></td>
            </tr>
        </table>

        <input type="submit" name="guardar" value="Guardar"> 
    </form>

</body>
</html>
