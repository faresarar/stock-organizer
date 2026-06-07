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
public class Categorie_produit_op {
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();


public boolean  MarqueExist(String valeur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
           Connection conn = jdbc.Getconnection();
              String sql = "select * FROM Catégorie_produits where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("valeur"));
            if(wadifa.equals(valeur)&&(!valeur.equals("")))
            {  JOptionPane.showMessageDialog(null, " cette Catégorie de produit existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
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

public String  getidcategorie(String valeur) throws Exception {
         
 String id=null;
        try {
           Connection conn = jdbc.Getconnection();
              String sql = "select id_categorie FROM Catégorie_produits where valeur=?";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
           id =(rs.getString("id_categorie"));
            
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE);
            throw new Exception(sc.getMessage(), sc);
        }
        return id ;
    }


public  void inserer_categorie(String valeur,String gg )throws Exception{
        try {
         Connection conn = jdbc.Getconnection();
              String sql = "insert into Catégorie_produits (id_categorie,valeur) values (?,?) ";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, gg);
           pr.setString(2,valeur);
             
            pr.executeUpdate();
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }




//////////////////////////////////////////////////////////

public String GetNextReferencecategorie() throws Exception{
    String ref="C";
    int max=0;
         Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(id) as maxrow from Catégorie_produits ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
          max =rs.getInt( "maxrow");
 
        }
        if(max==0){ ref=ref+0+"";}
           else{
            max+=1;
           ref=ref+max+"";}

return ref;
}

//////////////////////////////////////////////////////////////

public  void Charger_categorie( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   //DefaultListCellRenderer centr = new DefaultListCellRenderer();
 //centr.setHorizontalAlignment(JLabel.CENTER);
//categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
           Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM Catégorie_produits  order by valeur asc";
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             categorie.addItem(rs.getString("valeur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_Categorie_produit(String  produit)throws Exception{

        try {
Connection conn = jdbc.Getconnection();
          

              String sql = "delete  from Catégorie_produits where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,produit);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  

}
