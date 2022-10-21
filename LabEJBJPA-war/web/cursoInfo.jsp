<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="cursoservlet" method="POST">
            <table>
                <tr>
                    <td>Curso ID</td>
                    <td><input type="text" name="cursoId" value="${curso.cursoId}" /></td>
                </tr>
                <tr>
                    <td>Nombre del curso</td>
                    <td><input type="text" name="nombre" value="${curso.nombre}" /></td>
                </tr>
                <tr>
                    <td>Números de créditos</td>
                    <td><input type="text" name="creditos" value="${curso.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curso.semestre}" /></td>
                </tr>
                <tr>
                    <td>Número de estudiantes admitidos</td>
                    <td><input type="text" name="numeroestudiantes" value="${curso.numeroestudiantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Curso ID</th>
            <th>Nombre del curso</th>
            <th>Números de crédito</th>
            <th>Semestre</th>
            <th>Número de estudiantes admitidos</th>
                <c:forEach items="${allCursos}" var="curso">
                <tr>
                    <td>${curso.cursoId}</td>
                    <td>${curso.nombre}</td>
                    <td>${curso.creditos}</td>
                    <td>${curso.semestre}</td>
                    <td>${curso.numeroestudiantes}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
