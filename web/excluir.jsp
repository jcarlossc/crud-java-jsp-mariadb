<%-- 
    Document   : excluir
    Created on : 27/05/2023, 20:12:14
    Author     : Ewe
--%>
<%@page import="controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    
    Controller controller = new Controller();
    controller.setId(id);
    
    if(controller.delete()){
            
        response.sendRedirect("index.jsp?mensagem2=<b style='color:green'>Usuário excluído com sucesso.</b>");
    }else{
            
        response.sendRedirect("index.jsp?mensagem2=<b style='color:red'>Usuário não excluido.</b>");
    }
%>
