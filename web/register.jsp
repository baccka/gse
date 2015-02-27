<%-- 
    Document   : register
    Created on : Feb 26, 2015, 2:33:00 PM
    Author     : Matthew
--%>

<%@page import="persistence.CustomerFacade"%>
<%@page import="persistence.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        Customer newCustomer =  new Customer();
        newCustomer.setEmail(email);
        newCustomer.setPassword(pass);
        newCustomer.setId(2);
        
        CustomerFacade cf = new CustomerFacade();
        cf.create(newCustomer);
        
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register USER</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
