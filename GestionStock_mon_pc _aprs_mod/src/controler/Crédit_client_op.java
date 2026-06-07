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
public class Crédit_client_op {
      JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
  String nom_prenom_client;
String id_client;
double credit;
    
   /*public void  ModifierCredit(double montant,String id_client) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "update  Crédit_client set crédit=? where id_client=?";
          
               PreparedStatement pr=conn.prepareStatement(sql);
             pr.setDouble(1, montant);
             pr.setString(2, id_client);
             pr.executeUpdate();
            // ResultSet rs = pr.executeQuery();
      
             pr.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }
 */
 /* public void InsererCredit(double credit,String id_client,String nom_prenom_client) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
           Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
             // String sql = "insert into  Crédit_client(id_client,nom_prénom_client,crédit) values ('"+id_client+"','"+nom_prenom_client+"','"+credit+"')" ;
           String sql = "insert into  Crédit_client(id_client,nom_prénom_client,crédit) values (?,?,?)" ;
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, id_client);
               pr.setString(2, nom_prenom_client);
                  pr.setDouble(3, credit);
            pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
       
             pr.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }*/
 /*public boolean  ClientExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM Crédit_client where nom_prénom_client=?";
           
 boolean a=false;
        try {
            Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1,param1);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String nom_prenom =rs.getString("nom_prénom_client");
            if(nom_prenom.equals(param1)&&(!param1.equals("")))
            {  //JOptionPane.showMessageDialog(null, " ce  de fournisseur existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           // JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
         //   throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }
 */
 
 
 
 /*public double  GetCredit(String client) throws Exception {
    String sql;
            sql = "select crédit FROM Crédit_client where nom_prénom_client='"+client+"'";
           double c=0;
 
        try {
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
           c =rs.getDouble("crédit"); 
        }
        rs.close();
        conn.close();
        } catch (Exception sc) {
        
        }
        return c;
    }
 */
}

