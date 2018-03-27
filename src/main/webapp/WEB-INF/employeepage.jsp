<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<% HttpSession sesh = request.getSession();
User user = (User) sesh.getAttribute("user");
String email = user.getEmail();
%>
<html>
        <style>
        html{
    background-image: url(image/lego.jpg) ;
    
    background-size: cover;
    height: 100%;
    background-repeat: no-repeat;
    
    color: white;
    text-align: center;
}
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        <link href="legoCss.css" rel="stylesheet" type="text/css"/>
        <h1>Hello <%=email%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        Here you can see all orders within the system and mark them as sent.
        
         <form name="viewAllOrdersAsEmp" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewAllOrdersAsEmp">
            <input type="submit" value="View all orders">
        </form>
        <form name="logout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="logout">
        </form>
    </body>
</html>
