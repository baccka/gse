<%-- 
    Document   : login
    Created on : Feb 23, 2015, 2:27:18 PM
    Author     : Matthew
--%>

<%@page import="persistence.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        
        Customer newCustomer = new Customer();
        newCustomer.setEmail(email);
        newCustomer.setPassword(password);
        
        newCustomer.validateUser(password);
        %>
    <head> 

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        
    </body>
</html>
