<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
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
        <title>Customer home page</title>
    </head>
    <body>
       
        <h1>Hello <%=email%> </h1>
        <h2 class="custom">
        You are now logged in as a customer of our wonderful site.<br>
        
        On this website, we can tell you how many lego bricks you would need in order to create a legohouse of your desired size.<br>
        In the fields below you can enter the size of your legohouse, and we will tell you how many bricks you would need to order.<br>
        The bricks we offer are 4x2, 2x2 and 2x1.
        </h2>
        <form name="makeorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="makeorder">
            Desired height(in lego bricks):
            <input type="text" name="height"><br>
            Desired length(in lego dots):
            <input type="text" name="length"><br>
            Desired width(in lego dots):
            <input type="text" name="width"><br>
            <input type="submit" value="Submit">
        </form>
        <form name="viewAllOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="viewAllOrders">
            <input type="submit" value="View all orders">
        </form>
        <form name="logout" action="FrontController" method="POST">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="logout">
        </form>
        
    </body>
</html>
