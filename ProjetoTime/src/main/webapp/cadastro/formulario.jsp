<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Time</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Formulário de Time</h1>
    <jsp:useBean id="t" class="org.libertas.Time" scope="request" />
    <jsp:useBean id="tdao" class="org.libertas.TimeDao" scope="request" />
    <jsp:setProperty property="*" name="t" />
    <% 
        if (request.getParameter("idtime") != null) {
            t = tdao.consultar(Integer.parseInt(request.getParameter("idtime")));
        }
    %>
    <form action="gravar.jsp" method="post">
        <input type="hidden" name="idtime" value="${t.idtime}" />
        <div class="form-group">
            <label>Nome do Time:</label>
            <input type="text" class="form-control" name="nome" value="${t.nome}" required />
        </div>
        <div class="form-group">
            <label>Fundação:</label>
            <input type="text" class="form-control" name="fundacao" value="${t.fundacao}" required />
        </div>
        <div class="form-group">
            <label>Estádio:</label>
            <input type="text" class="form-control" name="estadio" value="${t.estadio}" required />
        </div>
        <div class="form-group">
            <label>Treinador:</label>
            <input type="text" class="form-control" name="treinador" value="${t.treinador}" required />
        </div>
        <button type="submit" class="btn btn-success">Salvar</button>
        <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
