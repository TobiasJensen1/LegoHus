/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author tobbe
 */
public class Order {
    private int orderid;
    private int height;
    private int length;
    private int width;
    private String status;
    private int userid;

    public Order(int orderid, int height, int length, int width, String status, int userid) {
        this.orderid = orderid;
        this.height = height;
        this.length = length;
        this.width = width;
        this.status = status;
        this.userid = userid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", height=" + height + ", length=" + length + ", width=" + width + ", status=" + status + ", userid=" + userid + '}';
    }
    
    
    public static String orderToHtml(User user) throws LegoException{
       
       String output = "<tbody>";
        ArrayList<Order> order = LogicFacade.getOrdersByUser(user);

        for (Order orders : order) {
            output += "<tr>"
                    + "<td>" + orders.getOrderid() + "</td>"
                    + "<td>" + orders.getLength() + "</td>"
                    + "<td>" + orders.getWidth() + "</td>"
                    + "<td>" + orders.getHeight() + "</td>"
                    + "<td>" + orders.getStatus() + "</td>"
                    + "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"command\" value=\"showBrickList\">"
                    + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                    + "<input type=\"submit\" value=\"Show Brick List\">"
                    + "</form></td>"

                    + "</tr>";
    } 

    output += "</tbody>";

    return output;
    }
   
    public static String empOrderToHtml() throws LegoException{
       
       String output = "<tbody>";
        ArrayList<Order> order = LogicFacade.getAllOrders();

        for (Order orders : order) {
            output += "<tr>"
                    + "<td>" + orders.getOrderid() + "</td>"
                    + "<td>" + orders.getLength() + "</td>"
                    + "<td>" + orders.getWidth() + "</td>"
                    + "<td>" + orders.getHeight() + "</td>"
                    + "<td>" + orders.getStatus() + "</td>"
                    + "<td><form name=\"order\" action=\"FrontController\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"command\" value=\"showBrickList\">"
                    + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                    + "<input type=\"submit\" value=\"Show Brick List\">"
                    + "</form></td>"
                    + "<td><form name=\"sendOrder\" action=\"FrontController\" method=\"POST\">"
                    + "<input type=\"hidden\" name=\"command\" value=\"sendOrder\">"
                    + "<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getOrderid() + "\">"
                    + "<input type=\"submit\" value=\"Send Order\">"
                    + "</form></td>"

                    + "</tr>";
    } 

    output += "</tbody>";

    return output;
    }
}
