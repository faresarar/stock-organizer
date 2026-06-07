/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


/**
 *
 * @author Rais
 */
public class User_op {
      private static User_op instance;   
public User_op(){}
public static User_op getInstance(){
if(instance==null){
    instance=new User_op();
}
return instance;
}
     JdbcClassUser jdbc= JdbcClassUser.getInstance();
    // ImageIcon   img = new ImageIcon("Images/erreur.GIF");
    


 
 
 public boolean Password_Reset() throws Exception {      
         boolean a=true;
     try {
           
            Connection conn = jdbc.Getconnection();
            String sql1 = "UPDATE users set password=? where username=?";
            PreparedStatement pr=conn.prepareStatement(sql1);
            pr.setString(1,"7110eda4d09e062aa5e4a390b0a572ac0d2c0220" );   
            pr.setString(2,"admin" );     
            pr.executeUpdate();  
            pr.close(); 
            conn.close();
        } catch (Exception sc) {
            a= false;
            JOptionPane.showMessageDialog(null, sc.getMessage());
       //    JOptionPane.showMessageDialog(null,"", " Erreur", JOptionPane.WARNING_MESSAGE, null);  
          sc.printStackTrace(); 
        }
        return a;
    }  

 
 
  
 
   
    
    
    
  
}
