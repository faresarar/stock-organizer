/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.User;


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
       ImageIcon   img = new ImageIcon("Images/erreur.GIF");
    
Vector<Object> oneRow;
public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("nom d'utilisateur");  
    tableHeaders.add("nom_prénom");
    tableHeaders.add("Etat");
  
      
      
    for (Object o : resultList) {
        User f = (User) o;
         oneRow = new Vector<Object>();
           oneRow.add(f.getUsername());
        oneRow.add(f.getNom_prenom_utilisateur());
        if(f.getEtat()==1)
        oneRow.add("active");
        else  oneRow.add("inactive");
      
     
              tableData.add(oneRow);
    }

// oneRow.addMouseClicked

 DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
    
        return false;
    }
    
  
};

jTable1.setModel(tableModel);
   
}
       
 public void modifier_Autorisation(User f) throws Exception {
        
        try {
            Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE users set autorisation1=?, autorisation2=? , autorisation3=? , autorisation4=? , autorisation5=? , autorisation6=? , autorisation7=? , autorisation8=? ,autorisation9=?, autorisation10=?, autorisation11=? , autorisation12=?, autorisation13=? , autorisation14=?,autorisation15=? ,autorisation16=? ,autorisation17=? ,autorisation18=?  ,autorisation19=?  ,autorisation20=? ,autorisation21=? ,autorisation22=?  where username=?";
            //  ResultSet rs1 = stmt.executeQuery(sql1);
               
            PreparedStatement pr=conn.prepareStatement(sql1);
            pr.setInt(1, f.getAuto1());
             pr.setInt(2, f.getAuto2());
              pr.setInt(3, f.getAuto3());
               pr.setInt(4, f.getAuto4());
                pr.setInt(5, f.getAuto5());
                 pr.setInt(6, f.getAuto6()); 
                  pr.setInt(7, f.getAuto7());
                   pr.setInt(8, f.getAuto8());
                    pr.setInt(9, f.getAuto9());
                     pr.setInt(10, f.getAuto10());
                      pr.setInt(11, f.getAuto11());
                       pr.setInt(12, f.getAuto12());
                        pr.setInt(13, f.getAuto13());
                         pr.setInt(14, f.getAuto14());
                          pr.setInt(15, f.getAuto15());
                             pr.setInt(16, f.getAuto16());
                                pr.setInt(17, f.getAuto17());
                                pr.setInt(18, f.getAuto18());
                                    pr.setInt(19, f.getAuto19());
                                      pr.setInt(20, f.getAuto20());
                                        pr.setInt(21, f.getAuto21());
                                              pr.setInt(22, f.getAuto22());
                          pr.setString(23, f.getUsername());
                          pr.executeUpdate();
                 
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }  

 
 public void modifier_Etat(int etat,String username) throws Exception {      
        try {
            Connection conn = jdbc.Getconnection();
            String sql1 = "UPDATE users set etat=? where username=?";
            //  ResultSet rs1 = stmt.executeQuery(sql1);   
            PreparedStatement pr=conn.prepareStatement(sql1);
            pr.setInt(1, etat);
            pr.setString(2,username );     
            pr.executeUpdate();  
        pr.close(); 
        conn.close();
        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
    }  

 
 
  public  void Inserer_utilisateur(User U )throws Exception{
        try {
            Connection conn = jdbc.Getconnection();
                String sql = "insert into users (username,password,nom_prénom,etat) values (?,?,?,?) ";
            //ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setString(1, U.getUsername());
          pr.setString(2, U.getPassword());
          pr.setString(3, U.getNom_prenom_utilisateur());
          pr.setInt(4, U.getEtat());
          pr.executeUpdate();
        pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }      
 
    public  void sup_User(String username)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();
  String sql = "delete  from users where username=?";
            //ResultSet rs = stmt.executeQuery(sql);
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, username);
              pr.executeUpdate();
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
    
    
    
    public ArrayList getList_user() throws Exception {
         //
          String sql ="";
  ArrayList<User> List_user= new ArrayList<User>();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
                sql = "select * FROM users  ";
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      
            String username =rs.getString("username");
            String password =rs.getString("password");
             String nom_prénom =rs.getString("nom_prénom");
              int etat=rs.getInt("etat");
             int auto1=rs.getInt("autorisation1");
               int auto2=rs.getInt("autorisation2");
                 int auto3=rs.getInt("autorisation3");
                   int auto4=rs.getInt("autorisation4");
                     int auto5=rs.getInt("autorisation5");
                       int auto6=rs.getInt("autorisation6");
                         int auto7=rs.getInt("autorisation7");
                           int auto8=rs.getInt("autorisation8");
                             int auto9=rs.getInt("autorisation9");
                               int auto10=rs.getInt("autorisation10");
                                 int auto11=rs.getInt("autorisation11");
                                   int auto12=rs.getInt("autorisation12");
                                     int auto13=rs.getInt("autorisation13");
                                       int auto14=rs.getInt("autorisation14");
                                       int auto15=rs.getInt("autorisation15");
                                          int auto16=rs.getInt("autorisation16");
                                           int auto17=rs.getInt("autorisation17");
                                           int auto18=rs.getInt("autorisation18");
                                            int auto19=rs.getInt("autorisation19");
                                              int auto20=rs.getInt("autorisation20");
                                              int auto21=rs.getInt("autorisation21");
               int auto22=rs.getInt("autorisation22");
              
          List_user.add(new User( username,  password,  nom_prénom,etat,auto1,auto2,auto3,auto4,auto5,auto6,auto7,auto8,auto9,auto10,auto11,auto12,auto13,auto14,auto15,auto16,auto17,auto18,auto19,auto20,auto21,auto22) );
        }
        rs.close();
        conn.close();

       
        return List_user;
    }
    
    public boolean  UserExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM users where username=?";
           
 boolean a=false;
        try {
             Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1, param1);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String username =(rs.getString("username"));
            if(username.equals(param1)&&(!param1.equals("")))
            {
                //JOptionPane.showMessageDialog(null, " utilisateur existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }
    
     public boolean  UserEtat(String param1) throws Exception {
    String sql;
            sql = "select etat FROM users where username=?";
           
 boolean a=false;
        try {
             Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1, param1);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            int etat =(rs.getInt("etat"));
        
            
                //JOptionPane.showMessageDialog(null, " utilisateur existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
           if (etat==1) a=true;
           
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }
    
    
 public User get_user(String username) throws Exception {
         //
          String sql ="";
 
         User u = null;
            Connection conn = jdbc.Getconnection();
                sql = "select * FROM users  where username=?";
             PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {
      
          
            String password =rs.getString("password");
             String nom_prénom =rs.getString("nom_prénom");
              int etat=rs.getInt("etat");
             int auto1=rs.getInt("autorisation1");
               int auto2=rs.getInt("autorisation2");
                 int auto3=rs.getInt("autorisation3");
                   int auto4=rs.getInt("autorisation4");
                     int auto5=rs.getInt("autorisation5");
                       int auto6=rs.getInt("autorisation6");
                         int auto7=rs.getInt("autorisation7");
                           int auto8=rs.getInt("autorisation8");
                             int auto9=rs.getInt("autorisation9");
                               int auto10=rs.getInt("autorisation10");
                                 int auto11=rs.getInt("autorisation11");
                                   int auto12=rs.getInt("autorisation12");
                                     int auto13=rs.getInt("autorisation13");
                                       int auto14=rs.getInt("autorisation14");
                                          int auto15=rs.getInt("autorisation15");
                                            int auto16=rs.getInt("autorisation16");
                                              int auto17=rs.getInt("autorisation17");
                                               int auto18=rs.getInt("autorisation18");
                                                int auto19=rs.getInt("autorisation19");
                                                     int auto20=rs.getInt("autorisation20");
                                                      int auto21=rs.getInt("autorisation21");
                                                          int auto22=rs.getInt("autorisation22");
           
              
         u= new User( username,  password,  nom_prénom,etat,auto1,auto2,auto3,auto4,auto5,auto6,auto7,auto8,auto9,auto10,auto11,auto12,auto13,auto14,auto15,auto16,auto17,auto18,auto19,auto20,auto21,auto22) ;
        }
        rs.close();
        conn.close();

       
        return u;
    }
    
}
