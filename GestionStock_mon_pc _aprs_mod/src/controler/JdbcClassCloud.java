/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

//import PW.MotDePasse;
//import Objets.Professeur;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import java.util.ArrayList;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class JdbcClassCloud {

    private Connection connection = null;
//    private final String url = "jdbc:mysql://46.252.181.108:3306/bqnlbfacof0ccz0gn2zh";
  //   private final String url = "jdbc:mysql://bqnlbfacof0ccz0gn2zh-mysql.services.clever-cloud.com:3306/bqnlbfacof0ccz0gn2zh";
   private final String url = "jdbc:mysql://ujvwhawmnumlba0i:hbcs5pM05dGLrfug8a4a@bqnlbfacof0ccz0gn2zh-mysql.services.clever-cloud.com:3306/bqnlbfacof0ccz0gn2zh";
    // private final String url = "jdbc:sqlite:sahraoui.db";  
   /* public Connection connect()throws Exception {
       46.252.181.108
        try {
              Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection(url);
        } catch (Exception sc) {
          JOptionPane.showMessageDialog(null, " erreur de connection,le fichier sqlitejdbc-v056 est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
        }

        return connection;
    }*/
    //
    
     public Connection connect()throws Exception {
       
        try {
              Class.forName("com.mysql.jdbc.Driver");
           // mysql://ujvwhawmnumlba0i:hbcs5pM05dGLrfug8a4a@bqnlbfacof0ccz0gn2zh-mysql.services.clever-cloud.com:3306/bqnlbfacof0ccz0gn2zh
        connection = DriverManager.getConnection(url,"ujvwhawmnumlba0i","hbcs5pM05dGLrfug8a4a");
        // connection = DriverManager.getConnection(url,"root","98521fatna$");
        } catch (Exception sc) {
         sc.printStackTrace();
        }

        return connection;
    }
  public  void setPW(String pw,String user)throws Exception{

        try {

           JdbcClassCloud j=new JdbcClassCloud();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
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
    public String getPW(String user) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
        String mp="";
        try {
             try (Connection conn = connect()) {
                 Statement stmt = conn.createStatement();
                 String sql = "SELECT password FROM users where username='"+user+"'";
                 ResultSet rs = stmt.executeQuery(sql);
                 
                 while (rs.next()) {
                     mp=rs.getString("password");
                 }
                 rs.close();
             }    
           
        } catch (SQLException sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        } 
        return mp;
    }
      
  /*  public ArrayList getListUsers() throws Exception {
       ImageIcon   img = new ImageIcon("images/erreur.GIF");
        ArrayList<String> ListUsers= new ArrayList<String>();
       
        try {

            Connection conn = connect();
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
   }



  

    

