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
import java.util.Properties;
//import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JdbcClassSingleton {
    private static JdbcClassSingleton jdbc;
   // DataBase_op dbop=DataBase_op.getInstance();
    private JdbcClassSingleton(){}
     static  String ipAdress="127.0.0.1";
     static  String DataBase="gestion";
     static  String port="3306";
     
     public static JdbcClassSingleton getInstance() {    
                                     if (jdbc==null)  
                                   {  
                                            jdbc=new  JdbcClassSingleton();  
                                   }  
                         return jdbc;  
             }  

    private static Connection connection = null;
    private static  String url = "jdbc:mysql://127.0.0.1:3306/gestion";
    // private final String url = "jdbc:sqlite:sahraoui.db";  
   /* public Connection connect()throws Exception {
       
        try {
              Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection(url);
        } catch (Exception sc) {
          JOptionPane.showMessageDialog(null, " erreur de connection,le fichier sqlitejdbc-v056 est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
        }

        return connection;
    }*/
    //
    
       public  Connection Getconnection()throws Exception {
       connection = null;
       url = "jdbc:mysql://127.0.0.1:3306/";
     
      try {
              Properties prop=new Properties();
  //FileInputStream ip= new FileInputStream("src/controler/Config.properties");
   FileInputStream ip= new FileInputStream("Config.properties");
      try {
          prop.load(ip);
        
      //    CreateTables("bdd4");
          
          
      } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), " Erreur de connection ", JOptionPane.WARNING_MESSAGE, null);
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      }
    ipAdress=  prop.getProperty("ip");
    DataBase=prop.getProperty("database");
    port=prop.getProperty("port");
   
 
  url=url.replace("127.0.0.1", ipAdress);
  url=url.replace("3306", port);
    url=url+DataBase;
    // url=url.replace("gestion", DataBase);
 
      Class.forName("com.mysql.jdbc.Driver");
      if(GetPrivelege().equals("true"))
        connection = DriverManager.getConnection(url,"root","160588");
      else connection = DriverManager.getConnection(url,"root","");
      
        } catch (Exception sc) {
           // System.out.println(sc.getMessage());
          JOptionPane.showMessageDialog(null, sc.getMessage(), " Erreur de connection a la Base de donnéé", JOptionPane.WARNING_MESSAGE, null);
          System.exit(0);
        }

        return connection;
    }
  public  void setPW(String pw,String user)throws Exception{

        try {

         //  JdbcClassSingleton j=new JdbcClassSingleton();
            Connection conn  = Getconnection();
          //  Statement stmt = conn.createStatement();
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
        JOptionPane.showMessageDialog(null, sc.getMessage(), " Erreur ", JOptionPane.WARNING_MESSAGE, null);
        }



   }
    public String getPW(String user) throws Exception {
        Connection conn = null;
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
        String mp="";
        try {
              conn = Getconnection();
                 Statement stmt = conn.createStatement();
                 String sql = "SELECT password FROM users where username='"+user+"'";
                 ResultSet rs = stmt.executeQuery(sql);
                 
                 while (rs.next()) {
                     mp=rs.getString("password");
                 }
                 rs.close();
                 
           
        } catch (SQLException sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(), " ", JOptionPane.WARNING_MESSAGE, img);
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
    
    
   String GetPrivelege() throws FileNotFoundException{
 //String host="127.0.0.1";
  Properties prop=new Properties();
  FileInputStream 
 ip= new FileInputStream("Config.properties");
   try {
          prop.load(ip);
      } catch (IOException ex) {
          Logger.getLogger(DataBase_op.class.getName()).log(Level.SEVERE, null, ex);
      } 
 return prop.getProperty("privelege");
 }  
    
    
    
   }



  

    

