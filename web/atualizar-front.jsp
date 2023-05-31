<%-- 
    Document   : atualizar-front
    Created on : 26/05/2023, 21:42:41
    Author     : Carlos da Costa
--%>
<%@page import="controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGU</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
            .titulo { padding-top: 30px; }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center mb-4 titulo">Sistema de gerenciamento de usuários</h1>
            <hr>
            <h4 class="text-center mb-4">Atualizar usuário</h4>
            <form action="atualizar.jsp" method="POST">
                <div class="mb-3">
                  <label for="id" class="form-label">Id</label>
                  <input type="text" class="form-control" name="id" readonly="true" id="id" value="<%out.write("" + request.getParameter("id"));%>">
                </div>
                <div class="mb-3">
                  <label for="idP_nome" class="form-label">Primeiro nome</label>
                  <input type="text" class="form-control" name="p_nome" id="p_nome">
                </div>
                <div class="mb-3">
                    <label for="idU_nome" class="form-label">Último nome</label>
                    <input type="text" class="form-control" name="u_nome" id="u_nome">
                </div>
                <div class="mb-3">
                    <label for="idTelefone" class="form-label">Telefone</label>
                    <input type="text" class="form-control" name="telefone" id="telefone">
                </div>
                  <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>
        </div>
    </body>
</html>
