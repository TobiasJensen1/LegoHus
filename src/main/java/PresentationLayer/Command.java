package PresentationLayer;

import FunctionLayer.LegoException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "logout", new Logout() );
        commands.put( "home", new Home() );
        commands.put( "makeorder", new MakeOrder() );
        commands.put( "viewAllOrders", new ViewAllOrders() );
        commands.put( "viewAllOrdersAsEmp", new ViewAllOrdersAsEmp() );
        commands.put( "showBrickList", new ShowBrickList() );
        commands.put( "sendOrder", new SendOrder()) ;
        
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LegoException;

}
