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
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Marque;

/**
 *
 * @author Rais
 */
public class Marque_op {
    private static Marque_op instance;   
public Marque_op(){}
public static Marque_op getInstance(){
if(instance==null){
    instance=new Marque_op();
}
return instance;
}
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
public  int NumbreValeur(  ){ 
    int nb=0;
   

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT count(valeur) as nb_v FROM marques ";
                         
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
public  int Index( String t2 ){ 
    int index=1;
 
 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT valeur FROM marques order by valeur asc";
                         
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

public boolean  MarqueExist(String marque) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
              Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement();
              String sql = "select * FROM Marques where valeur=?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,marque);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("valeur"));
            if(wadifa.equals(marque)&&(!marque.equals("")))
            {  JOptionPane.showMessageDialog(null, " Cette marque existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
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


/*public  void inserer_marque(String valeur )throws Exception{
        try {
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
              String sql = "insert into Marque (valeur) values ('"+valeur+"') ";
            ResultSet rs = stmt.executeQuery(sql);
          
        rs.close();
        conn.close();
        } catch (Exception sc) {
        }
   }*/
public  void inserer_marque(String valeur )throws Exception{
        try {
             Connection conn = jdbc.Getconnection();
             String sql = "insert into Marques (valeur) values (?) ";
               PreparedStatement pr=conn.prepareStatement(sql);
               pr.setString(1, valeur);
             //  pr.setString(2, id);
               pr.executeUpdate();
          //  ResultSet rs = stmt.executeQuery(sql);
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }


public  void Charger_marque( JComboBox marques ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
marques.setRenderer(centr);
marques.removeAllItems();

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
            // switch(cas){
                  sql = "SELECT * FROM Marques  order by valeur asc";
                 
             //}
            ResultSet rs = stmt.executeQuery(sql);
            marques.addItem(" ");
        while (rs.next()) {
           
             marques.addItem(rs.getString("valeur") );
        }
        
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }
/*public  void Charger_marques(  JComboBox marques, String categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
// ArrayList li=new ArrayList();
marques.setRenderer(centr);
marques.removeAllItems();
JdbcClass mz=new JdbcClass();
 try {
       try (Connection conn = mz.connect()) {
           Statement stmt = conn.createStatement();
           String sql;
           // switch(cas){
           sql = "SELECT M.valeur AS g FROM Marques AS M, Catégorie_produits AS C  WHERE( C.id_categorie=M.id_categorie  and C.valeur=?) order by M.valeur asc  ";
          ///sql= " SELECT valeur FROM Marques " ; 
           PreparedStatement pre=conn.prepareStatement(sql);
           pre.setString(1, categorie);
           try ( //}
                   ResultSet rs = stmt.executeQuery(sql)) {
               while (rs.next()) {
                   marques.addItem(rs.getString("g") );
                   System.out.println(rs.getString("g")+categorie);
               }  
               rs.close();
           }
           conn.close();
       }
           
        } catch(Exception e){}
   //return li;
   }
*/
////////////////////////////////////////////////////////////////
public  void Charger_marquesm(  JComboBox marques){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
// ArrayList li=new ArrayList();
marques.setRenderer(centr);
marques.removeAllItems();

 try {
        Connection conn = jdbc.Getconnection();
          
           String sql;
           // switch(cas){
          //sql = "SELECT M.valeur FROM Marques AS M, Catégorie_produits AS C  WHERE( C.id_categorie=M.id_categorie  and C.valeur="+auto+") order by M.valeur asc" ;
          sql= " SELECT valeur FROM Marques " ;
           Statement stmt = conn.prepareStatement(null);
           //PreparedStatement pre=conn.prepareStatement(sql);
          // pre.setString(1, "auto");
          
          try ( //}
                   ResultSet rs = stmt.executeQuery(sql)) {
               while (rs.next()) {
                   marques.addItem(rs.getString("valeur") );
                  // System.out.println(rs.getString("valeur"));
               } 
                rs.close(); 
           }
          conn.close(); 
       
         
        } catch(Exception e){}
   //return li;
   }
/////////////////////////////////////////////////////////////////////////////////
/*public  ArrayList<Marque> Charger_marqueslist(String categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   //DefaultListCellRenderer centr = new DefaultListCellRenderer();
 //centr.setHorizontalAlignment(JLabel.CENTER);
ArrayList<Marque> li=new ArrayList<>();
Marque mq=new Marque();
JdbcClass mmm;
    mmm = new JdbcClass();
 try {
       try (Connection conn = mmm.connect()) {
           Statement stmt = conn.createStatement();
           String sql;
           // switch(cas){
           //sql = "SELECT *  FROM Marques AS M, Catégorie_produits AS C  WHERE( C.id_categorie=M.id_categorie  and C.valeur="+categorie+") order by M.valeur asc  ";
          sql= " SELECT M.valeur FROM Marques AS M, Catégorie_produits AS C  WHERE( C.id_categorie=M.id_categorie  and C.valeur=?) order by M.valeur asc" ; 
           PreparedStatement pre=conn.prepareStatement(sql);
           pre.setString(1, categorie);
           try ( //}
                   
                   ResultSet rs = stmt.executeQuery(sql)) {
               
               if(rs==null){System.out.println("pas resultat");}
               while (rs.next()) {
                   mq.setValeur(rs.getString("valeur"));
                 li.add( mq);
                   System.out.println(mq.getValeur());
               }
               rs.close();
           }
           
        conn.close();
       }
           
        } catch(Exception e){}
   return li;
   }
*/

//////////////////////////////////////////////////////////////////////////////////
  public  void sup_Marque(String  marque)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();

              String sql = "delete  from Marques where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, marque);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  
 
}
