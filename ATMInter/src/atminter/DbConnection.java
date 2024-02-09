package atminter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
    Connection con;
    public Connection connect(){
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmbank","root","");
        }catch(ClassNotFoundException | SQLException e){
            System.err.print("Error is="+e);
        }
        return con;
    }
}