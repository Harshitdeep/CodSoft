package atminter;
import files.Error;
import files.Withdraw;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Debited {
    int balance1=0;
    boolean n;
    public Debited(int username,int amountd,String pwd){
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
                balance1=rs.getInt("balance");
                balance=rs.getInt("balance")-amountd;
            }
            if(balance1>=amountd){
                try{
               Connection con1 = new DbConnection().connect();
            String qry1="Insert into transaction(userid,amount,balance,t_type,date) values ('"+userid+"','"+amountd+"','"+balance+"','deb','"+java.time.LocalDate.now()+"')";
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
                n=true;
                Withdraw withdraw=new Withdraw(n);
            }
            else{
                n=false;
                Withdraw withdraw=new Withdraw(n);
            }
        }
        catch(SQLException e){
            System.out.println("Error = "+e);
                Error ee=new Error();
                ee.setVisible(true);
        }
    }
} 
