<%-- 
    Document   : atualizar
    Created on : 26/05/2023, 21:32:26
    Author     : Carlos da Costa
--%>
<%@page import="controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String primeiro_nome = request.getParameter("p_nome");
    String ultimo_nome = request.getParameter("u_nome");
    String telefone = request.getParameter("telefone");
    
    if(primeiro_nome == "" || ultimo_nome == "" || telefone == ""){
        
        response.sendRedirect("index.jsp?mensagem1=<b style='color:red'>Digite as informações para atualizar o usuário.</b>");
        
    }else{
    
        Controller controller = new Controller();
        controller.setId(id);
        controller.setFirst_name(primeiro_nome);
        controller.setLast_name(ultimo_nome);
        controller.setPhone(telefone);
        if(controller.update()){
            
            response.sendRedirect("index.jsp?mensagem1=<b style='color:green'>Usuário Atualizado com sucesso.</b>");
        }else{
            
            response.sendRedirect("index.jsp?mensagem1=<b style='color:red'>Usuário não cadastrado.</b>");
        }
    }
%>
