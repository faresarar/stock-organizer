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
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rais
 */
public class Famille_op {
private static Famille_op instance;   
public Famille_op(){}
public static Famille_op getInstance(){
if(instance==null){
    instance=new Famille_op();
}
return instance;
}
    
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
public  int Index( String t2 ){ 
    int index=1;
   

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT valeur FROM famille order by valeur asc";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
          String  t1 =rs.getString("valeur");
         if(t1.equals(t2))break;else index=index+1;
     //    System.out.println("index="+index);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return index;
   }
public  int NumbreValeur(  ){ 
    int nb=0;
   

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT count(valeur) as nb_v FROM famille ";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
            nb =rs.getInt("nb_v");
           //  System.out.println("max="+max);
          
           //  System.out.println("ref="+ref);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return nb;
   }
public boolean  FamilleExist(String valeur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
              Connection conn = jdbc.Getconnection();
              String sql = "select * FROM famille where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("valeur"));
            if(wadifa.equals(valeur)&&(!valeur.equals("")))
            {  JOptionPane.showMessageDialog(null, " Cette famille existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_famille(String valeur )throws Exception{
        try {
             Connection conn = jdbc.Getconnection();
              String sql = "insert into famille (valeur) values (?) ";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }



public  void Charger_famille( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
             Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM famille  order by valeur asc";
            ResultSet rs = stmt.executeQuery(sql);
            categorie.addItem(" ");
        while (rs.next()) {
             categorie.addItem(rs.getString("valeur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_Famille(String  marque)throws Exception{

        try {
   Connection conn = jdbc.Getconnection();
              String sql = "delete  from famille where valeur=?";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,marque);
              pr.executeUpdate();
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  

}
