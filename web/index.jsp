<%-- 
    Document   : index
    Created on : 26/05/2023, 10:33:03
    Author     : Carlos da Costa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.Controller"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGU</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <style>
            .titulo { padding-top: 30px; }
            #titulo { text-decoration: none; color: gray; }
            
        </style>
    </head>
    <body>
        <div class="container">
            <a href="index.jsp" id="titulo" class="text-dark"><h1 class="text-center mb-4 titulo">Sistema de gerenciamento de usuários</h1></a>
            <hr>
            <h4 class="text-center mb-4">Cadastro de usuário</h4>
            <%
                if(request.getParameter("mensagem") != null)
                out.write(request.getParameter("mensagem"));
            %>
            <form action="cadastrar.jsp" method="POST">
                <div class="mb-3">
                  <label for="idP_nome" class="form-label">Primeiro nome</label>
                  <input type="text" class="form-control" name="p_nome" id="p_nome">
                <div class="mb-3">
                    <label for="idU_nome" class="form-label">Último nome</label>
                    <input type="text" class="form-control" name="u_nome" id="u_nome">
                </div>
                <div class="mb-3">
                    <label for="idTelefone" class="form-label">Telefone</label>
                    <input type="text" class="form-control" name="telefone" id="telefone">
                </div>
                  <button type="submit" class="btn btn-primary">Cadastrar</button>
                  
            </form>
            <%
            Controller controller = new Controller();
            List<Controller> lista = controller.getAll();
            %>
            <hr>
            <h4 class="text-center mb-4">Lista de usuários</h4>
            <%
                if(request.getParameter("mensagem1") != null)
                out.write(request.getParameter("mensagem1"));
                
                if(request.getParameter("mensagem2") != null)
                out.write(request.getParameter("mensagem2"));
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Primeiro nome</th>
                        <th scope="col">Último nome</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < lista.size(); i++) {%>
                    <tr>
                        <td><%=lista.get(i).getId()%></td>
                        <td><%=lista.get(i).getFirst_name()%></td>
                        <td><%=lista.get(i).getLast_name()%></td>
                        <td><%=lista.get(i).getPhone()%></td>
                        <td><%out.write("<a href=atualizar-front.jsp?id=" + lista.get(i).getId() + ">" + "<button type='button' class='btn btn-primary'>Editar</button></a>");%></td>
                        <td><%out.write("<a href=excluir.jsp?id=" + lista.get(i).getId() + ">" + "<button type='button' class='btn btn-danger'>Excluir</button></a>");%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
