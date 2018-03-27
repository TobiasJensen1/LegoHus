/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoException;
import FunctionLayer.LogicFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class SendOrder extends Command {

    public SendOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession sesh = request.getSession();
        User user = (User)sesh.getAttribute("user");
        int orderid =  Integer.parseInt(request.getParameter("orderid"));
        
        LogicFacade.sendOrderById(orderid);
        
        return "WEB-INF/" + user.getRole() + "orders";
    }
    
}
