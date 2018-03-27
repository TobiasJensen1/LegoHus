<%-- 
    Document   : employeeorders
    Created on : 23-03-2018, 11:39:09
    Author     : tobbe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

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
        <title>Employee Orders Page</title>
    </head>
    <body>
        <div>
            <h1>All Orders in system:</h1><br>
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
                <%=Order.empOrderToHtml()%>
            </table>
        </div>
            
            <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">
            <input type="submit" name="home" value="Back to homepage">
        </form>
    </body>
</html>
