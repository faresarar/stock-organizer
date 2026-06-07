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
public class Categorie_depence_op {
private static Categorie_depence_op instance;   
public Categorie_depence_op(){}
public static Categorie_depence_op getInstance(){
if(instance==null){
    instance=new Categorie_depence_op();
}
return instance;
}    
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();


public boolean  MarqueExist(String valeur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
             Connection conn = jdbc.Getconnection();
              String sql = "select * FROM typedepence where depence=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("depence"));
            if(wadifa.equals(valeur)&&(!valeur.equals("")))
            {  JOptionPane.showMessageDialog(null, " cette dépence existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
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


public  void inserer_categorie(String valeur )throws Exception{
        try {
             Connection conn = jdbc.Getconnection();              String sql = "insert into typedepence (depence) values (?) ";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }



public  void Charger_categorie( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM typedepence order by depence asc";
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             categorie.addItem(rs.getString("depence") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_Categorie_piece(String  marque)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();
              String sql = "delete  from typedepence where depence=?";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,marque);
              pr.executeUpdate();
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  

}
