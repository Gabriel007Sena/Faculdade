<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gravação de Time</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:useBean id="t" class="org.libertas.Time" scope="request" />
    <jsp:useBean id="tdao" class="org.libertas.TimeDao" scope="request" />
    <jsp:setProperty property="*" name="t" />

    <%
        tdao.salvar(t);
    %>

    <div class="alert alert-success" role="alert">
        Registro salvo com sucesso!
    </div>
    <a class="btn btn-primary" href="index.jsp">OK</a>
</div>
</body>
</html>
