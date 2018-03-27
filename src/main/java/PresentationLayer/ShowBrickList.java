/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoBricks;
import FunctionLayer.LegoException;
import FunctionLayer.LegoFactory;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class ShowBrickList extends Command {

    public ShowBrickList() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession sesh = request.getSession();
        User user = (User)sesh.getAttribute("user");
        
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        Order order = LogicFacade.getOrderByOrderId(orderid);
        
        int height = order.getHeight();
        int length = order.getLength();
        int width = order.getWidth();
        
        LegoBricks lb = LegoFactory.buildLegoHouse(user, height, length, width);
        
        request.setAttribute("bricklist", lb);
        request.setAttribute("height", height);
        
        return "WEB-INF/" + "viewbricklist";
    }
    
}
