/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Perte;

/**
 *
 * @author pc
 */
public class Pertes_op {
   Vector<Object> oneRow;
   JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
   TextNumber tn= TextNumber.getObj();
   Produit_op pop=Produit_op.getInstance();
   private static Pertes_op instance;   
public Pertes_op(){}
public static Pertes_op getInstance(){
if(instance==null){
    instance=new Pertes_op();
}
return instance;
}     


public  void inserer_perte(Perte p )throws Exception{
        try {
          Connection conn = jdbc.Getconnection();
              String sql = "insert into pertes (   date,  heure,  type_perte,  désignation,  id_produit,  prix_achat,  quantité,  obsérvation,  user) values (?,?,?,? ,?,?,?,?,?)";
           // ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setDate(1, p.getDate());
            pr.setString(2, p.getHeure());
            pr.setString(3, p.getType_perte());
            pr.setString(4,p.getDésignation());
            pr.setInt(5, p.getId_produit());
            pr.setDouble(6, p.getPrix_achat());
            pr.setFloat(7, p.getQuantité());
          //  pr.setFloat(8, p.getQuantité_stock());
            pr.setString(8,p.getObsérvation());
            pr.setString(9,p.getUser());                       
       
            pr.executeUpdate();
            pr.close();
        conn.close();
        } catch (Exception sc) {
           sc.printStackTrace();
           sc.getMessage();
        }
   }
  public  void sup_perte(int num_perte)throws Exception{

        try {
         Connection conn = jdbc.Getconnection();
              String sql = "delete   FROM pertes where  num_perte=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num_perte);
              
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
} 
 
 /*public boolean  DepenceExist(int annee,String mois,String depence) throws Exception {
 
 boolean a=false;
        try {
           Connection conn = jdbc.Getconnection();
              String sql = "select * FROM dépence where année=? and mois=? and depence=?";
              
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, annee);
                 pr.setString(2, mois);
                 pr.setString(3, depence);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String année =(rs.getString("année"));
            String depenc =(rs.getString("depence"));
            if( (!depenc.equals("")))
            { 
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
*/
  

 /* public void modifier_perte(Perte p){
        try {
           Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE pertes set type_perte=?, désignation=?,id_prodduit=?,prix_achat=?,quantité=?,quantité_stock=?,obsérvation=? where  num_perte=? ";
              //ResultSet rs1 = stmt.executeQuery(sql1);
             PreparedStatement pr=conn.prepareStatement(sql1);
             pr.setString(1, p.getType_perte());
             pr.setString(2, p.getDésignation());
             pr.setInt(3, p.getId_produit());
             pr.setDouble(4, p.getPrix_achat());
             pr.setFloat(5, p.getQuantité());
             pr.setFloat(6, p.getQuantité_stock());
             pr.setString(7, p.getObsérvation());
                   // pr.setString(8, sql1);
                   //  pr.setString(9, sql1);
                     
         pr.executeUpdate();
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
        
        }
       
    }  */
 
 /* public Dépense getDépence(int annee,String mois) throws Exception {
      Dépense d=null;
        String sql;
 
        
          sql = "select * FROM dépence where année=? and mois= ?  ";
            
            
      
         
 
         Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, annee);
                 pr.setString(2, mois);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String depence =rs.getString("depence");
            double montant =rs.getDouble("montant");
            
        
          d=new Dépense(annee,mois,depence,montant);
        }
        rs.close();
        conn.close();

      
        return d;
    }*/
  
 public void displayResult(List resultList,JTable jTable) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table

  

    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("N° perte"); 
    tableHeaders.add("Date");
    tableHeaders.add("Heure");
    tableHeaders.add("Type de perte");
    tableHeaders.add("Désignation");
    tableHeaders.add("Quantité");
    tableHeaders.add("Prix d'achat");
    tableHeaders.add("Observation");
    tableHeaders.add("User");
  
    for (Object o : resultList) {
        Perte p = (Perte) o;
        oneRow = new Vector<Object>();
        oneRow.add(p.getNum_perte());
        oneRow.add(p.getDate());
        oneRow.add(p.getHeure());
        oneRow.add(p.getType_perte());
        oneRow.add(p.getDésignation());
        oneRow.add(p.getQuantité());
        oneRow.add(p.getPrix_achat());
        oneRow.add(p.getObsérvation());
        oneRow.add(p.getUser());
        tableData.add(oneRow);
    }

// oneRow.addMouseClicked

jTable.setModel(new DefaultTableModel(tableData, tableHeaders));
   
}
  
  
 public ArrayList getList_Perte() throws Exception {
 String sql ="";
 ArrayList<Perte> List_pertes= new ArrayList<Perte>();
 try {
      Connection conn = jdbc.Getconnection();
      sql = "select * FROM pertes  ";
      PreparedStatement pr=conn.prepareStatement(sql);
      ResultSet rs = pr.executeQuery();
        while(rs.next()){
        int num_perte =rs.getInt("num_perte");
        Date date =rs.getDate("date");
        String heure =rs.getString("heure");
        String type_perte =rs.getString("type_perte");
        String désignation =rs.getString("désignation");
        int id_produit =rs.getInt("id_produit");
        double prix_achat=rs.getDouble("prix_achat");
        float quantité=rs.getFloat("quantité");
      //  float quantité_stock=rs.getFloat("quantité_stock");
        float quantité_stock=pop.QuantitéEnStock(désignation);
        String obsérvation =rs.getString("obsérvation");
        String user =rs.getString("user");
        
        List_pertes.add(new Perte( num_perte,date, heure, type_perte,désignation,id_produit,prix_achat,quantité,quantité_stock,obsérvation,user) );
                         }
        pr.close();
        conn.close();
        }
         catch (Exception sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(), " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
        return List_pertes;
    }
    public ArrayList getList_Perte(java.sql.Date d1,java.sql.Date d2) throws Exception{
    ArrayList<Perte> List_perte= new ArrayList<>();   
   Connection conn = jdbc.Getconnection();
      String    sql = "select * FROM pertes where  date between ?  and ?";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {      
            int num_perte =rs.getInt("num_perte");
        Date date =rs.getDate("date");
        String heure =rs.getString("heure");
        String type_perte =rs.getString("type_perte");
        String désignation =rs.getString("désignation");
        int id_produit =rs.getInt("id_produit");
        double prix_achat=rs.getDouble("prix_achat");
        float quantité=rs.getFloat("quantité");
         float quantité_stock=pop.QuantitéEnStock(désignation);
        String obsérvation =rs.getString("obsérvation");
        String user =rs.getString("user");   
          
        List_perte.add(new Perte( num_perte,date, heure, type_perte,désignation,id_produit,prix_achat,quantité,quantité_stock,obsérvation,user) );
        }
        rs.close();
        conn.close();

      
        return List_perte;
}  
 
 /*public ArrayList getList_depence(String param1,String param2,int type) throws Exception {
         //
          String sql ="";
  ArrayList<Dépense> List_produit= new ArrayList<Dépense>();
        try {


           Connection conn = jdbc.Getconnection();
            if(type==1){
            switch(param1){
                case "désignation":sql = "select * FROM Produit where désignation like %?% ";break;
                case "code_barre":sql = "select * FROM Produit where code_barre like %?% ";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:  sql = "select * FROM dépence where année=? and mois= ?  ";break;
                           }
            
            }else {
                if(param2.equals("toute"))param2="";
                
                
                //if(param5.equals("toute les marques"))param5="";
                //int quantite=Integer.parseInt(param1);
// sql ="select * FROM  where categorie_produit like '%"+param2+"%' and categorie_piece like '%"+param3+"%' and etat like '%"+param4+"%' and marque like '%"+param5+"%' and quantité<='"+quantite+"' ";          
            }
            PreparedStatement pr=conn.prepareStatement(sql);
             switch(param1){
                case "désignation":pr.setString(1, param1);break;
                case "code_barre":pr.setString(1, param1);break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default: pr.setString(1, param1);pr.setString(2, param2);break;
                           }
                // pr.setString(2, mois);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while(rs.next()){
            int annee =rs.getInt("année");
            String mois =rs.getString("mois");
            String depence =rs.getString("depence");
             double montant =rs.getDouble("montant");
          
                 
           
          List_produit.add(new Dépense( annee,mois, depence, montant) );}
           pr.close();
        conn.close();
        }
        
        

         catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
       
        return List_produit;
    }*/
}
