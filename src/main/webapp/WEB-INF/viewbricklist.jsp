<%-- 
    Document   : viewbricklist
    Created on : 22-03-2018, 22:19:45
    Author     : tobbe
--%>

<%@page import="FunctionLayer.LegoBricks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
LegoBricks lb = (LegoBricks)request.getAttribute("bricklist");
int height = (int)request.getAttribute("height");

String bricklist = lb.toHtml(height);


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
        <title>Brick List Page</title>
    </head>
    <body>
        <h1>Brick List for chosen order:
        
        <%=bricklist%>
        
        <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">
            <input type="submit" name="home" value="Back to homepage">
        </form>
        
        
        </h1>
    </body>
</html>
