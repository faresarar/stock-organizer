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
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.VersementS;

/**
 *
 * @author Rais
 */
public class Versement_employe {
TextNumber tnb= TextNumber.getObj();  
private static Versement_employe instance;   
public Versement_employe(){}
public static Versement_employe getInstance(){
if(instance==null){
    instance=new Versement_employe();
}
return instance;
}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
    Vector<Object> oneRow;
 public  void inserer_versement(VersementS v )throws Exception{
        try {
             Connection conn = jdbc.Getconnection();
              String sql = "insert into salaire_employe(nom_prenom,type_versement,id_employe,date_versement,montant,remarque) values (?,?,?,?,?,?) ";
           //ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, v.getNom_prenom());
             pr.setString(2, v.getType_versement());
              pr.setString(3, v.getId_employe());
               pr.setDate(4, v.getDate());
                pr.setDouble(5, v.getMontant());
                pr.setString(6, v.getRemarque());
                pr.executeUpdate();
        pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }   
    public int GetNextNumVersement() throws Exception{
    int num=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(*) as maxid from salaire_employe ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =rs.getInt("maxid");
           //  System.out.println("max="+max);
          // if(max==0)num=1;
          num=max+1;
           //  System.out.println("ref="+ref);
        }

return num;
}
    public ArrayList getList_Versement_employe() throws Exception {
           String sql = "select * FROM salaire_employe order by date_versement desc";       
  ArrayList<VersementS> List_versement= new ArrayList<VersementS>();   
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {           
            String nom_prenom_emp =rs.getString("nom_prenom");
          
            Date date_versement =rs.getDate("date_versement");
            double montant_versé =rs.getDouble("montant");
            String type_versement =rs.getString("type_versement");
            String remarque =rs.getString("remarque");
      List_versement.add(new VersementS(nom_prenom_emp,type_versement,date_versement,montant_versé,remarque ) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }
    
    public ArrayList getList_Versement_employe(String id_employe) throws Exception {
           String sql = "select * FROM salaire_employe where id_employe =?  order by date_versement desc";       
  ArrayList<VersementS> List_versement= new ArrayList<>();   
            Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement(); 
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, id_employe);
            
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {   
           int id_salair=rs.getInt("id_salaire");
            String nom_prenom_emp =rs.getString("nom_prenom");
          
            Date date_versement =rs.getDate("date_versement");
            String id_emp =rs.getString("id_employe");
            double montant_versé =rs.getDouble("montant");
            String type_versement =rs.getString("type_versement");
            String remarque =rs.getString("remarque");
      List_versement.add(new VersementS(id_salair,nom_prenom_emp,type_versement,id_emp,date_versement,montant_versé,remarque ) );
        }
        rs.close();
        pr.close();
        conn.close();
        return List_versement;
    }
    
      public ArrayList getList_Versement_employe(java.sql.Date date1,java.sql.Date date2,String id) throws Exception  {
        
  ArrayList<VersementS> List_versement= new ArrayList<>();   
           Connection conn = jdbc.Getconnection();
               String sql = "select * FROM salaire_employe where  date_versement between ?  and ? and   id_employe=?  order by date_versement desc   ";       
           // Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";   
            PreparedStatement pr=conn.prepareStatement(sql);
            // System.out.println("after prepare");
           // pr.setString(1, fournisseu"r);
            //pr.setString(1, type_ver);
         pr.setDate(1, date1);
         pr.setDate(2, date2);
          pr.setString(3, id);
            ResultSet rs = pr.executeQuery();
             //  System.out.println("after exete query"+rs.isFirst()+rs.next());
      while (rs.next()) {      
           //   System.out.println("rs next");
          String nom_prenom_emp =rs.getString("nom_prenom");
         
            Date date_versement =rs.getDate("date_versement");
            double montant_versé =rs.getDouble("montant");
            String type_versement =rs.getString("type_versement");
            String idemploi =rs.getString("id_employe");
            String remarque =rs.getString("remarque");
      List_versement.add(new VersementS(nom_prenom_emp,type_versement,idemploi,date_versement,montant_versé,remarque ) );
     
        } 
      //System.out.println("list versement ="+List_versement.size());
        rs.close();
        conn.close();
        return List_versement;
    }
    
 public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    // tableHeaders.add("Fournisseur");
      tableHeaders.add("numéro_versement");
      tableHeaders.add("type_versement");
     tableHeaders.add("montant_versé");
     
      tableHeaders.add("date_versement");
      tableHeaders.add("Remarque");
   
    for (Object o : resultList) {
        VersementS v = (VersementS) o;
         oneRow = new Vector<Object>();
        oneRow.add(v.getNum_salaire());
        oneRow.add(v.getType_versement());
        try {
            oneRow.add(tnb.Afficher2Verguile(v.getMontant()));
        } catch (Exception ex) {
            Logger.getLogger(Versement_employe.class.getName()).log(Level.SEVERE, null, ex);
        }
        oneRow.add(v.getDate());
         oneRow.add(v.getRemarque());
        
         
     
       
              tableData.add(oneRow);
    }    
    
  jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));


DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
  return false;
    }
    
  
};

jTable1.setModel(tableModel);
    
}
 
 
 
 public void modifier_versement(  int  num_versement,String type,double montant,String remarque) throws Exception {
        
        try {
             Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE salaire_employe set type_versement=?,montant=?,remarque=?  where id_salaire=?";
              //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setString(1, type);
               pr.setDouble(2, montant);
               pr.setString(3,remarque );
                pr.setInt(4, num_versement);
                pr.executeUpdate();
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  
 public  void sup_salaire(int id)throws Exception{

        try {
         Connection conn = jdbc.Getconnection();
              String sql = "delete  from salaire_employe where id_salaire=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
 
 
 public double GetMontantVerser(int num_versement) throws Exception{
    //String ref="B";
    double  m=0;
  Connection conn = jdbc.Getconnection();
             String sql = "select montant from salaire_employe where num_versement= ?";
             PreparedStatement pr=conn.prepareStatement(sql);
               pr.setInt(1, num_versement);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            double max =(rs.getDouble("montant"));
           m=max;
        }

return m;
}
 
 
 
}