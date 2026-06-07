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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rais
 */
public class Dette_fournisseur_op {
     private static Dette_fournisseur_op instance;   
public Dette_fournisseur_op(){}
public static Dette_fournisseur_op getInstance(){
if(instance==null){
    instance=new Dette_fournisseur_op();
}
return instance;
}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
  String nom_prenom_fournisseur;
String id_fournisseur;
double dette;
    
   public void  ModifierDette(double dette,String id_fournisseur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "update  Dette_fournisseur set dette=? where id_f=?";
            //ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setDouble(1, dette);
             pr.setString(2, id_fournisseur);
             pr.executeUpdate();
             pr.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }
  public void InsererDette(double dette,String id_fournisseur,String nom_prenom_fournisseur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "insert into  Dette_fournisseur(id_f,nom_prenom_fournisseur,dette) values (?,?,?)" ;
           //ResultSet rs = stmt.executeQuery(sql);
       PreparedStatement pr=conn.prepareStatement(sql);
       pr.setString(1, id_fournisseur);
        pr.setString(2, nom_prenom_fournisseur);
         pr.setDouble(3, dette);
         pr.executeUpdate();
             pr.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }
 public boolean  FournisseurExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM Dette_fournisseur where nom_prenom_fournisseur=?";
           
 boolean a=false;
        try {
            Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1,param1);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String nom_prenom =(rs.getString("nom_prenom_fournisseur"));
            if(nom_prenom.equals(param1)&&(!param1.equals("")))
            {  //JOptionPane.showMessageDialog(null, " ce  de fournisseur existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        pr.close();
        conn.close();

        } catch (Exception sc) {
           // JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }
 public double  GetDette(String fournisseur) throws Exception {
    String sql;
            sql = "select dette FROM fournisseur where nom_prenom_fournisseur='"+fournisseur+"'";
           double d=0;
 
        try {
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           d =rs.getDouble("dette"); 
        }
        rs.close();
        conn.close();
        } catch (Exception sc) {
        
        }
        return d;
    }
 
    
}
