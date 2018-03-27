<%-- 
    Document   : vieworder
    Created on : 21-03-2018, 03:26:00
    Author     : tobbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PresentationLayer.*" %>
<%@page import="FunctionLayer.*" %>
<!DOCTYPE html>
<% 
   HttpSession sesh = request.getSession();
   User user = (User)sesh.getAttribute("user");
   String email = user.getEmail();
   
   LegoBricks lb = (LegoBricks)request.getAttribute("order");
   int height = (int)request.getAttribute("height");
   int length = (int)request.getAttribute("length");
   int width = (int)request.getAttribute("width");
   
   String order = lb.toHtml(height);
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
        <title>View Orders Page</title>
    </head>
    <body>
       
        <h1>Congratulations <%=email%> <br> </h1>
        You have succesfully made an order of a lego house sized:<br>
        Height(in lego bricks): <%=height%> <br>
        Length(in lego dots): <%=length%> <br>
        Width(in lego dots): <%=width%> <br>
            
        Brick List: <br>
            
        
        
        <%= order %>
        
        <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">
            <input type="submit" name="home" value="Back to homepage">
        </form>
         
        <br> Thank you for your purchase, you can see all your orders and the bricklist to all orders at the homepage!
        
    </body>
</html>
