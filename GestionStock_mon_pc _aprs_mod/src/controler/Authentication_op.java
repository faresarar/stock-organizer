/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rais
 */
public class Authentication_op {
     private static Authentication_op obj=null;
    JdbcClassUser jdbcuser= JdbcClassUser.getInstance();
    //  JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
     
     public static Authentication_op getObj(){
        if(obj==null){
            try {
                obj=new Authentication_op();
            } catch (Exception ex) {
           //     Logger.getLogger(Authentication_op.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
    
   // JdbcClass m=new JdbcClass();
     /*public ArrayList getListUsers() throws Exception {
       ImageIcon   img = new ImageIcon("images/erreur.GIF");
        ArrayList<String> ListUsers= new ArrayList<String>();
       
        try {

            Connection conn = m.connect();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM users ";
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             ListUsers.add(rs.getString("username"));
           
        }
        rs.close();
        conn.close();    
           
        } catch (SQLException sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        } 
        return ListUsers;
    }

     */
     
/*public  void charger_user1( JComboBox users ){ 
   
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);

users.setRenderer(centr);
users.removeAllItems();


JdbcClass m=new JdbcClass();
       
       ArrayList<String> List_chou3ab= new ArrayList<String>();
        try {
 List_chou3ab=m.getListUsers();
      
     //recuper la liste des matieres a partir de la bdd
     
          for(String mat : List_chou3ab){
       //  wadifa_op op=new wadifa_op();
           //if(op.WadifaIsExist(mat.getNom_fonction())==false)    
       users.addItem(mat );

        }         
        } catch (Exception ex) {
        }
   
   
   }
*/

public  void charger_user( JComboBox users ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
users.setRenderer(centr);
users.removeAllItems();
//JdbcClass m=new JdbcClass();
//JdbcClassCloud m=new JdbcClassCloud();
 try {
           Connection conn = jdbcuser.Getconnection();
          
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
         //    ListUsers.add(rs.getString("username"));
             users.addItem(rs.getString("username") );
         //    System.out.println(rs.getString("username"));
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
       
    
   
   }

 public String getPW(String username) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
        String mp="";
       //   JdbcClass m=new JdbcClass();
        try {
            Connection conn = jdbcuser.Getconnection();
            Statement stmt = conn.createStatement();
              String sql = "SELECT password FROM users where username='"+username+"'";
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             mp=rs.getString("password");
        }
        rs.close();
        conn.close();    
           
        } catch (SQLException sc) {
            JOptionPane.showMessageDialog(null, " Erreur de connection a la BDD  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        } 
        return mp;
    }
 
  public  void setPW(String pw,String user)throws Exception{

        try {

         //  JdbcClassSingleton j=new JdbcClassSingleton();
             Connection conn = jdbcuser.Getconnection();
             //Statement stmt = conn.createStatement();
              String sql = "update users set password=? where username=?" ;
             PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, pw);
              pr.setString(2, user);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
            // ResultSet rs = stmt.executeQuery("select * from PassWord;");

        pr.close();
        conn.close();

        } catch (SQLException sc) {
           // throw new Exception(sc.getMessage(), sc);
        }



   }
 
 
 
 
 
}
