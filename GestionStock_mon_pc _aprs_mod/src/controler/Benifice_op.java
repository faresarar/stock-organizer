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

/**
 *
 * @author Rais
 */
public class Benifice_op {
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
 public int GetTotalProduitVendu(String d1,String d2) throws Exception{
    int q=0;
       
             Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
             String sql = "select count(distinct (désignation))  as maxrow from Vente  where date_vente between ? and ? ";
           
             PreparedStatement pr=conn.prepareStatement(sql);
             pr.setString(1, d1);
             pr.setString(2, d2);
             
             ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            int max =rs.getInt("maxrow");
            q=max;
        }
//System.out.println(q);
return q;
}   
 
 
 
 public int GetTotalQuantiteVendu(String d1,String d2) throws Exception{
    int q=0;
   
             Connection conn = jdbc.Getconnection();
             String sql = "select sum(quantité_vente)  as maxrow from Vente  where date_vente between ? and ? ";
            PreparedStatement pr=conn.prepareStatement(sql);
             pr.setString(1, d1);
             pr.setString(2, d2);
             
             ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            int max =rs.getInt("maxrow");
            q=max;
        }
//System.out.println(q);
return q;
}   
  public double GetTotalVente(String d1,String d2) throws Exception{
    double q=0;
   
             Connection conn = jdbc.Getconnection();
             String sql = "select sum(montantTTC)  as maxrow from Vente  where date_vente between ? and ? ";
             PreparedStatement pr=conn.prepareStatement(sql);
             pr.setString(1, d1);
             pr.setString(2, d2);
             
             ResultSet rs = pr.executeQuery();
        while (rs.next()) {
             double max =rs.getDouble("maxrow");
            q=max;
        }
//System.out.println(q);
return q;
}   
  
public double GetTotalVersemment(String d1,String d2) throws Exception{
    double q=0;
   
             Connection conn = jdbc.Getconnection();
             String sql = "select sum(montant_versé)  as maxrow from Versement_client  where date_versement between ? and ? ";
            PreparedStatement pr=conn.prepareStatement(sql);
             pr.setString(1, d1);
             pr.setString(2, d2);
             
             ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            double max =rs.getDouble("maxrow");
            q=max;
        }
//System.out.println(q);
return q;
}
public double GetTotalBenifice(String d1,String d2) throws Exception{
    double q=0;
  
             Connection conn = jdbc.Getconnection();             String sql = "select prix_achat,prix_vente,quantité_vente from Vente  where date_vente between ? and ? ";
           PreparedStatement pr=conn.prepareStatement(sql);
             pr.setString(1, d1);
             pr.setString(2, d2);
             
             ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            double prix_achat =rs.getDouble("prix_achat");
               double prix_vente =rs.getDouble("prix_vente");
                int quantité_vente =rs.getInt("quantité_vente");
               
            q=q+((prix_vente-prix_achat)*quantité_vente);
        }
//System.out.println(q);
return q;
}     
  
  
}
