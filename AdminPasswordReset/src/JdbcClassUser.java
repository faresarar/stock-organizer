/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



public class JdbcClassUser {
    private static JdbcClassUser jdbc;
    private JdbcClassUser(){}
   
     public static JdbcClassUser getInstance() {    
                                     if (jdbc==null)  
                                   {  
                                            jdbc=new  JdbcClassUser();  
                                   }  
                         return jdbc;  
             }  

    private static Connection connection = null;
    private static  String url = "jdbc:mysql://127.0.0.1:3306/utilisateurs";
  
       public  Connection Getconnection()throws Exception {
       
       try{
        Class.forName("com.mysql.jdbc.Driver");
        //connection = DriverManager.getConnection(url,"root","Pa$$w0rd");
        connection = DriverManager.getConnection(url,"root","160588");
        // connection = DriverManager.getConnection(url,"root","98521fatna$");
        } catch (Exception sc) {
            System.out.println(sc.getMessage());
            JOptionPane.showMessageDialog(null,sc.getMessage());
        //  JOptionPane.showMessageDialog(null, "Lancer votre serveur MySQL ", " Erreur de connection a la Base de donnéé", JOptionPane.WARNING_MESSAGE, null);
          System.exit(0);
        }

        return connection;
    }
 
   }



  

    

