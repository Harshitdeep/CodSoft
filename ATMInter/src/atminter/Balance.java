package atminter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {
     public int balanceam(int username,String pwd){
         int bal;
       try{
//           System.out.println("balan"+username);
//           System.out.println("balan"+pwd);
            Connection con = new DbConnection().connect();
            String qry="Select balance from admin where card_no='"+username+"' and pin='"+pwd+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                bal=rs.getInt("balance");
                return bal;
            }
            else{
               return 0;
            }  
}
       catch(SQLException e){
         return 0;   
       }
     }
}