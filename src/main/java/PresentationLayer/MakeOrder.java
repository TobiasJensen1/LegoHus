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
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class MakeOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession sesh = request.getSession();
        User user = (User)sesh.getAttribute("user");
        
        int H = Integer.parseInt(request.getParameter("height"));
        int L = Integer.parseInt(request.getParameter("length"));
        int W = Integer.parseInt(request.getParameter("width"));
        
        LegoBricks lb = LegoFactory.buildLegoHouse(user, H, L, W);
        
        LogicFacade.makeOrder(user, H, L, W);
        
        request.setAttribute("order", lb);
        request.setAttribute("height", H);
        request.setAttribute("length", L);
        request.setAttribute("width", W);

        return "WEB-INF/" +"vieworder";
    }
    
}
