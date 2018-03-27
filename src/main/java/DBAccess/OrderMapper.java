/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LegoException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Purpose of OrderMapper is to insert and give us the desired information from our database regarding the 'Orders' table
 *
 * @author tobbe
 */
public class OrderMapper {

    public static void makeOrder(User user, int height, int length, int width) throws LegoException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (height, length, width, status, id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, height);
            st.setInt(2, length);
            st.setInt(3, width);
            st.setString(4, "Not Sent");
            st.setInt(5, user.getid());
            st.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getOrdersByUser(User user) throws LegoException {
        ArrayList<Order> output = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "Select * from orders where id = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, user.getid());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String status = rs.getString("status");

                Order order = new Order(orderid, height, length, width, status, user.getid());

                output.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
        return output;
    }

    public static Order getOrderByOrderId(int orderid) throws LegoException {
        Order output = null;

        try {
            Connection con = Connector.connection();
            String SQL = "Select * from orders where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, orderid);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String status = rs.getString("status");
                int userid = rs.getInt("id");

                output = new Order(orderid, height, length, width, status, userid);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
        return output;
    }

    public static ArrayList<Order> getAllOrders() throws LegoException {
        ArrayList<Order> output = new ArrayList();
        Order order = null;

        try {
            Connection con = Connector.connection();
            String SQL = "Select * from orders";
            PreparedStatement st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int orderid = rs.getInt("orderid");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                String status = rs.getString("status");
                int userid = rs.getInt("id");

                order = new Order(orderid, height, length, width, status, userid);

                output.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
        return output;
    }

    public static void sendOrderById(int orderid) throws LegoException {
        Order output = null;

        try {
            Connection con = Connector.connection();
            String SQL = "Update orders set status = ? where orderid = ?";
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, "Sent");
            st.setInt(2, orderid);
            st.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LegoException(ex.getMessage());
        }
    }
}
