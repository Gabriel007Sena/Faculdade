<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Times</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Lista de Times</h1>
    <table class="table">
        <thead>
            <tr>
                <th>Nome do Time</th>
                <th>Fundação</th>
                <th>Estádio</th>
                <th>Treinador</th>
            </tr>
        </thead>
        <tbody>
            <jsp:useBean id="tdao" class="org.libertas.TimeDao" scope="request" />
            <c:forEach var="t" items="${tdao.listar()}">
                <tr>
                    <td>${t.nome}</td>
                    <td>${t.fundacao}</td>
                    <td>${t.estadio}</td>
                    <td>${t.treinador}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
