<%-- 
    Document   : customerorders
    Created on : 22-03-2018, 19:19:41
    Author     : tobbe
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession sesh = request.getSession();
    User user = (User)sesh.getAttribute("user");
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
        <title>Customer Orders Page</title>
    </head>
    <body>
        <div>
            <h1>Your Orders:</h1><br>
            <table>
                <thead>
                    <tr>
                        <th>Orderid</th>
                        <th>Length</th>
                        <th>Width</th>
                        <th>Height</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <%=Order.orderToHtml(user)%>
            </table>
        </div>
            
            <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">
            <input type="submit" name="home" value="Back to homepage">
        </form>
    </body>
</html>
