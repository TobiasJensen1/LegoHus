package DBAccess;

import FunctionLayer.LegoException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to insert the desired information to the 'Users' table in our database

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LegoException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            st.setString( 1, user.getEmail() );
            st.setString( 2, user.getPassword() );
            st.setString( 3, user.getRole() );
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt( 1 );
            user.setid( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LegoException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement st = con.prepareStatement( SQL );
            st.setString( 1, email );
            st.setString( 2, password );
            ResultSet rs = st.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setid( id );
                return user;
            } else {
                throw new LegoException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }

}
