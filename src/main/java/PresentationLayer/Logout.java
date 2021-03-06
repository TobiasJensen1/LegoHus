/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LegoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobbe
 */
public class Logout extends Command {

    public Logout() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession sesh = request.getSession();
        sesh.setAttribute("user", null);
        
        return "index";
    }
    
}
