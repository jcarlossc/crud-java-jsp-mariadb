<%-- 
    Document   : cadastrar
    Created on : 26/05/2023, 13:41:57
    Author     : Carlos da Costa
--%>
<%@page import="controller.Controller"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String primeiro_nome = request.getParameter("p_nome");
    String ultimo_nome = request.getParameter("u_nome");
    String telefone = request.getParameter("telefone");
    
    if(primeiro_nome == "" || ultimo_nome == "" || telefone == ""){
        
        response.sendRedirect("index.jsp?mensagem=<b style='color:red'>Digite as informações para cadastrar o usuário.</b>");
        
    }else{
    
        Controller controller = new Controller();
        controller.setFirst_name(primeiro_nome);
        controller.setLast_name(ultimo_nome);
        controller.setPhone(telefone);
        if(controller.save()){
            
            response.sendRedirect("index.jsp?mensagem=<b style='color:green'>Usuário cadastrado com sucesso.</b>");
        }else{
            
            response.sendRedirect("index.jsp?mensagem=<b style='color:red'>Usuário não cadastrado.</b>");
        }
    }
%>
