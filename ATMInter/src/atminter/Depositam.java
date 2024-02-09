package atminter;
import files.Error;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Depositam {
    public Depositam(int username,int amountc,String pwd){
        int userid=0;
         try{
             Connection con = new DbConnection().connect();
            String qry="Select id from admin where card_no='"+username+"'";
            PreparedStatement pst=con.prepareStatement(qry); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                userid=rs.getInt("id");
            }
            else{
                    Error ee=new Error();
                    ee.setVisible(true);
            }
         }
         catch(SQLException e){
             System.out.println("Error = "+e);
               Error ee=new Error();
               ee.setVisible(true);  
         }
        int balance=0;
        try{
            Connection con = new DbConnection().connect();
            String qry2="Select balance from admin where id='"+userid+"'";
            PreparedStatement pst=con.prepareStatement(qry2); 
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                balance=rs.getInt("balance")+amountc;
            }
      
           try{
               Connection con1 = new DbConnection().connect();
            String qry1="Insert into transaction(userid,amount,balance,t_type,date) values ('"+userid+"','"+amountc+"','"+balance+"','cred','"+java.time.LocalDate.now()+"')";
               PreparedStatement pst1=con1.prepareStatement(qry1); 
               pst1.executeUpdate();
               try{
                   Connection con2 = new DbConnection().connect();
            String qry3="Update admin set balance="+balance+" where id='"+userid+"'";
               PreparedStatement pst2=con2.prepareStatement(qry3); 
               pst2.executeUpdate();
            }
        catch(SQLException e){
            System.out.println("Error = "+e);
             Error ee=new Error();
             ee.setVisible(true);   
        }
        }
        catch(SQLException e){
            System.out.println("Error = "+e);
             Error ee=new Error();
             ee.setVisible(true);   
        }
        }
        catch(SQLException e){
            System.out.println("Error = "+e);
                Error ee=new Error();
                ee.setVisible(true);
        }
    }
}

