package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LegoException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LegoException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static void makeOrder(User user, int height, int length, int width) throws LegoException{
        OrderMapper.makeOrder(user, height, length, width);
    }
    
    public static ArrayList<Order> getOrdersByUser(User user) throws LegoException{
        ArrayList<Order> allUserOrders = OrderMapper.getOrdersByUser(user);
        return allUserOrders;
    }
    
    public static Order getOrderByOrderId(int id) throws LegoException{
        Order order = OrderMapper.getOrderByOrderId(id);
        return order;
    }
    
    public static ArrayList<Order> getAllOrders() throws LegoException{
        ArrayList<Order> allOrders = OrderMapper.getAllOrders();
        return allOrders;
    }
    
    public static void sendOrderById(int orderid) throws LegoException{
        OrderMapper.sendOrderById(orderid);
    }

    
}
